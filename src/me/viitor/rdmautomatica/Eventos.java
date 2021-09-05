package me.viitor.rdmautomatica;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.viitor.API.API;
import me.viitor.invencivel.Proteção;
import me.viitor.main.Main;

public class Eventos implements Listener {

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent Evento) {
		Player Jogador = Evento.getPlayer();
		if (Main.Evento == Estado.FECHADO) {
			return;
		}
		if (Main.Evento == Estado.INICIANDO && PlayerAPI.Participando.contains(Jogador)) {
			PlayerAPI.RemoverRDM(Jogador);
			PlayerAPI.Participando.remove(Jogador);
			Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7saiu do evento §6(" + PlayerAPI.Participando.size() + "/30)");
		
		}
		else if (Main.Evento == Estado.ANDAMENTO) {
			if (!PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador)) {
				PlayerAPI.RemoverRDM(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + "§7 saiu do evento §6(" + PlayerAPI.Participando.size() + "/30)");
				return;
			}
			else if (PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador) && PlayerAPI.Batalhando1.get(Jogador) == Jogador.getName() && PlayerAPI.Ganhador.get(Jogador) == Jogador.getName()) {
				Player Ganhador = Bukkit.getPlayer(PlayerAPI.Batalhando2.get(Jogador));
				PlayerAPI.Batalhando.remove(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7desistiu da batalha contra §6" + Ganhador.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Ganhador.getName() + " §7ganhou a batalha contra §6" + Jogador.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Ganhador.put(Jogadores, Ganhador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				if (PlayerAPI.Participando.size() > 1) {
					PlayerAPI.SelecionarProximoJogador(Ganhador);
				}  else {
					PlayerAPI.CheckarGanhador(Ganhador);
				}
				return;
			}
			else if (PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador) && PlayerAPI.Batalhando1.get(Jogador) == Jogador.getName() && PlayerAPI.Ganhador.get(Jogador) != Jogador.getName()) {
				Player Ganhador = Bukkit.getPlayer(PlayerAPI.Batalhando2.get(Jogador));
				PlayerAPI.Batalhando.remove(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7desistou da batalha contra §6" + Ganhador.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Ganhador.getName() + " §7ganhou a batalha contra §6" + Jogador.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Ganhador.put(Jogadores, Ganhador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);	
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				if (PlayerAPI.Participando.size() > 1) {
					PlayerAPI.SelecionarProximoJogador(Ganhador);
				} else {
					PlayerAPI.CheckarGanhador(Ganhador);
				}
				return;
			}
			else if (PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador) && PlayerAPI.Batalhando2.get(Jogador) == Jogador.getName() && PlayerAPI.Ganhador.get(Jogador) == Jogador.getName()) {
				Player Ganhador = Bukkit.getPlayer(PlayerAPI.Batalhando1.get(Jogador));
				PlayerAPI.Batalhando.remove(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7desistou da batalha contra §6" + Ganhador.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Ganhador.getName() + " §7ganhou a batalha contra §6" + Jogador.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					PlayerAPI.Ganhador.put(Jogadores, Ganhador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				if (PlayerAPI.Participando.size() > 1) {
					PlayerAPI.SelecionarProximoJogador(Ganhador);
				}  else {
					PlayerAPI.CheckarGanhador(Ganhador);
				}
				return;
			}
			else if (PlayerAPI.Batalhando.contains(Jogador) && PlayerAPI.Participando.contains(Jogador) && PlayerAPI.Batalhando2.get(Jogador) == Jogador.getName() && PlayerAPI.Ganhador.get(Jogador) != Jogador.getName()) {
				Player Ganhador = Bukkit.getPlayer(PlayerAPI.Batalhando1.get(Jogador));
				PlayerAPI.Batalhando.remove(Jogador);
				PlayerAPI.Participando.remove(Jogador);
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7desistou da batalha contra §6" + Ganhador.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Ganhador.getName() + " §7ganhou a batalha contra §6" + Jogador.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					PlayerAPI.Ganhador.put(Jogadores, Ganhador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				if (PlayerAPI.Participando.size() > 1) {
					PlayerAPI.SelecionarProximoJogador(Ganhador);
				}  else {
					PlayerAPI.CheckarGanhador(Ganhador);
				}
				return;
			}
		}
	}
	
	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent Evento) {
		
		if (!(Evento.getEntity().getKiller() instanceof Player && Evento.getEntity() instanceof Player)) {
			return;
		}
		Player Matador = Evento.getEntity().getKiller();
		Player Vitima = Evento.getEntity();
		if (Matador != Vitima) {
			if (Main.Evento == Estado.ANDAMENTO && PlayerAPI.Participando.contains(Matador) && PlayerAPI.Participando.contains(Vitima)) {
				Matador.sendMessage("§6§lNew§f§lPvP §6» §7Voce ganhou a batalha contra §6" + Vitima.getName());
				Vitima.sendMessage("§6§lNew§f§lPvP §6» §7Voce perdeu a batalha contra §6" + Matador.getName());

				PlayerAPI.RemoverRDM(Vitima);
				
				PlayerAPI.Batalhando1.remove(Matador);
				PlayerAPI.Ganhador.put(Matador, Matador.getName());
				PlayerAPI.Batalhando2.remove(Matador);
				PlayerAPI.Batalhando.remove(Matador);

				PlayerAPI.Batalhando1.remove(Vitima);
				PlayerAPI.Ganhador.put(Vitima, Matador.getName());
				PlayerAPI.Batalhando2.remove(Vitima);
				PlayerAPI.Batalhando.remove(Vitima);
				PlayerAPI.Participando.remove(Vitima);
				
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					PlayerAPI.Batalhando1.remove(Jogadores);
					PlayerAPI.Ganhador.put(Jogadores, Matador.getName());
					PlayerAPI.Batalhando2.remove(Jogadores);
					PlayerAPI.Batalhando.remove(Jogadores);
				}
				
				Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Matador.getName() + " §7ganhou a batalha contra §6" + Vitima.getName() + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
				if (PlayerAPI.Ganhador.get(Matador) == Matador.getName()) {
					Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Matador.getName() + " §7continua na liderança");
				} else {
					Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O jogador §6" + Matador.getName() + " §7e o novo §6ganhador");
				}
				if (PlayerAPI.Participando.size() >= 2) {
					PlayerAPI.SelecionarProximoJogador(Matador);
				} else {
					if (PlayerAPI.Participando.size() == 1) {
						PlayerAPI.CheckarGanhador(Matador);
					}
				}
				
				Evento.getDrops().clear();
				Evento.setDroppedExp(0);
				Evento.setDeathMessage(null);
			}
		} else {
			return;
		}
	}
	
	@EventHandler
	public void onPlayerRespawnEvent(PlayerRespawnEvent Evento) {
		
		Player Jogador = Evento.getPlayer();
		
		if (Configuração.getEvento().get("Saida") == null) {
			Jogador.sendMessage("§6§lNew§f§lPvP §6» §7O local da saida ainda nao foi setado");
			return;
		}
		
		double x = Configuração.getEvento().getDouble("Saida" + ".X");
		double y = Configuração.getEvento().getDouble("Saida" + ".Y");
		double z = Configuração.getEvento().getDouble("Saida" + ".Z");
		float pitch = (float)Configuração.getEvento().getDouble("Saida" + ".Pitch");
		float yaw = (float)Configuração.getEvento().getDouble("Saida" + ".Yaw");
		
		if (Main.Evento == Estado.ANDAMENTO) {
			if (PlayerAPI.Participando.contains(Jogador)) {
				Evento.setRespawnLocation(new Location(Jogador.getWorld(), x, y, z, yaw, pitch));
				API.sendItems(Jogador);
				Proteção.setImortal(Jogador, true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent Evento) {
		
		Player Jogador = Evento.getPlayer();
		
		if (PlayerAPI.Batalhando.contains(Jogador)) {
			if (Evento.getMessage().toLowerCase().startsWith("/")) {
				Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode digitar comandos durante a batalha");
				Evento.setCancelled(true);
			}
			return;
		}
		
		if (PlayerAPI.Participando.contains(Jogador) && !PlayerAPI.Batalhando.contains(Jogador)) {
			if (!Evento.getMessage().startsWith("/sair") && !Evento.getMessage().startsWith("/rdm")) {
				if (!Jogador.hasPermission("RDM.Admin")) {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce so pode executar o comando §6/sair §7neste local");
				} else {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce so pode executar os comandos §6/sair §7e §6/rdm §7neste local");
				}
				Evento.setCancelled(true);
			}
			return;
		}
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent Evento) {
		
		if (Main.Evento == Estado.FECHADO) {
			return;
		}
		
		Player Jogador = Evento.getPlayer();
		if (Main.Evento == Estado.INICIANDO || Main.Evento == Estado.ANDAMENTO) {
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				PlayerAPI.jogador1.put(Jogador, PlayerAPI.jogador1.get(Jogadores));
				PlayerAPI.jogador2.put(Jogador, PlayerAPI.jogador2.get(Jogadores));
				PlayerAPI.jogador3.put(Jogador, PlayerAPI.jogador3.get(Jogadores));
				PlayerAPI.jogador4.put(Jogador, PlayerAPI.jogador4.get(Jogadores));
				PlayerAPI.jogador5.put(Jogador, PlayerAPI.jogador5.get(Jogadores));
				PlayerAPI.jogador6.put(Jogador, PlayerAPI.jogador6.get(Jogadores));
				PlayerAPI.jogador7.put(Jogador, PlayerAPI.jogador7.get(Jogadores));
				PlayerAPI.jogador8.put(Jogador, PlayerAPI.jogador8.get(Jogadores));
				PlayerAPI.jogador9.put(Jogador, PlayerAPI.jogador9.get(Jogadores));
				PlayerAPI.jogador10.put(Jogador, PlayerAPI.jogador10.get(Jogadores));
				PlayerAPI.jogador11.put(Jogador, PlayerAPI.jogador11.get(Jogadores));
				PlayerAPI.jogador12.put(Jogador, PlayerAPI.jogador12.get(Jogadores));
				PlayerAPI.jogador13.put(Jogador, PlayerAPI.jogador13.get(Jogadores));
				PlayerAPI.jogador14.put(Jogador, PlayerAPI.jogador14.get(Jogadores));
				PlayerAPI.jogador15.put(Jogador, PlayerAPI.jogador15.get(Jogadores));
				PlayerAPI.jogador16.put(Jogador, PlayerAPI.jogador16.get(Jogadores));
				PlayerAPI.jogador17.put(Jogador, PlayerAPI.jogador17.get(Jogadores));
				PlayerAPI.jogador18.put(Jogador, PlayerAPI.jogador18.get(Jogadores));
				PlayerAPI.jogador19.put(Jogador, PlayerAPI.jogador19.get(Jogadores));
				PlayerAPI.jogador20.put(Jogador, PlayerAPI.jogador20.get(Jogadores));
				PlayerAPI.jogador21.put(Jogador, PlayerAPI.jogador21.get(Jogadores));
				PlayerAPI.jogador22.put(Jogador, PlayerAPI.jogador22.get(Jogadores));
				PlayerAPI.jogador23.put(Jogador, PlayerAPI.jogador23.get(Jogadores));
				PlayerAPI.jogador24.put(Jogador, PlayerAPI.jogador24.get(Jogadores));
				PlayerAPI.jogador25.put(Jogador, PlayerAPI.jogador25.get(Jogadores));
				PlayerAPI.jogador26.put(Jogador, PlayerAPI.jogador26.get(Jogadores));
				PlayerAPI.jogador27.put(Jogador, PlayerAPI.jogador27.get(Jogadores));
				PlayerAPI.jogador28.put(Jogador, PlayerAPI.jogador28.get(Jogadores));
				PlayerAPI.jogador29.put(Jogador, PlayerAPI.jogador29.get(Jogadores));
				PlayerAPI.jogador30.put(Jogador, PlayerAPI.jogador30.get(Jogadores));
				
				
			}
		}
	}
	
} 
