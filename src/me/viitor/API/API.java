package me.viitor.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.spigotmc.ProtocolInjector;

import me.viitor.API.CalendarioAPI.Calendario;
import me.viitor.bossbar.api.BossBarAPI;
import me.viitor.commands.GiveAllCommand;
import me.viitor.configuração.cfConfig;
import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfKitdiario;
import me.viitor.configuração.cfPermissão;
import me.viitor.configuração.cfStatus;
import me.viitor.configuração.cfTempGrupo;
import me.viitor.events.CorGrupo;
import me.viitor.habilidades.Ajnin;
import me.viitor.habilidades.Ninja;
import me.viitor.habilidades.Strong;
import me.viitor.invencivel.Proteção;
import me.viitor.main.Main;
import me.viitor.nametag.Array;
import me.viitor.nametag.NametagManager;
import me.viitor.nametag.NametagUtils;
import me.viitor.nametag.PlayerLoader;
import me.viitor.scoreboard.sScoreAPI;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayOutChat;

public class API {

	public static ArrayList<Player> inCombat = new ArrayList<>();
	
	public static void BarAPI(Player p, String menssagem){
		
		int numero = 20;
				BossBarAPI.setMessage(p, menssagem);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						BossBarAPI.removeBar(p);
					}
				}, numero * 4);
			}
	public static void checarGrupo(Player p){

		if(cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") == null){
			cfGrupo.setarGrupo(p, "Membro");
			cfGrupo.salvarconfiguracao();
		}
		else if(cfGrupo.pegargrupo().get("configuração." + p.getUniqueId() + ".PadraoKit") == null){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "PvP");
			cfConfig.salvarconfiguracao();
		}
	}
	public static void  setarKitPadrao(Player p){
		if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("PvP")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "PvP");
			cfConfig.salvarconfiguracao();
			}
		 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Archer")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Archer");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Kangaroo")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Kangaroo");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Fisherman")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Fisherman");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Cactus")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Cactus");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Monk")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Monk");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Ninja")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Ninja");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Phantom")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Phantom");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Grappler")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Grappler");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Viper")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Viper");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Snail")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Snail");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Hulk")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Hulk");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Timelord")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Timelord");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Thor")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Thor");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Switcher")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Switcher");
			cfConfig.salvarconfiguracao();
			}
			 	if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Gladiator")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Gladiator");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Stomper")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Stomper");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Magma")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Magma");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Grandpa")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Grandpa");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Ajnin")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Ajnin");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("FireLauncher")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "FireLauncher");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Strong")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Strong");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals("Sumo")){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "Sumo");
			cfConfig.salvarconfiguracao();
			}
			 if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit").equals(null)){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "PvP");
			cfConfig.salvarconfiguracao();
			}
	}
	public static void corGrupo(Player p){
		
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
	}
	public static void acharTag(Player p){
		 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				API.checarGrupo(p);
				 if(cfGrupo.ChecarGrupo(p, "Dono")){
					 p.chat("/tag dono");
			}
				 if(cfGrupo.ChecarGrupo(p, "Admin")){
				p.chat("/tag admin");
			}
				 if(cfGrupo.ChecarGrupo(p, "Gerente")){
				p.chat("/tag gerente");
			}
				 if(cfGrupo.ChecarGrupo(p, "Mod+")){
				p.chat("/tag modplus");
			}
				 if(cfGrupo.ChecarGrupo(p, "Mod")){
				p.chat("/tag mod");
			}
				 if(cfGrupo.ChecarGrupo(p, "Trial")){
				p.chat("/tag trial");
			}
				 if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
				p.chat("/tag ytplus");
			}
				 if(cfGrupo.ChecarGrupo(p, "Builder")){
					 p.chat("/tag builder");
			}
				 if(cfGrupo.ChecarGrupo(p, "Helper")){
				p.chat("/tag helper");
			}
				 if(cfGrupo.ChecarGrupo(p, "Youtuber")){
				p.chat("/tag yt");
			}
				 if(cfGrupo.ChecarGrupo(p, "Pro")){
				p.chat("/tag pro");
			}
				 if(cfGrupo.ChecarGrupo(p, "S-Pro")){
				p.chat("/tag s-pro");
			}
				 if(cfGrupo.ChecarGrupo(p, "Mvp")){
				p.chat("/tag mvp");
			}
				 if(cfGrupo.ChecarGrupo(p, "Light")){
				p.chat("/tag light");
			}
				 if(cfGrupo.ChecarGrupo(p, "Membro")){
				p.chat("/tag normal");
			 }
		    if(GiveAllCommand.pro && cfGrupo.ChecarGrupo(p, "Membro")){
						p.chat("/tag pro");
					}
					 if(GiveAllCommand.mvp && cfGrupo.ChecarGrupo(p, "Membro")){
						p.chat("/tag mvp");
					}
					 if(GiveAllCommand.light && cfGrupo.ChecarGrupo(p, "Membro")){
						p.chat("/tag light");
					}
			}
		 }, 2L);
	}
	@SuppressWarnings("deprecation")
	public static void checarAlgumasCoisas(Player p){
		
		 if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Youtuber")
				 && (cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") == null)){
				 p.sendMessage("§6§lNew§f§lPvP §6» §7Você já pode pegar seu kit diario.");
					 
				 }
				API.sendItems(p);
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
					
						API.mandarTitulo(p, "§6§lNew§f§lPvP");
						API.mandarSubTitulo(p, "§7Seu VIP [§6§l" + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7] expirou");
						cfGrupo.salvarconfiguracao();
						Bukkit.getConsoleSender().sendMessage("§6§lNew§f§lPvP §6» §7O VIP do jogador §6" + p.getName() + " §7expirou");
						p.sendMessage("§6§lNew§f§lPvP §6» §7Seu VIP §7[§6§l" + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7] expirou");
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
							
							if(cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos,"Gerente") || cfGrupo.ChecarGrupo(todos,"Admin")){
								todos.sendMessage("§6§lNew§f§lPvP §6» §7O VIP [§6§l" + cfGrupo.pegargrupo().getString("grupos." + p.getUniqueId() + ".grupo") + "§7] do jogador §6" + p.getName() + " §7expirou");
												}
											}
						cfGrupo.setarGrupo(p, "Membro");
						if(cfGrupo.ChecarGrupo(p, "Dono")){
							CorGrupo.setarTag(p, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(p, "Gerente")){
							CorGrupo.setarTag(p, "§4§l");
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
	public static void checarNameTag(Player p){
		 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			@SuppressWarnings("unused")
			public void run() {
				
		 NametagManager.MandarTeamsParaJogador(p);
	        NametagManager.Limpar(p.getName());
	        boolean SetarGrupo = true;
	          
	        LinkedHashMap<String, String> pData = PlayerLoader.getPlayer(p.getName());
	        if (pData != null) {
	        	String Prefix = (String)pData.get("prefix");
	        	String Suffix = (String)pData.get("suffix");
	        	if (Prefix != null) {
	        		Prefix = NametagUtils.formatColors(Prefix);
	        	}
	        	if (Suffix != null) {
	        		Suffix = NametagUtils.formatColors(Suffix);
	        	}
	        	if (Array.consolePrintEnabled) {
	        		System.out.println("Setting prefix/suffix for " + p.getName() + ": " + Prefix + ", " + Suffix + " (user)");
	        	}
	        	NametagManager.Overlap(p.getName(), Prefix, Suffix);
	        	SetarGrupo = false;
	        }
		 }
		}, 1L);
		 Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				acharTag(p);
			}
		}, 2L);
	}
	public static void checarConfig(Player p){
		if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Nick") == null){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Nick", p.getName());
			cfConfig.salvarconfiguracao();
		}
			if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".PadraoKit") == null){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".PadraoKit", "PvP");
			cfConfig.salvarconfiguracao();
			}
			if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell") == null){
			cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell", "Ativado");
			cfConfig.salvarconfiguracao();
			}
			cfConfig.salvarconfiguracao();
	}
	public static void checarPermissao(Player p){

		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.monk") == null){
			cfPermissão.setarPermissao(p, "kit.monk", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.kangaroo") == null){
			cfPermissão.setarPermissao(p, "kit.kangaroo", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.ninja") == null){
			cfPermissão.setarPermissao(p, "kit.ninja", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.phantom") == null){
			cfPermissão.setarPermissao(p, "kit.phantom", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.grappler") == null){
			cfPermissão.setarPermissao(p, "kit.grappler", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.viper") == null){
			cfPermissão.setarPermissao(p, "kit.viper", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.snail") == null){
			cfPermissão.setarPermissao(p, "kit.snail", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.hulk") == null){
			cfPermissão.setarPermissao(p, "kit.hulk", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.timelord") == null){
			cfPermissão.setarPermissao(p, "kit.timelord", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.thor") == null){
			cfPermissão.setarPermissao(p, "kit.thor", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.switcher") == null){
			cfPermissão.setarPermissao(p, "kit.switcher", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.gladiator") == null){
			cfPermissão.setarPermissao(p, "kit.gladiator", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.endermage") == null){
			cfPermissão.setarPermissao(p, "kit.endermage", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.stomper") == null){
			cfPermissão.setarPermissao(p, "kit.stomper", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.magma") == null){
			cfPermissão.setarPermissao(p, "kit.magma", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.grandpa") == null){
			cfPermissão.setarPermissao(p, "kit.grandpa", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.ajnin") == null){
			cfPermissão.setarPermissao(p, "kit.ajnin", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.firelauncher") == null){
			cfPermissão.setarPermissao(p, "kit.firelauncher", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.strong") == null){
			cfPermissão.setarPermissao(p, "kit.strong", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.forcefield") == null){
			cfPermissão.setarPermissao(p, "kit.forcefield", "false");
		}
		if(cfPermissão.pegarpermissao().get("permissões." + p.getUniqueId() + ".kit.sumo") == null){
			cfPermissão.setarPermissao(p, "kit.sumo", "false");
			
		}
	}
public static void AutomaticMessage() {
		
		Random random = new Random();
		switch (random.nextInt(10)) {
		case 1:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Ajude nosso servidor a crescer e se manter online comprando VIP em nossa loja: §6mc-new.tk/loja");
			break;
		case 2:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Nossa equipe e grata a sua jogatina no servidor");
			break;
		case 3:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Envie-nos dicas e sugestoes para fazer com que o servidor se torne melhor gradativamente por meio do comando §6/dica <Dica>");
			break;
		case 4:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Fique por dentro de tudo que acontece em nossa rede por meio de nosso Twitter: §6@NewNetworkMC");
			break;
		case 5:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Caso encontre algum hacker, nao exite em reporta-lo por meio do comando §6/report <Jogador> <Motivo>");
			break;
		case 6:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Obtenha mais informacoes sobre o servidor em nosso site: §6mc-new.tk");
			break;
		case 7:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Possuimos placas de §6VIP §7escondidas pelo mapa. Ache-as e clique para ganhar o respectivo §6VIP");
			break;
		case 8:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Confira os requisitos para a tag §6YouTuber §7por meio do comando §6/youtuber");
			break;
		case 9:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Acompanhe nossos banimentos por meio do twitter §6@NewMCBans");
			break;
		case 10:
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Acompanhe as novidades de nossa staff por meio do twitter §6@NewMCStaff");
			break;
		}
	}
	public static ItemStack criarItem(Player p, Material material, String nome, String[] lore, int quantidade, short cor){
		
		ItemStack item = new ItemStack(material, quantidade, cor);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(lore));
		item.setItemMeta(kitem);
		
		return item;
	}
	private static HashMap<Player, String> Warp = new HashMap<>();
	
	public static String getWarp(Player p){
		
		if(Warp.containsKey(p)){
			return Warp.get(p);
		}else{
			return "Spawn";
		}
	}
	public static void setWarp(Player p, String warp){
		Warp.put(p, warp);
	}
	public static void sendItems(Player p){
		
		if(getWarp(p) == "Spawn"){
			
			p.getInventory().setArmorContents(null);
			Ajnin.a.remove(p);
			Ninja.a.remove(p);
			Ninja.b.remove(p);
			Strong.fulliron.remove(p);
			p.setFoodLevel(20);
			p.setFireTicks(0);
			cfStatus.RemoverKS(p);
			API.setWarp(p, "Spawn");
			
			
			ItemStack Kits = new ItemStack(Material.CHEST);
			ItemMeta kKits = Kits.getItemMeta();
			kKits.setDisplayName("§6» §7Seletor de KITS");
			kKits.setLore(Arrays.asList("§7Confira, neste menu,", "§7os kits que voce possui"));
			Kits.setItemMeta(kKits);
			
			ItemStack Warps = new ItemStack(Material.NAME_TAG);
			ItemMeta kWarps = Warps.getItemMeta();
			kWarps.setDisplayName("§6» §7Seletor de WARPS");
			kWarps.setLore(Arrays.asList("§7Confira, neste menu,", "§7as warps disponiveis em nosso servidor"));
			Warps.setItemMeta(kWarps);
			
			ItemStack Loja = new ItemStack(Material.EMERALD);
			ItemMeta kLoja = Loja.getItemMeta();
			kLoja.setDisplayName("§6» §7Loja");
			kLoja.setLore(Arrays.asList("§7Clique neste item para", "§7obter o link de nossa loja"));
			Loja.setItemMeta(kLoja);
			
			ItemStack Rank = new ItemStack(Material.FLOWER_POT_ITEM);
			ItemMeta kRank = Rank.getItemMeta();
			kRank.setDisplayName("§6» §7Configuracoes pessoais");
			kRank.setLore(Arrays.asList("§7Configure, por este menu,", "§7algumas coisas pessoais"));
			Rank.setItemMeta(kRank);
			
			ItemStack Heads = new ItemStack(Material.NOTE_BLOCK);
			ItemMeta kHeads = Heads.getItemMeta();
			kHeads.setDisplayName("§6» §7Heads");
			kHeads.setLore(Arrays.asList("§7Selecione, neste menu", "§7uma cabeca para ser colocada"));
			Heads.setItemMeta(kHeads);
			
			ItemStack Caixas = new ItemStack(Material.ENDER_CHEST);
			ItemMeta kCaixas = Caixas.getItemMeta();
			kCaixas.setDisplayName("§6» §7Kit DIARIO");
			kCaixas.setLore(Arrays.asList("§7Ganhe KITS validos por 1 dia", "§7a cada 24 horas"));
			Caixas.setItemMeta(kCaixas);
			
			@SuppressWarnings("deprecation")
			ItemStack KitPadrao = new ItemStack(Material.getMaterial(351), 1, (short)14);
			ItemMeta kKitPadrao = KitPadrao.getItemMeta();
			kKitPadrao.setDisplayName("§6» §7Kit PADRAO");
			kKitPadrao.setLore(Arrays.asList("§7Escolhe um KIT para ser", "§7setado como PADRAO"));
			KitPadrao.setItemMeta(kKitPadrao);
			
			ItemStack Vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
			ItemMeta kVidro = Caixas.getItemMeta();
			kVidro.setDisplayName("§6§lNew§f§lPvP");
			kVidro.setLore(Arrays.asList("§7Apenas um vidro"));
			Vidro.setItemMeta(kVidro);

			
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			
			Proteção.setImortal(p, true);
			
			p.setHealth(20.0D);
			p.setMaxHealth(20.0D);
			
			sScoreAPI.scoreboard(p);
			
			CooldownAPI.tirarCooldown(p);
			WarpsAPI.Ir(p, "Spawn");
			
			if(cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") == null){
				p.getInventory().setItem(8,     Caixas);
			}
			         
			p.getInventory().setHeldItemSlot(4);
			p.getInventory().setItem(4, Kits);
			p.getInventory().setItem(2, Warps);
			p.getInventory().setItem(6, Loja);
			p.getInventory().setItem(0, Heads);
			p.getInventory().setItem(3, Vidro);
			p.getInventory().setItem(5, Vidro);
		}
	}
	public static int getAmount(Player p, Material m) {
	     int amount = 0;
	     for (ItemStack item : p.getInventory().getContents()) {
	      if ((item != null) && (item.getType() == m) && (item.getAmount() > 0)) {
	       amount += item.getAmount();
	      }
	     }
	     return amount;
	 }
	public static void mandarTitulo(Player player, String titulo) {
	    if (((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() < 45) {
	    	return;
	    }
	    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE, ChatSerializer.a("{\"text\": \"\"}").a(titulo)));
	}
	public static void mandarSubTitulo(Player player, String titulo) {
	    if (((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() < 45) {
	    	return;
	    }
	    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE, ChatSerializer.a("{\"text\": \"\"}").a(titulo)));
	}
	public static void mandarActionBar(Player player, String titulo) {
		  CraftPlayer p = (CraftPlayer) player;
		  if (p.getHandle().playerConnection.networkManager.getVersion() != 47) {
		   return;
		  }
		
		  IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + titulo + "\"}");
		  PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, 2);
		  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
		  ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
	} 
	public static void clear(Player player) {
	    if (((CraftPlayer)player).getHandle().playerConnection.networkManager.getVersion() < 45) {
	    	return;
	    }
	    ((CraftPlayer)player).getHandle().playerConnection.sendPacket(new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
	}
	public static void setHotbar(Player p) {
		ItemStack Kits = new ItemStack(Material.CHEST);
		ItemMeta kKits = Kits.getItemMeta();
		kKits.setDisplayName("§6» §7Seletor de KITS");
		kKits.setLore(Arrays.asList("§7Confira, neste menu,", "§7os kits que voce possui"));
		Kits.setItemMeta(kKits);
		
		ItemStack Warps = new ItemStack(Material.NAME_TAG);
		ItemMeta kWarps = Warps.getItemMeta();
		kWarps.setDisplayName("§6» §7Seletor de WARPS");
		kWarps.setLore(Arrays.asList("§7Confira, neste menu,", "§7as warps disponiveis em nosso servidor"));
		Warps.setItemMeta(kWarps);
		
		ItemStack Loja = new ItemStack(Material.EMERALD);
		ItemMeta kLoja = Loja.getItemMeta();
		kLoja.setDisplayName("§6» §7Loja");
		kLoja.setLore(Arrays.asList("§7Clique neste item para", "§7obter o link de nossa loja"));
		Loja.setItemMeta(kLoja);
		
		ItemStack Rank = new ItemStack(Material.FLOWER_POT_ITEM);
		ItemMeta kRank = Rank.getItemMeta();
		kRank.setDisplayName("§6» §7Configuracoes pessoais");
		kRank.setLore(Arrays.asList("§7Configure, por este menu,", "§7algumas coisas pessoais"));
		Rank.setItemMeta(kRank);
		
		ItemStack Heads = new ItemStack(Material.NOTE_BLOCK);
		ItemMeta kHeads = Heads.getItemMeta();
		kHeads.setDisplayName("§6» §7Heads");
		kHeads.setLore(Arrays.asList("§7Selecione, neste menu", "§7uma cabeca para ser colocada"));
		Heads.setItemMeta(kHeads);
		
		ItemStack Caixas = new ItemStack(Material.ENDER_CHEST);
		ItemMeta kCaixas = Caixas.getItemMeta();
		kCaixas.setDisplayName("§6» §7Kit DIARIO");
		kCaixas.setLore(Arrays.asList("§7Ganhe KITS validos por 1 dia", "§7a cada 24 horas"));
		Caixas.setItemMeta(kCaixas);
		
		@SuppressWarnings("deprecation")
		ItemStack KitPadrao = new ItemStack(Material.getMaterial(351), 1, (short)14);
		ItemMeta kKitPadrao = KitPadrao.getItemMeta();
		kKitPadrao.setDisplayName("§6» §7Kit PADRAO");
		kKitPadrao.setLore(Arrays.asList("§7Escolhe um KIT para ser", "§7setado como PADRAO"));
		KitPadrao.setItemMeta(kKitPadrao);
		
		ItemStack Vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
		ItemMeta kVidro = Caixas.getItemMeta();
		kVidro.setDisplayName("§6§lNew§f§lPvP");
		kVidro.setLore(Arrays.asList("§7Apenas um vidro"));
		Vidro.setItemMeta(kVidro);
		
		if(cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".dia") == null){
			p.getInventory().setItem(8,     Caixas);
		}
		         
		p.getInventory().setHeldItemSlot(4);
		p.getInventory().setItem(4, Kits);
		p.getInventory().setItem(2, Warps);
		p.getInventory().setItem(6, Loja);
		p.getInventory().setItem(0, Heads);
		p.getInventory().setItem(3, Vidro);
		p.getInventory().setItem(5, Vidro);
	}
	@SuppressWarnings("deprecation")
	public static void sendWarn(String msg) {
		for(Player todos : Bukkit.getOnlinePlayers()) {
			if(cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos, "Gerente")) {
				for(Player k : Bukkit.getOnlinePlayers()) {
					if(cfGrupo.ChecarGrupo(k, "Dono") || cfGrupo.ChecarGrupo(k, "Gerente") || cfGrupo.ChecarGrupo(k, "Admin") || cfGrupo.ChecarGrupo(k, "Mod+") || cfGrupo.ChecarGrupo(k, "Mod") || cfGrupo.ChecarGrupo(k, "Trial") || cfGrupo.ChecarGrupo(k, "Youtuber+") || cfGrupo.ChecarGrupo(k, "Helper")) {
						if(ArraysAPI.Monitor.contains(todos)) {
							todos.sendMessage(msg);
							return;
						}
					}
				}
			}
		}
	}
}
