package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.viitor.API.API;
import me.viitor.API.KitAPI;
import me.viitor.API.WarpsAPI;
import me.viitor.invencivel.Proteção;
import me.viitor.main.Main;
import me.viitor.menus.WarpsMenu;
import me.viitor.scoreboard.sScoreAPI;

public class WarpCommand implements CommandExecutor, Listener{
	
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("warp")){
			
			if(Args.length == 0){
				WarpsMenu.inventory(p);
				return true;
			}
			if(Args[0].equalsIgnoreCase("fps")){
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999,99999));
				
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta sendo teleportado");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);
						
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						
						WarpsAPI.Ir(p, "Fps");
						API.setWarp(p, "Fps");
						sScoreAPI.scoreboard(p);
						
						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						ItemMeta sopam = sopa.getItemMeta();
						sopam.setDisplayName("§7Sopa");
						sopa.setItemMeta(sopam);
				        for(int i = 0; i < 36; i++){
				     	   p.getInventory().setItem(i, sopa);
				     	   p.updateInventory();
						}
						p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho", new String[] {""}, 64, (short)0));
						p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom", new String[] {""}, 64, (short)0));
						p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "§7Pote", new String[] {""}, 64, (short)0));
						
							ItemStack Espada = new ItemStack(Material.STONE_SWORD);
							Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
							ItemMeta kEspada = Espada.getItemMeta();
							kEspada.setDisplayName("§eEspada");
							Espada.setItemMeta(kEspada);
							
				            p.getInventory().setItem(0, Espada);
					}
				}, 3 * 20);
			}
			else if(Args[0].equalsIgnoreCase("1v1")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta sendo teleportado");
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999,99999));
				
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);
						
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						
						KitAPI.removeKits(p);
						
						WarpsAPI.Ir(p, "1v1");
						API.setWarp(p, "1v1");
						Proteção.setImortal(p, true);
						sScoreAPI.scoreboard(p);
						
						WarpsAPI.segundos.remove(p.getName());
						
							ItemStack Espada = new ItemStack(Material.BLAZE_ROD);
							ItemMeta kEspada = Espada.getItemMeta();
							kEspada.setDisplayName("§e1v1");
							Espada.setItemMeta(kEspada);
							
							ItemStack Espada1 = new ItemStack(Material.INK_SACK, 1, (short)8);
							ItemMeta kEspada1 = Espada1.getItemMeta();
							kEspada1.setDisplayName("§ePartida Rapida");
							Espada1.setItemMeta(kEspada1);
							
				            p.getInventory().setItem(3, Espada);  
				            p.getInventory().setItem(5, Espada1);
				            
					}
				}, 3 * 20);
			}
			else if(Args[0].equalsIgnoreCase("challenge")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta sendo teleportado");
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999,99999));
				
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);
						
						p.setGameMode(GameMode.SURVIVAL);
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						
						WarpsAPI.Ir(p, "Challenge");
						API.setWarp(p, "Challenge");
						sScoreAPI.scoreboard(p);
						
						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						ItemMeta sopam = sopa.getItemMeta();
						sopam.setDisplayName("§7Sopa");
						sopa.setItemMeta(sopam);
				        for(int i = 0; i < 36; i++){
				     	   p.getInventory().setItem(i, sopa);
				     	   p.updateInventory();
						}
						p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho", new String[] {""}, 64, (short)0));
						p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom", new String[] {""}, 64, (short)0));
						p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "§7Pote", new String[] {""}, 64, (short)0));
				            
					}
				}, 3 * 20);
			}
			else if(Args[0].equalsIgnoreCase("knockback")){
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999,99999));
				
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta sendo teleportado");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);
						
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						
						WarpsAPI.Ir(p, "Knockback");
						API.setWarp(p, "Knockback");
						sScoreAPI.scoreboard(p);
						
						Proteção.setImortal(p, false);
						
						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
				        for(int i = 0; i < 36; i++){
				     	   p.getInventory().setItem(i, sopa);
				     	   p.updateInventory();
						}
						p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho", new String[] {""}, 64, (short)0));
						p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom", new String[] {""}, 64, (short)0));
						p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "§7Pote", new String[] {""}, 64, (short)0));
						
						ItemStack Espada = new ItemStack(Material.STICK);
						ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("§eKnockBack");
						kEspada.addEnchant(Enchantment.KNOCKBACK, 5, true);
						Espada.setItemMeta(kEspada);
							
				            p.getInventory().setItem(0, Espada);
					}
				}, 3 * 20);
			}
			else if(Args[0].equalsIgnoreCase("main")){
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999,99999));
				
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta sendo teleportado");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);
						
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						
						WarpsAPI.Ir(p, "Main");
						API.setWarp(p, "Main");
						sScoreAPI.scoreboard(p);
						
						Proteção.setImortal(p, false);
						
						ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
						ItemMeta sopam = sopa.getItemMeta();
						sopam.setDisplayName("§7Sopa");
						sopa.setItemMeta(sopam);
				        for(int i = 0; i < 36; i++){
				     	   p.getInventory().setItem(i, sopa);
				     	   p.updateInventory();
						}
				        
				        ItemStack peitoral = new ItemStack(Material.IRON_CHESTPLATE);
				        ItemMeta peitoralm = peitoral.getItemMeta();
				        peitoralm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				        peitoralm.setDisplayName("§6Peitoral");
				        peitoral.setItemMeta(peitoralm);
				        
				        ItemStack capacete = new ItemStack(Material.IRON_HELMET);
				        ItemMeta capacetem = capacete.getItemMeta();
				        capacetem.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				        capacetem.setDisplayName("§6Capacete");
				        capacete.setItemMeta(capacetem);
				        
				        ItemStack calca = new ItemStack(Material.IRON_LEGGINGS);
				        ItemMeta calcam = peitoral.getItemMeta();
				        calcam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				        calcam.setDisplayName("§6Calca");
				        calca.setItemMeta(calcam);
				        
				        ItemStack bota = new ItemStack(Material.IRON_BOOTS);
				        ItemMeta botam = bota.getItemMeta();
				        botam.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				        botam.setDisplayName("§6Bota");
				        bota.setItemMeta(botam);
				        
				        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000000000, 0));
				        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000000, 0));
				        
				        p.getInventory().setHelmet(capacete);
				        p.getInventory().setChestplate(peitoral);
				        p.getInventory().setLeggings(calca);
				        p.getInventory().setBoots(bota);
				        
						p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho", new String[] {""}, 64, (short)0));
						p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom", new String[] {""}, 64, (short)0));
						p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "§7Pote", new String[] {""}, 64, (short)0));
						
							ItemStack Espada = new ItemStack(Material.DIAMOND_SWORD);
							Espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
							ItemMeta kEspada = Espada.getItemMeta();
							kEspada.setDisplayName("§eEspada Do " + KitAPI.getKit(p));
							Espada.setItemMeta(kEspada);
							
				            p.getInventory().setItem(0, Espada);
					}
				}, 3 * 20);
			}
			else if(Args[0].equalsIgnoreCase("fisherman")){
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999,99999));
				p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 99999,99999));
				
				p.closeInventory();
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta sendo teleportado");
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
						
						p.setGameMode(GameMode.SURVIVAL);
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
						p.removePotionEffect(PotionEffectType.CONFUSION);
						p.setHealth(20.0D);
						p.setMaxHealth(20.0D);
						
						p.closeInventory();
						p.getInventory().clear();
						p.getInventory().setArmorContents(null);
						
						WarpsAPI.Ir(p, "Fisherman");
						API.setWarp(p, "Fisherman");
						KitAPI.setKit(p, "Fisherman");
						sScoreAPI.scoreboard(p);
						
						Proteção.setImortal(p, false);
						
						ItemStack Espada = new ItemStack(Material.FISHING_ROD);
						ItemMeta kEspada = Espada.getItemMeta();
						kEspada.setDisplayName("§eVara de pesca");
						Espada.setItemMeta(kEspada);
						
						ItemStack knock = new ItemStack(Material.STICK);
						ItemMeta knockm = knock.getItemMeta();
						knockm.setDisplayName("§eKnockback");
						knockm.addEnchant(Enchantment.KNOCKBACK, 2, true);
						knock.setItemMeta(knockm);
							
				            p.getInventory().setItem(0, Espada);
				            p.getInventory().setItem(1, knock);
					}
				}, 3 * 20);
			}
		}
		return false;
	}
	@EventHandler
	public void aoConsume(PlayerItemConsumeEvent e) {
		Player p = e.getPlayer();
		if(API.getWarp(p) == "Arena" || API.getWarp(p) == "Main" || API.getWarp(p) == "Fisherman") {
			e.setCancelled(true);
		}
	}
}
