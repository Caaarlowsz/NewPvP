package me.viitor.habilidades;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.viitor.API.CooldownAPI;
import me.viitor.API.KitAPI;

public class Thor implements Listener{
	
	@EventHandler
	  public void ThorKit(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((p.getItemInHand().getType() == Material.GOLD_AXE) && (e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	      (KitAPI.getKit(p) == "Thor")) {
	      if (CooldownAPI.Cooldown.containsKey(p.getName())) {
	    		p.sendMessage("§6§lNew§f§lPvP §6» §7Espere seu cooldown acaba em §c§l" + CooldownAPI.Cooldown(p) + "s");
	        return;
	      }

	     CooldownAPI.addCooldown(p, 5);
	      Location loc = p.getTargetBlock(null, 25).getLocation();
	      p.getWorld().strikeLightning(loc);
	      e.setCancelled(true);
	      p.damage(0.0D);
	    }
	  }

}
