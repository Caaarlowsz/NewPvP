package me.viitor.API;

import org.bukkit.entity.Player;

public class HatAPI {
	
	public static void removeHat(Player p) {
		p.getInventory().setHelmet(null);
	}
}
