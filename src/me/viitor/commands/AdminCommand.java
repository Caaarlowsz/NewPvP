package me.viitor.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.viitor.API.API;
import me.viitor.API.ArraysAPI;
import me.viitor.API.KitAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;
import me.viitor.invencivel.Proteção;
import me.viitor.main.Main;
import me.viitor.scoreboard.sScoreAPI;

public class AdminCommand implements CommandExecutor, Listener{

	public static HashMap<Player, ItemStack[]> inventario = new HashMap<Player, ItemStack[]>();
	public static HashMap<Player, ItemStack[]> armadura = new HashMap<Player, ItemStack[]>();
	public static HashMap<Player, String> warp = new HashMap<Player, String>();
	public static HashMap<Player, String> kit = new HashMap<Player, String>();
	@SuppressWarnings("deprecation")
	@EventHandler
	private void interact(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		
		if(p.getItemInHand().getType() == Material.SLIME_BALL && ArraysAPI.Admin.contains(p) && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasDisplayName() && p.getItemInHand().getItemMeta().getDisplayName().equals("§aTroca Rapida")){
			
			for(Player todos : Bukkit.getOnlinePlayers()){
				
				todos.showPlayer(p);
				p.showPlayer(todos);
			} 
			
			p.setGameMode(GameMode.SURVIVAL);
			ArraysAPI.Admin.remove(p);
			p.sendMessage("§6§lNew§f§lPvP §6» §7Realizando troca rapida");
			
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			
			p.getInventory().setItem(2, API.criarItem(p, Material.REDSTONE, "§aTroca-Rapida", new String[] {""}, 1, (short)0));
			p.getInventory().setItem(3, API.criarItem(p, Material.MUSHROOM_SOUP, "§cAuto-Soup", new String[] {""}, 1, (short)0));
			p.getInventory().setItem(6, API.criarItem(p, Material.IRON_FENCE, "§4Cage", new String[] {""}, 1, (short)0));
			
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {

					ArraysAPI.Admin.add(p);
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					
					p.getInventory().setItem(2, API.criarItem(p, Material.SLIME_BALL, "§aTroca-Rapida", new String[] {""}, 1, (short)0));
					p.getInventory().setItem(3, API.criarItem(p, Material.MUSHROOM_SOUP, "§cAuto-Soup", new String[] {""}, 1, (short)0));
					p.getInventory().setItem(6, API.criarItem(p, Material.IRON_FENCE, "§4Cage", new String[] {""}, 1, (short)0));
					
					p.setGameMode(GameMode.CREATIVE);
					
					p.setHealth(20.0D);
					
					setAdmin(p);
				}
			}, 10L);
		}
	}
		@EventHandler
		public void autosoup(PlayerInteractEntityEvent e){
		
			Player p = e.getPlayer();
			
			if(p instanceof Player && e.getRightClicked() instanceof Player){
				
				if(p.getItemInHand().getType() == Material.MUSHROOM_SOUP && ArraysAPI.Admin.contains(p)){
					
					Player t = (Player) e.getRightClicked();
					
					if(ArraysAPI.Checando.contains(t)){
						p.sendMessage("§6§lNew§f§lPvP §6» §7Outro staffer ja esta testando o Auto-Soup neste jogador");
						return;
						
					}
				inventario.put(t, t.getInventory().getContents());
				t.getInventory().clear();
				t.setHealth(0.5D);
				ArraysAPI.Checando.add(t);

				p.openInventory(t.getInventory());
					t.getInventory().setItem(19, API.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] {""}, 1, (short)0));
					t.getInventory().setItem(20, API.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] {""}, 1, (short)0));
					t.getInventory().setItem(21, API.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] {""}, 1, (short)0));
					
			    p.sendMessage("§6§lNew§f§lPvP §6» §7Realizando teste de Auto-Soup");
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
					public void run() {
					    
						
						if(API.getAmount(t, Material.BOWL) >= 1){
							p.closeInventory();
							p.sendMessage(" ");
							p.sendMessage("§6§lNew§f§lPvP §6» §7Resultado: §cAuto-Soup detectado");
							p.sendMessage(" ");
						}
						else if(API.getAmount(t, Material.BOWL) == 0){
							p.closeInventory();
							p.sendMessage(" ");
							p.sendMessage("§6§lNew§f§lPvP §6» §7Resultado: §aAuto-Soup nao detectado");
							p.sendMessage(" ");
						}
						ArraysAPI.Checando.remove(t);
						t.getInventory().clear();
						t.closeInventory();
						t.getInventory().setContents(inventario.get(t));
						t.setHealth(20.0D);
						
					}
				}, 1*60);
				}
			}
			 if(p.getItemInHand().getType() == Material.IRON_FENCE && ArraysAPI.Admin.contains(p)){
					Player t = (Player) e.getRightClicked();
			    p.sendMessage("§6§lNew§f§lPvP §6» §7Voce prendeu o jogador §6" + t.getName());
		          t.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		          t.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
		          t.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		          t.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
		          t.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		          t.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
		          t.teleport(t.getLocation().add(0.0D, 11.0D, -0.05D));
		          p.teleport(t.getLocation().add(3.0D, 0.0D, 0.05D));
			}
			 if(p.getItemInHand().getType() == Material.AIR && ArraysAPI.Admin.contains(p)){
					Player t = (Player) e.getRightClicked();
				p.openInventory(t.getInventory());
			}
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("admin")){
			
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
		}
			if(!ArraysAPI.Admin.contains(p)){
					ArraysAPI.Admin.add(p);
					
					kit.put(p, KitAPI.getKitAntes(p));
					warp.put(p, API.getWarp(p));
					
					inventario.put(p, p.getInventory().getContents());
					armadura.put(p, p.getInventory().getArmorContents());
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					
					Proteção.setImortal(p, false);
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce entrou no modo admin");
					API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) entrou no modo admin");
					KitAPI.setKit(p, "Admin");
					API.setWarp(p, "Admin");
					p.setHealth(20.0D);
					p.setMaxHealth(20.0D);
					p.setGameMode(GameMode.CREATIVE);
					p.getInventory().setItem(2, API.criarItem(p, Material.SLIME_BALL, "§aTroca-Rapida", new String[] {""}, 1, (short)0));
					p.getInventory().setItem(4, API.criarItem(p, Material.MUSHROOM_SOUP, "§cAuto-Soup", new String[] {""}, 1, (short)0));
					p.getInventory().setItem(6, API.criarItem(p, Material.IRON_FENCE, "§4Cage", new String[] {""}, 1, (short)0));
					
					setAdmin(p);
					ArraysAPI.Jogando.remove(p);
					
					for(Player todos : Bukkit.getOnlinePlayers()){
							sScoreAPI.scoreboard(todos);
					}
					sScoreAPI.scoreboard(p);
					return true;
				}
				if(ArraysAPI.Admin.contains(p)){
					
					ArraysAPI.Admin.remove(p);
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce saiu do modo admin");
					API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) saiu do modo admin");
					KitAPI.setKit(p, kit.get(p));
					API.setWarp(p, warp.get(p));
					p.setGameMode(GameMode.SURVIVAL);
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					p.getInventory().setArmorContents(armadura.get(p));
					p.getInventory().setContents(inventario.get(p));
			     	   p.updateInventory();
			     	   
			     	   ArraysAPI.Jogando.add(p);
			     	   
					for(Player todos : Bukkit.getOnlinePlayers()){
							sScoreAPI.scoreboard(todos);
					}
			     	   
					for(Player todos : Bukkit.getOnlinePlayers()){
						
						todos.showPlayer(p);
						p.showPlayer(todos);
					}
					sScoreAPI.scoreboard(p);
				}
		}
		return false;
	}
	@SuppressWarnings("deprecation")
	public static void setAdmin(Player p){
		for(Player todos : Bukkit.getOnlinePlayers()) {
			if(!cfGrupo.ChecarGrupo(todos, "Dono") && !cfGrupo.ChecarGrupo(todos, "Admin") && !cfGrupo.ChecarGrupo(todos, "Gerente") && !cfGrupo.ChecarGrupo(todos, "Mod+") && !cfGrupo.ChecarGrupo(todos, "Mod") && !cfGrupo.ChecarGrupo(todos, "Trial") && !cfGrupo.ChecarGrupo(todos, "Youtuber+")) {
				todos.hidePlayer(p);
				p.showPlayer(todos);
			}
		}
	}
	@SuppressWarnings("deprecation")
	public static void checarAdmin(){
		
		for(Player todos : Bukkit.getOnlinePlayers()){
		if(ArraysAPI.Admin.contains(todos)){
			
			setAdmin(todos);
		}
		}
	}
}
