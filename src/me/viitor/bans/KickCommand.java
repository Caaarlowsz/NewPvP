package me.viitor.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class KickCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("kick")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+"))))))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /kick <Jogador> <Motivo>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao pode kickar a si mesmo");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (args.length == 1) {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /kick <Jogador> <Motivo>");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			API.sendBC("§c" + jogador.getName() + " kickou " + vitima.getName() + " por " + Motivo);
			API.sendMsg(jogador, "§aVoce kickou " + vitima.getName() + " por " + Motivo);
			API.sendStaff("§7O staffer " + jogador.getName() + " kickou o jogador " + vitima.getName() + " pelo motivo " + Motivo);
			vitima.kickPlayer("§cVoce foi §c§nkickado§c do servidor." + "\n" + "§cJogador kickado: " + vitima.getName() + "\n" + "§cKickado por: " + jogador.getName() + "\n" + "§cMotivo: " + Motivo);
			return true;						
		}
		return false;
	}
}
