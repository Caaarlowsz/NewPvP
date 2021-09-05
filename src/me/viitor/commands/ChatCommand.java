package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import me.viitor.API.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

@SuppressWarnings("deprecation")
public class ChatCommand implements CommandExecutor, Listener{
	  public static boolean pausado = false;
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		if(Cmd.getName().equalsIgnoreCase("chat")){
			Player p = (Player)Sender;
			
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+"))))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			
			if(Args.length == 0){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /chat <On | Off | Clear>");
				return true;
			}
			if(Args[0].equalsIgnoreCase("clear")){
				
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("  ");
				Bukkit.getServer().broadcastMessage("§6§lNew§f§lPvP §6» §7Chat limpo");
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) limpou o chat");
			}else{
				
				if(Args[0].equalsIgnoreCase("off")){
					Bukkit.getServer().broadcastMessage("§6§lNew§f§lPvP §6» §7O chat do servidor foi desativado");
					API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) desativou o chat");
					pausado = true;
			}else{
				if(Args[0].equalsIgnoreCase("on")){
					Bukkit.getServer().broadcastMessage("§6§lNew§f§lPvP §6» §7O chat do servidor foi ativado");
					API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) ativou o chat");
					pausado = false;
					}
				}
			}
		}
		return true;
		}
			 @EventHandler
			  public void onChat(PlayerChatEvent e){
			  {
			    Player p = e.getPlayer();
			    if ((pausado) && 
			    		((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Youtuber"))))))))))){
			      e.setCancelled(true);
			      p.sendMessage("§6§lNew§f§lPvP §6» §7O chat do servidor esta desativado");
			    }
		  }
	 }
}
