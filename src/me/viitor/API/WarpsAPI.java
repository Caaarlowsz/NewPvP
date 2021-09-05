package me.viitor.API;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

import me.viitor.configuração.WarpsConfig;




public class WarpsAPI implements Listener{
	
	public static ArrayList<String> segundos = new ArrayList<>();
	
	
	@EventHandler
	public void andou(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		
		if(segundos.contains(p.getName())){
			segundos.remove(p.getName());
			
			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce se moveu, teleporte cancelado");
			p.removePotionEffect(PotionEffectType.SLOW);
			p.removePotionEffect(PotionEffectType.BLINDNESS);
		}
	}
	

	public static void Set(Player p,String Warp){
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".X", p.getLocation().getX());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Y", p.getLocation().getY());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Z", p.getLocation().getZ());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Pitch", p.getLocation().getPitch());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".Yaw", p.getLocation().getYaw());
		WarpsConfig.getConfig().config().set("Warps." + Warp + ".World", p.getLocation().getWorld().getName());
		WarpsConfig.getConfig().saveConfigs();
	}
	public static void Ir(Player p,String Warp){
		
		if(WarpsConfig.getConfig().config().contains("Warps." + Warp)){
			
			double x = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".X");
			double y = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Y");
			double z = WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Z");
			float Pitch = (float)WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Pitch");
			float Yaw = (float)WarpsConfig.getConfig().config().getDouble("Warps." + Warp + ".Yaw");
			World world = Bukkit.getWorld(WarpsConfig.getConfig().config().getString("Warps." + Warp + ".World"));
			Location loc = new Location(world, x, y, z, Yaw, Pitch);
			
			p.teleport(loc);
		}else{
			p.sendMessage("§6§lNew§f§lPvP §6» §7Esta warp ainda nao foi setada");
		}
	}
}
