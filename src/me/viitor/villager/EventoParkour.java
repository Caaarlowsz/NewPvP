package me.viitor.villager;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import me.viitor.API.API;
import me.viitor.API.WarpsAPI;
import me.viitor.invencivel.Proteção;

public class EventoParkour implements Listener{
	
		@EventHandler
		public void noExecut(PlayerCommandPreprocessEvent e){
			Player p = e.getPlayer();
			if(VillagerParkour.noParkour.contains(p)){
				e.setCancelled(true);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode executar comandos no Parkour");
			}
		}
		@EventHandler
		public void protect(PlayerMoveEvent e) {
			Player p = e.getPlayer();
			if(e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER && Proteção.isImortal(p) && API.getWarp(p) == "FPS") {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce perdeu sua protecao");
				Proteção.setImortal(p, false);
				return;
			}
		}
		@SuppressWarnings("deprecation")
		@EventHandler
		public void clickar(PlayerInteractEvent e){
			
			Player p = e.getPlayer();
			if((API.getWarp(p) == "Spawn") && (VillagerParkour.noParkour.contains(p) && (p.getItemInHand().getType() == Material.BED))){
				
				WarpsAPI.Ir(p, "Spawn");
		        API.sendItems(p);
		        VillagerParkour.noParkour.remove(p);
		        
		        p.getInventory().clear();
	            p.getInventory().setArmorContents(null);
	            
	            p.sendMessage("§6§lNew§f§lPvP §6» §7Voce saiu do parkour");
	            
              p.removePotionEffect(PotionEffectType.INVISIBILITY);	
              
              for(Player todos : Bukkit.getOnlinePlayers()){
            	  
            	  p.showPlayer(todos);
            	  todos.showPlayer(p);
              }
			}
		}
		@EventHandler
		public void limite(PlayerMoveEvent e){
			Player p = e.getPlayer();
		    if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.WATER)) {
		    	
		    	if(API.getWarp(p) == "Spawn" && VillagerParkour.noParkour.contains(p)){
		    		WarpsAPI.Ir(p, "Parkour");
		    		p.sendMessage("§6§lNew§f§lPvP §6» §7Voce caiu");
		    	}
		    }
		}
}