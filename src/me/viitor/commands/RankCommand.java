package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.bans.API;
import net.md_5.bungee.api.ChatColor;

public class RankCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("rank") || cmd.getName().equalsIgnoreCase("ranks")) {
			if(args.length == 0) {
				API.sendMsg(p, " ");
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Lista de ranks do servidor: ");
				API.sendMsg(p, " ");
				API.sendMsg(p, "§7▪ §4✯ Supremo §8[§61500+ kills§8]");
				API.sendMsg(p, "§7▪ §3✹ Safira §8[§6900 a 1499 kills§8]");
				API.sendMsg(p, "§7▪ " + ChatColor.RED + "✫ Ruby §8[§6800 a 900 kills§8]");
				API.sendMsg(p, "§7▪ §2✠ Emerald §8[§6700 a 800 kills§8]");
				API.sendMsg(p, "§7▪ " + ChatColor.AQUA + "✦ Diamond §8[§6600 a 700 kills§8]");
				API.sendMsg(p, "§7▪ §6✷ Gold §8[§6500 a 600 kills§8]");
				API.sendMsg(p, "§7▪ §7✶ Silver §8[§6400 a 500 kills§8]");
				API.sendMsg(p, "§7▪ §1☷ Experient §8[§6300 a 400 kills§8]");
				API.sendMsg(p, "§7▪ " + ChatColor.YELLOW + "☲ Apprentice §8[§6200 a 300 kills§8]");
				API.sendMsg(p, "§7▪ " + ChatColor.GREEN + "☰ Starter §8[§6100 a 200 kills§8]");
				API.sendMsg(p, "§7▪ §f�? Unranked §8[§60 a 100 kills§8]");
				API.sendMsg(p, " ");
			}
		}
		return false;
	}
}
