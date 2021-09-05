package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class InvisCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("invis")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				for(Player todos : Bukkit.getOnlinePlayers()) {
					if(!cfGrupo.ChecarGrupo(todos, "Dono") && !cfGrupo.ChecarGrupo(todos, "Admin") && !cfGrupo.ChecarGrupo(todos, "Gerente") && !cfGrupo.ChecarGrupo(todos, "Mod+") && !cfGrupo.ChecarGrupo(todos, "Mod") && !cfGrupo.ChecarGrupo(todos, "Trial") && !cfGrupo.ChecarGrupo(todos, "Youtuber+")) {
						todos.hidePlayer(p);
						p.showPlayer(todos);
					}
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta invisivel para todos os jogadores");
					return true;
				}
			}
		}
		return false;
	}
}
