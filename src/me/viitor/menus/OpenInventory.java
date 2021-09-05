package me.viitor.menus;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.viitor.API.API;
import me.viitor.API.KitdiarioAPI;
import me.viitor.configuração.cfKitdiario;

public class OpenInventory implements Listener{
	
	@EventHandler
	public void abrirMenuKits(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.CHEST && API.getWarp(p) == "Spawn" && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Seletor de KITS")){
		KitsMenu.inventory(p);
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
		}
	}
	@EventHandler
	public void abrirMenuWarps(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.NAME_TAG && API.getWarp(p) == "Spawn" && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Seletor de WARPS")){
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
		WarpsMenu.inventory(p);
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void abrirConfig(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.getMaterial(351) && API.getWarp(p) == "Spawn" && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Kit PADRAO")){
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 20L, 20L);
        PadraoMenu.inventory(p);
		}
	}
	@EventHandler
	public void openCaixa(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.ENDER_CHEST && API.getWarp(p) == "Spawn" && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Kit DIARIO")){
		
			if(cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".hora") != null){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce ja utilizou seu KIT DIARIO hoje. Aguarde antes de pega-lo novamente");
			}else{
			if(cfKitdiario.pegargrupo().get("kitdiario." + p.getUniqueId() + ".hora") == null){
			p.playSound(p.getLocation(), Sound.EXPLODE, 20L, 20L);
		KitdiarioAPI.kitdiario(p);
		p.getInventory().remove(Material.ENDER_CHEST);
				}
			}
		}
	}
}
