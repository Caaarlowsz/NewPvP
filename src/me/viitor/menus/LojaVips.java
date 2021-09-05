package me.viitor.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LojaVips {
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 9, "§7Qual §6[VIP] §7deseja?");
		
		menu.setItem(2, criarItemMenu(Material.EMERALD_BLOCK, "§7[VIP] §a§lLIGHT", new String[] {" ", "                   §6§lBeneficios", "§7- §6Slot exclusivo no servidor", "§7- §6Tag §a§lLIGHT §6para se destacar dos demais jogadores", "§7- §6Acesso a §711 §6kits do servidor", " "}));
		menu.setItem(4, criarItemMenu(Material.LAPIS_BLOCK, "§7[VIP] §9§lMVP", new String[] {" ", "                   §6§lBeneficios", "§7- §6Slot exclusivo no servidor", "§7- §6Tag §9§lMVP §6para se destacar dos demais jogadores", "§7- §6Acesso a §716 §6kits do servidor", " "}));
		menu.setItem(6, criarItemMenu(Material.GOLD_BLOCK, "§7[VIP] §6§lPRO", new String[] {" ", "                   §6§lBeneficios", "§7- §6Slot exclusivo no servidor", "§7- §6Tag §6§lPRO §6para se destacar dos demais jogadores", "§7- §6Acesso a §7todos §6os kits do servidor", " "}));
		
		p.openInventory(menu);
	}
}
