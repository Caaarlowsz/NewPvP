package me.viitor.umVum;

import org.bukkit.scheduler.BukkitRunnable;

import me.viitor.main.Main;

public class Scoreboard1v1 {
	
	public Scoreboard1v1() {
		
	}
	
	public void run() {
		new BukkitRunnable() {
			
			@Override
			public void run() {
				
			}
		}.runTaskTimer(Main.plugin, 0, 3);
	}

}
