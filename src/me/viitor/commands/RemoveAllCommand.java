package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class RemoveAllCommand implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("removeall")){
		
		if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")){
			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
			return true;
		}
		
		if(Args.length == 0){
			p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /removeall <FULLKIT>");
			return true;
		}
		if(Args[0].equalsIgnoreCase("fullkit")){
			
			if(!GiveAllCommand.fullkit){
				p.sendMessage("§6§lNew§f§lPvP §6» §7A permissao §6FULL KIT §7nao esta liberada");
			}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce retirou a permissao §6FULL KIT §7de todos");
				Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7O staffer §6" + p.getName() + " §7retirou a permissao §6FULL KIT §7de todos os jogadores");
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) retirou o fullkit de todos os jogadores");
				GiveAllCommand.fullkit = false;
				return true;
			}
		}
	}
 return false;
  }
}
