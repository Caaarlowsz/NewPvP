package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.viitor.API.API;
import me.viitor.API.KitAPI;
import me.viitor.API.TopKillStreak;
import me.viitor.API.WarpsAPI;
import me.viitor.main.Main;
import me.viitor.scoreboard.sScoreAPI;

public class SpawnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		if(Cmd.getName().equalsIgnoreCase("spawn")){

			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta sendo teleportado");
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999, 9999));
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 9999, 9999));
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					
					  TopKillStreak.Ks.put(p, Integer.valueOf(0));
					  for (Player players : Bukkit.getOnlinePlayers()) {
						  TopKillStreak.KsTop.put(p, TopKillStreak.getKsTop(players));
						  TopKillStreak.Name.put(p, TopKillStreak.getNameTop(players));
						  sScoreAPI.scoreboard(players);
					 }
						WarpsAPI.Ir(p, "Spawn");
						API.setWarp(p, "Spawn");
						API.sendItems(p);
						KitAPI.removeKits(p);
						sScoreAPI.scoreboard(p);
					
					p.removePotionEffect(PotionEffectType.SLOW);
					p.removePotionEffect(PotionEffectType.BLINDNESS);
					
					p.setHealth(20.0D);
					p.setMaxHealth(20.0D);

				}
			}, 3*20);
		}
		return false;
	}

}
