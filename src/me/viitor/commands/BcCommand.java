package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class BcCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("bc")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /bc <Mensagem>");
				return true;
			}
			if (args.length >= 1) {
				String bc = "";
				for (int i = 0; i < args.length; i++) {
					bc = bc + args[i] + " ";
				}
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7" + bc.replace("&", "§"));
				Bukkit.broadcastMessage(" ");
				return true;
			}
		}
		return false;
	}
}
