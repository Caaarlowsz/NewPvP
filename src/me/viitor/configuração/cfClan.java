package me.viitor.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class cfClan {
	
	private static FileConfiguration player_grupo;
	private static File playergrupo;
	
	public static void setarconfig(Plugin plugin){
		
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		playergrupo = new File(plugin.getDataFolder(), "clan.yml");
		if(playergrupo.exists()){
			try{
				playergrupo.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		player_grupo = YamlConfiguration.loadConfiguration(playergrupo);
	}
	public static FileConfiguration pegarclan(){
		return player_grupo;
	}
	public static void salvarconfiguracao(){
		try{
			player_grupo.save(playergrupo);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static boolean pegarClan(Player p, String Clan){
		if(pegarclan().get("clan."  + p.getUniqueId() + ".Clan").equals(Clan)){
			return true;
		}else{
			return false;
		}
	}
	public static boolean pegarPrefix(Player p, String Prefix){
		if(pegarclan().get("clan."  + p.getUniqueId() + ".Prefix").equals(Prefix)){
			return true;
		}else{
			return false;
		}
	}
	public static void setarClan(Player p, String Clan, String Prefix){
		
		pegarclan().set("clan." + p.getUniqueId() + ".Nick", p.getName());
		pegarclan().set("clan." + p.getUniqueId() + ".Clan", Clan);
		pegarclan().set("clan." + p.getUniqueId() + ".Prefix", Prefix);
		cfClan.salvarconfiguracao();
	}
}
