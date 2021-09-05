package me.viitor.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class VisAPI {
	
	public static void updateVis(Player p) {
		for(Player todos : Bukkit.getOnlinePlayers()) {
			if(!cfGrupo.ChecarGrupo(todos, "Dono") && !cfGrupo.ChecarGrupo(todos, "Admin") && !cfGrupo.ChecarGrupo(todos, "Gerente") && !cfGrupo.ChecarGrupo(todos, "Mod+") && !cfGrupo.ChecarGrupo(todos, "Mod") && !cfGrupo.ChecarGrupo(todos, "Trial") && !cfGrupo.ChecarGrupo(todos, "Youtuber+")) {
				todos.hidePlayer(p);
				p.showPlayer(todos);
			}
		}
	}
}
