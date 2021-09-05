package me.viitor.configuração;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.viitor.API.TopKillStreak;
import me.viitor.main.Main;
import me.viitor.scoreboard.sScoreAPI;

public class cfStatus {
	
	public static File file;
	public static FileConfiguration cfile;
	
	public cfStatus() {
		Plugin plugin = Main.getPlugin();
		
		if (plugin.getDataFolder().exists() == false) {
			plugin.getDataFolder().mkdir();
		}
		file = new File(plugin.getDataFolder(), "playersstatus.yml");
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		cfile = YamlConfiguration.loadConfiguration(file);
	}
	
	public static void FirstJoin(Player jogador) {
		if (cfile.getString(jogador.getName() + ".UUID") == null) {
			cfile.set(jogador.getName() + ".UUID", jogador.getUniqueId().toString());
			cfile.set(jogador.getName() + ".Kills", 0);
			cfile.set(jogador.getName() + ".Deaths", 0);
			cfile.set(jogador.getName() + ".Money", 0);
			cfile.set(jogador.getName() + ".XP", 0);
			Save();
		}
	}
	
	public static void setKills(Player p) {
        cfile.set(p.getName() + ".Kills", getKills(p) + 1);
        cfile.set(p.getName() + ".Ks", getKillStreak(p) + 1);
        TopKillStreak.Ks.put(p, Integer.valueOf(TopKillStreak.Ks.get(p) + 1));
        Save();
    }
	public static void addKills(Player p, String valor) {
        cfile.set(p.getName() + ".Kills", getKills(p) + valor);
        Save();
    }
	public static void setKillsCmd(Player p, String valor) {
        cfile.set(p.getName() + ".Kills", valor);
        Save();
    }
	
	public static int getKills(Player p) {
        return cfile.getInt(p.getName() + ".Kills");
    }
	
	public static int getKillsOff(OfflinePlayer off) {
		return cfile.getInt(off.getName() + ".Kills");
	}
	
	public static int getKillStreak(Player p) {
        return cfile.getInt(p.getName() + ".Ks");
    }
   
    public static void setDeaths(Player p) {
        cfile.set(p.getName() + ".Deaths", getDeaths(p) + 1);
        Save();
    }
    public static void addDeaths(Player p, double valor) {
        cfile.set(p.getName() + ".Deaths", valor);
        Save();
    }
    public static void setDeathsCmd(Player p, double valor) {
        cfile.set(p.getName() + ".Deaths", getDeaths(p) + valor);
        Save();
    }
    
    public static int getDeaths(Player p) {
        return cfile.getInt(p.getName() + ".Deaths");
    }
   
    public static void setMoney(Player p, int Money) {
        cfile.set(p.getName() + ".Money", getMoney(p) + Money);
        Save();
    }
    public static int getXp(Player p) {
    	return cfile.getInt(p.getName() + ".XP");
    }
    public static void setXP(Player p, int Xp) {
        cfile.set(p.getName() + ".Money", Xp);
        Save();
    }
    public static void addXP(Player p, int Xp) {
        cfile.set(p.getName() + ".Money", getXp(p) + Xp);
        Save();
    }
    public static void removeXp(Player p, int Xp) {
    	cfile.set(p.getName() + ".XP", getXp(p) - Xp);
    }
    public static void addMoney(Player p, double Money) {
        cfile.set(p.getName() + ".Money", getMoney(p) + Money);
        Save();
    }
    public static void setMoneyCmd(Player p, double Money) {
        cfile.set(p.getName() + ".Money", getMoney(p) + Money);
        Save();
    }
   
    public static void RemoveMoney(Player p, int Money) {
        if (getMoney(p) <= 0) {
            return;
        }
        cfile.set(p.getName() + ".Money", getMoney(p) - Money);
        Save();
    }
    
	public static void RemoverKS(Player p) {
        cfile.set(p.getName() + ".Ks", getKillStreak(p) - getKillStreak(p));
        
    	TopKillStreak.Ks.put(p, Integer.valueOf(0));
    	for (Player players : Bukkit.getOnlinePlayers()) {
    		TopKillStreak.createTopKillStreak(players);
    		sScoreAPI.scoreboard(players);
    	}
        Save();
    }
   
    public static int getMoney(Player p) {
        return cfile.getInt(p.getName() + ".Money");
    }
    
    public static void Save() {
        try {
            cfile.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
