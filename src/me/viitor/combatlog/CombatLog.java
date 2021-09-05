package me.viitor.combatlog;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.viitor.API.API;
import me.viitor.API.ArraysAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfStatus;
import me.viitor.main.Main;
import me.viitor.scoreboard.sScoreAPI;

public class CombatLog implements Listener {
	
	public static ArrayList<Player> combat = new ArrayList<>();
	
	public static String getCombat(Player p) {
		if(combat.contains(p)) {
			return "§a§lSim";
		}
		if(!combat.contains(p)) {
			return "§c§lNão";
		}
		return "§c§lNão";
	}
	
	@EventHandler
	public void aoHitar(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player p = (Player) e.getEntity();
			Player k = (Player) e.getDamager();
			if(!ArraysAPI.Admin.contains(p) && !ArraysAPI.Admin.contains(k) && API.getWarp(p) != "Spawn" && API.getWarp(k) != "Spawn" && API.getWarp(p) != "1v1" && API.getWarp(k) != "1v1") {
				
				if(!combat.contains(p)) {
					combat.add(p);
					sScoreAPI.scoreboard(p);
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce entrou em combate com o jogador " + k.getDisplayName());
					p.sendMessage("§6§lNew§f§lPvP §6» §7Caso deslogue, sera punido com uma morte.");
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							combat.remove(p);
							sScoreAPI.scoreboard(p);
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce saiu de combate.");
							p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta livre para deslogar sem nenhuma punicao.");
						}
					}, 10 * 20);
				}
				if(!combat.contains(k)) {
					combat.add(k);
					sScoreAPI.scoreboard(k);
					k.sendMessage("§6§lNew§f§lPvP §6» §7Voce entrou em combate com o jogador " + p.getDisplayName());
					k.sendMessage("§6§lNew§f§lPvP §6» §7Caso deslogue, sera punido com uma morte.");
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							combat.remove(k);
							sScoreAPI.scoreboard(k);
							k.sendMessage("§6§lNew§f§lPvP §6» §7Voce saiu de combate.");
							k.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta livre para deslogar sem nenhuma punicao.");
						}
					}, 10 * 20);
				}
			}
		}
	}
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(combat.contains(p)) {
			cfStatus.setDeaths(p);
			Bukkit.broadcastMessage("§6§lCOMBATLOG §6» §7O jogador §6" + p.getName() + "§7 deslogou em combate e foi punido com §61 morte§7.");
		}
	}
	@EventHandler
	public void aoComando(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		if(combat.contains(p)) {
			if(!e.getMessage().contains("/report")) {
				if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") &&!cfGrupo.ChecarGrupo(p, "Youtuber+") && !cfGrupo.ChecarGrupo(p, "Helper")) {
					e.setCancelled(true);
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce esta em combate");
				}
			}
		}
	}
}
