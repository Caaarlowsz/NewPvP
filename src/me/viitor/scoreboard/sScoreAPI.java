package me.viitor.scoreboard;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.viitor.API.KitAPI;
import me.viitor.API.TopKillStreak;
import me.viitor.check.CheckUtils;
import me.viitor.configuração.cfStatus;
import net.md_5.bungee.api.ChatColor;

public class sScoreAPI {
	
	public sScoreAPI() {
		
	}
	
	public static ArrayList<Player> Score = new ArrayList<>();
	public static ArrayList<Player> Delay = new ArrayList<>();
	
	public static String getRank(Player p) {
		double a = cfStatus.getKills(p);
		if(a <= 99) {
			return "§f�?";
		}
		if(a <=  199) {
			return ChatColor.GREEN + "☰";
		}
		if(a <=  299) {
			return ChatColor.YELLOW + "☲";
		}
		if(a <=  399) {
			return "§1☷";
		}
		if(a <=  499) {
			return "§7✶";
		}
		if(a <=  599) {
			return "§6✷";
		}
		if(a <=  699) {
			return ChatColor.AQUA + "✦";
		}
		if(a <=  799) {
			return "§2✠";
		}
		if(a <=  899) {
			return ChatColor.RED + "✫";
		}
		if(a <=  1499) {
			return "§3✹";
		}
		if(a >=  1500) {
			return "§4✯";
		}
		return "§4✯";
	}
	public static String getRankConfig(Player p) {
		double a = cfStatus.getKills(p);
		if(a <= 99) {
			return "�?";
		}
		if(a <=  199) {
			return "☰";
		}
		if(a <=  299) {
			return "☲";
		}
		if(a <=  399) {
			return "☷";
		}
		if(a <=  499) {
			return "✶";
		}
		if(a <=  599) {
			return "✷";
		}
		if(a <=  699) {
			return "✦";
		}
		if(a <=  799) {
			return "✠";
		}
		if(a <=  899) {
			return "✫";
		}
		if(a <=  1499) {
			return "✹";
		}
		if(a >=  1500) {
			return "✯";
		}
		return "✯";
	}
	public static String getNomeRank(Player p) {
		double a = cfStatus.getKills(p);
		if(a <= 99) {
			return "§fUnranked";
		}
		if(a <=  199) {
			return "§aStarter";
		}
		if(a <=  299) {
			return "§eApprentice";
		}
		if(a <=  399) {
			return "§1Experient";
		}
		if(a <=  499) {
			return "§7Silver";
		}
		if(a <=  599) {
			return "§6Gold";
		}
		if(a <=  699) {
			return "§bDiamond";
		}
		if(a <=  799) {
			return "§2Emerald";
		}
		if(a <=  899) {
			return "§cRuby";
		}
		if(a <=  1499) {
			return "§3Safira";
		}
		if(a >=  1500) {
			return "§4Supremo";
		}
		return "§4Supremo";
	}
	public static String getNomeRankConfig(Player p) {
		double a = cfStatus.getKills(p);
		if(a <= 99) {
			return "Unranked";
		}
		if(a <= 199) {
			return "Starter";
		}
		if(a <= 299) {
			return "Apprentice";
		}
		if(a <= 399) {
			return "Experient";
		}
		if(a <= 499) {
			return "Silver";
		}
		if(a <= 599) {
			return "Gold";
		}
		if(a <= 699) {
			return "Diamond";
		}
		if(a <= 799) {
			return "Emerald";
		}
		if(a <= 899) {
			return "Ruby";
		}
		if(a <= 999) {
			return "Safira";
		}
		if(a <= 1500) {
			return "Supremo";
		}
		return "Supremo";
	}
	
	public static void scoreboard(Player p){
		
		 uScore scoreboard = new uScore("§6§lNASH§f§lPVP ");
		 
		 scoreboard.addLine("§a", 12);
		 scoreboard.addLine("§7Grupo " + CheckUtils.Grupo(p), 11);
		 scoreboard.addLine("§7Kit §9" + KitAPI.getKit(p), 10);
		 scoreboard.addLine("§7Rank " + getRank(p) + " " + getNomeRank(p), 9);
		 scoreboard.addLine("§7Coins §e$" + cfStatus.getMoney(p), 8);
		 scoreboard.addLine("§b", 7);
		 scoreboard.addLine("§7Matou §a" + cfStatus.getKills(p), 6);
		 scoreboard.addLine("§7Morreu §c" + cfStatus.getDeaths(p), 5);
		 scoreboard.addLine("§7KillStreak §2" + cfStatus.getKillStreak(p), 4);
		 scoreboard.addLine("§c", 3);
		 scoreboard.addLine("§7TopKS " + TopKillStreak.formatTopKillStreak(p), 2);
		 scoreboard.addLine("§d", 1);
		 scoreboard.addLine("   §6pvp.mc-nash.tk", 0);
		 
		 if(Score.contains(p)){
		 scoreboard.setScoreboard();
		 p.setScoreboard(scoreboard.getScoreboard());
		 }else{
			 scorenull(p);
		 }
	}
	public static void scorenull(Player p){
		   
		 uScore scoreboard = new uScore("");
		 
		 scoreboard.setScoreboard();
		 p.setScoreboard(scoreboard.getScoreboard());
	}
	
}
