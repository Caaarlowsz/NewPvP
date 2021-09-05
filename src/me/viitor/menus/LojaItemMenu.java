package me.viitor.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojaItemMenu implements Listener {
	
	public static void setarInventario(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "§6Loja(s)");
		
		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("§7Loja de KITS (Coins)");
		kits.setItemMeta(kitsm);
		
		ItemStack site = new ItemStack(Material.PAPER);
		ItemMeta sitem = site.getItemMeta();
		sitem.setDisplayName("§7Loja de KITS (Site)");
		site.setItemMeta(sitem);
		
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§7-");
		vidro.setItemMeta(vidrom);
		
		inv.setItem(11, kits);
		inv.setItem(15, site);
		
		inv.setItem(0, vidro);
		inv.setItem(1, vidro);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro);
		inv.setItem(4, vidro);
		inv.setItem(5, vidro);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro);
		inv.setItem(8, vidro);
		
		inv.setItem(9, vidro);
		inv.setItem(10, vidro);
		inv.setItem(12, vidro);
		inv.setItem(13, vidro);
		inv.setItem(14, vidro);
		inv.setItem(16, vidro);
		inv.setItem(17, vidro);
		
		inv.setItem(18, vidro);
		inv.setItem(19, vidro);
		inv.setItem(20, vidro);
		inv.setItem(21, vidro);
		inv.setItem(22, vidro);
		inv.setItem(23, vidro);
		inv.setItem(24, vidro);
		inv.setItem(25, vidro);
		inv.setItem(26, vidro);
		
		p.openInventory(inv);
	}
	@EventHandler
	public void abrirInv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getItemInHand().getType() == Material.EMERALD && me.viitor.API.API.getWarp(p) == "Spawn" && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§6» §7Loja")) {
			setarInventario(p);
		}
	}
	@EventHandler
	public void clicarInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if(e.getInventory().getTitle().equals("§6Loja(s)")) {
			if(e.getCurrentItem().getType() == Material.AIR) {
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getType() == Material.CHEST) {
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getType() == Material.PAPER) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(" ");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Loja do servidor: §6mc-nash.tk/loja");
				p.sendMessage(" ");
				return;
			}
		}
	}
}
