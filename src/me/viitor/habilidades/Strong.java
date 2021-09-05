package me.viitor.habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.viitor.API.CooldownAPI;
import me.viitor.API.KitAPI;
import me.viitor.main.Main;

public class Strong implements Listener{
	
	 public static HashMap<Player, ItemStack[]> salvarArmadura = new HashMap<Player, ItemStack[]>();
	 public static HashMap<Player, ItemStack[]> salvarInventario = new HashMap<Player, ItemStack[]>();
	 
	public static ArrayList<Player> fulliron = new ArrayList<>();
	@EventHandler
	public void interagir(PlayerInteractEvent e){
		
		final Player p = e.getPlayer();
		if((KitAPI.getKit(p)== "Strong") && (CooldownAPI.Cooldown.containsKey(p.getName())) && (p.getItemInHand().getType() == Material.WATCH)){
			e.setCancelled(true);
			p.sendMessage("§6§lNew§f§lPvP §6» §7Espere seu cooldown acaba em §c§l" + CooldownAPI.Cooldown(p) + "s");
		     }else{
					if((KitAPI.getKit(p)== "Strong") && (!CooldownAPI.Cooldown.containsKey(p.getName()) && (p.getItemInHand().getType() == Material.WATCH))){
						   salvarInventario.put(p, p.getInventory().getContents());
						   salvarArmadura.put(p, p.getInventory().getArmorContents());
						
						   p.getInventory().setArmorContents(null);
						ItemStack Peito = new ItemStack(Material.IRON_CHESTPLATE);

						
						ItemStack Calça = new ItemStack(Material.IRON_LEGGINGS);

						
						ItemStack Bota = new ItemStack(Material.IRON_BOOTS);

						
						ItemStack Capacete = new ItemStack(Material.IRON_HELMET);
						
						ItemStack Espada = new ItemStack(Material.STONE_SWORD);
						Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);

						
						p.getInventory().setChestplate(Peito);
						p.getInventory().setLeggings(Calça);
						p.getInventory().setHelmet(Capacete);
						p.getInventory().setBoots(Bota);
						p.getInventory().setItem(0, Espada);
						p.updateInventory();
						CooldownAPI.addCooldown(p, 60);
						
					p.sendMessage("§6§lNew§f§lPvP §6» §7§7Você ficou full iron por §c10 segundos.");
					fulliron.add(p);
					
					if(fulliron.contains(p)){
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
						public void run() {
							
					if(fulliron.contains(p)){
					p.sendMessage("§6§lNew§f§lPvP §6» §7§cArmadura resetada!");
					   p.getInventory().setArmorContents(null);
					   
					   p.closeInventory();
						p.getInventory().remove(Material.IRON_CHESTPLATE);
						p.getInventory().remove(Material.IRON_LEGGINGS);
						p.getInventory().remove(Material.IRON_BOOTS);
						p.getInventory().remove(Material.IRON_HELMET);
						p.getInventory().remove(Material.IRON_SWORD);
					   
					   p.getInventory().setArmorContents(salvarArmadura.get(p));
					   
						 if (KitAPI.getKit(p) == "Strong") {
							 
								ItemStack Espada = new ItemStack(Material.WOOD_SWORD);
								Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
								ItemMeta kEspada = Espada.getItemMeta();
								kEspada.setDisplayName("§eEspada");
								Espada.setItemMeta(kEspada);
							
								p.getInventory().setItem(0, Espada);
							
								
								
					   
						 }
						}
					
						}
					}, 10 * 20);

					}else{
		     }
		     }
		     }
	 	}
	}
