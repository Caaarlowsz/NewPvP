package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;
import me.viitor.scoreboard.sScoreAPI;
import me.viitor.tab_1_8.TituloAPI;

public class GiveCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("giveyoutuber")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				if((sender instanceof Player)) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /giveyoutuber <Jogador>");
					return true;
				}
				if(!(sender instanceof Player)) {
					sender.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /giveyoutuber <Jogador>");
					return true;
				}
			}
			if(args.length == 1) {
				Player k = Bukkit.getPlayer(args[0]);
				if((sender instanceof Player)) {
					if(k == null) {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						
						p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o grupo §6YouTuber §7para o jogador §6" + off.getName());
						
						cfGrupo.setarGrupo(off, "Youtuber");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if(k != null) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o grupo §6YouTuber §7para o jogador §6" + k.getName());
						
						k.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6YouTuber");
						
						TituloAPI.MandarTitulo(k, "§6GroupSet");
						TituloAPI.MandarSubTitulo(k, "§7Seu grupo foi alterado para §6YouTuber");
						
						cfGrupo.setarGrupo(k, "Youtuber");
						cfGrupo.salvarconfiguracao();
						
						if(cfGrupo.ChecarGrupo(k, "Dono")){
							CorGrupo.setarTag(k, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Gerente")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Admin")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod+")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Trial")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber+")){
							CorGrupo.setarTag(k, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Builder")){
							CorGrupo.setarTag(k, "§2§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Helper")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber")){
							CorGrupo.setarTag(k, "§b§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "S-Pro")){
							CorGrupo.setarTag(k, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Pro")){
							CorGrupo.setarTag(k, "§6§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mvp")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Light")){
							CorGrupo.setarTag(k, "§a§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Membro")){
							CorGrupo.setarTag(k, "§7§l");
						}
						
						sScoreAPI.scoreboard(k);
						
						k.chat("/tag yt");
						return true;
					}
				}
				if(!(sender instanceof Player)) {
					if(k == null) {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						
						sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o grupo §6YouTuber §7para o jogador §6" + off.getName());
						
						cfGrupo.setarGrupo(off, "Youtuber");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if(k != null) {
						sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o grupo §6YouTuber §7para o jogador §6" + k.getName());
						
						k.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6YouTuber");
						
						TituloAPI.MandarTitulo(k, "§6GroupSet");
						TituloAPI.MandarSubTitulo(k, "§7Seu grupo foi alterado para §6YouTuber");
						
						cfGrupo.setarGrupo(k, "Youtuber");
						cfGrupo.salvarconfiguracao();
						
						if(cfGrupo.ChecarGrupo(k, "Dono")){
							CorGrupo.setarTag(k, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Gerente")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Admin")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod+")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Trial")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber+")){
							CorGrupo.setarTag(k, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Builder")){
							CorGrupo.setarTag(k, "§2§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Helper")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber")){
							CorGrupo.setarTag(k, "§b§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "S-Pro")){
							CorGrupo.setarTag(k, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Pro")){
							CorGrupo.setarTag(k, "§6§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mvp")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Light")){
							CorGrupo.setarTag(k, "§a§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Membro")){
							CorGrupo.setarTag(k, "§7§l");
						}
						
						sScoreAPI.scoreboard(k);
						
						k.chat("/tag yt");
						return true;
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("givebuilder")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				if((sender instanceof Player)) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /givebuilder <Jogador>");
					return true;
				}
				if(!(sender instanceof Player)) {
					sender.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /givebuilder <Jogador>");
					return true;
				}
			}
			if(args.length == 1) {
				Player k = Bukkit.getPlayer(args[0]);
				if((sender instanceof Player)) {
					if(k == null) {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[1]);
						
						p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o grupo §6YouTuber §7para o jogador §6" + off.getName());
						
						cfGrupo.setarGrupo(off, "Builder");
						cfGrupo.salvarconfiguracao();
						return true;
					}
					if(k != null) {
						p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o grupo §6Builder §7para o jogador §6" + k.getName());
						
						k.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Builder");
						
						TituloAPI.MandarTitulo(k, "§6GroupSet");
						TituloAPI.MandarSubTitulo(k, "§7Seu grupo foi alterado para §6Builder");
						
						cfGrupo.setarGrupo(k, "Builder");
						cfGrupo.salvarconfiguracao();
						
						if(cfGrupo.ChecarGrupo(k, "Dono")){
							CorGrupo.setarTag(k, "§4§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Gerente")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Admin")){
							CorGrupo.setarTag(k, "§c§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod+")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mod")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Trial")){
							CorGrupo.setarTag(k, "§5§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber+")){
							CorGrupo.setarTag(k, "§3§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Builder")){
							CorGrupo.setarTag(k, "§2§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Helper")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Youtuber")){
							CorGrupo.setarTag(k, "§b§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "S-Pro")){
							CorGrupo.setarTag(k, "§e§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Pro")){
							CorGrupo.setarTag(k, "§6§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Mvp")){
							CorGrupo.setarTag(k, "§9§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Light")){
							CorGrupo.setarTag(k, "§a§l");
						}
						else if(cfGrupo.ChecarGrupo(k, "Membro")){
							CorGrupo.setarTag(k, "§7§l");
						}
						
						sScoreAPI.scoreboard(k);
						
						k.chat("/tag builder");
						return true;
					}
				}
			}
		}
		return false;
	}
}
