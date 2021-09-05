package me.viitor.habilidades;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.viitor.API.KitAPI;

public class Viper implements Listener{
	
	@EventHandler
	public void onPosion(EntityDamageByEntityEvent e) {
		if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player))) {
			Player p = (Player)e.getEntity();
			Player d = (Player)e.getDamager();
			if (KitAPI.getKit(d) == "Viper")  {
				Random r = new Random();
				int rand = r.nextInt(100);
				if (rand >= 67)
					p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 0));
				}
	    	}
	  }
 }
