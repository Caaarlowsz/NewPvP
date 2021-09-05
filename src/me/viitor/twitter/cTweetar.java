package me.viitor.twitter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class cTweetar implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tweetar")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /tweetar <Principal/Staff/Bans>");
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("principal")) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /tweetar <Principal> <Tweet>");
					return true;
				}
				if(args[0].equalsIgnoreCase("staff")) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /tweetar <Staff> <Jogador> <Entrou/Saiu/Retirado/Retorna/Promovido/Rebaixado/Afastou/Afastado> <Cargo> <Twitter>");
					return true;
				}
				if(args[0].equalsIgnoreCase("bans")) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /tweetar <Bans> <Tweet>");
					return true;
				}
			}
			if(args.length >= 2) {
				if(args[0].equalsIgnoreCase("principal")) {
					String tweet = "";
					for(int i = 1; i < args.length; i++) {
						tweet = tweet + args[i] + " ";
					}
					TweetAPI.updatePrincipal(tweet);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
				if(args[0].equalsIgnoreCase("bans")) {
					String tweet = "";
					for(int i = 1; i < args.length; i++) {
						tweet = tweet + args[i] + " ";
					}
					TweetAPI.updateBans(tweet);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
			}
			if(args.length == 4) {
				if(args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("saiu")) {
					String jogador = args[1];
					String twitter = args[3];
					TweetAPI.updateStaffSaiu(jogador, twitter);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
				if(args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("retirado")) {
					String jogador = args[1];
					String twitter = args[3];
					TweetAPI.updateStaffRetirado(jogador, twitter);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
				if(args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("afastou")) {
					String jogador = args[1];
					String twitter = args[3];
					TweetAPI.updateStaffAfastou(jogador, twitter);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
				if(args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("afastado")) {
					String jogador = args[1];
					String twitter = args[3];
					TweetAPI.updateStaffAfastado(jogador, twitter);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
			}
			if(args.length == 5) {
				if(args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("entrou")) {
					String jogador = args[1];
					String cargo = args[3];
					String twitter = args[4];
					TweetAPI.updateStaffEntrou(jogador, cargo, twitter);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
				if(args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("promovido")) {
					String jogador = args[1];
					String cargo = args[3];
					String twitter = args[4];
					TweetAPI.updateStaffPromovido(jogador, cargo, twitter);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
				if(args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("rebaixado")) {
					String jogador = args[1];
					String cargo = args[3];
					String twitter = args[4];
					TweetAPI.updateStaffRebaixado(jogador, cargo, twitter);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
				if(args[0].equalsIgnoreCase("staff") && args[2].equalsIgnoreCase("retorna")) {
					String jogador = args[1];
					String cargo = args[3];
					String twitter = args[4];
					TweetAPI.updateStaffRetorna(jogador, cargo, twitter);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Tweet publicado com sucesso");
					return true;
				}
			}
		}
		return false;
	}
}
