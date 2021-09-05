package me.viitor.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.viitor.API.ArraysAPI;
import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class SKitCommand implements CommandExecutor {
	
	public static HashMap<String, ItemStack[]> itens = new HashMap<String, ItemStack[]>();
	public static HashMap<String, ItemStack[]> armadura = new HashMap<String, ItemStack[]>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("skit")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+")))))){
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /skit <Criar/Remover/Aplicar> <Nome>");
				return true;
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /skit <Criar/Remover/Aplicar> <Nome>");
				return true;
			}
			if(args.length <= 2) {
				if(args[0].equalsIgnoreCase("criar")) {
					String nome = args[1];
					if(itens.containsKey(nome) && armadura.containsKey(nome)) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7O kit §6" + nome + " §7ja existe");
						return true;
					}
					itens.put(nome, p.getInventory().getContents());
					armadura.put(nome, p.getInventory().getArmorContents());
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce criou o kit §6" + nome);
					me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) criou o kit(/skit) §6" + nome);
					return true;
				}
				if(args[0].equalsIgnoreCase("remover")) {
					String nome = args[1];
					if(!itens.containsKey(nome) && !armadura.containsKey(nome)) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7O kit §6" + nome + "§7 nao existe");
						return true;
					}
					itens.remove(nome);
					armadura.remove(nome);
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deletou o kit §6" + nome);
					me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) removeu o kit(/skit) §6" + nome);
					return true;
				}
				if(args[0].equalsIgnoreCase("aplicar")) {
					String nome = args[1];
					if(!itens.containsKey(nome) && !armadura.containsKey(nome)) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7O kit §6" + nome + "§7 nao existe");
						return true;
					}
					if(itens.containsKey(nome) && armadura.containsKey(nome)) {
						for(Player todos : Bukkit.getOnlinePlayers()) {
							if(todos != p) {
								if(!ArraysAPI.Admin.contains(todos)) {
									todos.getInventory().setContents((ItemStack[])itens.get(nome));
									todos.getInventory().setArmorContents((ItemStack[])armadura.get(nome));
									todos.updateInventory();
									p.sendMessage("§6§lNew§f§lPvP §6» §7Voce aplicou o kit §6" + nome + "§7 com sucesso a todos os jogadores");
									Bukkit.broadcastMessage("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + " §7aplicou o kit §6" + nome + "§7 a todos os jogadores");
									me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) aplicou o kit(/skit) §6" + nome + "§7 a todos os jogadores");
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

}
