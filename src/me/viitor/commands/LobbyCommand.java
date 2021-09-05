package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.viitor.main.Main;

public class LobbyCommand implements CommandExecutor {
	
	 public static void sendPlayerBungee(Player p, String s) {
		  ByteArrayDataOutput out = ByteStreams.newDataOutput();
		  out.writeUTF("Connect");
		  out.writeUTF(s);
		  p.sendPluginMessage(Main.getPlugin(), "BungeeCord", out.toByteArray());
	 }
	 
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("lobby")) {
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce sera enviado ao lobby em §63 segundos§7.");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Para cancelar, digite §6/lobby §7novamente.");
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
					
					@Override
					public void run() {
						p.sendMessage("§6§lNew§f§lPvP §6» §7Estamos enviando voce ao lobby...");
						sendPlayerBungee(p, "lobby");
					}
				}, 60L);
			}
		}
		return false;
	}
}
