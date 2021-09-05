package me.viitor.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.viitor.API.API;
import me.viitor.API.ArraysAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;
import me.viitor.main.Main;

public class AutoSoupCommand implements CommandExecutor {
	
	public static HashMap<Player, ItemStack[]> inventario = new HashMap<Player, ItemStack[]>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("autosoup")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /autosoup <Jogador>");
				return true;
			}
			if(args.length == 1) {
				Player t = Bukkit.getPlayer(args[0]);
				if(t == null) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador " + args[0] + " encontra-se §6§lOFFLINE");
					return true;
				}
				if(t.getName() == p.getName()) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode testar Auto-Soup em si mesmo");
					return true;
				}
				if(ArraysAPI.Checando.contains(t)){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Outro staffer ja esta testando o Auto-Soup neste jogador");
				}
			inventario.put(t, t.getInventory().getContents());
			t.getInventory().clear();
			t.setHealth(0.5D);
			ArraysAPI.Checando.add(t);
			
			p.openInventory(t.getInventory());
				t.getInventory().setItem(20, API.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] {""}, 1, (short)0));
				t.getInventory().setItem(21, API.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] {""}, 1, (short)0));
				t.getInventory().setItem(22, API.criarItem(p, Material.MUSHROOM_SOUP, "§cSopa", new String[] {""}, 1, (short)0));
				
		    p.sendMessage("§6§lNew§f§lPvP §6» §7Realizando teste de Auto-Soup");
			API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) testou o Auto-Soup de " + t.getDisplayName() + " (" + CorGrupo.getTag(t) + cfGrupo.pegargrupo().get("grupos." + t.getUniqueId() + ".grupo") + "§7)");
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
		return false;
	}
}
