package me.viitor.tab_1_8;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import me.viitor.main.Main;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;

public class TabAPI implements Listener{
  private static int VERSION = 47;

  @EventHandler
  void TabDoServidor(PlayerJoinEvent evento) { final Player jogador = evento.getPlayer();
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
      public void run() {
    	  
        PlayerConnection connect = ((CraftPlayer)jogador).getHandle().playerConnection;
        IChatBaseComponent top = ChatSerializer.a("{'extra': [{text: '', color: 'aqua'}],'color': gold, 'text': '              §6§lNash§f§lPvP              '}");

		IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': '  \n§6§lINFORMAÇÕES  \n        §7Compre VIP em: §loja.mc-nash.com.br \n§7Twitter do servidor §6@NashNetworkMC "+ "', 'underline': 'true'}], 'color': 'gold', 'text': ''}");
        if (((CraftPlayer)jogador).getHandle().playerConnection.networkManager.getVersion() < TabAPI.VERSION) {
          return;
        }
        connect.sendPacket(new ProtocolInjector.PacketTabHeader(top, bottom));
      }
    }
    , 1L, 20L);
  }
}