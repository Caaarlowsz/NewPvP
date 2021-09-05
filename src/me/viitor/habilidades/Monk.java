package me.viitor.habilidades;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import me.viitor.API.CooldownAPI;
import me.viitor.API.KitAPI;

public class Monk implements Listener{
	
	 @EventHandler
	  public void monkHabilidade(PlayerInteractEntityEvent e) {
	    final Player p = e.getPlayer();

	    if ((e.getRightClicked() instanceof Player)){
	      Player jogadorClicado = (Player)e.getRightClicked();

        	 if ((p.getItemInHand().getType() == Material.BLAZE_ROD) && (KitAPI.getKit(p) == "Monk") && (CooldownAPI.Cooldown.containsKey(p.getName()))){
         		e.setCancelled(true);
         		p.sendMessage("§6§lNew§f§lPvP §6» §7Espere seu cooldown acaba em §c§l" + CooldownAPI.Cooldown(p) + "s");
         		return;
        	 }
	      if ((p.getItemInHand().getType() == Material.BLAZE_ROD) && (KitAPI.getKit(p) == "Monk") && (!CooldownAPI.Cooldown.containsKey(p.getName()))){
 
	              

	              int random = new Random().nextInt(jogadorClicado.getInventory().getSize() - 10 + 1 + 10);

	              ItemStack ItemSelecionado = jogadorClicado.getInventory().getItem(random);
	              ItemStack ItemMudado = jogadorClicado.getItemInHand();

	              jogadorClicado.setItemInHand(ItemSelecionado);
	              jogadorClicado.getInventory().setItem(random, ItemMudado);
	              jogadorClicado.sendMessage("§6§lNew§f§lPvP §6» §7Você foi monkado.");
	              
	              CooldownAPI.addCooldown(p, 35);
	      }
	      return;
	            }
	          }
	  }
