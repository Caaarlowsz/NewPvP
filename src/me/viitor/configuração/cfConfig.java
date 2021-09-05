package me.viitor.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class cfConfig {

	private static FileConfiguration config_player;
	private static File configplayer;
	
	public static void setarConfig(Plugin plugin){
		
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		configplayer = new File(plugin.getDataFolder(), "configuraçao.yml");
		if(configplayer.exists()){
			try{
				configplayer.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		config_player = YamlConfiguration.loadConfiguration(configplayer);
	}
	public static FileConfiguration pegarconfig(){
		return config_player;
	}
	public static void salvarconfiguracao(){
		try{
			config_player.save(configplayer);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}