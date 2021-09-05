package me.viitor.configuração;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.viitor.API.CalendarioAPI;
import me.viitor.API.CalendarioAPI.Calendario;

public class cfKitdiario {
	
	private static FileConfiguration playerkitdiario;
	private static File player_kitdiario;
	
	public static void setarconfig(Plugin plugin){
		
		if(!plugin.getDataFolder().exists()){
			plugin.getDataFolder().mkdir();
		}
		player_kitdiario = new File(plugin.getDataFolder(), "kitdiario.yml");
		if(player_kitdiario.exists()){
			try{
				player_kitdiario.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		playerkitdiario = YamlConfiguration.loadConfiguration(player_kitdiario);
	}
	public static FileConfiguration pegargrupo(){
		return playerkitdiario;
	}
	public static void salvarconfiguracao(){
		try{
			playerkitdiario.save(player_kitdiario);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void setarTempo(Player p, String Kit){
		
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".Nick", p.getName());
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".kit", Kit);
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".dia", CalendarioAPI.PegarCalendario(Calendario.Dia));
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".hora", CalendarioAPI.PegarCalendario(Calendario.Hora));
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".minuto", CalendarioAPI.PegarCalendario(Calendario.Minuto));
		pegargrupo().set("kitdiario." + p.getUniqueId() + ".segundos", CalendarioAPI.PegarCalendario(Calendario.Segundo));
		cfKitdiario.salvarconfiguracao();
	}
}
