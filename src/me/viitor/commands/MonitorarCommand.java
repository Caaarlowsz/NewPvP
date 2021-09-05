package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.API.ArraysAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class MonitorarCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("monitorar")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /monitorar <On/Off>");
				return true;
			}
			if(args[0].equalsIgnoreCase("on")) {
				ArraysAPI.Monitor.add(p);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Modo monitorar ativado");
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) ativou a funcao monitorar");
				return true;
			}
			if(args[0].equalsIgnoreCase("off")) {
				ArraysAPI.Monitor.remove(p);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Modo monitorar desativado");
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) desativou a funcao monitorar");
				return true;
			}
		}
		return false;
	}

}
