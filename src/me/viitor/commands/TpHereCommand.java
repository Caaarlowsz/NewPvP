package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class TpHereCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tphere") || cmd.getName().equalsIgnoreCase("s")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /tphere <Jogador> ou /s <Jogador>");
				return true;
			}
			Player k = Bukkit.getPlayer(args[0]);
			if(k == null) {
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
				return true;
			}
			k.teleport(p);
			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce puxou o jogador §6§l" + k.getName() + " §7ate sua localizacao atual");
			me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) puxou o jogador " + k.getDisplayName() + " §7(" + CorGrupo.getTag(k) + cfGrupo.pegargrupo().get("grupos." + k.getUniqueId() + ".grupo") + "§7)");
			return true;
		}
		return false;
	}

}
