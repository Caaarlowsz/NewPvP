package me.viitor.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.ChatInterativo;
import me.viitor.configuração.cfGrupo;
import me.viitor.main.Main;

public class ReportCommand implements CommandExecutor{
	
  @SuppressWarnings({ "unchecked", "rawtypes" })
public ArrayList<String> reported = new ArrayList();


@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args){
	  
    final Player p = (Player)Sender;
    if (Cmd.getName().equalsIgnoreCase("report")) {
      if (Args.length >= 2) {
        Player target = p.getServer().getPlayer(Args[0]);
        if (target != null) {
          if (reported.contains(p.getName())){
            p.sendMessage("§6§lNew§f§lPvP §6» §7Aguarde para enviar outro report");
            return true;
          }
        	  if(target == p){
        		  return true;
          }
          String reportMsg = StringUtils.join(
            Arrays.copyOfRange(Args, 1, Args.length), " ");
          this.reported.add(p.getName());
          p.sendMessage("§6§lNew§f§lPvP §6» §7Seu report foi enviado com sucesso");
          for (Player s : Bukkit.getOnlinePlayers()) {
      		if((cfGrupo.ChecarGrupo(s, "Dono") || ((cfGrupo.ChecarGrupo(s, "Gerente") || ((cfGrupo.ChecarGrupo(s, "Admin") || ((cfGrupo.ChecarGrupo(s, "Mod+") || ((cfGrupo.ChecarGrupo(s, "Mod") || ((cfGrupo.ChecarGrupo(s, "Trial") || ((cfGrupo.ChecarGrupo(s, "Youtuber+"))))))))))))))){
            	
   			    s.getPlayer().playSound(p.getPlayer().getLocation(), Sound.ANVIL_USE, 5.0F, 5.0F);
            	s.sendMessage(" ");
            	s.sendMessage("                  §6§lREPORT                    ");
            	s.sendMessage(" ");
            	s.sendMessage("  §7Jogador reportado: §e" + target.getName());
            	s.sendMessage("  §7Reportado pelo: §e" + p.getName());
            	s.sendMessage("  §7Motivo: §e" + reportMsg);
            	s.sendMessage(" ");
            	
              
        		ChatInterativo.Comando(s.getName(), "§7Clique para se teleportar ao jogador reportado","/tp " + target.getName(), "§eClique");
              Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable(){
                public void run(){
                 reported.remove(p.getName());
                }
              }
              , 300L);
            }
          }
        }
        else {
        	p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador §6" + Args[0] + " §7encontra-se §6§lOFFLINE");
        }
      }
      else {
			p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /report <Jogador> <Motivo>");
      }
    }
    return false;
  }
}