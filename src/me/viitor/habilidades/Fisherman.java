package me.viitor.habilidades;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import me.viitor.API.KitAPI;

public class Fisherman implements Listener{
	
	  @EventHandler
	  public void onPlayerFish(PlayerFishEvent e) {
	    Player p = e.getPlayer();
	    Entity caught = e.getCaught();
	    Block block = e.getHook().getLocation().getBlock();
	    if ((caught != null) && (caught != block) &&  (KitAPI.getKit(p) == "Fisherman"))
	      caught.teleport(p.getPlayer().getLocation());
	  }
}
