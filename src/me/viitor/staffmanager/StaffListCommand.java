package me.viitor.staffmanager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class StaffListCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		String staff = "";
		Player[] arrayOfPlayer;
		int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
		for(int i = 0; i < j; i++) {
			Player player = arrayOfPlayer[i];
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")) {
				if(cfGrupo.ChecarGrupo(player, "Mod+") || cfGrupo.ChecarGrupo(player, "Mod") || cfGrupo.ChecarGrupo(player, "Trial") || cfGrupo.ChecarGrupo(player, "Youtuber+") || cfGrupo.ChecarGrupo(player, "Helper") || cfGrupo.ChecarGrupo(player, "Builder")) {
					staff = staff + GroupManager.getGrupo(player) + player.getName() + " §7- KitPvP" + "\n";
				}
			} else {
				if(cfGrupo.ChecarGrupo(player, "Dono") || cfGrupo.ChecarGrupo(player, "Admin") || cfGrupo.ChecarGrupo(player, "Gerente") || cfGrupo.ChecarGrupo(player, "Mod+") || cfGrupo.ChecarGrupo(player, "Mod") || cfGrupo.ChecarGrupo(player, "Trial") || cfGrupo.ChecarGrupo(player, "Youtuber+") || cfGrupo.ChecarGrupo(player, "Helper") || cfGrupo.ChecarGrupo(player, "Builder")) {
					staff = staff + GroupManager.getGrupo(player) + player.getName() + " §7- KitPvP" + "\n";
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("stafflist")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper") && !cfGrupo.ChecarGrupo(p, "Builder")) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			p.sendMessage(" ");
			p.sendMessage("§6§lNash§f§lPvP §6» §7Staffers online no momento:");
			p.sendMessage(" ");
			p.sendMessage(staff);
			p.sendMessage(" ");
		}
		return false;
	}

}
