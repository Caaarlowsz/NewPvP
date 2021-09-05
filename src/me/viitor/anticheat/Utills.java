package me.viitor.anticheat;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class Utills {

	public static HashMap<Player, Integer> FastAttackClicks = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> MacroClicks = new HashMap<Player, Integer>();
	public static ArrayList<Player> fly = new ArrayList<>();
	public static String FastAttack = null;
	public static String Forcefield = null;
	public static String Macro = null;
	public static String Fly = null;
	public static String Speed = null;
	public static String ForjandoAutoSoup = null;
	public static String AutoSoup = null;
	
	public static HashMap<Player, Integer> ClicksFastClicks = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> ClicksMacro = new HashMap<Player, Integer>();
	
	public static HashMap<Player, Integer> AvisosForcefield = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosFastClick = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosFly = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosSpeed = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosMacro = new HashMap<Player, Integer>();
	public static HashMap<Player, Integer> AvisosAutoSoup = new HashMap<Player, Integer>();
	
	public static enum Hack {
		
		FASTCLICKTALVEZ(ChatColor.RED + "nick" + " esta [TALVEZ] clicando muito rapido (CPS: clicks) [" + "avisos" + "]"),
		FASTCLICKPROVAVELMENTE(ChatColor.RED + "nick" + " esta [PROVAVELMENTE] clicando muito rapido (CPS: clicks) [" + "avisos" + "]"),
		FASTCLICKDEFINITIVAMENTE(ChatColor.RED + "nick" + " esta [DEFINITIVAMENTE] clicando muito rapido (CPS: clicks) [" + "avisos" + "]"),
		
		MACROTALVEZ(ChatColor.RED + "nick" + " esta [TALVEZ] utilizando Macro (CPS: clicks) [" + "avisos" + "]"),
		MACROPROVAVELMENTE(ChatColor.RED + "nick" + " esta [PROVAVELMENTE] utilizando Macro (CPS: clicks) [" + "avisos" + "]"),
		MACRODEFINITIVAMENTE(ChatColor.RED + "nick" + " esta [DEFINITIVAMENTE] utilizando Macro (CPS: clicks) [" + "avisos" + "]"),
		
		FORCEFIELDTALVEZ(ChatColor.RED + "nick" + " esta [TALVEZ] utilizando Force-Field [" + "avisos" + "]"),
		FORCEFIELDPROVAVELMENTE(ChatColor.RED + "nick" + " esta [PROVAVELMENTE] utilizando Force-Field [" + "avisos" + "]"),
		FORCEFIELDDEFINITIVAMENTE(ChatColor.RED + "nick" + " esta [DEFINITIVAMENTE] utilizando Force-Field [" + "avisos" + "]"),
		
		FLY(ChatColor.RED + "nick" + " esta utilizando Fly (MS: ping) [" + "avisos" + "]"),
		
		SPEED(ChatColor.RED + "nick" + " esta utilizando Speed (MS: ping) [" + "avisos" + "]"),
		
		AUTOSOUPTALVEZ(ChatColor.RED + "nick" + " esta [TALVEZ] utilizando Auto-Soup [" + "avisos" + "]"),
		AUTOSOUPPROVAVELMENTE(ChatColor.RED + "nick" + " esta [PROVAVELMENTE] utilizando Auto-Soup [" + "avisos" + "]"),
		AUTOSOUPDEFINITIVAMENTE(ChatColor.RED + "nick" + " esta [DEFINITIVAMENTE] utilizando Auto-Soup [" + "avisos" + "]");
		
		private String Menssagem;
		
		private Hack(String Menssagem) { this.Menssagem = Menssagem; }

		public String getMenssagem() {
			return this.Menssagem;
		}
	}
	
	public static void sendAntiCheat(String Menssagem) {
		
		for (Player playeres : Bukkit.getOnlinePlayers()) {
			if(cfGrupo.ChecarGrupo(playeres, "Dono") || cfGrupo.ChecarGrupo(playeres, "Gerente") || cfGrupo.ChecarGrupo(playeres, "Admin") || cfGrupo.ChecarGrupo(playeres, "Mod+") || cfGrupo.ChecarGrupo(playeres, "Mod") || cfGrupo.ChecarGrupo(playeres, "Trial") || cfGrupo.ChecarGrupo(playeres, "Youtuber+")){
			playeres.sendMessage(Menssagem);
			}
		}
	}

	public static boolean Flight(Player playeres) {
		return (playeres.getGameMode() == GameMode.CREATIVE) || (playeres.getAllowFlight());
	}

	public static boolean Speeding(Player playeres) {
	    return (playeres.getGameMode() == GameMode.CREATIVE) || (playeres.getAllowFlight());
	}

	public static void setPlayer(Player player) {
		AvisosFastClick.put(player, Integer.valueOf(1));
		AvisosMacro.put(player, Integer.valueOf(1));
		AvisosFly.put(player, Integer.valueOf(1));
		AvisosSpeed.put(player, Integer.valueOf(1));
		AvisosForcefield.put(player, Integer.valueOf(1));
		AvisosAutoSoup.put(player, Integer.valueOf(1));
		
		ClicksFastClicks.put(player, Integer.valueOf(1));
		ClicksMacro.put(player, Integer.valueOf(1));
	}
}
