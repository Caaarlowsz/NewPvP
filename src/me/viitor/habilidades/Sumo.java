package me.viitor.habilidades;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import me.viitor.API.CooldownAPI;
import me.viitor.API.KitAPI;
import me.viitor.main.Main;


public class Sumo implements Listener{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public ArrayList<String> Cima = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
private ArrayList<Block> remover = new ArrayList();

 
@EventHandler
  public void Clicar(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if ((p instanceof Player))  {
      if (p.getItemInHand().getTypeId() == 260) {
      }
      if (!e.getAction().name().contains("RIGHT")) {
        return;
      }
      if ((p.getItemInHand().getTypeId() == 260) && (KitAPI.getKit(p) == "Sumo") ) {
    	  if(Gladiator.noExecut.contains(p)){
    		  return;
    	  }
      e.setCancelled(true);
      if (!CooldownAPI.Cooldown.containsKey(p.getName())){
        Location Local = e.getPlayer().getLocation();
        Local = Local.getWorld().getHighestBlockAt(Local).getLocation().add(0.0D, 22.0D, 0.0D);
        for (int x = 0; x <= 0; x++) {
          for (int z = 0; z <= 0; z++)
          {
            final Block a = Local.add(x, 0.0D, z).getBlock();
            a.setType(Material.DIRT);
            e.getPlayer().teleport(Local.add(0.0D, 1.0D, 0.0D));
            CooldownAPI.addCooldown(p, 35);
            this.Cima.add(p.getName());
            Bukkit.getServer().getScheduler().runTaskLater(Main.getPlugin(), new Runnable()
            {
              public void run()
              {
                a.setType(Material.AIR);
                Sumo.this.remover.remove(a);
              }
            }
            , 50L);
          }
        }
      } else {
			p.sendMessage("§6§lNew§f§lPvP §6» §7Espere seu cooldown acaba em §c§l" + CooldownAPI.Cooldown(p) + "s");
      }
    }
   }
  }
  

  @EventHandler
  public void Cair(EntityDamageEvent e)
  {
    if (!(e.getEntity() instanceof Player)) {
      return;
    }
    final Player p = (Player)e.getEntity();
    if (e.getCause() == EntityDamageEvent.DamageCause.FALL){
      if (Cima.contains(p.getName())) {
        e.setCancelled(true);
        for (Entity Altura : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
          if ((Altura instanceof Player)){
            Player Pular = (Player)Altura;
            Vector v = p.getLocation().getDirection().multiply(0).setY(2.0D);
            Pular.setVelocity(v);
          }
        }
        this.Cima.remove(p.getName());
        e.setDamage(9.0D);
        return;
      }
    }
  }
}