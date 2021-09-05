package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class YoutuberCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("youtuber")){
			p.sendMessage(" ");
			p.sendMessage("§6§lNew§f§lPvP §6» §7Requisitos para obter a tag §b§lYOUTUBER§7:");
			p.sendMessage(" ");
			p.sendMessage("§b▪ §7Possuir §b2.500+ §7inscritos");
			p.sendMessage("§b▪ §7Possuir uma media de §b500/700+ §7visualizacoes por video");
			p.sendMessage("§b▪ §7Possuir uma media de §b500+ §7likes por video");
			p.sendMessage("§b▪ §7Possuir §b1+ §7video(s) gravado(s) no servidor");
			p.sendMessage(" ");
			p.sendMessage("§7Caso possua os requisitos acima, peca sua TAG em nosso Twitter: §b@NewNetworkMC");
		}
		else if(Cmd.getName().equalsIgnoreCase("spro")){
			p.sendMessage(" ");
			p.sendMessage("§6§lNew§f§lPvP §6» §7Requisitos para obter a tag §e§lSEMIPRO§7:");
			p.sendMessage(" ");
			p.sendMessage("§e▪ §7Possuir §e1.000+ §7inscritos");
			p.sendMessage("§e▪ §7Possuir uma media de §e100/200+ §7visualizacoes por video");
			p.sendMessage("§e▪ §7Possuir uma media de §e100+ §7likes por video");
			p.sendMessage("§e▪ §7Possuir §e1+ §7video(s) gravado(s) no servidor");
			p.sendMessage(" ");
			p.sendMessage("§7Caso possua os requisitos acima, peca sua TAG em nosso Twitter: §e@NewNetworkMC");
		}
		return false;
	}
}
