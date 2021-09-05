package me.viitor.anticheat.hacks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import me.viitor.anticheat.Utills;
import me.viitor.main.Main;

public class FastClick implements Listener {

	@EventHandler
	private void onPlayerInteractEvent(PlayerInteractEvent Evento) {
		if (!(Evento.getPlayer() instanceof Player)) {
			return;
		}
		if (!Evento.getAction().name().contains("LEFT")) {
			return;
		}
		final Player Jogador = Evento.getPlayer();
		if (Utills.FastAttackClicks.containsKey(Jogador)) {
			Utills.FastAttackClicks.put(Jogador, Integer.valueOf(Integer.valueOf(((Integer)Utills.FastAttackClicks.get(Jogador)).intValue()).intValue() + 1));
		} else {
			Utills.FastAttackClicks.put(Jogador, Integer.valueOf(1));
		}
		if (Utills.ClicksFastClicks.containsKey(Jogador)) {
			Utills.ClicksFastClicks.put(Jogador, Integer.valueOf(Integer.valueOf(((Integer)Utills.ClicksFastClicks.get(Jogador)).intValue()).intValue() + 1));
		} else {
			Utills.ClicksFastClicks.put(Jogador, Integer.valueOf(1));
		}
		Utills.Hack FastClickTalvez = Utills.Hack.FASTCLICKTALVEZ;
		Utills.Hack FastClickProvelmente = Utills.Hack.FASTCLICKPROVAVELMENTE;
		Utills.Hack FastClickDefinitimante = Utills.Hack.FASTCLICKDEFINITIVAMENTE;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				Utills.ClicksFastClicks.remove(Jogador);
				Utills.FastAttackClicks.remove(Jogador);	
			}
		}.runTaskLater(Main.getPlugin(), 20L);
		if (((Integer)Utills.FastAttackClicks.get(Jogador)).intValue() >= 50) {
			Utills.FastAttack = FastClickTalvez.getMenssagem().replace("nick", Jogador.getName().toString()).replace("avisos", Utills.AvisosFastClick.get(Jogador) + "").replace("clicks", Utills.ClicksFastClicks.get(Jogador) + "");
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					if (Utills.FastAttackClicks.containsKey(Jogador)) {
						Utills.FastAttackClicks.remove(Jogador);
					}
					if (Utills.FastAttack != null) {
						Utills.AvisosFastClick.put(Jogador, Integer.valueOf(Utills.AvisosFastClick.get(Jogador) + 1));
						Utills.sendAntiCheat(Utills.FastAttack);
					}
					Utills.FastAttack = null;
					Utills.ClicksFastClicks.remove(Jogador);
					Utills.FastAttackClicks.remove(Jogador);
				}
			}
			, 20L);
		}
		if (((Integer)Utills.FastAttackClicks.get(Jogador)).intValue() >= 60) {
			Utills.FastAttack = FastClickProvelmente.getMenssagem().replace("nick", Jogador.getName().toString()).replace("avisos", Utills.AvisosFastClick.get(Jogador) + "").replace("clicks", Utills.ClicksFastClicks.get(Jogador) + "");
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					if (Utills.FastAttackClicks.containsKey(Jogador)) {
						Utills.FastAttackClicks.remove(Jogador);
					}
					if (Utills.FastAttack != null) {
						Utills.AvisosFastClick.put(Jogador, Integer.valueOf(Utills.AvisosFastClick.get(Jogador) + 1));
						Utills.sendAntiCheat(Utills.FastAttack);
					}
					Utills.FastAttack = null;
					Utills.ClicksFastClicks.remove(Jogador);
					Utills.FastAttackClicks.remove(Jogador);
				}
			}
			, 20L);
		}
		if (((Integer)Utills.FastAttackClicks.get(Jogador)).intValue() >= 80) {
			Utills.FastAttack = FastClickDefinitimante.getMenssagem().replace("nick", Jogador.getName().toString()).replace("avisos", Utills.AvisosFastClick.get(Jogador) + "").replace("clicks", Utills.ClicksFastClicks.get(Jogador) + "");
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					if (Utills.FastAttackClicks.containsKey(Jogador)) {
						Utills.FastAttackClicks.remove(Jogador);
					}
					if (Utills.FastAttack != null) {
						Utills.AvisosFastClick.put(Jogador, Integer.valueOf(Utills.AvisosFastClick.get(Jogador) + 1));
						Utills.sendAntiCheat(Utills.FastAttack);
					}
					Utills.ClicksFastClicks.remove(Jogador);
					Utills.FastAttackClicks.remove(Jogador);
				}
			}
			, 20L);
		}
	}
}
