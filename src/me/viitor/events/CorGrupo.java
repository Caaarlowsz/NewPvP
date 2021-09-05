package me.viitor.events;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class CorGrupo {

	
	public static HashMap<Player, String> tag = new HashMap<>();
	
	public static String getTag(Player player) {
		if (tag.containsKey(player)) {
			return tag.get(player);
		} else {
			return "§7";
		}
 	}
	
	public static void setarTag(Player player, String Tag) {
		tag.put(player, Tag);
	}
}
