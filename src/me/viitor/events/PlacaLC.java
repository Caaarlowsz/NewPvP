package me.viitor.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.viitor.API.API;
import me.viitor.API.KitAPI;
import me.viitor.API.WarpsAPI;
import me.viitor.configuração.cfPermissão;
import me.viitor.configuração.cfStatus;
import me.viitor.scoreboard.sScoreAPI;

public class PlacaLC implements Listener {
	
	@EventHandler
	public void Escrever(SignChangeEvent e) {
		if(e.getLine(0).equalsIgnoreCase("lcfacil")) {
			e.setLine(0, " ");
			e.setLine(1, "§a§lNIVEL FACIL");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}
		
		if(e.getLine(0).equalsIgnoreCase("lcmedio")) {
			e.setLine(0, " ");
			e.setLine(1, "§c§lNIVEL MEDIO");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
		}
		
		if(e.getLine(0).equalsIgnoreCase("lcdificil")) {
			e.setLine(0, " ");
			e.setLine(1, "§4§lNIVEL HARD");
			e.setLine(2, " §7(Clique)");
			e.setLine(3, " ");
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
			if ((lines.length > 0) && (lines[0].equals(" ")) && 
					(lines.length > 1) && (lines[1].equals("§a§lNIVEL FACIL"))&&
					(lines.length > 2) && (lines[2].equals(" §7(Clique)")) &&
					(lines.length > 3) && (lines[3].equals(" ") &&
							API.getWarp(p) == "Challenge")) {
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Parabens, voce completou o §6§lNIVEL FACIL");
				
				cfStatus.setMoney(p, 500);
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.removeKits(p);
				
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho", new String[] {""}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom", new String[] {""}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "§7Pote", new String[] {""}, 64, (short)0));
				
				sScoreAPI.scoreboard(p);
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce ganhou §6§l500 §7coins");
				
		}
			if ((lines.length > 0) && (lines[0].equals(" ")) && 
					(lines.length > 1) && (lines[1].equals("§c§lNIVEL MEDIO"))&&
					(lines.length > 2) && (lines[2].equals(" §7(Clique)")) &&
					(lines.length > 3) && (lines[3].equals(" ") &&
							API.getWarp(p) == "Challenge")) {
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Parabens, voce completou o §6§lNIVEL MEDIO");
				
				cfStatus.setMoney(p, 1000);
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.removeKits(p);
				
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho", new String[] {""}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom", new String[] {""}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "§7Pote", new String[] {""}, 64, (short)0));
				
				sScoreAPI.scoreboard(p);
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce ganhou §6§l1000 §7coins");
				
		}
			if ((lines.length > 0) && (lines[0].equals(" ")) && 
					(lines.length > 1) && (lines[1].equals("§4§lNIVEL HARD"))&&
					(lines.length > 2) && (lines[2].equals(" §7(Clique)")) &&
					(lines.length > 3) && (lines[3].equals(" ") &&
							API.getWarp(p) == "Challenge")) {
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Parabens, voce completou o §6§lNIVEL EXTREMO");
				
				Bukkit.broadcastMessage(" ");
				Bukkit.broadcastMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + p.getName() + " §7completou o §6§lNIVEL DIFICIL §7do LavaChallenge");
				Bukkit.broadcastMessage(" ");
				
				cfStatus.setMoney(p, 2000);
				
				cfPermissão.setarPermissao(p, "kit.firelauncher", "true");
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				
				KitAPI.removeKits(p);
				
				WarpsAPI.Ir(p, "Challenge");
				API.setWarp(p, "Challenge");
				KitAPI.setKitAntes(p, "Challenge");
				
				ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		        for(int i = 0; i < 36; i++){
		     	   p.getInventory().setItem(i, sopa);
		     	   p.updateInventory();
				}
				p.getInventory().setItem(13, API.criarItem(p, Material.RED_MUSHROOM, "§cCogumelo vermelho", new String[] {""}, 64, (short)0));
				p.getInventory().setItem(14, API.criarItem(p, Material.BROWN_MUSHROOM, "§eCogumelo marrom", new String[] {""}, 64, (short)0));
				p.getInventory().setItem(15, API.criarItem(p, Material.BOWL, "§7Pote", new String[] {""}, 64, (short)0));
				
				sScoreAPI.scoreboard(p);
				
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce ganhou §6§l2000 §7coins e o §6Kit FireLauncher");
				
		}
			}

	    }
}
