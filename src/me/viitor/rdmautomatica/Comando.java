package me.viitor.rdmautomatica;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import me.viitor.API.API;
import me.viitor.API.KitAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.invencivel.Proteção;
import me.viitor.main.Main;

public class Comando implements CommandExecutor {

	
	private boolean CheckarNumero(String Numero){
		try {
			Integer.parseInt(Numero);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
		
	}
	
	public boolean onCommand(CommandSender Sender, Command Comando, String Label, String[] Args) {
		if (!(Sender instanceof Player)) {
			return true;
		}
		Player Jogador = (Player)Sender;
		if (Comando.getName().equalsIgnoreCase("RDM") || Comando.getName().equalsIgnoreCase("ReiDaMesa")) {
			if(!cfGrupo.ChecarGrupo(Jogador, "Dono") && !cfGrupo.ChecarGrupo(Jogador, "Admin")){
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (Args.length == 0) {
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /rdm <Iniciar/Cancelar/Tempo>");
				return true;
			}
			if (Args[0].equalsIgnoreCase("Iniciar") || Args[0].equalsIgnoreCase("Start")) {
				if (Main.Evento == Estado.INICIANDO) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel iniciar o evento pois outro ja esta sendo iniciado");
					return true;
				}
				else if (Main.Evento == Estado.ANDAMENTO) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel iniciar o evento pois outro ja esta em andamento");
					return true;
				}
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce iniciou o evento RDM");
				Tempo.mandarBroadcast(" " + "\n" + "§6§lNew§f§lPvP §6» §7O evento RDM foi iniciado" + "\n" + " ");
				
				Tempo.CancelarTempo();
				Main.Evento = Estado.INICIANDO;
				Tempo.Iniciando = 301;
				new Tempo(Jogador);
				return true;
			}
			if (Args[0].equalsIgnoreCase("Cancelar") || Args[0].equalsIgnoreCase("Cancel")) {
				if (Main.Evento == Estado.FECHADO) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel cancelar o evento pois o mesmo nao esta aberto");
					return true;
				}
				if (Main.Evento == Estado.ANDAMENTO) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel cancelar o evento pois o mesmo ja esta em andamento");
					return true;
				}
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce cancelou o evento RDM");
				Tempo.mandarBroadcast(" " + "\n" + "§6§lNew§f§lPvP §6» §7O evento RDM foi cancelado" + "\n" + " ");
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7Todos os jogadores foram teleportados para o §6spawn");
				
				if (PlayerAPI.Participando.contains(Jogador)) {
					PlayerAPI.Participando.remove(Jogador);
					EventoAPI.TeleportarWarp(Jogador, "Saida");
				}
				
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					if (PlayerAPI.Participando.contains(Jogadores)) {
						Jogadores.sendMessage("§6§lNew§f§lPvP §6» §7Desculpe, mas o evento em que voce estava foi cancelado");
						PlayerAPI.Participando.remove(Jogadores);
						EventoAPI.TeleportarWarp(Jogadores, "Saida");
					}
				}
				
				Main.Evento = Estado.FECHADO;
				Tempo.Iniciando = 301;
				Tempo.CancelarTempo();
				return true;
			}
			if (Args[0].equalsIgnoreCase("Tempo") || Args[0].equalsIgnoreCase("Time")) {
				if (Main.Evento == Estado.FECHADO) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode editar o tempo com o evento fechado");
					return true;
				}
				if (Main.Evento == Estado.ANDAMENTO) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode editar o tempo pois o evento ja esta em andamento");
					return true;
				}
				if (Args.length == 1) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /rdm <Tempo> <Tempo>");
					return true;
				}
				if (!CheckarNumero(Args[1])) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Utilize apenas numeros");
					return true;
				}
				Integer Time = Integer.parseInt(Args[1]);
				if (Time == 0 || Time > 301) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce so pode utilizar numeros acima de §60 segundos §7ou §6301 segundos (5 minutos)");
					return true;
				}
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o tempo do evento para §6" + Time + " §7segundo(s)");
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O tempo do evento foi alterado para §6" + Time + " §7segundo(s)");
				Tempo.Iniciando = Time;
				return true;
			}
			if (Args[0].equalsIgnoreCase("Setar") || Args[0].equalsIgnoreCase("Set")) {
				if (Args.length == 1) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /rdm <Set> <Spawn/Saida/Loc1/Loc2>");
					return true;
				}
				if (Args[1].equalsIgnoreCase("Spawn")) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Local setado com sucesso");
					EventoAPI.SetarWarp(Jogador, "Spawn");
					return true;
				}
				if (Args[1].equalsIgnoreCase("Loc1")) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Local setado com sucesso");
					EventoAPI.SetarWarp(Jogador, "Loc1");
					return true;
				}
				if (Args[1].equalsIgnoreCase("Loc2")) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Local setado com sucesso");
					EventoAPI.SetarWarp(Jogador, "Loc2");
					return true;
				}
				if (Args[1].equalsIgnoreCase("Saida")) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Local setado com sucesso");
					EventoAPI.SetarWarp(Jogador, "Saida");
					return true;
				}
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /rdm <Set> <Spawn/Saida/Loc1/Loc2>");
				return true;
			}
			Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /rdm <Iniciar/Cancelar/Tempo>");
			return true;
		}
		if (Comando.getName().equalsIgnoreCase("Entrar") || Comando.getName().equalsIgnoreCase("Join")) {
			if (Main.Evento == Estado.FECHADO) {
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel entrar no evento pois o mesmo esta fechado");
				return true;
			}
			if (Main.Evento == Estado.INICIANDO) {
				if (PlayerAPI.Participando.size() == 30) {
					if(!cfGrupo.ChecarGrupo(Jogador, "Dono") && !cfGrupo.ChecarGrupo(Jogador, "Admin") && !cfGrupo.ChecarGrupo(Jogador, "Gerente") && !cfGrupo.ChecarGrupo(Jogador, "Mod+") && !cfGrupo.ChecarGrupo(Jogador, "Mod") && !cfGrupo.ChecarGrupo(Jogador, "Trial") && !cfGrupo.ChecarGrupo(Jogador, "Youtuber+") && !cfGrupo.ChecarGrupo(Jogador, "Helper") && !cfGrupo.ChecarGrupo(Jogador, "Pro") && !cfGrupo.ChecarGrupo(Jogador, "Mvp") && !cfGrupo.ChecarGrupo(Jogador, "Light")){
						Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel entrar no evento pois o mesmo esta cheio");
						return true;
					} else {
						if (PlayerAPI.Participando.contains(Jogador)) {
							Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce ja esta participando do evento. Para sair, utilize o comando /sair");
							return true;
						}
						if (EventoAPI.Teleportando.contains(Jogador)) {
							Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Aguarde o termino do teleporte");
							return true;
						}
						if (EventoAPI.Cooldown.containsKey(Jogador)) {
							Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Agurade §6" + EventoAPI.PegarCooldown(Jogador) + " §7segundo(s) para se teleportar novamente");
							return true;
						}
						if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
							Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado pois o evento esta sendo iniciado");
							return true;
						}
						EventoAPI.AdicinarCooldown(Jogador, 5);
						EventoAPI.Teleportando.add(Jogador);
						EventoAPI.AntiBug.add(Jogador);
						Jogador.setExp(0.0F);
						Jogador.setLevel(3);
						Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte sera concluido em §63 §7segundo(s)");
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
									Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado pois o evento esta sendo iniciado");
									EventoAPI.Teleportando.remove(Jogador);
									return;
								}
								if (EventoAPI.Teleportando.contains(Jogador)) {
									Jogador.setExp(0.50F);
									Jogador.setLevel(2);
									Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte sera concluido em §62 §7segundo(s)");
								}
							}
						}.runTaskLater(Main.getPlugin(), 20L);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
									Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado pois o evento esta sendo iniciado");
									EventoAPI.Teleportando.remove(Jogador);
									return;
								}
								if (EventoAPI.Teleportando.contains(Jogador)) {
									Jogador.setExp(1.0F);
									Jogador.setLevel(1);
									Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte sera concluido em §61 §7segundo(s)");
								}
							}
						}.runTaskLater(Main.getPlugin(), 40L);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
									Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado pois o evento esta sendo iniciado");
									EventoAPI.Teleportando.remove(Jogador);
									return;
								}
								if (Main.Evento == Estado.FECHADO && EventoAPI.Teleportando.contains(Jogador)) {
									Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel completar o teleporte pois o evento foi cancelado");
									EventoAPI.Teleportando.remove(Jogador);
									return;
								} 
								if (EventoAPI.Teleportando.contains(Jogador)) {
									if (Main.Evento == Estado.FECHADO) {
										Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel completar o teleporte pois o evento esta fechado");
										return;
									}
									Jogador.setExp(0.0F);
									Jogador.setLevel(0);
									PlayerAPI.AdicionarRDMCheio(Jogador);
									Proteção.setImortal(Jogador, true);
									Jogador.setMaxHealth(20);
									Jogador.setHealth(20.0D);
									Jogador.setFoodLevel(20);
									Jogador.setFlySpeed(0.1F);
									Jogador.setAllowFlight(false);
									Jogador.setWalkSpeed(0.2F);
									Jogador.getInventory().clear();
									Jogador.setGameMode(GameMode.SURVIVAL);
											
									Jogador.getInventory().setBoots(null);
									Jogador.getInventory().setChestplate(null);
									Jogador.getInventory().setHelmet(null);
									Jogador.getInventory().setLeggings(null);
								}
							}
						}.runTaskLater(Main.getPlugin(), 60L);
					}
				} else {
					if (PlayerAPI.Participando.contains(Jogador)) {
						Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce ja esta participando do evento");
						return true;
					}
					if (EventoAPI.Teleportando.contains(Jogador)) {
						Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Aguarde o termino do teleporte");
						return true;
					}
					if (EventoAPI.Cooldown.containsKey(Jogador)) {
						Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Aguarde §6" + EventoAPI.PegarCooldown(Jogador) + " §7segundo(s) para se teleportar novamente");
						return true;
					}
					if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
						Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado pois o evento esta sendo iniciado");
						return true;
					}
					EventoAPI.AdicinarCooldown(Jogador, 5);
					EventoAPI.Teleportando.add(Jogador);
					EventoAPI.AntiBug.add(Jogador);
					Jogador.setExp(0.0F);
					Jogador.setLevel(3);
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte sera concluido em §63 §7segundo(s)");
					new BukkitRunnable() {
						
						@Override
						public void run() {
							if (!EventoAPI.Teleportando.contains(Jogador)) {
								return;
							}
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
								Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado pois o evento esta sendo iniciado");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.setExp(0.50F);
								Jogador.setLevel(2);
								Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte sera concluido em §62 §7segundo(s)");
							}
						}
					}.runTaskLater(Main.getPlugin(), 20L);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							if (!EventoAPI.Teleportando.contains(Jogador)) {
								return;
							}
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
								Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado pois o evento esta sendo iniciado");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.setExp(1.0F);
								Jogador.setLevel(1);
								Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte sera concluido em §61 §7segundo(s)");
							}
						}
					}.runTaskLater(Main.getPlugin(), 40L);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							if (!EventoAPI.Teleportando.contains(Jogador)) {
								return;
							}
							if (Tempo.Iniciando == 0 || Tempo.Iniciando == 1 || Tempo.Iniciando == 2 || Tempo.Iniciando == 3) {
								Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado pois o evento esta sendo iniciado");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							}
							if (Main.Evento == Estado.FECHADO && EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel completar seu teleporte pois o evento foi cancelado");
								EventoAPI.Teleportando.remove(Jogador);
								return;
							} 
							if (EventoAPI.Teleportando.contains(Jogador)) {
								Jogador.setExp(0.0F);
								Jogador.setLevel(0);
								if (PlayerAPI.Participando.size() == 30) {
									if (!Jogador.hasPermission("RDM.Full")) {
										Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel entrar no evento pois o mesmo esta cheio");
										EventoAPI.Teleportando.remove(Jogador);
										return;
									} else {
										PlayerAPI.AdicionarRDMCheio(Jogador);
										Proteção.setImortal(Jogador, true);
										Jogador.setMaxHealth(20);
										Jogador.setHealth(20.0D);
										Jogador.setFoodLevel(20);
										Jogador.setFlySpeed(0.1F);
										Jogador.setAllowFlight(false);
										Jogador.setWalkSpeed(0.2F);
										Jogador.getInventory().clear();
										Jogador.setGameMode(GameMode.SURVIVAL);
												
										Jogador.getInventory().setBoots(null);
										Jogador.getInventory().setChestplate(null);
										Jogador.getInventory().setHelmet(null);
										Jogador.getInventory().setLeggings(null);
									}
								}
								KitAPI.removeKits(Jogador);
								Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Teleporte concluido com sucesso");
								Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Agora voce esta participando do evento, bom jogo");
								PlayerAPI.AdicionarRDM(Jogador);
								PlayerAPI.Participando.add(Jogador);
								EventoAPI.AntiBug.remove(Jogador);
								EventoAPI.Teleportando.remove(Jogador);
								EventoAPI.TeleportarWarp(Jogador, "Spawn");
								Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7entrou no evento §6(" + PlayerAPI.Participando.size() + "/30)");
								API.setWarp(Jogador, "RDM");
								Proteção.setImortal(Jogador, true);
								Iterator<?> Interator = Jogador.getActivePotionEffects().iterator();
								while (Interator.hasNext()) {
									PotionEffect Efeito = (PotionEffect)Interator.next();
									Jogador.removePotionEffect(Efeito.getType());
								}
								        
								Jogador.setMaxHealth(20);
								Jogador.setHealth(20.0D);
								Jogador.setFoodLevel(20);
								Jogador.setFlySpeed(0.1F);
								Jogador.setAllowFlight(false);
								Jogador.setWalkSpeed(0.2F);
								Jogador.getInventory().clear();
								Jogador.setGameMode(GameMode.SURVIVAL);
										
								Jogador.getInventory().setBoots(null);
								Jogador.getInventory().setChestplate(null);
								Jogador.getInventory().setHelmet(null);
								Jogador.getInventory().setLeggings(null);
							}
						}
					}.runTaskLater(Main.getPlugin(), 60L);
				}
			} else if (Main.Evento == Estado.ANDAMENTO) {
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Desculpe, mas o evento ja comecou");
			}
			return true;
		}
		if (Comando.getName().equalsIgnoreCase("Sair") || Comando.getName().equalsIgnoreCase("Leave")) {
			if (Main.Evento == Estado.FECHADO) {
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel sair do evento pois o mesmo esta fechado");
				return true;
			}
			if (!PlayerAPI.Participando.contains(Jogador)) {
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Nao foi possivel sair do evento pois voce nao esta participando do mesmo");
				return true;
			}
			if (EventoAPI.Teleportando.contains(Jogador)) {
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Aguarde o termino do teleporte");
				return true;
			}
			if (EventoAPI.Cooldown.containsKey(Jogador)) {
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Aguarde §6" + EventoAPI.PegarCooldown(Jogador) + " §7segundo(s) para se teleportar novamente");
				return true;
			}
			if (PlayerAPI.Participando.contains(Jogador)) {
				if (PlayerAPI.Ganhador.containsKey(Jogador)) {
					Player Ganhador = Bukkit.getPlayer(PlayerAPI.Ganhador.get(Jogador));
					PlayerAPI.CheckarGanhador(Ganhador);
				}
			}
			EventoAPI.AdicinarCooldown(Jogador, 5);
			EventoAPI.Teleportando.remove(Jogador);
			EventoAPI.AntiBug.remove(Jogador);
			PlayerAPI.Participando.remove(Jogador);
			Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce saiu do evento RDM");
			Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7saiu do evento §6(" + PlayerAPI.Participando.size() + "/30)");
			PlayerAPI.RemoverRDM(Jogador);
			EventoAPI.TeleportarWarp(Jogador, "Saida");
			API.setWarp(Jogador, "Spawn");
			API.sendItems(Jogador);
			Proteção.setImortal(Jogador, true);
			return true;
		}
		return false;
	}
}
