package me.viitor.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.HorarioAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.main.Main;
import me.viitor.twitter.TweetAPI;

public class TempBanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("tempban")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+"))))))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /tempban <Jogador> <Ftell (Flood no Tell) | FFA (Free for All) | Tfps (Time na FPS) | Fkill (Free Kill) | Ofs (Ofensa a Staffer) | Oftell (Ofensa pelo Tell) | Abug (Abuso de Bugs) | Citlink (Citacao de links externos [nao relacionados ao servidor]) | Fident (Falsa identidade [ex: se passar por um staffer])");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" +  args[0] +  " §7encontra-se §6§lOFFLINE");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitima.getName() + " §7ja esta §6§lBANIDO TEMPORARIAMENTE");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" +  vitima.getName() +  " §7ja esta §6§lBANIDO POR IP");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" +  args[0] +  " §7ja esta §6§lBANIDO PERMANENTEMENTE");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao pode banir a si mesmo");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args.length == 1) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /tempban <Jogador> <Ftell (Flood no Tell) | FFA (Free for All) | Tfps (Time na FPS) | Fkill (Free Kill) | Ofs (Ofensa a Staffer) | Abug (Abuso de Bugs)");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args[1].equalsIgnoreCase("ftell")) {
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " temporariamente por Flood no Tell");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " temporariamente por Flood no Tell");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " temporariamente pelo motivo Flood no Tell");
				vitima.kickPlayer( "§fVocê foi §c§lBANIDO TEMPORARIAMENTE" + "\n§fPelo." + jogador.getName() + "\n" +  "§cMotivo: Flood no Tell" + "\n" + "§cDuracao do banimento: 2 dias" + "\n" + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)");
				
				TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: Flood no Tell" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Flood no Tell");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("ffa")) {
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " temporariamente por Free for All");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " temporariamente por Free for All");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " temporariamente pelo motivo Free for All");
				vitima.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: Free for All" + "\n" + "§cDuracao do banimento: 2 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)");
				
				TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: Free for All" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Free for All");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("fkill")) {
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " temporariamente por FreeKill");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " temporariamente por FreeKill");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " temporariamente pelo motivo FreeKill");
				vitima.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: FreeKill" + "\n" + "§cDuracao do banimento: 4 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)"); 
				
				TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: FreeKill" + "\n" + "Duração: 4 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "FreeKill");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "4 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
					}
				}, 6912000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("ofs")) {
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " temporariamente por Ofensa a Staffer");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " temporariamente por Ofensa a Staffer");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " temporariamente pelo motivo Ofensa a Staffer");
				vitima.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: Ofensa a Staffer" + "\n" + "§cDuracao do banimento: 4 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)"); 
				
				TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: Ofensa a Staffer" + "\n" + "Duração: 4 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Ofensa a Staffer");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "4 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
					}
				}, 6912000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("abug")) {
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " temporariamente por Abuso de Bugs");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " temporariamente por Abuso de Bugs");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " temporariamente pelo motivo Abuso de Bugs");
				vitima.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: Abuso de Bugs" + "\n" + "§cDuracao do banimento: 7 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)"); 
				
				TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: Abuso de Bugs" + "\n" + "Duração: 7 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Abuso de Bugs");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "7 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
					}
				}, 12096000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("tfps")) {
				if (args.length == 2) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /tempban <Jogador> TFPS <Time>");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				final Player vitimatime = Bukkit.getPlayer(args[2]);
				if (vitimatime == null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (vitima.getName() == vitimatime.getName()) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Os dois nicks tem de ser diferentes");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) != null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador §6" + vitimatime.getName() + " §7ja esta §6§lBANIDO TEMPORARIAMENTE");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getIpBans().get("IPBans." + vitimatime.getUniqueId()) != null)  {
					 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitimatime.getName() + " §7ja esta §6§lBANIDO POR IP");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
				}
				if (Config.getConfig().getBans().get("Bans." + vitimatime.getUniqueId()) != null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitimatime.getName() + " §7ja esta §6§lBANIDO PERMANENTEMENTE");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (vitima.getName() == jogador.getName()) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao pode banir a si mesmo");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (vitimatime.getName() == jogador.getName()) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Você nao pode banir a si mesmo");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " e " + vitimatime.getName() + " temporariamente por Time na FPS");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " e " + vitimatime.getName() + " temporariamente por Time na FPS");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu os jogadores " + vitima.getName() + " e " + vitimatime.getName() + " temporariamente pelo motivo Time na FPS");
				vitima.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: Time na FPS" + "\n" + "§cDuracao do banimento: 2 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)");
				vitimatime.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: Time na FPS" + "\n" + "§cDuracao do banimento: 2 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)"); 
				
				TweetAPI.update("Jogadores banidos: " + vitima.getName() + " e " + vitimatime.getName() + "\n" + "Banidos por: " + jogador.getName() + "\n" + "Motivo: Time na FPS" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Time na FPS");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Nome", vitimatime.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Motivo", "Time na FPS");
				Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
			
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if ((Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) == null) && (Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) != null)) {
							Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitimatime.getName() +  " foi desbanido automaticamente.");
							API.sendStaff("§7O jogador " + vitimatime.getName() + " foi desbanido automaticamente");
						}
						else if ((Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) && (Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) == null)) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
						else if ((Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) && (Config.getConfig().getTempBans().get("TempBans." + vitimatime.getUniqueId()) != null)) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().getTempBans().set("TempBans." + vitimatime.getUniqueId(), null);	
							Config.getConfig().saveTempBans();
							API.sendBC("§cOs jogadores " +  vitima.getName() +  " foram desbanidos automaticamente.");
							API.sendStaff("§7Os jogadores " + vitima.getName() + " e " + vitimatime.getName() + " foram desbanidos automaticamente");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("oftell")) {
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " temporariamente por Ofensa pelo Tell");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " temporariamente por Ofensa pelo Tell");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " temporariamente pelo motivo Ofensa pelo Tell");
				vitima.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: Ofensa pelo Tell" + "\n" + "§cDuracao do banimento: 2 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)"); 
				
				TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: Ofensa pelo Tell" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Ofensa pelo Tell");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("citlink")) {
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " temporariamente por Citar links externos");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " temporariamente por Citar links externos");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " temporariamente pelo motivo Citar links externos");
				vitima.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: Citar links externos" + "\n" + "§cDuracao do banimento: 2 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)"); 
				
				TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: Citar links externos" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Citar links externos");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "2 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("fident")) {
				API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " temporariamente por Falsa identidade");
				API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " temporariamente por Falsa identidade");
				API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " temporariamente pelo motivo Falsa identidade");
				vitima.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: Falsa identidade" + "\n" + "§cDuracao do banimento: 7 dias" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)"); 
				
				TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: Falsa identidade" + "\n" + "Duração: 7 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Motivo", "Falsa identidade");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Tempo do Ban", "7 dias");
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				
				Config.getConfig().saveTempBans();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null) {
							Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempBans();
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desbanido automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desbanido automaticamente");
						}
					}
				}, 12096000L);
				return true;
			}
			API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /tempban <Jogador> <Ftell (Flood no Tell) | FFA (Free for All) | Tfps (Time na FPS) | Fkill (Free Kill) | Ofs (Ofensa a Staffer) | Oftell (Ofensa pelo Tell) | Abug (Abuso de Bugs) | Citlink (Citacao de links externos [nao relacionados ao servidor]) | Fident (Falsa identidade [ex: se passar por um staffer])");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		return false;
	}
}
