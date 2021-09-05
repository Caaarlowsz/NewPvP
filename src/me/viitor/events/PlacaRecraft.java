package me.viitor.events;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlacaRecraft implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("recraft")) {
			e.setLine(0, "§4§m----------");
			e.setLine(1, " §6Recraft");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, "§4§m----------");
		}
		
	}
	
	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if(e.getClickedBlock() != null)
			   if (e.getClickedBlock().getType() == Material.WALL_SIGN || (e.getClickedBlock().getType() == Material.SIGN_POST)) {
			Sign s = (Sign)e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 0) && (lines[0].equals("§4§m----------")) && 
					(lines.length > 1) && (lines[1].equals(" §6Recraft"))&&
					(lines.length > 2) && (lines[2].equals(" §7(Clique)")) &&
					(lines.length > 3) && (lines[3].equals("§4§m----------"))) {
				
				ItemStack cogu1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
				
				ItemStack cogu2 = new ItemStack(Material.RED_MUSHROOM, 64);
	
				ItemStack pote = new ItemStack(Material.BOWL, 64);
	
				p.sendMessage("§7Recraft posicionado em seu inventario");
		           p.getInventory().addItem(cogu1);
		           p.getInventory().addItem(cogu2);
		           p.getInventory().addItem(pote);
		           p.updateInventory();
			
		}}

	    }
} 