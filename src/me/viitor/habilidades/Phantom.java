package me.viitor.habilidades;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.viitor.API.CooldownAPI;
import me.viitor.API.KitAPI;
import me.viitor.main.Main;

public class Phantom implements Listener{
	
	 public static HashMap<Player, ItemStack[]> salvarArmadura = new HashMap<Player, ItemStack[]>();
	@EventHandler
	public void interagir(PlayerInteractEvent e){
		
		final Player p = e.getPlayer();
		if((KitAPI.getKit(p)== "Phantom") && (CooldownAPI.Cooldown.containsKey(p.getName())) && (p.getItemInHand().getType() == Material.FEATHER)){
			e.setCancelled(true);
			p.sendMessage("§6§lNew§f§lPvP §6» §7Espere seu cooldown acaba em §c§l" + CooldownAPI.Cooldown(p) + "s");
		     }else{
					if((KitAPI.getKit(p)== "Phantom") && (!CooldownAPI.Cooldown.containsKey(p.getName()) && (p.getItemInHand().getType() == Material.FEATHER))){
						
						   salvarArmadura.put(p, p.getInventory().getArmorContents());
						
						   p.getInventory().setArmorContents(null);
						ItemStack Peito = new ItemStack(Material.LEATHER_CHESTPLATE);
						LeatherArmorMeta kPeito = (LeatherArmorMeta)Peito.getItemMeta();
						kPeito.setDisplayName("§cPeitoral");
						kPeito.setColor(Color.WHITE);
						Peito.setItemMeta(kPeito);
						
						ItemStack Calça = new ItemStack(Material.LEATHER_LEGGINGS);
						LeatherArmorMeta kCaça = (LeatherArmorMeta)Calça.getItemMeta();
						kCaça.setDisplayName("§cCalça");
						kCaça.setColor(Color.WHITE);
						Calça.setItemMeta(kCaça);
						
						ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
						LeatherArmorMeta kBota = (LeatherArmorMeta)Bota.getItemMeta();
						kBota.setDisplayName("§cBotas");
						kBota.setColor(Color.WHITE);
						Bota.setItemMeta(kBota);
						
						ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
						LeatherArmorMeta kCasapete = (LeatherArmorMeta)Capacete.getItemMeta();
						kCasapete.setDisplayName("§cCapacete");
						kCasapete.setColor(Color.WHITE);
						Capacete.setItemMeta(kCasapete);
						
						p.getInventory().setChestplate(Peito);
						p.getInventory().setLeggings(Calça);
						p.getInventory().setHelmet(Capacete);
						p.getInventory().setBoots(Bota);
						p.updateInventory();
						
					
					p.sendMessage("§6§lNew§f§lPvP §6» §7§7Agora você pode voar por §c§l5s");
					CooldownAPI.addCooldown(p, 35);
					
					p.setAllowFlight(true);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
					p.sendMessage("§6§lNew§f§lPvP §6» §7§7Seu fly acabou");
					   p.getInventory().setArmorContents(null);
					   
					   p.closeInventory();
						p.getInventory().remove(Material.LEATHER_BOOTS);
						p.getInventory().remove(Material.LEATHER_CHESTPLATE);
						p.getInventory().remove(Material.LEATHER_HELMET);
						p.getInventory().remove(Material.LEATHER_LEGGINGS);
						p.updateInventory();
					   
					   p.getInventory().setArmorContents(salvarArmadura.get(p));
					p.setAllowFlight(false);
						}
					}, 5 * 20);
		     }
		     }
		     }
					
}
