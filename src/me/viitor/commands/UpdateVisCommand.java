package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.VisAPI;
import me.viitor.configuração.cfGrupo;

public class UpdateVisCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("updatevis")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				VisAPI.updateVis(p);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Visibilidade atualizada");
				return true;
			}
			if(args.length >= 0) {
				VisAPI.updateVis(p);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Visibilidade alterada. Procure utilizar argumentos somente quando necessario");
				return true;
			}
		}
		return false;
	}
}
