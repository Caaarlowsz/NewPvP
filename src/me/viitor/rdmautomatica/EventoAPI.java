package me.viitor.rdmautomatica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.viitor.main.Main;

public class EventoAPI implements Listener {

	public static ArrayList<Player> Teleportando = new ArrayList<Player>();
	public static ArrayList<Player> AntiBug = new ArrayList<Player>();
	public static HashMap<Player, Long> Cooldown = new HashMap<Player, Long>();
	
	public static void SetarWarp(Player Jogador, String LocalDoEvento) {
		Configuração.getEvento().set(LocalDoEvento + ".Setado por", Jogador.getName());
		Configuração.getEvento().set(LocalDoEvento + ".X", Jogador.getLocation().getX());
		Configuração.getEvento().set(LocalDoEvento + ".Y", Jogador.getLocation().getY());
		Configuração.getEvento().set(LocalDoEvento + ".Z", Jogador.getLocation().getZ());
		Configuração.getEvento().set(LocalDoEvento + ".Pitch", Jogador.getLocation().getPitch());
		Configuração.getEvento().set(LocalDoEvento + ".Yaw", Jogador.getLocation().getYaw());
		Configuração.salvarConfig();
	}
	
	public static void TeleportarWarp(Player Jogador, String LocalDoEvento) {
		if (Configuração.getEvento().get(LocalDoEvento) == null) {
			Jogador.sendMessage("§6§lNew§f§lPvP §6» §7O local §6" + LocalDoEvento + " §7ainda nao foi setado");
			return;
		}
		double x = Configuração.getEvento().getDouble(LocalDoEvento + ".X");
		double y = Configuração.getEvento().getDouble(LocalDoEvento + ".Y");
		double z = Configuração.getEvento().getDouble(LocalDoEvento + ".Z");
		float pitch = (float)Configuração.getEvento().getDouble(LocalDoEvento + ".Pitch");
		float yaw = (float)Configuração.getEvento().getDouble(LocalDoEvento + ".Yaw");
		
		Jogador.teleport(new Location(Jogador.getWorld(), x, y, z, yaw, pitch));
		
	}
	
	public static void AdicinarCooldown(Player Jogador, int Tempo){
		Cooldown.put(Jogador, Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(Tempo)));
		    
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				RemoverCooldown(Jogador);
			}
		}, Tempo * 20);    
	}

	public static void RemoverCooldown(Player Jogador){
		Cooldown.remove(Jogador);
	}

	public static long PegarCooldown(Player Jogador) {
		long Tempo = TimeUnit.MILLISECONDS.toSeconds(((Long)Cooldown.get(Jogador)).longValue() - System.currentTimeMillis());

		if ((Cooldown.containsKey(Jogador)) || (((Long)Cooldown.get(Jogador)).longValue() > System.currentTimeMillis())){
			return Tempo;
		}
		return 0L;
	}
	
	@EventHandler
	private void onPlayerMoveEvent(PlayerMoveEvent Evento) {
		Player Jogador = Evento.getPlayer();
		
		if (Teleportando.contains(Jogador)) {
			Teleportando.remove(Jogador);
			AntiBug.remove(Jogador);
			Jogador.setExp(0.0F);
			Jogador.setLevel(0);
			Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Seu teleporte foi cancelado");
			Jogador.playSound(Jogador.getLocation(), Sound.NOTE_PIANO, 10.0F, 10.0F);
		}
		
		if (PlayerAPI.Esperando.contains(Jogador)) {
			Jogador.teleport(Jogador.getLocation());
		}
	}
		
	@EventHandler
	private void onPlayerQuitEvent(PlayerQuitEvent event) {
		Player Jogador = event.getPlayer();
		
		RemoverCooldown(Jogador);
	}
	
	@EventHandler
	public void onRightClickPiston(PlayerInteractEvent Evento) {
		Player Jogador = Evento.getPlayer();
	    if (Evento.getAction().equals(Action.RIGHT_CLICK_BLOCK) && Evento.getClickedBlock().getType() != Material.STONE && EventoAPI.AntiBug.contains(Jogador)) {
	    	Evento.setCancelled(true);
	    	return;
	    }
	}
}
