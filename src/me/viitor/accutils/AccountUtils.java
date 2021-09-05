package me.viitor.accutils;

import org.bukkit.OfflinePlayer;

import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfStatus;
import net.md_5.bungee.api.ChatColor;

public class AccountUtils {
	
	public static String getRankOffline(OfflinePlayer p) {
		double a = cfStatus.getKillsOff(p);
		if(a <= 99) {
			return "§f�?";
		}
		if(a <= 199) {
			return ChatColor.GREEN + "☰";
		}
		if(a <= 299) {
			return ChatColor.YELLOW + "☲";
		}
		if(a <= 399) {
			return "§1☷";
		}
		if(a <= 499) {
			return "§7✶";
		}
		if(a <= 599) {
			return "§6✷";
		}
		if(a <= 699) {
			return ChatColor.AQUA + "✦";
		}
		if(a <= 799) {
			return "§2✠";
		}
		if(a <= 899) {
			return ChatColor.RED + "✫";
		}
		if(a <= 1499) {
			return "§3✹";
		}
		if(a >= 1500) {
			return "§4✯";
		}
		return "§4✯";
	}
	
	public static String getRankNomeOffline(OfflinePlayer p) {
		double a = cfStatus.getKillsOff(p);
		if(a <= 100) {
			return "§fUnranked";
		}
		if(a <= 200) {
			return "§aStarter";
		}
		if(a <= 300) {
			return "§eApprentice";
		}
		if(a <= 400) {
			return "§1Experient";
		}
		if(a <= 500) {
			return "§7Silver";
		}
		if(a <= 600) {
			return "§6Gold";
		}
		if(a <= 700) {
			return "§bDiamond";
		}
		if(a <= 800) {
			return "§2Emerald";
		}
		if(a <= 900) {
			return "§cRuby";
		}
		if(a <= 1000) {
			return "§3Safira";
		}
		if(a <= 1500) {
			return "§4Supremo";
		}
		return "§4Supremo";
	}
	
	public static String getGrupo(OfflinePlayer p) {
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
	
}
