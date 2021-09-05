package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class StopServerCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("stopserver")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") || !p.isOp()) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			for(Player todos : Bukkit.getOnlinePlayers()) {
				todos.kickPlayer("§6§lNew§f§lPvP" + "\n" + "§7Servidor fechado" + "\n" + "§7Podemos estar fechados por diversas razoes," + "\n" + "§7mas com certeza estamos fazendo algo" + "\n" + "§7para melhorar sua jogabilidade no servidor." + "\n" + "§7Esperamos a compreensao de todos." + "\n" + "§7§oAtenciosamente, equipe §6§lNew§f§lPvP§7.");
			}
			Bukkit.shutdown();
		}
		return false;
	}

}
