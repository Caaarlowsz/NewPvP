package me.viitor.commands;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.viitor.configuração.cfGrupo;
import me.viitor.staffmanager.GroupManager;

@SuppressWarnings("deprecation")
public class ScCommand  implements Listener, CommandExecutor {
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  
	  public static ArrayList<String> staff = new ArrayList();

	    @EventHandler
	    public void onChat(PlayerChatEvent e) { Player p = e.getPlayer();
	      for (Player online : Bukkit.getOnlinePlayers()) {
	        if (!isStaffChatting(p))
	          continue;
	        e.setCancelled(true);
	        if (cfGrupo.ChecarGrupo(online, "Dono") || cfGrupo.ChecarGrupo(online, "Admin") || cfGrupo.ChecarGrupo(online, "Gerente") || cfGrupo.ChecarGrupo(online, "Mod+") || cfGrupo.ChecarGrupo(online, "Mod") || cfGrupo.ChecarGrupo(online, "Trial") || cfGrupo.ChecarGrupo(online, "Youtuber+") || cfGrupo.ChecarGrupo(online, "Helper") || (isStaffChatting(online)))
	          online.sendMessage("§e§lSTAFF §6» " + GroupManager.getGrupo(p) + p.getName() + " §6» §7" + e.getMessage());
	      }
	    }

	    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	      Player p = (Player)sender;
	      if (cmd.getName().equalsIgnoreCase("sc")){
	      	if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
	  			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando");
	  			return true;
	      	}
	        if (isStaffChatting(p)){
	          staff.remove(p.getName());
	          p.sendMessage("§6§lNew§f§lPvP §6» §7Você saiu do StaffChat");
	        }else  {
	          staff.add(p.getName());
	          p.sendMessage("§6§lNew§f§lPvP §6» §7Você entrou no StaffChat");
	        }
	      }
	      return true;
	    }

	    public boolean isStaffChatting(Player player)
	    {
	      return staff.contains(player.getName());
	    }
	  }