package me.viitor.API;


import org.bukkit.entity.Player;

import me.viitor.configura��o.cfConfig;
import me.viitor.scoreboard.sScoreAPI;

public class PadraoAPI {
	
	
	public static void setKit(Player p, String kit){
		
		cfConfig.pegarconfig().set("configura��o." + p.getUniqueId() + ".PadraoKit", kit);
		cfConfig.salvarconfiguracao();
		sScoreAPI.scoreboard(p);
	}
}
