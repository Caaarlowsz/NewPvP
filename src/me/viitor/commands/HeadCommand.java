package me.viitor.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;

public class HeadCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("head")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin"))))){
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /head <Jogador>");
				return true;
			}
			if(args.length == 1) {
				String jogador = args[0];
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
				SkullMeta itemm = (SkullMeta) item.getItemMeta();
				itemm.setOwner(jogador);
				itemm.setDisplayName("§7Cabeca de " + jogador);
				item.setItemMeta(itemm);
			}
		}
		return false;
	}
}
