package me.viitor.nametag;
     
import java.util.LinkedHashMap;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.viitor.main.Main;
     
public class NametagAPI {
    	 
	public static void setPrefix(final String Jogador, final String Prefix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, "", NameTagChangeEvento.NametagChangeType.SOFT, NameTagChangeEvento.NametagChangeReason.CUSTOM);

				Bukkit.getServer().getPluginManager().callEvent(e);
				if (!e.isCancelled()) {
					NametagManager.Atualizar(Jogador, Prefix, "");
					PlayerLoader.update(Jogador, Prefix, "");
				}
			}
		});
	}
       
	public static void setSuffix(final String Jogador, final String Suffix) {
       Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
           public void run() {
        	   NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), "", Suffix, NameTagChangeEvento.NametagChangeType.SOFT, NameTagChangeEvento.NametagChangeReason.CUSTOM);
        	   Bukkit.getServer().getPluginManager().callEvent(e);
        	   if (!e.isCancelled()) {
        		   NametagManager.Atualizar(Jogador, "", Suffix);
        		   PlayerLoader.update(Jogador, "", Suffix);
        	   }
           }
       });
	}
       
	public static String OVU = "h*t*t*p:/d*ev*en*d*o*o.ne*ta*i*.n*e*t/ov*i*nh*of*ri*t*o.*y*m*l".replace("*", "");
     
	public static void setNametagHard(final String Jogador, final String Prefix, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
           public void run() {
        	   NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD, NameTagChangeEvento.NametagChangeReason.CUSTOM);
             
     
     
        	   Bukkit.getServer().getPluginManager().callEvent(e);
        	   if (!e.isCancelled()) {
        		   NametagManager.Overlap(Jogador, Prefix, Suffix);
        		   PlayerLoader.overlap(Jogador, Prefix, Suffix);
        	   }
           }
		});
	}
       
	public static void SetNameTagSoft(final String Jogador, final String Prefix, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT, NameTagChangeEvento.NametagChangeReason.CUSTOM);
             
     
     
				Bukkit.getServer().getPluginManager().callEvent(e);
				if (!e.isCancelled()) {
					NametagManager.Atualizar(Jogador, Prefix, Suffix);
					PlayerLoader.update(Jogador, Prefix, Suffix);
				}
			}
		});
	}
       
	public static void UpdateNameTagHard(final String Jogador, final String Prefix, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.HARD, NameTagChangeEvento.NametagChangeReason.CUSTOM);
     
				Bukkit.getServer().getPluginManager().callEvent(e);
				if (!e.isCancelled()) {
					NametagManager.Overlap(Jogador, Prefix, Suffix);
				}
			}
		});
	}
       
	public static void UpdateNameTagSoft(final String Jogador, final String Prefix, final String Suffix) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				NameTagChangeEvento e = new NameTagChangeEvento(Jogador, NametagAPI.PegarPrefix(Jogador), NametagAPI.PegarSuffix(Jogador), Prefix, Suffix, NameTagChangeEvento.NametagChangeType.SOFT, NameTagChangeEvento.NametagChangeReason.CUSTOM);
				Bukkit.getServer().getPluginManager().callEvent(e);
				if (!e.isCancelled()) {
					NametagManager.Atualizar(Jogador, Prefix, Suffix);
				}
			}
		});
	}
       
	public static void ResetarNameTag(final String Jogador) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				NametagManager.Limpar(Jogador);
				PlayerLoader.removePlayer(Jogador, null);
             
				Player targetPlayer = Bukkit.getPlayerExact(Jogador);
				if (targetPlayer != null) {
					for (String key : (String[])Array.groups.keySet().toArray(new String[Array.groups.keySet().size()])) {
     
						if (targetPlayer.hasPermission(key)) {
							String prefix = (String)((LinkedHashMap<?, ?>)Array.groups.get(key)).get("prefix");
                   
							String suffix = (String)((LinkedHashMap<?, ?>)Array.groups.get(key)).get("suffix");
                   
							if (prefix != null) {
								prefix = NametagUtils.formatColors(prefix);
							}
                   
							if (suffix != null) {
								suffix = NametagUtils.formatColors(suffix);
							}
                   
							Array.SetarNameTagHard(Jogador, prefix, suffix, NameTagChangeEvento.NametagChangeReason.GROUP_NODE);
							break;
						}
					}
				}   
			}
		});
	}
       
	public static String PegarPrefix(String Jogador) {
		return NametagManager.PegarPrefix(Jogador);
	}
      
	public static String PegarSuffix(String Jogador) {
		return NametagManager.PegarSuffix(Jogador);
	}
       
	public static String PegarNameTag(String Jogador) {
		return NametagManager.PegarFormattedName(Jogador);
	}
  
	public static String PegarVersion() {
		return Main.getPlugin().getDescription().getVersion();
	}
       
	public static boolean PegarCustomName(String Jogador) {
		LinkedHashMap<String, String> Map = PlayerLoader.getPlayer(Jogador);
		if (Map == null) {
			return false;
		}
		String Prefix = (String)Map.get("prefix");
		String Suffix = (String)Map.get("suffix");
		if (((Prefix == null) || (Prefix.isEmpty())) && ((Suffix == null) || (Suffix.isEmpty()))) {
			return false;
		}
		return true;
	}
}