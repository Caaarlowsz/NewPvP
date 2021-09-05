package me.viitor.commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.HatAPI;
import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;

public class cRemoveHead implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("removerhead") || cmd.getName().equalsIgnoreCase("removerhat") || cmd.getName().equalsIgnoreCase("removehead") || cmd.getName().equalsIgnoreCase("removehat")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Youtuber") && !cfGrupo.ChecarGrupo(p, "S-Pro") && !cfGrupo.ChecarGrupo(p, "Pro") && !cfGrupo.ChecarGrupo(p, "Mvp") && !cfGrupo.ChecarGrupo(p, "Helper")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			} else {
				HatAPI.removeHat(p);
				API.sendSound(p, Sound.LEVEL_UP, 10);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Cabeca removida com sucesso");
			}
		}
		
		return false;
	}
}
