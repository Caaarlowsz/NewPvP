package me.viitor.API;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.viitor.scoreboard.sScoreAPI;

public class TopKillStreak implements Listener{

	public static HashMap<Player, String> Name = new HashMap<Player, String>();
	public static HashMap<Player, Integer> KsTop = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> Ks = new HashMap<Player, Integer>();
	
	public static String getNameTop(Player player) {
		if (Name.containsKey(player)) {
			return Name.get(player);
		} else {
			return "Ninguem";
		}
	}
	public static int getKsTop(Player player) {
		if (KsTop.containsKey(player)) {
			return KsTop.get(player);
		} else {
			return 0;
		}
	}
	public static void createTopKillStreak(Player player) {
		for (Player players : Bukkit.getOnlinePlayers()) {
					if (Ks.get(player) > Ks.get(players)) {
						Name.put(player, player.getName());
						Name.put(players, player.getName());
						KsTop.put(player, Integer.valueOf(Ks.get(player)));
						KsTop.put(players, Integer.valueOf(Ks.get(player)));
			    		if(TopKillStreak.getKsTop(player) >= TopKillStreak.getKsTop(players)){
			        		sScoreAPI.scoreboard(players);
			        		sScoreAPI.scoreboard(player);
			        		}
					}
			}
	}
	public static String formatTopKillStreak(Player player) {
		return "§e" + getNameTop(player) + " §7-§e " + getKsTop(player);
	}
}