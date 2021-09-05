package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import me.viitor.API.API;
import me.viitor.bans.Config;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class ManutencaoCommand implements CommandExecutor, Listener {
	
	public static boolean manutencao = false;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("manutencao")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /manutencao <On/Off>");
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("on")) {
					if((manutencao)) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7O modo manutencao ja esta ativado");
						return true;
					} else {
						manutencao = true;
						p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ativou o modo manutencao");
						API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) ativou o modo manutencao");
						for(Player todos : Bukkit.getOnlinePlayers()) {
							if(!cfGrupo.ChecarGrupo(todos, "Dono") && !cfGrupo.ChecarGrupo(todos, "Gerente") && !cfGrupo.ChecarGrupo(todos, "Admin")) {
								todos.kickPlayer("§cO servidor entrou no §c§nmodo de manutencao§c." + "\n" + "Estamos, com certeza, trabalhando em algo para melhorar sua jogabilidade e garantir melhor diversao enquanto jogando no servidor." + "\n" + "Nosso servidor estara de volta em breve. Esperamos e agradecemos a compreensao de todos." + "\n" + "§c§oAtenciosamente, equipe NewNetworkMC");
								return true;
							}
						}
						Config.getConfig().saveManutencao();
						return true;
					}
				}
				if(args[0].equalsIgnoreCase("off")) {
					if(!(manutencao)) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7O modo manutencao ja esta desativado");
						return true;
					} else {
						manutencao = false;
						p.sendMessage("§6§lNew§f§lPvP §6» §7Voce desativou o modo manutencao");
						API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) desativou o modo manutencao");
						return true;
					}
				}
			}
		}
		
		return false;
	}
	@EventHandler
	public void aoEntrarManutencao(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if((manutencao) && !cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin")) {
			e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cO servidor esta no §c§nmodo de manutencao§c." + "\n" + "Estamos, com certeza, trabalhando em algo para melhorar sua jogabilidade e garantir melhor diversao enquanto jogando no servidor." + "\n" + "Nosso servidor estara de volta em breve. Esperamos e agradecemos a compreensao de todos." + "\n" + "§c§oAtenciosamente, equipe NewNetworkMC");
		}
	}
}
