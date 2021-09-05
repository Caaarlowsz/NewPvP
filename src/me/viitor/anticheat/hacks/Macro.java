package me.viitor.anticheat.hacks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.viitor.anticheat.Utills;
import me.viitor.main.Main;

public class Macro implements Listener {

	@EventHandler
	private void onInventoryClickEvent(InventoryClickEvent Evento) { 
		if (!(Evento.getWhoClicked() instanceof Player)) {
			return;
		}
	    if (!Evento.isShiftClick()) {
	    	return;
	    }
	    final Player Jogador = (Player)Evento.getWhoClicked();
	    if (Utills.MacroClicks.containsKey(Jogador))
	    	Utills.MacroClicks.put(Jogador, Integer.valueOf(Integer.valueOf(((Integer)Utills.MacroClicks.get(Jogador)).intValue()).intValue() + 1));
	    else {
	    	Utills.MacroClicks.put(Jogador, Integer.valueOf(1));
	    }
	    if (Utills.ClicksMacro.containsKey(Jogador))
	    	Utills.ClicksMacro.put(Jogador, Integer.valueOf(Integer.valueOf(((Integer)Utills.ClicksMacro.get(Jogador)).intValue()).intValue() + 1));
	    else {
	    	Utills.ClicksMacro.put(Jogador, Integer.valueOf(1));
	    }
	    Utills.Hack MacroTalvez = Utills.Hack.MACROTALVEZ;
	    Utills.Hack MacroProvavelmente = Utills.Hack.MACROPROVAVELMENTE;
	    Utills.Hack MacroDefinitivamente = Utills.Hack.MACRODEFINITIVAMENTE;
	    new BukkitRunnable() {
			
			@Override
			public void run() {
				Utills.ClicksMacro.remove(Jogador);
				Utills.MacroClicks.remove(Jogador);	
			}
		}.runTaskLater(Main.getPlugin(), 20L);
	    if (((Integer)Utills.MacroClicks.get(Jogador)).intValue() >= 45) {
	    	Utills.Macro = MacroTalvez.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosMacro.get(Jogador) + "").replace("clicks", Utills.ClicksMacro.get(Jogador) + "");
	    
	    	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
	    		public void run() {
	    			if (Utills.Macro != null) {
	    				Utills.AvisosMacro.put(Jogador, Integer.valueOf(Utills.AvisosMacro.get(Jogador) + 1));
	    				Utills.sendAntiCheat(Utills.Macro);
	    			}
	    			if (Utills.MacroClicks.containsKey(Jogador)) {
	    				Utills.MacroClicks.remove(Jogador);
	    			}
	    			Utills.Macro = null;
	    			Utills.ClicksMacro.put(Jogador, Integer.valueOf(0));
	    		}
	    	}
	    	, 20L);
	    }
	    if (((Integer)Utills.MacroClicks.get(Jogador)).intValue() >= 55) {
	    	Utills.Macro = MacroProvavelmente.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosMacro.get(Jogador) + "").replace("clicks", Utills.ClicksMacro.get(Jogador) + "");
	    
	    	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
	    		public void run() {
	    			if (Utills.Macro != null) {
	    				Utills.AvisosMacro.put(Jogador, Integer.valueOf(Utills.AvisosMacro.get(Jogador) + 1));
	    				Utills.sendAntiCheat(Utills.Macro);
	    			}
	    			if (Utills.MacroClicks.containsKey(Jogador)) {
	    				Utills.MacroClicks.remove(Jogador);
	    			}
	    			Utills.Macro = null;
	    			Utills.ClicksMacro.put(Jogador, Integer.valueOf(0));
	    		}
	    	}
	    	, 20L);
	    }
	    if (((Integer)Utills.MacroClicks.get(Jogador)).intValue() >= 65) {
	    	Utills.Macro = MacroDefinitivamente.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosMacro.get(Jogador) + "").replace("clicks", Utills.ClicksMacro.get(Jogador) + "");
	    
	    	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
	    		public void run() {
	    			if (Utills.Macro != null) {
	    				Utills.AvisosMacro.put(Jogador, Integer.valueOf(Utills.AvisosMacro.get(Jogador) + 1));
	    				Utills.sendAntiCheat(Utills.Macro);
	    			}
	    			if (Utills.MacroClicks.containsKey(Jogador)) {
	    				Utills.MacroClicks.remove(Jogador);
	    			}
	    			Utills.Macro = null;
	    			Utills.ClicksMacro.put(Jogador, Integer.valueOf(0));
	    		}
	    	}
	    	, 20L);
	    }
	}
}
