package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.main.Main;
import me.viitor.scoreboard.sScoreAPI;

public class ScoreCommand implements CommandExecutor{

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("score")){
			if(sScoreAPI.Delay.contains(p)){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Aguarde para executar outro comando");
				return true;
			}
			if(sScoreAPI.Score.contains(p)){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce desativou a scoreboard");
				sScoreAPI.Score.remove(p);
				sScoreAPI.scorenull(p);
				sScoreAPI.Delay.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						sScoreAPI.Delay.remove(p);
					}
				}, 6 * 20);
			}
			else if(!sScoreAPI.Score.contains(p)){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ativou a scoreboard");
				sScoreAPI.Score.add(p);
				sScoreAPI.scoreboard(p);
				sScoreAPI.Delay.add(p);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						sScoreAPI.Delay.remove(p);
					}
				}, 6 * 20);
			}
		}
		return false;
	}
}
