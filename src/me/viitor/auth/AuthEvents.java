package me.viitor.auth;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.viitor.configuração.cfGrupo;
import me.viitor.main.Main;

public class AuthEvents implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		Auth.login.add(p);
		new BukkitRunnable() {
			@Override
			public void run() {
				if(Auth.login.contains(p)) {
					p.kickPlayer("§cVoce §c§ndemorou demais§c para se logar." + "\n" + "Voce possui apenas 30 segundos para se logar no servidor." + "\n" + "Esqueceu sua senha?" + "\n" + "@NewNetworkMC");
				}
			}
		}.runTaskLater(Main.getPlugin(), 600L);
		if(Auth.checarRegistro(p)) {
			Main.getPlugin().getServer().getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), new Runnable() {
				
				@Override
				public void run() {
					if(Auth.login.contains(p)) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Logue-se utilizando §6/login <SuaSenha>");
					}
				}
			}, 0L, 100L);
		}
		if(!Auth.checarRegistro(p)) {
			Main.getPlugin().getServer().getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), new Runnable() {
				
				@Override
				public void run() {
					if(Auth.login.contains(p)) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Registre-se utilizando §6/register <SuaSenha>");
					}
				}
			}, 0L, 100L);
		}
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(Auth.login.contains(p)) {
			p.teleport(p);
		}
	}
	
	@EventHandler
	public void onPickUp(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onClickInventory(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
			p.updateInventory();
		}
	}
	
	@EventHandler
	public void onOpenInventory(InventoryOpenEvent e) {
		Player p = (Player) e.getPlayer();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player) {
			Player p = (Player) e.getEntity();
			if(Auth.login.contains(p)) {
				e.setCancelled(true);
			}
		}
		if(e.getDamager() instanceof Player) {
			Player p = (Player) e.getDamager();
			if(Auth.login.contains(p)) {
				e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(Auth.login.contains(p)) {
			e.setCancelled(true);
		} else {
			e.setCancelled(false);
		}
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String cmd = e.getMessage();
		if(Auth.login.contains(p)) {
			if(cmd.contains("unregister")) {
				e.setCancelled(true);
				for(Player todos : Bukkit.getOnlinePlayers()) {
					if(cfGrupo.ChecarGrupo(todos, "Dono") || cfGrupo.ChecarGrupo(todos, "Admin")) {
						todos.sendMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + p.getName() + " §7com o IP §6" + p.getAddress().getHostString() + " §7tentou utilizar o comando /unregister sem estar logado");
					}
				}
			}
			if(cmd.contains("login") || cmd.contains("register") || cmd.contains("tag") || cmd.contains("tags") || cmd.contains("admin")) {
				e.setCancelled(false);
			} else {
				e.setCancelled(true);
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce precisa estar logado para executar este comando");
			}
		}
	}

}
