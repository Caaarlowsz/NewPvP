	package me.viitor.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class FlyCommand implements CommandExecutor{
	
	public static ArrayList<Player> Fly = new ArrayList<>();
	
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("fly")){
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(Args.length == 0 && API.getWarp(p) == "Spawn"){
				if(!Fly.contains(p)){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ativou seu modo Fly");
					API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) ativou o proprio modo fly");
					p.setAllowFlight(true);
					Fly.add(p);
					return true;
				}
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce desativou seu modo Fly");
					API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) desativou o proprio modo fly");
					p.setAllowFlight(false);
					Fly.remove(p);
					return false;
				}
			if(API.getWarp(p) != "Spawn") {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce so pode habilitar seu Fly na warp Spawn");
				return true;
			}
			else if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente")))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
				Player target = Bukkit.getPlayer(Args[0]);
				  if ((target == null) || (!(target instanceof Player))){
					p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador §6" + target.getName() + " §7encontra-se §6§lOFFLINE");
					return true;
				}
				if(!Fly.contains(target)){
					target.sendMessage("§6§lNew§f§lPvP §6» §7Seu modo Fly foi ativado pelo staffer §6" + p.getName());
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ativou o modo Fly do jogador §6" + target.getName());
					API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) ativou o modo fly de " + target.getDisplayName() + " (" + CorGrupo.getTag(target) + cfGrupo.pegargrupo().get("grupos." + target.getUniqueId() + ".grupo") + "§7)");
					Fly.add(target);
					target.setAllowFlight(true);
				}else{
					target.sendMessage("§6§lNew§f§lPvP §6» §7Seu modo Fly foi desativado pelo staffer §6" + p.getName());
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce desativou o modo Fly do jogador §6" + target.getName());
					API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) desativou o modo fly de " + target.getDisplayName() + " (" + CorGrupo.getTag(target) + cfGrupo.pegargrupo().get("grupos." + target.getUniqueId() + ".grupo") + "§7)");
					Fly.remove(target);
					target.setAllowFlight(false);
				}
		}
		return false;
	}
}
