package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class InvseeCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("inv") || cmd.getName().equalsIgnoreCase("invsee")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Utilize /invsee <Jogador> ou /inv <Jogador>");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			Player inv = Bukkit.getPlayer(args[0]);
			if(inv == null) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador citado encontra-se offline");
			}
			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce abriu o inventario de " + inv.getName());
			me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) abriu o inventario de " + inv.getDisplayName() + " §7(" + CorGrupo.getTag(inv) + cfGrupo.pegargrupo().get("grupos." + inv.getUniqueId() + ".grupo") + "§7)");
			API.sendSound(p, Sound.NOTE_PLING, 10);
			p.openInventory(inv.getInventory());
			return true;
		}
		return false;
	}
}
