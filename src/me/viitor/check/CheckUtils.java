package me.viitor.check;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.API.KitAPI;
import me.viitor.commands.FlyCommand;
import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfStatus;
import me.viitor.scoreboard.sScoreAPI;

public class CheckUtils {
	
	public static String Grupo(Player p) {
		if(cfGrupo.ChecarGrupo(p, "Membro")) {
			return "§7§lMEMBRO";
		}
		if(cfGrupo.ChecarGrupo(p, "Light")) {
			return "§a§lLIGHT";
		}
		if(cfGrupo.ChecarGrupo(p, "Mvp")) {
			return "§9§lMVP";
		}
		if(cfGrupo.ChecarGrupo(p, "Pro")) {
			return "§6§lPRO";
		}
		if(cfGrupo.ChecarGrupo(p, "S-Pro")) {
			return "§e§lSEMIPRO";
		}
		if(cfGrupo.ChecarGrupo(p, "Youtuber")) {
			return "§b§lYOUTUBER";
		}
		if(cfGrupo.ChecarGrupo(p, "Youtuber+")) {
			return "§3§lYOUTUBER+";
		}
		if(cfGrupo.ChecarGrupo(p, "Helper")) {
			return "§9§lHELPER";
		}
		if(cfGrupo.ChecarGrupo(p, "Builder")) {
			return "§2§lBUILDER";
		}
		if(cfGrupo.ChecarGrupo(p, "Trial")) {
			return "§5§lTRIAL";
		}
		if(cfGrupo.ChecarGrupo(p, "Mod")) {
			return "§5§lMOD";
		}
		if(cfGrupo.ChecarGrupo(p, "Mod+")) {
			return "§5§lMOD+";
		}
		if(cfGrupo.ChecarGrupo(p, "Gerente")) {
			return "§c§lGERENTE";
		}
		if(cfGrupo.ChecarGrupo(p, "Admin")) {
			return "§c§lADMIN";
		}
		if(cfGrupo.ChecarGrupo(p, "Dono")) {
			return "§4§lDONO";
		}
		return "§4§lDONO";
	}
	
	public static String Nickname(Player p) {
		return "§6" + p.getName();
	}
	
	public static String UUID(Player p) {
		return "§6" + p.getUniqueId().toString();
	}
	
	public static String IP(Player p) {
		return "§6" + p.getAddress().getHostString();
	}
	
	public static String IPReverso(Player p) {
		return "§6" + p.getAddress().getHostName();
	}
	
	public static String GeoIP(Player p) {
		return "§6https://www.geoiptool.com/pt/?ip=" + p.getAddress().getHostString();
	}
	
	public static String Gamemode(Player p) {
		if(p.getGameMode() == GameMode.CREATIVE) {
			return "§6Criativo";
		}
		if(p.getGameMode() == GameMode.SURVIVAL) {
			return "§6Sobrevivencia";
		}
		if(p.getGameMode() == GameMode.ADVENTURE) {
			return "§6Aventura";
		}
		return "§6Aventura";
	}
	
	public static String Fly(Player p) {
		if(FlyCommand.Fly.contains(p)) {
			return "§6Ativado";
		}
		if(!FlyCommand.Fly.contains(p)) {
			return "§6Desativado";
		}
		return "§6Desativado";
	}
	
	public static String Vida(Player p) {
		return "§6" + p.getHealthScale();
	}
	
	public static String Fome(Player p) {
		return "§6" + p.getFoodLevel();
	}
	
	public static String Kit(Player p) {
		return "§6" + KitAPI.getKitAntes(p);
	}
	
	public static String Warp(Player p) {
		return "§6" + API.getWarp(p);
	}
	
	public static String Rank(Player p) {
		return "§6" + sScoreAPI.getRank(p) + " " + sScoreAPI.getNomeRank(p);
	}
	
	public static String Coins(Player p) {
		return "§6" + cfStatus.getMoney(p);
	}
	
	public static String Kills(Player p) {
		return "§6" + cfStatus.getKills(p);
	}
	
	public static String Deaths(Player p) {
		return "§6" + cfStatus.getDeaths(p);
	}
	
	public static String KillStreak(Player p) {
		return "§6" + cfStatus.getKillStreak(p);
	}
}
