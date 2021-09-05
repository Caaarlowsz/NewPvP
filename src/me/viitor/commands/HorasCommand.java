package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.HorarioAPI;

public class HorasCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("horas")) {
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Checando informacoes sobre data e hora");
				p.sendMessage(" ");
				p.sendMessage("§7Data/Hora atuais: " + HorarioAPI.getHorario());
				p.sendMessage(" ");
				return true;
			}
		}
		return false;
	}
}
