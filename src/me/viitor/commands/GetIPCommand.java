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

public class GetIPCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("getip")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial"))))))){
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Utilize /getip <Jogador>");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			Player ip = Bukkit.getPlayer(args[0]);
			if(ip == null) {
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7O jogador " + args[0] + " encontra-se §6§lOFFLINE");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			if(ip != null) {
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Resgatando informacoes sobre o IP de " + ip.getName());
				API.sendMsg(p, "§7IP do jogador: " + ip.getAddress().getHostString());
				API.sendMsg(p, "§7IP reverso: " + ip.getAddress().getHostName());
				me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) pegou o ip de " + ip.getDisplayName() + "§7 (" + CorGrupo.getTag(ip) + cfGrupo.pegargrupo().get("grupos." + ip.getUniqueId() + ".grupo") + "§7)");
				return true;
			}
		}
		return false;
	}
}
