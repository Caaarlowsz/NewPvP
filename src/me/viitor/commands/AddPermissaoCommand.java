package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfPermissão;
import me.viitor.events.CorGrupo;

public class AddPermissaoCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("addpermission")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Admin")))){
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /addpermission <Jogador> <Permissao>");
				return true;
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /addpermission <Jogador> <Permissao>");
				return true;
			}
			Player k = Bukkit.getPlayer(args[0]);
			String permissao = args[1];
			cfPermissão.setarPermissao(k, permissao, "true");
			p.sendMessage("§6§lNew§f§lPvP §6» §7Permissao §6" + permissao + " §7adicionada ao jogador §6" + k.getName());
			me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) adicionou a permissao §6" + permissao + " §7ao jogador " + k.getDisplayName() + " §7(" + CorGrupo.getTag(k) + cfGrupo.pegargrupo().get("grupos." + k.getUniqueId() + ".grupo") + "§7)");
		}
		if(cmd.getName().equalsIgnoreCase("removepermission")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Admin")))){
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /removepermission <Jogador> <Permissao>");
				return true;
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /removepermission <Jogador> <Permissao>");
				return true;
			}
			Player k = Bukkit.getPlayer(args[0]);
			String permissao = args[1];
			cfPermissão.setarPermissao(k, permissao, "false");
			p.sendMessage("§6§lNew§f§lPvP §6» §7Permissao §6" + permissao + " §7retirada do jogador §6" + k.getName());
			me.viitor.API.API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) removeu a permissao §6" + permissao + " §7do jogador " + k.getDisplayName() + " §7(" + CorGrupo.getTag(k) + cfGrupo.pegargrupo().get("grupos." + k.getUniqueId() + ".grupo") + "§7)");
		}
		return false;
	}
}
