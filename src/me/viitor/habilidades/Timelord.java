package me.viitor.habilidades;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.viitor.API.CooldownAPI;
import me.viitor.API.KitAPI;
import me.viitor.main.Main;

public class Timelord implements Listener{
	
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<String> frozenPlayers = new ArrayList();

	  
	  @EventHandler
	  public void onTimeLord(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((p.getItemInHand().getType() == Material.WATCH) && ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
	    	  if (KitAPI.getKit(p) == "Timelord"){
	    	if (CooldownAPI.Cooldown.containsKey(p.getName()))   {
	    		p.sendMessage("§6§lNew§f§lPvP §6» §7Espere seu cooldown acaba em §c§l" + CooldownAPI.Cooldown(p) + "s");
	        return;
	    	}
	      }
	      if (KitAPI.getKit(p) == "Timelord"){
	    	  
	        List<Entity> ne = e.getPlayer().getNearbyEntities(5.0D, 5.0D, 5.0D);
	        for (Entity t : ne) {
	          if ((t instanceof Player)){
	            final Player ta = (Player)t;
	            frozenPlayers.add(((Player)t).getName());
	            ((Player)t).sendMessage("§6§lNew§f§lPvP §6» §7Você foi congelado por um §c§lTIMELORD");
	            
	           CooldownAPI.addCooldown(p, 35);
	            p.sendMessage("§6§lNew§f§lPvP §6» §7Você congelou os players envolta de você");
	            
	            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable()
	            {
	              public void run()
	              {
	                frozenPlayers.remove(ta.getName());
	              }
	            }, 5 * 20);
	          }
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onTimeLordado(PlayerMoveEvent e)
	  {
	    if (frozenPlayers.contains(e.getPlayer().getName())) {
	      e.getPlayer().teleport(e.getPlayer());
	    }
	  }
	}

