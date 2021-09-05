package me.viitor.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class WarpsConfig {

public class Warps {
}
	public static WarpsConfig pasta = new WarpsConfig();
	FileConfiguration Warps;
	File FileWarps;
	public static WarpsConfig getConfig(){
		return pasta;
	}
	public void ConfigEnable(Plugin plugin){
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		FileWarps = new File(plugin.getDataFolder(), "warps.yml");
		if(FileWarps.exists()){
			try{
				FileWarps.createNewFile();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
		Warps = YamlConfiguration.loadConfiguration(FileWarps);
	}
	public FileConfiguration config(){
		return Warps;
	}
	public void saveConfigs(){
		try{
			Warps.save(FileWarps);
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
