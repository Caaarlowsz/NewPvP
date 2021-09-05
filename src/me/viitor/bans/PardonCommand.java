package me.viitor.bans;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class PardonCommand implements CommandExecutor {

	private static String ip(OfflinePlayer vitima) {
		return (String)Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId() + ".IP do Jogador");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player jogador = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("pardon")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+")))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /pardon <Ban|IPBan|TempBan|Mute|TempMute> <Jogador>");
				return true;                                               
			}
			if (args[0].equalsIgnoreCase("ban")) {
				if (args.length == 1) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /pardon ban <Jogador>");
					return true;
				}
				OfflinePlayer vitima = Bukkit.getOfflinePlayer(args[1]);
				if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitima.getName() + "§7 nao esta §6§lBANIDO PERMANENTEMENTE");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendBC("§cConsole desbaniu " + vitima.getName());
					API.sendStaff("§7O §7§ostaffer §7Console desbaniu o jogador " + vitima.getName());
				} else {
					API.sendBC("§c" + jogador.getName() + " desbaniu " + vitima.getName());
					API.sendMsg(jogador, "§aVoce desbaniu " + vitima.getName());
					API.sendStaff("§7O staffer " + jogador.getName() + " desbaniu o jogador " + vitima.getName());
				}
				double l = Config.getConfig().getBans().getDouble("Players Banidos");
				Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l - 1.0D));
				Config.getConfig().getBans().set("Bans." + vitima.getUniqueId(), null);
				Config.getConfig().saveBans();
				return true;
			}
			if (args[0].equalsIgnoreCase("ipban")) {
				if (args.length == 1) {
					API.sendMsg(sender, "§6§lNew§f§lPvP §6» §7Utilize /pardon ipban <Jogador>");
					return true;
				}
				OfflinePlayer vitima = Bukkit.getOfflinePlayer(args[1]);
				if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitima.getName() + "§7 nao esta §6§lBANIDO POR IP");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendBC("§cConsole desbaniu o ip de " + vitima.getName());
					API.sendStaff("§7O §7§ostaffer §7Console desbaniu o ip de jogador " + vitima.getName());
				} else {
					API.sendBC("§c" + jogador.getName() + " desbaniu o ip de " + vitima.getName());
					API.sendMsg(jogador, "§aVoce desbaniu o ip de " + vitima.getName());
					API.sendStaff("§7O staffer " + jogador.getName() + " desbaniu o ip do jogador " + vitima.getName());
				}
				Bukkit.unbanIP(ip(vitima));
				Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId(), null);
				Config.getConfig().saveIpBans();
				return true;
			}
			if (args[0].equalsIgnoreCase("tempban")) {
				if (args.length == 1) {
					API.sendMsg(sender, "§6§lNew§f§lPvP §6» §7Utilize /pardon tempban <Jogador>");
					return true;
				}
				OfflinePlayer vitima = Bukkit.getOfflinePlayer(args[1]);
				if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) == null) {
					API.sendMsg(sender, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitima.getName() + "§7 nao esta §6§lBANIDO TEMPORARIAMENTE");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendBC("§cConsole desbaniu " + vitima.getName());
					API.sendStaff("§7O §7§ostaffer §7Console desbaniu o jogador " + vitima.getName());
				} else {
					API.sendBC("§c" + jogador.getName() + " desbaniu " + vitima.getName());
					API.sendMsg(jogador, "§aVoce desbaniu " + vitima.getName());
					API.sendStaff("§7O staffer " + jogador.getName() + " desbaniu o jogador " + vitima.getName());
				}
				Config.getConfig().getTempBans().set("TempBans." + vitima.getUniqueId(), null);
				Config.getConfig().saveTempBans();
				return true;
			}
			if (args[0].equalsIgnoreCase("mute")) {
				if (args.length == 1) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /pardon mute <Jogador>");
					return true;
				}
				Player vitima = Bukkit.getPlayer(args[1]);
				if (vitima == null) {
					OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[1]);
					if (Config.getConfig().getMute().get("Mute." + vitimaoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitimaoff.getName() + "§7 nao esta §6§lMUTADO PERMANENTEMENTE");
						return true;
					}
					if (!(sender instanceof Player)) {
						API.sendBC("§cConsole desmutou " + vitimaoff.getName());
						API.sendStaff("§7O §7§ostaffer §7Console desmutou o jogador " + vitimaoff.getName());
					} else {
						API.sendBC("§c" + jogador.getName() + " desmutou " + vitimaoff.getName());
						API.sendMsg(jogador, "§aVoce desmutou " + vitimaoff.getName());
						API.sendStaff("§7O staffer " + jogador.getName() + " desmutou o jogador " + vitimaoff.getName());
					}
					Config.getConfig().getMute().set("Mute." + vitimaoff.getUniqueId(), null);
					Config.getConfig().saveMute();
					return true;
				}
				if (Config.getConfig().getMute().get("Mute." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitima.getName() + "§7 nao esta §6§lMUTADO PERMANENTEMENTE");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendBC("§cConsole desmutou " + vitima.getName());
					API.sendStaff("§7O §7§ostaffer §7Console desmutou o jogador " + vitima.getName());
				} else {
					API.sendBC("§c" + jogador.getName() + " desmutou " + vitima.getName());
					API.sendMsg(jogador, "§aVoce desmutou " + vitima.getName());
					API.sendStaff("§7O staffer " + jogador.getName() + " desmutou o jogador " + vitima.getName());
				}
				Config.getConfig().getMute().set("Mute." + vitima.getUniqueId(), null);
				Config.getConfig().saveMute();
				return true;
			}
			if (args[0].equalsIgnoreCase("tempmute")) {
				if (args.length == 1) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /pardon tmepmute <Jogador>");
					return true;
				}
				Player vitima = Bukkit.getPlayer(args[1]);
				if (vitima == null) {
					OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[1]);
					if (Config.getConfig().getTempMute().get("TempMute." + vitimaoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitimaoff.getName() + "§7 nao esta §6§lMUTADO TEMPORARIAMENTE");
						return true;
					}
					if (!(sender instanceof Player)) {
						API.sendBC("§cConsole desmutou " + vitimaoff.getName());
						API.sendStaff("§7O §7§ostaffer §7Console desmutou o jogador " + vitimaoff.getName());
					} else {
						API.sendBC("§c" + jogador.getName() + " desmutou " + vitimaoff.getName());
						API.sendMsg(jogador, "§aVoce desmutou " + vitimaoff.getName());
						API.sendStaff("§7O staffer " + jogador.getName() + " desmutou o jogador " + vitimaoff.getName());
					}
					Config.getConfig().getTempMute().set("TempMute." + vitimaoff.getUniqueId(), null);
					Config.getConfig().saveTempMute();
					return true;
				}
				if (Config.getConfig().getTempMute().get("TempMute." + vitima.getUniqueId()) == null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + vitima.getName() + "§7 nao esta §6§lMUTADO TEMPORARIAMENTE");
					return true;
				}
				if (!(sender instanceof Player)) {
					API.sendBC("§cConsole desmutou " + vitima.getName());
					API.sendStaff("§7O §7§ostaffer §7Console desmutou o jogador " + vitima.getName());
				} else {
					API.sendBC("§c" + jogador.getName() + " desmutou " + vitima.getName());
					API.sendMsg(jogador, "§aVoce desmutou " + vitima.getName());
					API.sendStaff("§7O staffer " + jogador.getName() + " desmutou o jogador " + vitima.getName());
				}
				Config.getConfig().getTempMute().set("TempMute." + vitima.getUniqueId(), null);
				Config.getConfig().saveTempMute();
				return true;
			}
			API.sendMsg(sender, "§6§lNew§f§lPvP §6» §7Utilize /pardon <Ban|IPBan|TempBan|Mute|TempMute> <Jogador>");
			return true;
		}
		return false;
	}
}
