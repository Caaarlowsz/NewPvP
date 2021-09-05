package me.viitor.habilidades;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.viitor.API.KitAPI;


public class Magma implements Listener{
	
	 @EventHandler
	  public void damage(EntityDamageEvent e) {
	    if ((e.getEntity() instanceof Player))
	    {
	      Player p = (Player)e.getEntity();
	      if ((KitAPI.getKit(p) == "Magma") && (
	        (e.getCause() == EntityDamageEvent.DamageCause.LAVA) || 
	        (e.getCause() == EntityDamageEvent.DamageCause.FIRE) || 
	        (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)))
	        e.setCancelled(true); 
	    }
	  }

	  @EventHandler
	  public void snailEventd(EntityDamageByEntityEvent event) {
	    if ((!(event.getEntity() instanceof Player)) || 
	      (!(event.getDamager() instanceof Player))) {
	      return;
	    }

	    Player player = (Player)event.getDamager();
	    Player player1 = (Player)event.getEntity();

	    if (KitAPI.getKit(player) != "Magma") {
	      return;
	    }
	    if ((Math.random() > 0.5D) && (Math.random() < 0.4D))
	      player1.setFireTicks(150);
	  }
	}
