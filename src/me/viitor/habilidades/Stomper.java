package me.viitor.habilidades;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.viitor.API.CooldownAPI;
import me.viitor.API.KitAPI;

public class Stomper implements Listener {
	
	
	 @EventHandler(priority=EventPriority.HIGH)
	  public void onPlayerStomp(EntityDamageEvent e)  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getEntity();
	    if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
	      if (KitAPI.getKit(p) == "Stomper"){
	        for (Entity ent : p.getNearbyEntities(3.0D, 3.0D, 3.0D)) {
	          if (!(ent instanceof Player))
	            continue;
	          Player plr = (Player)ent;
	          if (e.getDamage() <= 4.0D) {
	            e.setCancelled(true);
	            return;
	          }
	          if (plr.isSneaking())
	          {
	            plr.damage(6.0D, p);
	          } else {
	            plr.damage(e.getDamage(), p);
	            plr.getKiller();
	          }
	        }

	        e.setDamage(4.0D);
	        return;
	      }
	      return;
	    }
	  }
	
	 @EventHandler
	  public void stomperApple(PlayerInteractEvent event){
		 
	    final Player p = event.getPlayer();
	    
	    
	    if ((event.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE) && 
	  	      (KitAPI.getKit(p) == "Stomper")) {
	  	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	  	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
	  	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	  	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
	  	            event.setCancelled(true);
	    
	      if (CooldownAPI.Cooldown.containsKey(p.getName())) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Espere seu cooldown acaba em §c§l" + CooldownAPI.Cooldown(p) + "s");
	      }else{
	      Vector vector = p.getEyeLocation().getDirection();
	      vector.multiply(0.0F);
	      vector.setY(6.0F);
	      p.setVelocity(vector);
	      Location loc = p.getLocation();
	      p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0F, -5.0F);
	      CooldownAPI.addCooldown(p, 45);
      	    }
	      }
		}
	 }
}