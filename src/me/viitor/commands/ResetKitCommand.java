package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.API.KitAPI;
import me.viitor.API.WarpsAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.scoreboard.sScoreAPI;

public class ResetKitCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("resetkit") || cmd.getName().equalsIgnoreCase("kitreset")) {
			if(cfGrupo.ChecarGrupo(p, "Membro")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(API.getWarp(p) == "Spawn" && KitAPI.getKit(p) == "Nenhum") {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce precisa estar utilizando um kit para executar este comando");
				return true;
			}
			if(API.getWarp(p) != "Arena") {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode resetar seu kit neste local");
			}
			if(API.getWarp(p) != "Spawn" && KitAPI.getKit(p) != "Nenhum" && API.getWarp(p) == "Arena") {
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				API.setWarp(p, "Spawn");
				KitAPI.removeKits(p);
				WarpsAPI.Ir(p, "Spawn");
				API.sendItems(p);
				sScoreAPI.scoreboard(p);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce resetou seu kit e foi enviado ao spawn");
			}
		}
		return false;
	}

}
