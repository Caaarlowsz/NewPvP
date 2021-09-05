package me.viitor.anticheat.hacks.flyspeed;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerVelocityEvent;

public class FlySpeed implements Listener {

	@EventHandler
	private void onPlayerTeleportEvent(PlayerTeleportEvent Evento) {
		MoveCheck.Invalidate(Evento.getPlayer(), 4000L);
	}
	  
	@EventHandler
	private void onPlayerPortalEvent(PlayerPortalEvent Evento) {
		MoveCheck.Invalidate(Evento.getPlayer(), 4000L);
	}
	  
	@EventHandler
	private void onEntityDamageEvent(EntityDamageEvent Evento) {
		if ((Evento.getEntity() instanceof Player)) {
			Player player = (Player)Evento.getEntity();
	      
			MoveCheck.Invalidate(player, 1000L);
		}
	}
	  
	@EventHandler
	private void onEntityDeathEvent(EntityDeathEvent Evento) {
		if ((Evento instanceof PlayerDeathEvent)) {
			MoveCheck.Invalidate((Player)Evento.getEntity(), 5000L);
		}
	}
	  
	@EventHandler
	private void onPlayerLoginEvent(PlayerLoginEvent Evento) {
		MoveCheck.Invalidate(Evento.getPlayer(), 5000L);
	}
	  
	@EventHandler
	private void onPlayerRespawnEvent(PlayerRespawnEvent Evento) {
		MoveCheck.Invalidate(Evento.getPlayer(), 5000L);
	}
	  
	@EventHandler
	private void onPlayerMoveEvent(PlayerMoveEvent Evento) {
		MoveCheck.AddMove(Evento.getPlayer(), Evento.getTo());
	}
	  
	@EventHandler
	private void onPlayerVelocityEvent(PlayerVelocityEvent Evento) {
		int Velocidade = (int)Evento.getVelocity().length();
		MoveCheck.Invalidate(Evento.getPlayer(), Velocidade * 1000L + 500L);
	}
}
