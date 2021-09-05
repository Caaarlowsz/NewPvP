package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class PvPCommand implements CommandExecutor, Listener {
	
	public static boolean pvp = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("pvp")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+")))))){
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7");
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("on")) {
					if((pvp)) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7O pvp ja esta ativado");
						return true;
					}
					pvp = true;
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ativou o pvp");
					Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7O pvp foi ativado pelo " + p.getDisplayName());
					me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) ativou o pvp");
					return true;
				}
			}
			if(args[0].equalsIgnoreCase("off")) {
				if(!(pvp)) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7O pvp ja esta desativado");
					return true;
				}
				pvp = false;
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce desativou o pvp");
				Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7O pvp foi desativado pelo " + p.getDisplayName());
				me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) desativou o pvp");
				return true;
			}
		}
		return false;
	}
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			if(!(pvp)) {
				e.setCancelled(true);
			}
		}
	}
}
