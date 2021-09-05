package me.viitor.staffmanager;

import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class GroupManager {
	
	public static String getGrupo(Player p) {
		if(cfGrupo.ChecarGrupo(p, "Membro")) {
			return "§7";
		}
		if(cfGrupo.ChecarGrupo(p, "Light")) {
			return "§a§lLIGHT §a";
		}
		if(cfGrupo.ChecarGrupo(p, "Mvp")) {
			return "§9§lMVP §9";
		}
		if(cfGrupo.ChecarGrupo(p, "Pro")) {
			return "§6§lPRO §6";
		}
		if(cfGrupo.ChecarGrupo(p, "S-Pro")) {
			return "§e§lSEMIPRO §e";
		}
		if(cfGrupo.ChecarGrupo(p, "Youtuber")) {
			return "§b§lYOUTUBER §b";
		}
		if(cfGrupo.ChecarGrupo(p, "Youtuber+")) {
			return "§3§lYOUTUBER+ §3";
		}
		if(cfGrupo.ChecarGrupo(p, "Helper")) {
			return "§9§lHELPER §9";
		}
		if(cfGrupo.ChecarGrupo(p, "Builder")) {
			return "§2§lBUILDER §2";
		}
		if(cfGrupo.ChecarGrupo(p, "Trial")) {
			return "§5§lTRIAL §5";
		}
		if(cfGrupo.ChecarGrupo(p, "Mod")) {
			return "§5§lMOD §5";
		}
		if(cfGrupo.ChecarGrupo(p, "Mod+")) {
			return "§5§lMOD+ §5";
		}
		if(cfGrupo.ChecarGrupo(p, "Gerente")) {
			return "§c§lGERENTE §c";
		}
		if(cfGrupo.ChecarGrupo(p, "Admin")) {
			return "§c§lADMIN §c";
		}
		if(cfGrupo.ChecarGrupo(p, "Dono")) {
			return "§4§lDONO §4";
		}
		return "§4§lDONO §4";
	}

}
