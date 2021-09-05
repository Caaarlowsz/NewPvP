package me.viitor.bans;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.HorarioAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.twitter.TweetAPI;

public class MuteCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		Player jogador = (Player)sender;
		if (cmd.getName().equalsIgnoreCase("mute")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+") && (!cfGrupo.ChecarGrupo(jogador, "Helper")))))))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /mute <Jogador> <Motivo>");
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
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao pode mutar a si mesmo");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Mute." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador §6" + vitima.getName() + " §7ja esta §6§lMUTADO PERMANENTEMENTE");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getIpBans().get("TempMute." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador §6" + vitima.getName() + " §7ja esta §6§lMUTADO TEMPORARIAMENTE");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (args.length == 1) {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /mute <Jogador> <Motivo>");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			API.sendBC("§c" + jogador.getName() + " mutou " + vitima.getName() + " por " + Motivo);
			API.sendMsg(jogador, "§aVoce mutou " + vitima.getName() + " por " + Motivo);
			API.sendStaff("§7O staffer " + jogador.getName() + " mutou o jogador " + vitima.getName() + " pelo motivo " + Motivo);
			API.sendMsg(vitima, "§cVoce foi mutado permanentemente pelo " + jogador.getName() + " por " + Motivo);
			
			TweetAPI.update("Jogador mutado: " + vitima.getName() + "\n" + "Mutado por: " + jogador.getName() + "\n" + "Motivo: " + Motivo + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
									 
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Nome", vitima.getName());
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Mutado por", jogador.getName());
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Motivo", Motivo);
			Config.getConfig().getMute().set("Mute." + vitima.getUniqueId() + ".Data do mute", HorarioAPI.getHorario());
			Config.getConfig().saveMute();
			return true;
		}
		return false;
		
	}
}
