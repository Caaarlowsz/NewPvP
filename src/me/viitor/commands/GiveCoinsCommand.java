package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.cfStatus;
import me.viitor.configuração.cfGrupo;
import me.viitor.scoreboard.sScoreAPI;

public class GiveCoinsCommand implements CommandExecutor {
	
	private boolean Numero(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("givecoins")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /givecoins <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /givecoins <Jogador> <Quantia>");
				return true;
			}
			String valorstring = args[1];
			Player k = Bukkit.getPlayer(args[0]);
			if(!Numero(valorstring)) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize apenas numeros na quantia");
				return true;
			}
			if(k == null) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
				return true;
			}
			if(k != null) {
				cfStatus.setMoney(p, valorstring.length());
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce adicionou §6" + valorstring + " coins §7ao jogador §6" + k.getName());
				sScoreAPI.scoreboard(k);
				return true;
			}
		}
		return false;
	}
}
