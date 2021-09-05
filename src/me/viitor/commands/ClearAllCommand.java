package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.ArraysAPI;
import me.viitor.API.KitAPI;
import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class ClearAllCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin"))))){
			API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("clearall")) {
			API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce limpou o inventario de todos os jogadores");
			me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) limpou o inventario de todos os jogadores");
			for(Player todos : Bukkit.getOnlinePlayers()) {
				if(todos  != p) {
					if(!ArraysAPI.Admin.contains(todos)) {
						todos.getInventory().clear();
						todos.getInventory().setArmorContents(null);
						todos.updateInventory();
						KitAPI.removeKits(p);
						me.viitor.API.API.setWarp(todos, "Spawn");
						return true;
					}
				}
			}
			return true;
 		}
		return false;
	}
}
