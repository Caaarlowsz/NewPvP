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

public class GiveVipCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("givevip")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				if((sender instanceof Player)) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /givevip <Jogador> <Vip>");
					return true;
				}
			}
			if(args.length == 1) {
				if((sender instanceof Player)) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /givevip <Jogador> <Vip>");
					return true;
				}
 			}
			if(args.length == 2) {
				Player k = Bukkit.getPlayer(args[0]);
				String arg = args[1];
				if((sender instanceof Player)) {
					if(k == null) {
						OfflinePlayer off = Bukkit.getOfflinePlayer(args[0]);
						if(arg.equalsIgnoreCase("light")) {
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o VIP §6Light §7para o jogador jogador §6" + off.getName());
							
							cfGrupo.setarGrupo(off, "Light");
							cfGrupo.salvarconfiguracao();
							return true;
						}
						if(arg.equalsIgnoreCase("mvp")) {
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o VIP §6Mvp §7para o jogador jogador §6" + off.getName());
							
							cfGrupo.setarGrupo(off, "Mvp");
							cfGrupo.salvarconfiguracao();
							return true;
						}
						if(arg.equalsIgnoreCase("pro")) {
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o VIP §6Pro §7para o jogador jogador §6" + off.getName());
							
							cfGrupo.setarGrupo(off, "Pro");
							cfGrupo.salvarconfiguracao();
							return true;
						}
					}
					if(k != null) {
						if(arg.equalsIgnoreCase("light")) {
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o VIP §6Light §7para o jogador §6" + k.getName());
							
							k.sendMessage("§6§lNew§f§lPvP §6» §7Voce ganhou o VIP §6Light");
							
							TituloAPI.MandarTitulo(k, "§6GiveVIP");
							TituloAPI.MandarSubTitulo(k, "§7Voce ganhou o VIP §6Light");
							
							cfGrupo.setarGrupo(k, "Light");
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
							
							k.chat("/tag light");
							return true;
						}
						if(arg.equalsIgnoreCase("mvp")) {
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o VIP §6Mvp §7para o jogador §6" + k.getName());
							
							k.sendMessage("§6§lNew§f§lPvP §6» §7Voce ganhou o VIP §6Mvp");
							
							TituloAPI.MandarTitulo(k, "§6GiveVIP");
							TituloAPI.MandarSubTitulo(k, "§7Voce ganhou o VIP §6Mvp");
							
							cfGrupo.setarGrupo(k, "Mvp");
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
							
							k.chat("/tag mvp");
							return true;
						}
						if(arg.equalsIgnoreCase("pro")) {
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce deu o VIP §6Pro §7para o jogador §6" + k.getName());
							
							k.sendMessage("§6§lNew§f§lPvP §6» §7Voce ganhou o VIP §6Pro");
							
							TituloAPI.MandarTitulo(k, "§6GiveVIP");
							TituloAPI.MandarSubTitulo(k, "§7Voce ganhou o VIP §6Pro");
							
							cfGrupo.setarGrupo(k, "Pro");
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
							
							k.chat("/tag pro");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
