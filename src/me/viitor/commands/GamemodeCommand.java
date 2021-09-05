package me.viitor.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class GamemodeCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("gamemode") || Cmd.getName().equalsIgnoreCase("gm")){
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial")))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(Args.length == 0){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /gamemode <0 | 1> ou /gm <0 | 1>");
				return true;
			}
			if(Args[0].equalsIgnoreCase("1")){
				
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Seu modo de jogo foi alterado para Criativo");
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) alterou o proprio modo de jogo para criativo");
			}
			if(Args[0].equalsIgnoreCase("0")){
				
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Seu modo de jogo foi alterado para Sobrevivencia");
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) alterou o proprio modo de jogo para sobrevivencia");
			}
		}
		return false;
	}
}
