package me.viitor.anticheat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class API {
	
	public static final ChatColor BLACK = ChatColor.BLACK;
	public static final ChatColor DARK_BLUE = ChatColor.DARK_BLUE;
	public static final ChatColor DARK_GREEN = ChatColor.DARK_GREEN;
	public static final ChatColor DARK_AQUA = ChatColor.DARK_AQUA;
	public static final ChatColor DARK_RED = ChatColor.DARK_RED;
	public static final ChatColor DARK_PURPLE = ChatColor.DARK_PURPLE;
	public static final ChatColor GOLD = ChatColor.GOLD;
	public static final ChatColor GRAY = ChatColor.GRAY;
	public static final ChatColor DARK_GRAY = ChatColor.DARK_GRAY;
	public static final ChatColor BLUE = ChatColor.BLUE;
	public static final ChatColor GREEN = ChatColor.GREEN;
	public static final ChatColor YELLOW = ChatColor.YELLOW;
	public static final ChatColor LIGHT_PURPLE = ChatColor.LIGHT_PURPLE;
	public static final ChatColor RED = ChatColor.RED;
	public static final ChatColor WHITE = ChatColor.WHITE;
	public static final ChatColor AQUA = ChatColor.AQUA;
	public static final ChatColor BOLD = ChatColor.BOLD;
	public static final ChatColor ITALIC = ChatColor.ITALIC;
	public static final ChatColor UNDERLINE = ChatColor.UNDERLINE;
	public static final ChatColor STRIKETHROUGH = ChatColor.STRIKETHROUGH;
	
	public static String PrefixStaffer = GRAY + "» " + API.GRAY;
	
	@SuppressWarnings("deprecation")
	public static void sendStaffer(Player Jogador, String Menssagem) {
		for (Player Jogadores : Bukkit.getOnlinePlayers()) {
			if (Jogadores != Jogador) {
				Jogadores.sendMessage(Menssagem);
			}
		}
	}
}