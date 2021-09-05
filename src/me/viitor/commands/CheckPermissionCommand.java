package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfPermissão;

public class CheckPermissionCommand implements CommandExecutor {
	
	public static String checkPermission(Player p, String permission) {
		if(cfPermissão.getPermissao(p, permission)) {
			return "§a§lSim";
		}
		if(cfPermissão.getPermissao(p, permission)) {
			return "§c§lNao";
		}
		return "§c§lNao";
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("checkpermission")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /checkpermission <Jogador> <Permisao>");
				return true;
			}
			Player k = Bukkit.getPlayer(args[0]);
			if(k == null) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
				return true;
			} else {
				String permission = args[1];
				p.sendMessage("§6§lNew§f§lPvP §6» §7Checando informacoes sobre as permissoes do jogador §6" + k.getName() + "§7...");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Resultado: " + checkPermission(p, permission));
			}
		}
		return false;
	}

}
