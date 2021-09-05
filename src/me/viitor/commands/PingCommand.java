package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ping")) {
			if((sender instanceof Player)) {
				Player p = (Player) sender;
				int ping = ((CraftPlayer)p).getHandle().ping;
				if(args.length == 0) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Seu ping atual e: " + ping + "ms");
					return true;
				}
				if(args.length == 1) {
					Player k = Bukkit.getPlayer(args[0]);
					if(k == null) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador citado encontra-se offline");
						return true;
					}
					int ping2 = ((CraftPlayer)k).getHandle().ping;
					p.sendMessage("§6§lNew§f§lPvP §6» §7O ping atual de " + k.getName() + " e: " + ping2 + "ms.");
					return true;
				}
			}
		}
		return false;
	}
}