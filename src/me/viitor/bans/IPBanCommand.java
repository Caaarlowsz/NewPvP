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

public class IPBanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player)sender;	
		if (cmd.getName().equalsIgnoreCase("ipban")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+"))))))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /ipban <Jogador> <Motivo>");
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
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao pode banir a si mesmo");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if (Config.getConfig().getBans().get("Bans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador §6" + vitima.getName() + " §7ja esta §6§lBANIDO PERMANENTEMENTE");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getIpBans().get("IPBans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador §6" + vitima.getName() + " §7ja esta §6§lBANIDO POR IP");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (Config.getConfig().getTempBans().get("TempBans." + vitima.getUniqueId()) != null)  {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador " + vitima.getName() + " §7ja esta §6§lBANIDO TEMPORARIAMENTE");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			if (args.length == 1) {
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /ipban <Jogador> <Motivo>");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			API.sendBC("§c" + jogador.getName() + " baniu o ip de " + vitima.getName() + " por " + Motivo);
			API.sendMsg(jogador, "§aVoce baniu o ip de " + vitima.getName() + " por " + Motivo);
			API.sendStaff("§7O staffer " + jogador.getName() + " baniu o ip de jogador " + vitima.getName() + " pelo motivo " + Motivo);
			vitima.kickPlayer("§fVocê foi §4§lBANIDO ETERNAMENTE" + "\n" + "§fPelo" + jogador.getName() + "\n" + "§cMotivo: " + Motivo + "\n" + "§fNo dia: " + HorarioAPI.getHorario() + "\n" + "Foi §e§lbanido injustamente§f? Peça" + "§e§l APPEAL§f em: §f§l@NashKits" + "\nCompre §3§lUNBAN§f em nash-network.tk" +  " para ter o " + "§3§lACESSO §fliberado§f.");
			
			TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: " + Motivo + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
									 
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Nome", vitima.getName());
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Motivo", Motivo);
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".IP do Jogador", vitima.getAddress().getHostString());
			Config.getConfig().getIpBans().set("IPBans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
			Config.getConfig().saveIpBans();
			Bukkit.banIP(vitima.getAddress().getHostString());
			return true;						 
 		}
		return false;
	}
}
