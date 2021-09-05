package me.viitor.rdmautomatica;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Configuração {

	private static FileConfiguration Evento;
	private static File EventoFile;
	
	public static void getConfig(Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
	    }
		EventoFile = new File(plugin.getDataFolder(), "Evento.yml");
	    if (EventoFile.exists()) {
	    	try {
	    		EventoFile.createNewFile();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }
	    Evento = YamlConfiguration.loadConfiguration(EventoFile);
	    
	}
	public static FileConfiguration getEvento() {
		return Evento;
	}
 	public static void salvarConfig() {
		try {
			Evento.save(EventoFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
