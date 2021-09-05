package me.viitor.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.HorarioAPI;
import me.viitor.bans.API;
import me.viitor.bans.Config;
import me.viitor.configuração.cfGrupo;
import me.viitor.main.Main;
import me.viitor.twitter.TweetAPI;

public class TempMuteCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("tempmute")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+") && (!cfGrupo.ChecarGrupo(jogador, "Helper")))))))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /tempmute <Jogador> <Flood | Pdvip (Pedir VIP) | Pdstaff (Pedir Staff) | Ofj (Ofensa a Jogador) | Citch (Citar nome de canais) | Citsv (Citar nome de servidores) | Comercio | Spam | Cplk (Falar com o CapsLock ativado)>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			final Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao pode mutar a si mesmo");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getMute().get("Mute." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitima.getName() + " ja esta §6§lMUTADO PERMANENTEMENTE");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitima.getName() + " ja esta §6§lBANIDO TEMPORARIAMENTE");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (args.length == 1) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /tempmute <Jogador> <Flood | Pdvip (Pedir VIP) | Pdstaff (Pedir Staff) | Ofj (Ofensa a Jogador) | Citch (Citar nome de canais) | Citsv (Citar nome de servidores) | Comercio | Spam | Cplk (Falar com o CapsLock ativado)>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args[1].equalsIgnoreCase("flood")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por Flood");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por Flood");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo Flood");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por Flood");
				API.sendMsg(vitima, "§cSeu tempmute expira em 2 dias");
				
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: Flood" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
										 
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Flood");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("pdvip")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por Pedir VIP");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por Pedir VIP");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo Pedir VIP");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por Pedir VIP");
				API.sendMsg(vitima, "§cSeu tempmute expira em 2 dias");
				
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: Pedir VIP" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
										 
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Pedir VIP");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("pdstaff")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por Pedir Staff");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por Pedir Staff");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo Pedir Staff");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por Pedir Staff");
				API.sendMsg(vitima, "§cSeu tempmute expira em 3 dias");
				
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: Pedir Staff" + "\n" + "Duração: 3 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Pedir Staff");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "3 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 5184000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("ofj")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por Ofensa a Jogador(es)");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por Ofensa a Jogador(es)");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo Ofensa a Jogador(es)");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por Ofensa a Jogador(es)");
				API.sendMsg(vitima, "§cSeu tempmute expira em 2 dias");
				
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: Ofensa a Jogador(es)" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Ofensa a Jogador(es)");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("citch")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por Citar canais");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por Citar canais");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo Citar canais");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por Citar canais");
				API.sendMsg(vitima, "§cSeu tempmute expira em 2 dias");
				
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: Citar caians" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Citar canais");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("citsv")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por Citar servidores");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por Citar servidores");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo Citar servidores");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por Citar servidores");
				API.sendMsg(vitima, "§cSeu tempmute expira em 2 dias");
										
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: Citar servidores" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Citar servidores");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("comercio")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por Comercio no servidor");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por Comercio no servidor");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo Comercio no servidor");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por Comercio no servidor");
				API.sendMsg(vitima, "§cSeu tempmute expira em 2 dias");
				
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: Comercio no servidor" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Comercio no servidor");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("spam")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por Spam");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por Spam");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo Spam");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por Spam");
				API.sendMsg(vitima, "§cSeu tempmute expira em 2 dias");
				
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: Spam" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "Spam");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			if (args[1].equalsIgnoreCase("caps")) {
				API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " temporariamente por CapsLock");
				API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " temporariamente por CapsLock");
				API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " temporariamente pelo motivo CapsLock");
				API.sendMsg(vitima, "§cVoce foi mutado temporariamente pelo " + jogador.getName() + " por CapsLock");
				API.sendMsg(vitima, "§cSeu tempmute expira em 2 dias");
				
				TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: CapsLock" + "\n" + "Duração: 2 dias" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
				
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Nome", vitima.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Motivo", "CapsLock");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Tempo do Mute", "2 dias");
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
				Config.getConfig().saveTempMute();
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) != null) {	
							API.sendBC("§cO jogador " +  vitima.getName() +  " foi desmutado automaticamente");
							API.sendStaff("§7O jogador " + vitima.getName() + " foi desmutado automaticamente");
							API.sendMsg(vitima, "§cVoce foi desmutado automaticamente");
							Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
							Config.getConfig().saveTempMute();
						}
					}
				}, 3456000L);
				return true;
			}
			API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /tempmute <Jogador> <Flood | Pdvip (Pedir VIP) | Pdstaff (Pedir Staff) | Ofj (Ofensa a Jogador) | Citch (Citar canais) | Citsv (Citar servidores) | Comercio | Spam | Cplk (Uso de CAPSLOCK em frase inteira)>");
			API.sendSound(jogador, Sound.NOTE_PLING, 10);
			return true;
		}
		
		return false;
	}
}
