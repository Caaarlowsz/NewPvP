package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.WarpsAPI;
import me.viitor.configuração.cfGrupo;


public class SetCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("set")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Builder"))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /set <Local>");
				return true;
			}
			if (args[0].equalsIgnoreCase("spawn")) {
				WarpsAPI.Set(p, "Spawn");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Spawn setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc1")) {
				WarpsAPI.Set(p, "Loc1");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Loc1 setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc2")) {
				WarpsAPI.Set(p, "Loc2");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Loc2 setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc3")) {
				WarpsAPI.Set(p, "Loc3");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Loc3 setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc4")) {
				WarpsAPI.Set(p, "Loc4");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Loc4 setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("loc5")) {
				WarpsAPI.Set(p, "Loc5");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Loc5 setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("parkour")) {
				WarpsAPI.Set(p, "Parkour");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Parkour setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("villagerparkour")) {
				WarpsAPI.Set(p, "VillagerParkour");
				p.sendMessage("§6§lNew§f§lPvP §6» §7VillagerParkour setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("fps")) {
				WarpsAPI.Set(p, "Fps");
				p.sendMessage("§6§lNew§f§lPvP §6» §7FPS setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("1v1")) {
				WarpsAPI.Set(p, "1v1");
				p.sendMessage("§6§lNew§f§lPvP §6» §71v1 setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("1v1loc1")) {
				WarpsAPI.Set(p, "1v1loc1");
				p.sendMessage("§6§lNew§f§lPvP §6» §71v1Loc1 setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("1v1loc2")) {
				WarpsAPI.Set(p, "1v1loc2");
				p.sendMessage("§6§lNew§f§lPvP §6» §71v1Loc2 setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("challenge")) {
				WarpsAPI.Set(p, "Challenge");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Challenge setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("knockback")) {
				WarpsAPI.Set(p, "Knockback");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Knockback setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("main")) {
				WarpsAPI.Set(p, "Main");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Main setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("fisherman")) {
				WarpsAPI.Set(p, "Fisherman");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Fisherman setado com sucesso");
				return true;
			}
			if (args[0].equalsIgnoreCase("ss")) {
				WarpsAPI.Set(p, "SS");
				p.sendMessage("§6§lNew§f§lPvP §6» §7SS setado com sucesso");
				return true;
			}
		}
 		return false;
  }
}

