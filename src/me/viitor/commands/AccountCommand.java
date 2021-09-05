package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.accutils.AccountUtils;
import me.viitor.bans.API;
import me.viitor.bans.Config;
import me.viitor.check.CheckUtils;
import me.viitor.configuração.cfStatus;
import me.viitor.scoreboard.sScoreAPI;

public class AccountCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("account") || cmd.getName().equalsIgnoreCase("acc")) {
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /account <Jogador>");
				API.sendSound(p, Sound.NOTE_PLING, 10);
				return true;
			}
			Player acc = Bukkit.getPlayer(args[0]);
			if(acc == null) {
				OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
				if(Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId()) == null) {
					API.sendMsg(p, "§6§lNew§f§lPvP §6» §7O jogador " + off.getName() + " nunca entrou no servidor");
					API.sendSound(p, Sound.NOTE_PLING, 10);
					return true;
				}
				if(Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId()) != null) {
					API.sendMsg(p, " ");
					API.sendMsg(p, "§7Verificando conta de §6" + off.getName() + "\n" + "§7UUID: §6" + off.getUniqueId().toString());
					API.sendMsg(p, "§7§m----------------------------------------------------");
					API.sendMsg(p, "§7Grupo atual: §6" + AccountUtils.getGrupo(off));
					API.sendMsg(p, "§7Status: §c§lOFFLINE");
					API.sendMsg(p, "§7Rank: §6" + AccountUtils.getRankOffline(off) + " " + AccountUtils.getRankNomeOffline(off));
					API.sendMsg(p, "§7Coins: §6" + Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId() + ".Coins"));
					API.sendMsg(p, "§7Kills: §6" + Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId() + ".Kills"));
					API.sendMsg(p, "§7Deaths: §6" + Config.getConfig().getJogadores().get("Jogadores." + off.getUniqueId() + ".Deaths"));
					if(Config.getConfig().getBans().get("Bans." + off.getUniqueId()) != null) {
						API.sendMsg(p, "§7Foi banido permanentemente por §6" + Config.getConfig().getBans().get("Bans." + off.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getBans().get("Bans." + off.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getBans().get("Bans." + off.getUniqueId() + ".Motivo"));
					}
					if(Config.getConfig().getTempBans().get("TempBans." + off.getUniqueId()) != null) {
						API.sendMsg(p, "§7Foi banido temporariamente por §6" + Config.getConfig().getTempBans().get("TempBans." + off.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getTempBans().get("TempBans." + off.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getTempBans().get("TempBans." + off.getUniqueId() + ".Motivo") + "§7. Duracao: §6" + Config.getConfig().getTempBans().get("TempBans." + off.getUniqueId() + ".Tempo do Ban"));
					}
					if(Config.getConfig().getIpBans().get("IPBans." + off.getUniqueId()) != null) {
						API.sendMsg(p, "§7Foi banido por IP permanentemente por §6" + Config.getConfig().getIpBans().get("IPBans." + off.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getIpBans().get("IPBans." + off.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getIpBans().get("IPBans." + off.getUniqueId() + ".Motivo"));
					}
					if(Config.getConfig().getMute().get("Mute." + off.getUniqueId()) != null) {
						API.sendMsg(p, "§7Foi mutado permanentemente por §6" + Config.getConfig().getMute().get("Mute." + off.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getMute().get("Mute." + off.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getMute().get("Mute." + off.getUniqueId() + ".Motivo"));
					}
					if(Config.getConfig().getTempMute().get("TempMute." + off.getUniqueId()) != null) {
						API.sendMsg(p, "§7Foi banido temporariamente por §6" + Config.getConfig().getTempMute().get("TempMute." + off.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getTempMute().get("TempMute." + off.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getTempMute().get("TempMute." + off.getUniqueId() + ".Motivo") + "§7. Duracao: §6" + Config.getConfig().getTempMute().get("TempMute." + off.getUniqueId() + ".Tempo do Mute"));
					}
					API.sendMsg(p, "§7§m----------------------------------------------------");
					API.sendMsg(p, " ");
				}
			}
			if(acc != null) {
				API.sendMsg(p, " ");
				API.sendMsg(p, "§7Verificando conta de §6" + acc.getName() + "\n" + "§7UUID: §6" + acc.getUniqueId().toString());
				API.sendMsg(p, "§7§m----------------------------------------------------");
				API.sendMsg(p, "§7Grupo atual: " + CheckUtils.Grupo(acc));
				API.sendMsg(p, "§7Status: §a§lONLINE");
				API.sendMsg(p, "§7Rank: " + sScoreAPI.getRank(acc) + " " + sScoreAPI.getNomeRank(acc));
				API.sendMsg(p, "§7Coins: §6" + cfStatus.getMoney(acc));
				API.sendMsg(p, "§7Kills: §6" + cfStatus.getKills(acc));
				API.sendMsg(p, "§7Deaths: §6" + cfStatus.getDeaths(acc));
				if(Config.getConfig().getBans().get("Bans." + acc.getUniqueId()) != null) {
					API.sendMsg(p, "§7Foi banido permanentemente por §6" + Config.getConfig().getBans().get("Bans." + acc.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getBans().get("Bans." + acc.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getBans().get("Bans." + acc.getUniqueId() + ".Motivo"));
				}
				if(Config.getConfig().getTempBans().get("TempBans." + acc.getUniqueId()) != null) {
					API.sendMsg(p, "§7Foi banido temporariamente por §6" + Config.getConfig().getTempBans().get("TempBans." + acc.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getTempBans().get("TempBans." + acc.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getTempBans().get("TempBans." + acc.getUniqueId() + ".Motivo") + "§7. Duracao: §6" + Config.getConfig().getTempBans().get("TempBans." + acc.getUniqueId() + ".Tempo do Ban"));
				}
				if(Config.getConfig().getIpBans().get("IPBans." + p.getUniqueId()) != null) {
					API.sendMsg(p, "§7Foi banido por IP permanentemente por §6" + Config.getConfig().getIpBans().get("IPBans." + acc.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getIpBans().get("IPBans." + acc.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getIpBans().get("IPBans." + acc.getUniqueId() + ".Motivo"));
				}
				if(Config.getConfig().getMute().get("Mute." + acc.getUniqueId()) != null) {
					API.sendMsg(p, "§7Foi mutado permanentemente por §6" + Config.getConfig().getMute().get("Mute." + acc.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getMute().get("Mute." + acc.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getMute().get("Mute." + acc.getUniqueId() + ".Motivo"));
				}
				if(Config.getConfig().getTempMute().get("TempMute." + acc.getUniqueId()) != null) {
					API.sendMsg(p, "§7Foi banido temporariamente por §6" + Config.getConfig().getTempMute().get("TempMute." + acc.getUniqueId() + ".Banido por") + " §7em §6" + Config.getConfig().getTempMute().get("TempMute." + acc.getUniqueId() + ".Data do banimento") + "§7. Motivo: §6" + Config.getConfig().getTempMute().get("TempMute." + acc.getUniqueId() + ".Motivo") + "§7. Duracao: §6" + Config.getConfig().getTempMute().get("TempMute." + acc.getUniqueId() + ".Tempo do Mute"));
				}
				API.sendMsg(p, "§7§m----------------------------------------------------");
				API.sendMsg(p, " ");
			}
		}
		return false;
	}
}
