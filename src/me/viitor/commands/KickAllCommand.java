package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class KickAllCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("kickall")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			for(Player todos : Bukkit.getOnlinePlayers()) {
				if(!cfGrupo.ChecarGrupo(todos, "Dono") && !cfGrupo.ChecarGrupo(todos, "Gerente") && todos != p && !todos.isOp()) {
					todos.kickPlayer("§6§lNew§f§lPvP" + "\n" + "§7Todos os jogadores foram " + "\n" + " kickados do servidor pelo §6" + p.getName() + "§7.");
				}
			}
			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce kickou todos os jogadores do servidor");
			Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7Todos os jogadores foram kickados pelo §6" + p.getName());
			API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) kickou todos os jogadores");
			return true;
		}
		return false;
	}

}
