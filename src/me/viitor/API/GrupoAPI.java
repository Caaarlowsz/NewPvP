package me.viitor.API;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.viitor.API.CalendarioAPI.Calendario;
import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfTempGrupo;
import me.viitor.events.CorGrupo;
import me.viitor.main.Main;
import me.viitor.scoreboard.sScoreAPI;

public class GrupoAPI {
	
	public static boolean Checando; 
	
	public static void expirar(Player p, int dia, int mes, int ano, int hora, int minutos, int segundos){
		
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", p.getName());
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", dia);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", mes);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", ano);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", hora);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", minutos);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", segundos);
		cfTempGrupo.salvarconfiguracao();
		
		checarVip(p);
		
		 
		if(cfGrupo.ChecarGrupo(p, "Dono")){
			CorGrupo.setarTag(p, "§4§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Gerente")){
			CorGrupo.setarTag(p, "§c§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Admin")){
			CorGrupo.setarTag(p, "§c§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Mod+")){
			CorGrupo.setarTag(p, "§5§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Mod")){
			CorGrupo.setarTag(p, "§5§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Trial")){
			CorGrupo.setarTag(p, "§5§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
			CorGrupo.setarTag(p, "§3§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Helper")){
			CorGrupo.setarTag(p, "§9§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Youtuber")){
			CorGrupo.setarTag(p, "§b§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "S-Pro")){
			CorGrupo.setarTag(p, "§e§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Pro")){
			CorGrupo.setarTag(p, "§6§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Mvp")){
			CorGrupo.setarTag(p, "§9§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Light")){
			CorGrupo.setarTag(p, "§a§l");
		}
		else if(cfGrupo.ChecarGrupo(p, "Membro")){
			CorGrupo.setarTag(p, "§7§l");
		}
		sScoreAPI.scoreboard(p);
		p.chat("/tag " + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo"));
	  }
	public static void expirarOffline(OfflinePlayer p, int dia, int mes, int ano, int hora, int minutos, int segundos){
		
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", p.getName());
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", dia);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", mes);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", ano);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", hora);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", minutos);
		cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", segundos);
		cfTempGrupo.salvarconfiguracao();
		
		checarVipOffline(p);
	  }
	public static void checarVip(Player p){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			public void run() {
			
				if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Dia") != null){
					if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Mes") != null){
						if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Ano") != null){
							if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Hora") != null){
								if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Minuto") != null){
									if(cfTempGrupo.pegargrupo().get("tempgrupos." + p.getUniqueId() + ".Segundos") != null){
				if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") < CalendarioAPI.PegarCalendario(Calendario.Dia) 
						|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") == CalendarioAPI.PegarCalendario(Calendario.Dia)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
					
					if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") < CalendarioAPI.PegarCalendario(Calendario.Mes) 
							|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") == CalendarioAPI.PegarCalendario(Calendario.Mes)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
					
						if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") < CalendarioAPI.PegarCalendario(Calendario.Ano) 
								|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") == CalendarioAPI.PegarCalendario(Calendario.Ano)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
							
							if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") < CalendarioAPI.PegarCalendario(Calendario.Hora) 
									|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") == CalendarioAPI.PegarCalendario(Calendario.Hora)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
								
								if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") < CalendarioAPI.PegarCalendario(Calendario.Minuto) 
										|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") == CalendarioAPI.PegarCalendario(Calendario.Minuto)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
									
									if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Segundos") < CalendarioAPI.PegarCalendario(Calendario.Segundo) 
											|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Segundos") == CalendarioAPI.PegarCalendario(Calendario.Segundo)&& (cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")))))){
					
						API.mandarTitulo(p, "§6§lCake§f§lKits");
						API.mandarSubTitulo(p, "§7Seu VIP [§6§l" + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7] expirou");
						cfGrupo.salvarconfiguracao();
						Bukkit.getConsoleSender().sendMessage("§6§lNew§f§lPvP §6» §7O VIP do jogador §6" + p.getName() + " §7expirou");
						p.sendMessage("§6§lNew§f§lPvP §6» §7Seu VIP [§6§l" + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7] expirou");
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".grupo", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", null);
						cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", null);
						
						cfTempGrupo.salvarconfiguracao();
						
						
						for(Player todos : Bukkit.getOnlinePlayers()){
							
							if(cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos,"Gerente") || cfGrupo.ChecarGrupo(todos, "Admin")){
								todos.sendMessage("§6§lNew§f§lPvP §6» §7O VIP [§6§l" + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7] do jogador §6" + p.getName() + " §7expirou");
												}
											}
						cfGrupo.setarGrupo(p, "Membro");
						if(cfGrupo.ChecarGrupo(p, "Dono")){
							CorGrupo.setarTag(p, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Gerente")){
							CorGrupo.setarTag(p, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Admin")){
							CorGrupo.setarTag(p, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Mod+")){
							CorGrupo.setarTag(p, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Mod")){
							CorGrupo.setarTag(p, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Trial")){
							CorGrupo.setarTag(p, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
							CorGrupo.setarTag(p, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Builder")){
							CorGrupo.setarTag(p, "§2§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Helper")){
							CorGrupo.setarTag(p, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Youtuber")){
							CorGrupo.setarTag(p, "§b§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "S-Pro")){
							CorGrupo.setarTag(p, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Pro")){
							CorGrupo.setarTag(p, "§6§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Mvp")){
							CorGrupo.setarTag(p, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Light")){
							CorGrupo.setarTag(p, "§a§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Membro")){
							CorGrupo.setarTag(p, "§7§l");
						}
						sScoreAPI.scoreboard(p);
						p.chat("/tag normal");
										}
									}
								}
							}
					}
				}
			}
								}
							}
						}
					}
				}
			}
		}, 0L, 20L);
	}
		public static void checarVipOffline(OfflinePlayer p){
			Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
				public void run() {
				
					if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") < CalendarioAPI.PegarCalendario(Calendario.Dia) 
							|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Dia") == CalendarioAPI.PegarCalendario(Calendario.Dia)&& (!cfGrupo.ChecarGrupo(p, "Membro")))))){
						
						if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") < CalendarioAPI.PegarCalendario(Calendario.Mes) 
								|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Mes") == CalendarioAPI.PegarCalendario(Calendario.Mes)&& (!cfGrupo.ChecarGrupo(p, "Membro")))))){
						
							if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") < CalendarioAPI.PegarCalendario(Calendario.Ano) 
									|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Ano") == CalendarioAPI.PegarCalendario(Calendario.Ano)&& (!cfGrupo.ChecarGrupo(p, "Membro")))))){
								
								if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") < CalendarioAPI.PegarCalendario(Calendario.Hora) 
										|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Hora") == CalendarioAPI.PegarCalendario(Calendario.Hora)&& (!cfGrupo.ChecarGrupo(p, "Membro")))))){
									
									if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") < CalendarioAPI.PegarCalendario(Calendario.Minuto) 
											|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Minuto") == CalendarioAPI.PegarCalendario(Calendario.Minuto)&& (!cfGrupo.ChecarGrupo(p, "Membro")))))){
										
										if((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Segundos") < CalendarioAPI.PegarCalendario(Calendario.Segundo) 
												|| ((cfTempGrupo.pegargrupo().getInt("tempgrupos." + p.getUniqueId() + ".Segundos") == CalendarioAPI.PegarCalendario(Calendario.Segundo)&& (!cfGrupo.ChecarGrupo(p, "Membro")))))){
						
											if(cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Light")){
												cfGrupo.salvarconfiguracao();
												Bukkit.getConsoleSender().sendMessage("§6§lNew§f§lPvP §6» §7O VIP do jogador §6" + p.getName() + " §7expirou");
												cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Nick", null);
												cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".grupo", null);
												cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Dia", null);
												cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Mes", null);
												cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Ano", null);
												cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Hora", null);
												cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Minuto", null);
												cfTempGrupo.pegargrupo().set("tempgrupos." + p.getUniqueId() + ".Segundos", null);
												
												cfTempGrupo.salvarconfiguracao();
												for(Player todos : Bukkit.getOnlinePlayers()){
													
													if(cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos,"Gerente") || cfGrupo.ChecarGrupo(todos, "Admin")){
														todos.sendMessage("§6§lNew§f§lPvP §6» §7O VIP [§6§l" + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7] do jogador §6" + p.getName() + " §7expirou");
																		}
																	}
												cfGrupo.setarGrupo(p, "Membro");
											}
										}
									}
								}
							}
						}
					}
				}
			}, 0L, 20L);
	}
}
