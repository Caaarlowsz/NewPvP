package me.viitor.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import me.viitor.configuração.cfGrupo;
import me.viitor.scoreboard.sScoreAPI;
import me.viitor.tab_1_8.TituloAPI;

public class PlacaVIP implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("viplight")) {
			e.setLine(0, " ");
			e.setLine(1, "§a§lVIP LIGHT");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}
		
		if(e.getLine(0).equalsIgnoreCase("vipmvp")) {
			e.setLine(0, " ");
			e.setLine(1, "§9§lVIP MVP");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}
		
		if(e.getLine(0).equalsIgnoreCase("vippro")) {
			e.setLine(0, " ");
			e.setLine(1, "§6§lVIP PRO");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}
		
	}
	
	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if(e.getClickedBlock() != null)
			   if (e.getClickedBlock().getType() == Material.WALL_SIGN || (e.getClickedBlock().getType() == Material.SIGN_POST)) {
			Sign s = (Sign)e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals(" ")) && 
					(lines.length > 1) && (lines[1].equals("§a§lVIP LIGHT"))&&
					(lines.length > 2) && (lines[2].equals(" §7(Clique)")) &&
					(lines.length > 3) && (lines[3].equals(" "))) {
				
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + p.getName() + " §7achou a placa escondida e ganhou §a§lVIP LIGHT");
				Bukkit.broadcastMessage(" ");
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Parabens, voce ganhou o §a§lVIP LIGHT");
					
				s.getBlock().breakNaturally();
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Seu grupo foi alterado para §6Light");
				
				TituloAPI.MandarTitulo(p, "§6GroupSet");
				TituloAPI.MandarSubTitulo(p, "§7Seu grupo foi alterado para §6Light");
				
				cfGrupo.setarGrupo(p, "Light");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(p, "Dono")){
					CorGrupo.setarTag(p, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Gerente")){
					CorGrupo.setarTag(p, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Admin")){
					CorGrupo.setarTag(p, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mod+")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mod")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Trial")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
					CorGrupo.setarTag(p, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Builder")){
					CorGrupo.setarTag(p, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Helper")){
					CorGrupo.setarTag(p, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Youtuber")){
					CorGrupo.setarTag(p, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "S-Pro")){
					CorGrupo.setarTag(p, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Pro")){
					CorGrupo.setarTag(p, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mvp")){
					CorGrupo.setarTag(p, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Light")){
					CorGrupo.setarTag(p, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Membro")){
					CorGrupo.setarTag(p, "§7§l");
				}
				sScoreAPI.scoreboard(p);
				p.chat("/tag light");
			}
			
			if ((lines.length > 0) && (lines[0].equals(" ")) && 
					(lines.length > 1) && (lines[1].equals("§9§lVIP MVP"))&&
					(lines.length > 2) && (lines[2].equals(" §7(Clique)")) &&
					(lines.length > 3) && (lines[3].equals(" "))) {
				
				
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + p.getName() + " §7achou a placa escondida e ganhou §9§lVIP MVP");
				Bukkit.broadcastMessage(" ");
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Parabens, voce ganhou o §9§lVIP MVP");
					
				s.getBlock().breakNaturally();
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Seu grupo foi alterado para §6Mvp");
				
				TituloAPI.MandarTitulo(p, "§6GroupSet");
				TituloAPI.MandarSubTitulo(p, "§7Seu grupo foi alterado para §6Mvp");
				
				cfGrupo.setarGrupo(p, "Mvp");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(p, "Dono")){
					CorGrupo.setarTag(p, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Gerente")){
					CorGrupo.setarTag(p, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Admin")){
					CorGrupo.setarTag(p, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mod+")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mod")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Trial")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
					CorGrupo.setarTag(p, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Builder")){
					CorGrupo.setarTag(p, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Helper")){
					CorGrupo.setarTag(p, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Youtuber")){
					CorGrupo.setarTag(p, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "S-Pro")){
					CorGrupo.setarTag(p, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Pro")){
					CorGrupo.setarTag(p, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mvp")){
					CorGrupo.setarTag(p, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Light")){
					CorGrupo.setarTag(p, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Membro")){
					CorGrupo.setarTag(p, "§7§l");
				}
				sScoreAPI.scoreboard(p);
				p.chat("/tag mvp");
			}
			
			if ((lines.length > 0) && (lines[0].equals(" ")) && 
					(lines.length > 1) && (lines[1].equals("§6§lVIP PRO"))&&
					(lines.length > 2) && (lines[2].equals(" §7(Clique)")) &&
					(lines.length > 3) && (lines[3].equals(" "))) {
				
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + p.getName() + " §7achou a placa escondida e ganhou §6§lVIP PRO");
				Bukkit.broadcastMessage(" ");
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Parabens, voce ganhou o §6§lVIP PRO");
					
				s.getBlock().breakNaturally();
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Seu grupo foi alterado para §6Pro");
				
				TituloAPI.MandarTitulo(p, "§6GroupSet");
				TituloAPI.MandarSubTitulo(p, "§7Seu grupo foi alterado para §6Pro");
				
				cfGrupo.setarGrupo(p, "Pro");
				cfGrupo.salvarconfiguracao();
				
				if(cfGrupo.ChecarGrupo(p, "Dono")){
					CorGrupo.setarTag(p, "§4§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Gerente")){
					CorGrupo.setarTag(p, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Admin")){
					CorGrupo.setarTag(p, "§c§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mod+")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mod")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Trial")){
					CorGrupo.setarTag(p, "§5§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
					CorGrupo.setarTag(p, "§3§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Builder")){
					CorGrupo.setarTag(p, "§2§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Helper")){
					CorGrupo.setarTag(p, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Youtuber")){
					CorGrupo.setarTag(p, "§b§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "S-Pro")){
					CorGrupo.setarTag(p, "§e§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Pro")){
					CorGrupo.setarTag(p, "§6§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Mvp")){
					CorGrupo.setarTag(p, "§9§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Light")){
					CorGrupo.setarTag(p, "§a§l");
				}
				else if(cfGrupo.ChecarGrupo(p, "Membro")){
					CorGrupo.setarTag(p, "§7§l");
				}
				sScoreAPI.scoreboard(p);
				p.chat("/tag pro");
			}
			
		}
			}

} 