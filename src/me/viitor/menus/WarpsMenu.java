package me.viitor.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WarpsMenu {
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 27, "§6Warps");
		
		menu.setItem(10, criarItemMenu(Material.GLASS, "§7Warp §6§lFPS", new String[] {null}));
		menu.setItem(11, criarItemMenu(Material.BLAZE_ROD, "§7Warp §6§l1V1", new String[] {null}));
		menu.setItem(12, criarItemMenu(Material.LAVA, "§7Warp §6§lCHALLENGE", new String[] {null}));
		menu.setItem(13, criarItemMenu(Material.STICK, "§7Warp §6§lKNOCKBACK", new String[] {null}));
		menu.setItem(14, criarItemMenu(Material.FISHING_ROD, "§7Warp §6§lFISHERMAN", new String[] {null}));
		menu.setItem(16, criarItemMenu(Material.WATER_BUCKET, "§7Warp §6§lMLG", new String[] {null}));
		menu.setItem(15, criarItemMenu(Material.DIAMOND_SWORD, "§7Warp §6§lMAIN", new String[] {null}));
		
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE);
		ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§7-");
		vidro.setItemMeta(vidrom);
		
		menu.setItem(0, vidro);
		menu.setItem(1, vidro);
		menu.setItem(2, vidro);
		menu.setItem(3, vidro);
		menu.setItem(4, vidro);
		menu.setItem(5, vidro);
		menu.setItem(6, vidro);
		menu.setItem(7, vidro);
		menu.setItem(8, vidro);
		
		menu.setItem(9, vidro);
		menu.setItem(17, vidro);
		
		menu.setItem(18, vidro);
		menu.setItem(19, vidro);
		menu.setItem(20, vidro);
		menu.setItem(21, vidro);
		menu.setItem(22, vidro);
		menu.setItem(23, vidro);
		menu.setItem(24, vidro);
		menu.setItem(25, vidro);
		menu.setItem(26, vidro);
		
		p.openInventory(menu);
	}
}
