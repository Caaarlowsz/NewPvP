package me.viitor.bans;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.HorarioAPI;
import me.viitor.bans.API;
import me.viitor.bans.Config;
import me.viitor.configuração.cfGrupo;
import me.viitor.twitter.TweetAPI;

public class BanCommand implements CommandExecutor {

	@SuppressWarnings({ "deprecation" })
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player jogador = (Player)sender;	
		if (cmd.getName().equalsIgnoreCase("ban")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && (!cfGrupo.ChecarGrupo(jogador, "Trial") && (!cfGrupo.ChecarGrupo(jogador, "Youtuber+"))))))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if (args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /ban <Jogador> <Motivo>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player vitima = Bukkit.getPlayer(args[0]);
			if (vitima == null) {
				OfflinePlayer vitimaoff = Bukkit.getOfflinePlayer(args[0]);
				if (vitimaoff.getName() == jogador.getName()) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao pode banir a si mesmo");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if (Config.getConfig().getBans().get("Bans." + vitimaoff.getUniqueId()) != null)  {
					 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador §6" + vitimaoff.getName() + " §7ja esta §6§lBANIDO PERMANENTEMENTE");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
				}
				if (Config.getConfig().getIpBans().get("IPBans." + vitimaoff.getUniqueId()) != null)  {
					 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador §6" + vitimaoff.getName() + " §7ja esta §6§lBANIDO POR IP");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
				}
				if (Config.getConfig().getTempBans().get("TempBans." + vitimaoff.getUniqueId()) != null)  {
					 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O Jogador " + vitimaoff.getName() + " §7ja esta §6§lBANIDO TEMPORARIAMENTE");
					 API.sendSound(jogador, Sound.NOTE_PLING, 10);
					 return true;
				}
				String Motivo = "";
				for (int i = 1; i < args.length; i++) {
					Motivo = Motivo + args[i] + " ";
				}
				double l = Config.getConfig().getBans().getDouble("Players Banidos");
				API.sendBC("§c" + jogador.getName() + " foi banido por " + Motivo);
				API.sendMsg(jogador, "§aVoce baniu " + vitimaoff.getName() + " por " + Motivo +"!");
				
				TweetAPI.update("Jogador banido: " + vitimaoff.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: " + Motivo + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
														 
				Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l + 1.0D));
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Nome", vitimaoff.getName());
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Banido por", jogador.getName());
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Motivo", Motivo);
				Config.getConfig().getBans().set("Bans." + vitimaoff.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
				Config.getConfig().saveBans();
				return true;
			}
			if (vitima.getName() == jogador.getName()) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao pode banir a si mesmo");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			if(vitima.getName() == "NickDoJogadorQueNaoPodeSerBanido") {
				
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
				 API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /ban <Jogador> <Motivo>");
				 API.sendSound(jogador, Sound.NOTE_PLING, 10);
				 return true;
			}
			String Motivo = "";
			for (int i = 1; i < args.length; i++) {
				Motivo = Motivo + args[i] + " ";
			}
			double l = Config.getConfig().getBans().getDouble("Players Banidos");
			API.sendBC("§c" + jogador.getName() + " baniu " + vitima.getName() + " por " + Motivo);
			API.sendMsg(jogador, "§aVoce baniu " + vitima.getName() + " por " + Motivo);
			API.sendStaff("§7O staffer " + jogador.getName() + " baniu o jogador " + vitima.getName() + " pelo motivo " + Motivo);
			vitima.kickPlayer("§cVoce foi §c§nbanido permanentemente§c do servidor." + "\n" + "§cJogador banido: " + vitima.getName() + "\n" + "§cBanido por: " + jogador.getName() + "\n" + "§cMotivo: " + Motivo + "\n" + "§cDuracao do banimento: Permanente" + "\n" + "§cData do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)");
			
			TweetAPI.update("Jogador banido: " + vitima.getName() + "\n" + "Banido por: " + jogador.getName() + "\n" + "Motivo: " + Motivo + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
									 
			Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l + 1.0D));
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Nome", vitima.getName());
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Banido por", jogador.getName());
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Motivo", Motivo);
			Config.getConfig().getBans().set("Bans." + vitima.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
			Config.getConfig().saveBans();
			return true;							 
 		}
		return false;
	}
}
