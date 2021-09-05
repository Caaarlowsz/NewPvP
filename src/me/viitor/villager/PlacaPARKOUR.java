package me.viitor.villager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;

import me.viitor.API.API;
import me.viitor.API.WarpsAPI;
import me.viitor.configuração.cfStatus;
import me.viitor.scoreboard.sScoreAPI;

public class PlacaPARKOUR implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("parkourfinal")) {
			e.setLine(0, " ");
			e.setLine(1, "§6§lPARKOUR");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clicar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if(e.getClickedBlock() != null)
				if(e.getClickedBlock().getType() == Material.WALL_SIGN || (e.getClickedBlock().getType() == Material.SIGN_POST)) {
					if(API.getWarp(p) == "Parkour") {
						Sign s = (Sign) e.getClickedBlock().getState();
						String[] lines = s.getLines();
						if ((lines.length > 0) && (lines[0].equals(" ")) && 
								(lines.length > 1) && (lines[1].equals("§6§lPARKOUR")) && 
								(lines.length > 2) && (lines[2].equals(" §7(Clique)")) && 
								(lines.length > 3) && (lines[3].equals(" "))) {
							
							p.sendMessage("§6§lNew§f§lPvP §6» §7Parabens, voce completou o parkour");
							
							cfStatus.setMoney(p, 100);
							
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ganhou §6§l100 §7coins");
							
							API.setWarp(p, "Spawn");
							WarpsAPI.Ir(p, "Spawn");
							
				            p.removePotionEffect(PotionEffectType.INVISIBILITY);
				            
				            p.getInventory().clear();
				            p.getInventory().setArmorContents(null);
							
							API.sendItems(p);
							
							sScoreAPI.scoreboard(p);
							
 							for(Player todos : Bukkit.getOnlinePlayers()) {
 								p.showPlayer(todos);
 								todos.showPlayer(p);
 							}
							return;
						}
					}
				}
				
			
	}

}
