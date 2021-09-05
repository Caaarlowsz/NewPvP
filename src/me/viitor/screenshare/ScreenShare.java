package me.viitor.screenshare;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import me.viitor.API.HorarioAPI;
import me.viitor.API.WarpsAPI;
import me.viitor.bans.Config;
import me.viitor.configuração.cfGrupo;
import me.viitor.twitter.TweetAPI;

public class ScreenShare implements CommandExecutor, Listener {
	
	public static ArrayList<Player> SS = new ArrayList<>();
	public static HashMap<Player, Location> LOC = new HashMap<>();
	public static HashMap<Player, ItemStack[]> Itens = new HashMap<>();
	public static HashMap<Player, ItemStack[]> Armadura = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("ss")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Mod+")) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /ss <Jogador>");
				return true;
			}
			Player k = Bukkit.getPlayer(args[0]);
			if(k == null) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
				return true;
			} else {
				if(cfGrupo.ChecarGrupo(k, "Dono") || cfGrupo.ChecarGrupo(k, "Admin") || cfGrupo.ChecarGrupo(k, "Gerente") || cfGrupo.ChecarGrupo(k, "Mod+") || cfGrupo.ChecarGrupo(k, "Mod") || cfGrupo.ChecarGrupo(k, "Trial") || cfGrupo.ChecarGrupo(k, "Youtuber+")) {
					if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin")) {
						p.sendMessage("§6§lNash§f§lPvP §6» §7Este jogador nao pode ser adicionado ao modo SS");
						return true;
					}
				}
				if(k.getName() == p.getName()) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Voce nao pode se auto-colocar no modo SS");
					return true;
				}
				if(SS.contains(p)) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Voce ja esta em uma ScreenShare");
				}
				if(!SS.contains(k) && !SS.contains(p)) {
					LOC.put(p, p.getLocation());
					LOC.put(k, k.getLocation());
					Itens.put(p, p.getInventory().getContents());
					Itens.put(k, k.getInventory().getContents());
					Armadura.put(p, p.getInventory().getArmorContents());
					Armadura.put(k, k.getInventory().getArmorContents());
					WarpsAPI.Ir(p, "SS");
					WarpsAPI.Ir(k, "SS");
					p.getInventory().clear();
					k.getInventory().clear();
					p.getInventory().setArmorContents(null);
					k.getInventory().setArmorContents(null);
					SS.add(k);
					SS.add(p);
					p.sendMessage("§6§lNash§f§lPvP §6» §7Voce entrou no modo ScreenShare com o jogador §6" + k.getName() + "§7. Ambos foram teleportados para uma warp distinta. Voces agora estao em um canal privado.");
					k.sendMessage("§6§lNash§f§lPvP §6» §7Voce foi colocado no modo ScreenShare. Voce e o staffer agora estao em uma warp distinta, conversando por um canal privado. Caso deslogue, sera banido.");
					return true;
				} else {
					p.teleport(LOC.get(p));
					k.teleport(LOC.get(k));
					p.getInventory().setContents(Itens.get(p));
					p.getInventory().setArmorContents(Armadura.get(p));
					k.getInventory().setContents(Itens.get(k));
					k.getInventory().setArmorContents(Armadura.get(k));
					SS.remove(p);
					SS.remove(k);
					p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + k.getName() + " §7foi retirado do modo ScreenShare. O jogo de ambos volta ao normal.");
					k.sendMessage("§6§lNash§f§lPvP §6» §7Voce foi retirado do modo ScreenShare. Seu jogo voltou ao normal. Agora, voce esta livre para deslogar.");
					return true;
				}
			}
		}
		return false;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if(SS.contains(p)) {
			SS.remove(p);
			for(Player todos : Bukkit.getOnlinePlayers()) {
				SS.remove(todos);
			}
			double l = Config.getConfig().getBans().getDouble("Players Banidos");
			me.viitor.bans.API.sendBC("§cConsole baniu " + p.getName() + " por ScreenShare");
			me.viitor.bans.API.sendStaff("§7O §7§ostaffer §7Console baniu o jogador " + p.getName() + " pelo motivo ScreenShare Leave");
			
			TweetAPI.update("Jogador banido: " + p.getName() + "\n" + "Banido por: Console" + "\n" + "Motivo: ScreenShare Leave" + "\n" + "" + "\n" + "Servidor: " + Bukkit.getIp());
									 
			Config.getConfig().getBans().set("Players Banidos", Double.valueOf(l + 1.0D));
			Config.getConfig().getBans().set("Bans." + p.getUniqueId() + ".Nome", p.getName());
			Config.getConfig().getBans().set("Bans." + p.getUniqueId() + ".Banido por", "Console");
			Config.getConfig().getBans().set("Bans." + p.getUniqueId() + ".Motivo", "Sair na ScreenShare");
			Config.getConfig().getBans().set("Bans." + p.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
			Config.getConfig().saveBans();
			return;
		}
	}
}
