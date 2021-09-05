package me.viitor.anticheat.hacks;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.viitor.anticheat.Utills;

public class ForceField implements Listener{

	@EventHandler
	private void onEntityDamageByEntityEvent(EntityDamageByEntityEvent Evento) {
		if (!(Evento.getDamager() instanceof Player)) {
			return;
		}
		if (!(Evento.getEntity() instanceof LivingEntity)) {
			return;
		}
		Player Jogador = (Player)Evento.getDamager();
	    Utills.Hack ForcefieldTalvez = Utills.Hack.FORCEFIELDTALVEZ;
	    Utills.Hack ForcefieldProvavelmente = Utills.Hack.FORCEFIELDPROVAVELMENTE;
	    Utills.Hack ForcefieldDefinitivamente = Utills.Hack.FORCEFIELDDEFINITIVAMENTE;
	    if (((Evento.getEntity() instanceof LivingEntity)) && ((Evento.getDamager() instanceof Player))) {
	    	if (Evento.getEntity().getLocation().distance(Jogador.getLocation()) > 6.7D) {
	    		Utills.Forcefield = ForcefieldDefinitivamente.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosForcefield.get(Jogador) + "");
	    		if (Utills.Forcefield != null) {
	    			Utills.AvisosForcefield.put(Jogador, Integer.valueOf(Utills.AvisosForcefield.get(Jogador) + 1));
	    			Utills.sendAntiCheat(Utills.Forcefield);
	    		}
	    		Utills.Forcefield = null;
	    	}
	    	else if (Evento.getEntity().getLocation().distance(Jogador.getLocation()) > 6.5D) {
	    		Utills.Forcefield = ForcefieldProvavelmente.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosForcefield.get(Jogador) + "");
	    		if (Utills.Forcefield != null) {
	    			Utills.AvisosForcefield.put(Jogador, Integer.valueOf(Utills.AvisosForcefield.get(Jogador) + 1));
	    			Utills.sendAntiCheat(Utills.Forcefield);
	    		}
	    		Utills.Forcefield = null;
	    	}
	    	else if (Evento.getEntity().getLocation().distance(Jogador.getLocation()) > 6.0D) {
	    		Utills.Forcefield = ForcefieldTalvez.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosForcefield.get(Jogador) + "");
	    		if (Utills.Forcefield != null) {
	    			Utills.AvisosForcefield.put(Jogador, Integer.valueOf(Utills.AvisosForcefield.get(Jogador) + 1));
	    			Utills.sendAntiCheat(Utills.Forcefield);
	    		}
	    		Utills.Forcefield = null;
	    	}
	    }
	}
}
