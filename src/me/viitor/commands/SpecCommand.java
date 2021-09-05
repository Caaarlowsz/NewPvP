package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.API.ArraysAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class SpecCommand implements CommandExecutor{
	
	
	@SuppressWarnings("deprecation")
	public static void setON(Player p){
		for(Player todos : Bukkit.getOnlinePlayers()){
		if(ArraysAPI.Admin.contains(todos) && !ArraysAPI.Spec.contains(p)){
					if(todos != p){
						p.hidePlayer(todos);
					}
		   }
		}
	}
	@SuppressWarnings("deprecation")
	public static void setOFF(Player p){
		for(Player todos : Bukkit.getOnlinePlayers()){
		if(ArraysAPI.Admin.contains(todos) && ArraysAPI.Spec.contains(p)){
						p.showPlayer(todos);
						todos.showPlayer(p);
				}
		}
	}

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial")))))))){
			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
			return true;
		}
		
		if(Args.length == 0){
			p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /specs <On | Off>");
			return true;
		}
		if(Args[0].equalsIgnoreCase("on")){
		if(ArraysAPI.Spec.contains(p)){
			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ja esta com os SPECS ativados");
			return true;
		}
		p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ativou os SPECS");
		API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) ativou os specs");
		ArraysAPI.Spec.add(p);
	      setOFF(p);
	      return false;
		}
		if(Args[0].equalsIgnoreCase("off")){
		p.sendMessage("§6§lNew§f§lPvP §6» §7Voce desativou os SPECS");
		API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) desativou os specs");
		ArraysAPI.Spec.remove(p);
	      setON(p);
		}
		return false;
	}
}