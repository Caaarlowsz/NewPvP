package me.viitor.villager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.viitor.API.API;
import me.viitor.API.ArraysAPI;
import me.viitor.API.WarpsAPI;
import me.viitor.configuração.cfGrupo;


public class VillagerParkour implements CommandExecutor, Listener {
	
	public static ArrayList<Player> noParkour = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("spawnvillagerparkour")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
				
			}
			Villager v = (Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
			v.setCustomName("§6–ª §7Sr §6§lParkour §6–ª");
			v.setCustomNameVisible(true);
			v.setProfession(Profession.BLACKSMITH);
		}
		return false;
	}
	@EventHandler
	public void aoClicar(PlayerInteractEntityEvent e) {
	    if ((e.getRightClicked() instanceof Villager && !ArraysAPI.Admin.contains(e.getPlayer()))) {
	        Player p = e.getPlayer();
	        Villager v = (Villager)e.getRightClicked();
	        if (v.getCustomName().equals("§6–ª §7Sr §6§lParkour §6–ª")) {
	          e.setCancelled(true);
	          
	          
	          if(noParkour.contains(p)){
	          	p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ja esta no parkour");
	          	e.setCancelled(true);
	          	return;
	          }
	          if(!noParkour.contains(p)){
	         ItemStack Sair = new ItemStack(Material.BED);
	         ItemMeta kSair = Sair.getItemMeta();
	         kSair.setDisplayName("§6–ª §7Sair");
	         Sair.setItemMeta(kSair);
	         
	         p.setAllowFlight(false);
	         
	         noParkour.add(p);
	         
	         WarpsAPI.Ir(p, "Parkour");
	         API.setWarp(p, "Parkour");
	         p.getInventory().clear();
	         
	         p.getInventory().setArmorContents(null);
	         
	         p.getInventory().setItem(8, Sair);
	         p.updateInventory();
	         
	         
	         for(Player todos : Bukkit.getOnlinePlayers()){
	       	  
	       	  p.hidePlayer(todos);
	         }
	          }
	        }
		}
	}
	@EventHandler
	public void aoDano1(EntityDamageByEntityEvent e) {
		if(e.getDamager() instanceof Player && e.getEntity() instanceof Villager) {
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void aoDano2(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Villager) {
			e.setCancelled(true);
		}
	}
}