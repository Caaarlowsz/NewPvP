package me.viitor.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.viitor.API.ArraysAPI;
import me.viitor.configuração.cfConfig;

public class TellCommand implements CommandExecutor, Listener{
	
	public static ArrayList<Player> cooldown = new ArrayList<>();
	
	@EventHandler
	public void flodar(PlayerCommandPreprocessEvent e){
		
		Player p = e.getPlayer();
		if(cooldown.contains(p) && (cooldown.contains(p) && (e.getMessage().toLowerCase().startsWith("/tell")))){
			e.setCancelled(true);
		      p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode floodar o tell de um jogador. Aguarde alguns instantes antes de enviar outra mensagem privada");
			
		}
	}
	
public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args){
    final Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("tell")){
        if (Args.length == 0){
        	p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /tell <Jogador> <Mensagem> ou /tell <On | Off>");
          return true;
        }
        if(Args[0].equalsIgnoreCase("on")){
        	if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell").equals("Desativado")){
        	p.sendMessage("§6§lNew§f§lPvP §6» §7Voce ativou seu tell");
        	cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell", "Ativado");
        	cfConfig.salvarconfiguracao();
        	}else{
        		p.sendMessage("§6§lNew§f§lPvP §6» §7Seu tell ja esta ativado");
        	}
        	return true;
        }
        if(Args[0].equalsIgnoreCase("off")){
        	if(cfConfig.pegarconfig().get("configuração." + p.getUniqueId() + ".Tell").equals("Ativado")){
        	p.sendMessage("§6§lNew§f§lPvP §6» §7Voce desativou seu tell");
        	cfConfig.pegarconfig().set("configuração." + p.getUniqueId() + ".Tell", "Desativado");
        	cfConfig.salvarconfiguracao();
        	}else{
        		p.sendMessage("§6§lNew§f§lPvP §6» §7Seu tell ja esta desativado");
        	}
        	return true;
        }
        Player tell = Bukkit.getPlayer(Args[0]);
        if (tell == null){
     		p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador citado encontra-se offline");	
          return true;
        }
        if (tell == p){
        	p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode enviar tells a si mesmo");
          return true;
        }
    	if(cfConfig.pegarconfig().get("configuração." + tell.getUniqueId() + ".Tell").equals("Desativado")){
        	p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador citado se encontra com o tell desativado");
        	return true;
        }
    	if(ArraysAPI.Admin.contains(tell)){
     		p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador citado encontra-se offline");	
        	return true;
        }
        String message = " ";
        for (int i = 1; i < Args.length; i++) {
          if (i == Args.length - 1) {
            message = message + Args[i];
          } else {
            message = message + Args[i] + " ";
          }
        }
        p.sendMessage("§7(§6Você §7-> §6" + tell.getName() + "§7) " + message);
        tell.sendMessage("§7(§6" + p.getName()  + " §7-> §6Você§7) " + message);
    }
    return false;
  }
}
