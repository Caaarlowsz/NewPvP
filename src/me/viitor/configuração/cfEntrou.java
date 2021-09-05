package me.viitor.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class cfEntrou {

	private static FileConfiguration player_status;
	private static File playerstatus;
	
	public static void setarConfig(Plugin plugin){
		
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		playerstatus = new File(plugin.getDataFolder(), "playersoriginal.yml");
		if(playerstatus.exists()){
			try{
				playerstatus.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		player_status = YamlConfiguration.loadConfiguration(playerstatus);
	}
	public static FileConfiguration pegarconfig(){
		return player_status;
	}
	public static void salvarconfiguracao(){
		try{
			player_status.save(playerstatus);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private static FileConfiguration player_status1;
	private static File playerstatus1;
	
	public static void setarConfig1(Plugin plugin){
		
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		playerstatus1 = new File(plugin.getDataFolder(), "playerspiratas.yml");
		if(playerstatus1.exists()){
			try{
				playerstatus1.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		player_status1 = YamlConfiguration.loadConfiguration(playerstatus1);
	}
	public static FileConfiguration pegarconfig1(){
		return player_status1;
	}
	public static void salvarconfiguracao1(){
		try{
			player_status1.save(playerstatus1);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
