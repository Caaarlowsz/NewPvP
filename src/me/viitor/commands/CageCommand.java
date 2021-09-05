package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class CageCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("cage")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /cage <Jogador>");
				return true;
			}
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if(t == null) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador " + args[0] + " encontra-se §6§lOFFLINE");
					return true;
				}
				if(t.getName() == p.getName()) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode prender a si mesmo");
					return true;
				}
		        t.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		        t.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		        t.teleport(t.getLocation().add(0.0D, 11.0D, -0.05D));
		        p.teleport(t.getLocation().add(3.0D, 0.0D, 0.05D));
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce prendeu o jogador §6" + t.getName());
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) prendeu o jogador " + t.getDisplayName() + " §7(" + CorGrupo.getTag(t) + cfGrupo.pegargrupo().get("grupos." + t.getUniqueId() + ".grupo") + "§7)");
				return true;
			}
		}
		return false;
	}
}
