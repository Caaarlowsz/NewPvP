package me.viitor.bans;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class PunishCheckCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player jogador = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("bancheck")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod") && !cfGrupo.ChecarGrupo(jogador, "Trial"))))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /bancheck <Jogador>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player check = Bukkit.getPlayer(args[0]);
			if(check == null) {
				OfflinePlayer checkoff = Bukkit.getOfflinePlayer(args[0]);
				if(Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) == null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador " + checkoff.getName() + " §7nunca entrou no servidor");
					API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if(Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) != null) {
					if(Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + checkoff.getName());
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido PERMANENTEMENTE: §c§lNao");
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido TEMPORARIAMENTE: §c§lNao");
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido POR IP: §c§lNao");
						return true;
					}
					if(Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) != null && Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + checkoff.getName());
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido PERMANENTEMENTE: §a§lSim");
						API.sendMsg(jogador, "                     §7Banido por: " + Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "                     §7Data do banimento: " + Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido TEMPORARIAMENTE: §c§lNao");
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido POR IP: §c§lNao");
						return true;
					}
					if(Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) != null && Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + checkoff.getName());
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido PERMANENTEMENTE: §c§lNao");
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido TEMPORARIAMENTE: §a§lSim");
						API.sendMsg(jogador, "                     §7Banido por: " + Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "                     §7Duracao do banimento: " + Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Tempo do Ban"));
						API.sendMsg(jogador, "                     §7Data do banimento: " + Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido POR IP: §c§lNao");
						return true;
					}
					if(Config.getConfig().getBans().get("Bans." + checkoff.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + checkoff.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId()) != null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + checkoff.getName());
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido PERMANENTEMENTE: §c§lNao");
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido TEMPORARIAMENTE: §c§lNao");
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido POR IP: §a§lSim");
						API.sendMsg(jogador, "                     §7Banido por: " + Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".Banido por"));
						API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "                     §7Data do banimento: " + Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".Data do banimento"));
						API.sendMsg(jogador, "                     §7IP banido: " + Config.getConfig().getIpBans().get("IPBans." + checkoff.getUniqueId() + ".IP do Jogador"));
						return true;
					}
				}
			}
			if(Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + check.getName());
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido PERMANENTEMENTE: §c§lNao");
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido TEMPORARIAMENTE: §c§lNao");
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido POR IP: §c§lNao");
				return true;
			}
			if(Config.getConfig().getBans().get("Bans." + check.getUniqueId()) != null && Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + check.getName());
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido PERMANENTEMENTE: §a§lSim");
				API.sendMsg(jogador, "                     §7Banido por: " + Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "                     §7Data do banimento: " + Config.getConfig().getBans().get("Bans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido TEMPORARIAMENTE: §c§lNao");
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido POR IP: §c§lNao");
				return true;
			}
			if(Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) != null && Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + check.getName());
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido PERMANENTEMENTE: §c§lNao");
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido TEMPORARIAMENTE: §a§lSim");
				API.sendMsg(jogador, "                     §7Banido por: " + Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "                     §7Duracao do banimento: " + Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Tempo do Ban"));
				API.sendMsg(jogador, "                     §7Data do banimento: " + Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido POR IP: §c§lNao");
				return true;
			}
			if(Config.getConfig().getBans().get("Bans." + check.getUniqueId()) == null && Config.getConfig().getTempBans().get("TempBans." + check.getUniqueId()) == null && Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId()) != null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + check.getName());
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido PERMANENTEMENTE: §c§lNao");
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido TEMPORARIAMENTE: §c§lNao");
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Banido POR IP: §a§lSim");
				API.sendMsg(jogador, "                     §7Banido por: " + Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Banido por"));
				API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "                     §7Data do banimento: " + Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".Data do banimento"));
				API.sendMsg(jogador, "                     §7IP banido: " + Config.getConfig().getIpBans().get("IPBans." + check.getUniqueId() + ".IP do Jogador"));
				return true;
			}
		}
		if(cmd.getName().equalsIgnoreCase("mutecheck")) {
			if((!cfGrupo.ChecarGrupo(jogador, "Dono") && (!cfGrupo.ChecarGrupo(jogador, "Gerente") && (!cfGrupo.ChecarGrupo(jogador, "Admin") && (!cfGrupo.ChecarGrupo(jogador, "Mod+") && (!cfGrupo.ChecarGrupo(jogador, "Mod"))))))){
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Utilize /mutecheck <Jogador>");
				API.sendSound(jogador, Sound.NOTE_PLING, 10);
				return true;
			}
			Player check = Bukkit.getPlayer(args[0]);
			if(check == null) {
				OfflinePlayer checkoff = Bukkit.getOfflinePlayer(args[0]);
				if(Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) == null) {
					API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7O jogador " + checkoff.getName() + " §7nunca entrou no servidor");				API.sendSound(jogador, Sound.NOTE_PLING, 10);
					return true;
				}
				if(Config.getConfig().getJogadores().get("Jogadores." + checkoff.getUniqueId()) != null) {
					if(Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) == null && Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + checkoff.getName());
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado PERMANENTEMENTE: §c§lNao");
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado TEMPORARIAMENTE: §c§lNao");
						return true;
					}
					if(Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) != null && Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) == null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + checkoff.getName());
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado PERMANENTEMENTE: §a§lSim");
						API.sendMsg(jogador, "                     §7Mutado por: " + Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Mutado por"));
						API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "                     §7Data do mute: " + Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId() + ".Data do mute"));
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado TEMPORARIAMENTE: §c§lNao");
						return true;
					}
					if(Config.getConfig().getMute().get("Mute." + checkoff.getUniqueId()) == null && Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId()) != null) {
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + checkoff.getName());
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado PERMANENTEMENTE: §c§lNao");
						API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado TEMPORARIAMENTE: §a§lSim");
						API.sendMsg(jogador, "                     §7Mutado por: " + Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId() + ".Mutado por"));
						API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId() + ".Motivo"));
						API.sendMsg(jogador, "                     §7Duracao do mute: " + Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId() + ".Tempo do Mute"));
						API.sendMsg(jogador, "                     §7Data do mute: " + Config.getConfig().getTempMute().get("TempMute." + checkoff.getUniqueId() + ".Data do mute"));
						return true;
					}
				}
			}
			if(Config.getConfig().getMute().get("Mute." + check.getUniqueId()) == null && Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + check.getName());
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado PERMANENTEMENTE: §c§lNao");
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado TEMPORARIAMENTE: §c§lNao");
				return true;
			}
			if(Config.getConfig().getMute().get("Mute." + check.getUniqueId()) != null && Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) == null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + check.getName());
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado PERMANENTEMENTE: §a§lSim");
				API.sendMsg(jogador, "                     §7Mutado por: " + Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Mutado por"));
				API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "                     §7Data do mute: " + Config.getConfig().getMute().get("Mute." + check.getUniqueId() + ".Data do mute"));
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado TEMPORARIAMENTE: §c§lNao");
				return true;
			}
			if(Config.getConfig().getMute().get("Mute." + check.getUniqueId()) == null && Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId()) != null) {
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Checando informacoes do jogador §6" + check.getName());
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado PERMANENTEMENTE: §c§lNao");
				API.sendMsg(jogador, "§6§lNew§f§lPvP §6» §7Mutado TEMPORARIAMENTE: §a§lSim");
				API.sendMsg(jogador, "                     §7Mutado por: " + Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Mutado por"));
				API.sendMsg(jogador, "                     §7Motivo: " + Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Motivo"));
				API.sendMsg(jogador, "                     §7Duracao do mute: " + Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Tempo do Mute"));
				API.sendMsg(jogador, "                     §7Data do mute: " + Config.getConfig().getTempMute().get("TempMute." + check.getUniqueId() + ".Data do mute"));
				return true;
			}
		}
		return false;
	}
}
