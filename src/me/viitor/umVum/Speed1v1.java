 package me.viitor.umVum;
 import java.util.ArrayList;
import java.util.HashMap;
 import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
 import org.bukkit.event.block.Action;
 import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.viitor.main.Main;
@SuppressWarnings({ "unchecked", "rawtypes" })
public class Speed1v1 implements Listener {
 public static boolean Partida1 = false;
 public static String Nome = "";
public static List<Player> Iniciou = new ArrayList();
  public static List<Player> NeginhoSegundos = new ArrayList();
  public static HashMap<String, Player> Player2 = new HashMap();
   public static HashMap<String, Player> Player1 = new HashMap();

  @EventHandler
  public void onInteract(PlayerInteractEvent event)  {
    final Player p = event.getPlayer();
    if (p.getItemInHand().equals(Join1v1.Cinza)) {
       if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
         (event.getAction() == Action.RIGHT_CLICK_AIR))  {
       if (Partida1) {
           p.performCommand("speed1v1 " + Nome);
        Partida1 = false;
         Nome = "";

      return;
       }
        if (!Partida1) {
          Nome = p.getName();
          Partida1 = true;
           p.getInventory().removeItem(new ItemStack[] { Join1v1.Cinza });
         p.sendMessage("§6§lNew§f§lPvP §6» §7Voce entrou na fila do 1v1 rapido");
           Iniciou.add(p);
          Trocar(p);
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
          {
           public void run()
            {
              Speed1v1.NeginhoSegundos.add(p);
          }
           }
          , 2L);
         Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
           {
             public void run()
           {
            if (Speed1v1.NeginhoSegundos.contains(p)){
                 Speed1v1.NeginhoSegundos.remove(p);
               Speed1v1.Partida1 = true;
              Speed1v1.Nome = "";
               Speed1v1.Iniciou.remove(p);
                 p.getInventory().removeItem(new ItemStack[] { Join1v1.Verde1 });
               p.getInventory().removeItem(new ItemStack[] { Join1v1.Verde2 });
              p.getInventory().removeItem(new ItemStack[] { Join1v1.Verde3 });
               if(!Events1v1.inPvP.contains(p)){
                   p.updateInventory();
                   p.sendMessage("§6§lNew§f§lPvP §6» §7Nenhuma batalha foi localizada");
                   p.getInventory().setItem(5, Join1v1.Cinza);
               }
             }
            }
           }
           , 200L);
       }
      }
    }
   }
 
   public void Trocar(final Player p){

	   
         if (Speed1v1.Iniciou.contains(p)) {
         p.getInventory().setItem(5, new ItemStack(Join1v1.Verde1));
          p.updateInventory();
         }
   }

  @EventHandler
   public void onInteract2(PlayerInteractEvent event) {
     Player p = event.getPlayer();
     if ((p.getItemInHand().equals(Join1v1.Verde1)) || (p.getItemInHand().equals(Join1v1.Verde2)) || (p.getItemInHand().equals(Join1v1.Verde3)))
     {
       if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
        (event.getAction() == Action.RIGHT_CLICK_AIR))
      {
           if (Speed1v1.NeginhoSegundos.contains(p)) {
        	   Speed1v1.Partida1 = false;
        	   Speed1v1.Nome = "";
        	   Speed1v1.Iniciou.remove(p);
        	   Speed1v1.NeginhoSegundos.remove(p);
        	   p.sendMessage("§6§lNew§f§lPvP §6» §7Voce saiu da fila do 1v1 rapido");
        	   p.getInventory().setItem(5, Join1v1.Cinza);
              return;
            }
           if(!Speed1v1.NeginhoSegundos.contains(p)) {
        	   return;
           }
    }
   }
  }
 }
