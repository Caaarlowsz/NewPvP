package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.VisAPI;
import me.viitor.configuração.cfConfig;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;
import me.viitor.scoreboard.sScoreAPI;
import me.viitor.tab_1_8.TituloAPI;

public class GroupSetCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		
		if(Cmd.getName().equalsIgnoreCase("groupset")){
			if(Sender instanceof Player){
				Player p = (Player)Sender;
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(Args.length == 0){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /groupset <Jogador> <Grupo>");
				return true;
			}
			Player target = Bukkit.getPlayerExact(Args[0]);
			
			if(target == null){
				OfflinePlayer targetoff = Bukkit.getOfflinePlayer(Args[0]);
					
				if(Args.length == 1){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /groupset <Jogador> <Grupo>");
					return true;
				}
				if(Args[1].equalsIgnoreCase("membro")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Membro");
					
					cfGrupo.setarGrupo(targetoff, "Membro");
					cfGrupo.salvarconfiguracao();
					 cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Silent", "OFF");
					 cfConfig.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("light")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Light");
					
					cfGrupo.setarGrupo(targetoff, "Light");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("mvp")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Mvp");
					
					cfGrupo.setarGrupo(targetoff, "Mvp");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("semipro")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6SemiPro");
					
					cfGrupo.setarGrupo(targetoff, "S-Pro");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("pro")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Pro");
					
					cfGrupo.setarGrupo(targetoff, "Pro");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("youtuber")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6YouTuber");
					
					cfGrupo.setarGrupo(targetoff, "Youtuber");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("youtuberplus")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6YouTuberPlus");
					
					cfGrupo.setarGrupo(targetoff, "Youtuber+");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("helper")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Helper");
					
					cfGrupo.setarGrupo(targetoff, "Helper");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("builder")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Builder");
					
					cfGrupo.setarGrupo(targetoff, "Builder");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("trial")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Trial");
					
					cfGrupo.setarGrupo(targetoff, "Trial");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("mod")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Mod");
					
					cfGrupo.setarGrupo(targetoff, "Mod");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("modplus")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6ModPlus");
					
					cfGrupo.setarGrupo(targetoff, "Mod+");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("admin")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Admin");
					
					cfGrupo.setarGrupo(targetoff, "Admin");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("gerente")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Gerente");
					
					cfGrupo.setarGrupo(targetoff, "Gerente");
					cfGrupo.salvarconfiguracao();
					return true;
				}
				if(Args[1].equalsIgnoreCase("dono")){
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Dono");
					
					cfGrupo.setarGrupo(targetoff, "Dono");
					cfGrupo.salvarconfiguracao();
					return true;
				}
					p.sendMessage("§6§lNew§f§lPvP §6» §7Grupo inexistente");
			}
			if(Args.length == 1){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /groupset <Jogador> <Grupo>");
				return true;
			}
			if(Args[1].equalsIgnoreCase("membro")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Membro");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Membro");
				
				
				 cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
				 cfConfig.salvarconfiguracao();
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Membro");
				
				 cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
				 cfConfig.salvarconfiguracao();
				
				cfGrupo.setarGrupo(target, "Membro");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
	target.chat("/tag normal");
	VisAPI.updateVis(p);
	for(Player todos : Bukkit.getOnlinePlayers()) {
		VisAPI.updateVis(todos);
	}
				return true;
			}
			if(Args[1].equalsIgnoreCase("light")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Light");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Light");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Light");
				
				cfGrupo.setarGrupo(target, "Light");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag light");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("mvp")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Mvp");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Mvp");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Mvp");
				
				cfGrupo.setarGrupo(target, "Mvp");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag mvp");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("semipro")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6SemiPro");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6SemiPro");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6SemiPro");
				
				cfGrupo.setarGrupo(target, "S-Pro");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag semipro");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("pro")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Pro");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Pro");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Pro");
				
				cfGrupo.setarGrupo(target, "Pro");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag pro");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("youtuber")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6YouTuber");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6YouTuber");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6YouTuber");
				
				cfGrupo.setarGrupo(target, "Youtuber");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag yt");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("youtuberplus")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6YouTuberPlus");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6YouTuberPlus");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6YouTuberPlus");
				
				cfGrupo.setarGrupo(target, "Youtuber+");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag ytplus");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("builder")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Builder");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Builder");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Builder");
				
				cfGrupo.setarGrupo(target, "Builder");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag builder");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("helper")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Helper");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Helper");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Helper");
				
				cfGrupo.setarGrupo(target, "Helper");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag helper");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("trial")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Trial");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Trial");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Trial");
				
				cfGrupo.setarGrupo(target, "Trial");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag trial");
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				VisAPI.updateVis(p);
				return true;
			}
			if(Args[1].equalsIgnoreCase("mod")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Mod");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Mod");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Mod");
				
				cfGrupo.setarGrupo(target, "Mod");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag mod");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("modplus")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6ModPlus");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6ModPlus");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6ModPlus");
				
				cfGrupo.setarGrupo(target, "Mod+");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag modplus");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("admin")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Admin");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Admin");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Admin");
				
				cfGrupo.setarGrupo(target, "Admin");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag admin");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("gerente")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Gerente");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Gerente");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Gerente");
				
				cfGrupo.setarGrupo(target, "Gerente");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag gerente");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
			if(Args[1].equalsIgnoreCase("dono")){
				
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Dono");
				target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Dono");
				
				TituloAPI.MandarTitulo(target, "§6GroupSet");
				TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Dono");
				
				cfGrupo.setarGrupo(target, "Dono");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(target, "Dono")){
					CorGrupo.setarTag(target, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Gerente")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Admin")){
					CorGrupo.setarTag(target, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod+")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mod")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Trial")){
					CorGrupo.setarTag(target, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
					CorGrupo.setarTag(target, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Builder")){
					CorGrupo.setarTag(target, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Helper")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
					CorGrupo.setarTag(target, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
					CorGrupo.setarTag(target, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Pro")){
					CorGrupo.setarTag(target, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Mvp")){
					CorGrupo.setarTag(target, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Light")){
					CorGrupo.setarTag(target, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(target, "Membro")){
					CorGrupo.setarTag(target, "§7§l");
				}
				sScoreAPI.scoreboard(target);
				target.chat("/tag dono");
				VisAPI.updateVis(p);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					VisAPI.updateVis(todos);
				}
				return true;
			}
				p.sendMessage("§6§lNew§f§lPvP §6» §7Grupo inexistente");
		}
}
		if(!(Sender instanceof Player)){
		if(Args.length == 0){
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /groupset <Jogador> <Grupo>");
			return true;
		}
		Player target = Bukkit.getPlayerExact(Args[0]);
		if(target == null){
			OfflinePlayer targetoff = Bukkit.getOfflinePlayer(Args[0]);
			if(Args.length == 1){
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /groupset <Jogador> <Grupo>");
				return true;
			}
			if(Args[1].equalsIgnoreCase("membro")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Membro");
				
				 cfConfig.pegarconfig().set("configuração." + targetoff.getUniqueId() + ".Silent", "OFF");
				 cfConfig.salvarconfiguracao();
				
				cfGrupo.setarGrupo(targetoff, "Membro");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("light")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Light");
				
				cfGrupo.setarGrupo(targetoff, "Light");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("mvp")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Mvp");
				
				cfGrupo.setarGrupo(targetoff, "Mvp");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("semipro")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6SemiPro");
				
				cfGrupo.setarGrupo(targetoff, "S-Pro");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("pro")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Pro");
				
				cfGrupo.setarGrupo(targetoff, "Pro");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("youtuber")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6YouTuber");
				
				cfGrupo.setarGrupo(targetoff, "Youtuber");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("youtuberplus")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6YouTuberPlus");
				
				cfGrupo.setarGrupo(targetoff, "Youtuber+");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("builder")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Builder");
				
				cfGrupo.setarGrupo(targetoff, "Builder");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("helper")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Helper");
				
				cfGrupo.setarGrupo(targetoff, "Helper");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("trial")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Trial");
				
				cfGrupo.setarGrupo(targetoff, "Trial");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("mod")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Mod");
				
				cfGrupo.setarGrupo(targetoff, "Mod");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("modplus")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6ModPlus");
				
				cfGrupo.setarGrupo(targetoff, "Mod+");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("admin")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Admin");
				
				cfGrupo.setarGrupo(targetoff, "Admin");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("gerente")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Gerente");
				
				cfGrupo.setarGrupo(targetoff, "Gerente");
				cfGrupo.salvarconfiguracao();
				return true;
			}
			if(Args[1].equalsIgnoreCase("dono")){
				
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + targetoff.getName() + " §7para §6Dono");
				
				cfGrupo.setarGrupo(targetoff, "Dono");
				cfGrupo.salvarconfiguracao();
				return true;
			}
				Sender.sendMessage("§6§lNew§f§lPvP §6» §7Grupo inexistente");
		}
		
		if(target != null){
		if(Args.length == 1){
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /groupset <Jogador> <Grupo>");
			return true;
		}
		if(Args[1].equalsIgnoreCase("membro")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Membro");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Membro");
			
			 cfConfig.pegarconfig().set("configuração." + target.getUniqueId() + ".Silent", "OFF");
			 cfConfig.salvarconfiguracao();
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Membro");
			
			cfGrupo.setarGrupo(target, "Membro");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag normal");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("light")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Light");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Light");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Light");
			
			cfGrupo.setarGrupo(target, "Light");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag light");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("mvp")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Mvp");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Mvp");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Mvp");
			
			cfGrupo.setarGrupo(target, "Mvp");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag mvp");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("semipro")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6SemiPro");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6SemiPro");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6SemiPro");
			
			cfGrupo.setarGrupo(target, "S-Pro");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag semipro");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("pro")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Pro");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Pro");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Pro");
			
			cfGrupo.setarGrupo(target, "Pro");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag pro");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("youtuber")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6YouTuber");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6YouTuber");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6YouTuber");
			
			cfGrupo.setarGrupo(target, "Youtuber");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag yt");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("youtuberplus")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6YouTuberPlus");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6YouTuberPlus");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6YouTuberPlus");
			
			cfGrupo.setarGrupo(target, "Youtuber+");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag ytplus");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("builder")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Builder");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Builder");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Builder");
			
			cfGrupo.setarGrupo(target, "Builder");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag builder");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("helper")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Helper");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Helper");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Helper");
			
			cfGrupo.setarGrupo(target, "Helper");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag helper");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("trial")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Trial");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Trial");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Trial");
			
			cfGrupo.setarGrupo(target, "Trial");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag trial");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("mod")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Mod");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Mod");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Mod");
			
			cfGrupo.setarGrupo(target, "Mod");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag mod");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("modplus")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6ModPlus");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6ModPlus");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6ModPlus");
			
			cfGrupo.setarGrupo(target, "Mod+");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag modplus");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("admin")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Admin");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Admin");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Admin");
			
			cfGrupo.setarGrupo(target, "Admin");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag admin");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("gerente")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Gerente");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Gerente");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Gerente");
			
			cfGrupo.setarGrupo(target, "Gerente");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag gerente");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
		if(Args[1].equalsIgnoreCase("dono")){
			
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Voce alterou o grupo do player §6" + target.getName() + " §7para §6Dono");
			target.sendMessage("§6§lNew§f§lPvP §6» §7Seu grupo foi alterado para §6Dono");
			
			TituloAPI.MandarTitulo(target, "§6GroupSet");
			TituloAPI.MandarSubTitulo(target, "§7Seu grupo foi alterado para §6Dono");
			
			cfGrupo.setarGrupo(target, "Dono");
			cfGrupo.salvarconfiguracao();
			
			if(cfGrupo.ChecarGrupo(target, "Dono")){
				CorGrupo.setarTag(target, "§4§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Gerente")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Admin")){
				CorGrupo.setarTag(target, "§c§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod+")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mod")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber+")){
				CorGrupo.setarTag(target, "§3§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Builder")){
				CorGrupo.setarTag(target, "§2§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Helper")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Youtuber")){
				CorGrupo.setarTag(target, "§b§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "S-Pro")){
				CorGrupo.setarTag(target, "§e§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Pro")){
				CorGrupo.setarTag(target, "§6§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Mvp")){
				CorGrupo.setarTag(target, "§9§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Light")){
				CorGrupo.setarTag(target, "§a§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Trial")){
				CorGrupo.setarTag(target, "§5§l");
			}
			else if(cfGrupo.ChecarGrupo(target, "Membro")){
				CorGrupo.setarTag(target, "§7§l");
			}
			sScoreAPI.scoreboard(target);
			target.chat("/tag dono");
			VisAPI.updateVis(target);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				VisAPI.updateVis(todos);
			}
			return true;
		}
			Sender.sendMessage("§6§lNew§f§lPvP §6» §7Grupo inexistente");
		}
	}
		return false;
	}
}
