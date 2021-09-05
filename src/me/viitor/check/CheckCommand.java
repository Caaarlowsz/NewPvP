package me.viitor.check;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;

public class CheckCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("check")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod")) {
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /check <Jogador>");
				return true;
			}
			Player check = Bukkit.getPlayer(args[0]);
			if(check == null) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
				return true;
			}
			p.sendMessage(" ");
			p.sendMessage("§7Verificando conta de §6" + check.getName() + "\n" + "§7UUID: §6" + check.getUniqueId().toString());
			p.sendMessage("§7§m----------------------------------------------------");
			p.sendMessage("§7Grupo: " + CheckUtils.Grupo(check));
			p.sendMessage("§7Nickname: " + CheckUtils.Nickname(check));
			p.sendMessage("§7IP: " + CheckUtils.IP(check));
			p.sendMessage("§7IP Reverso: " + CheckUtils.IPReverso(check));
			p.sendMessage("§7GEOIP: " + CheckUtils.GeoIP(check));
			p.sendMessage("§7Gamemode: " + CheckUtils.Gamemode(check));
			p.sendMessage("§7Fly: " + CheckUtils.Fly(check));
			p.sendMessage("§7Vida: " + CheckUtils.Vida(check));
			p.sendMessage("§7Fome: " + CheckUtils.Fome(check));
			p.sendMessage("§7Kit: " + CheckUtils.Kit(check));
			p.sendMessage("§7Warp: " + CheckUtils.Warp(check));
			p.sendMessage("§7Rank: " + CheckUtils.Rank(check));
			p.sendMessage("§7§m----------------------------------------------------");
			p.sendMessage(" ");
		}
		return false;
	}
}
