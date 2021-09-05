package me.viitor.auth;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.viitor.API.HorarioAPI;
import me.viitor.main.Main;

public class Auth {
	
	public static ArrayList<Player> login = new ArrayList<>();
	
	public static FileConfiguration kAuth;
	public static File Auth;
	
	public Auth() {
		Plugin plugin = Main.getPlugin();
		
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		Auth = new File(plugin.getDataFolder(), "Auth.yml");
		if(Auth.exists()) {
			try {
				Auth.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kAuth = YamlConfiguration.loadConfiguration(Auth);
	}
	
	public static boolean checarRegistro(Player p) {
		return kAuth.get("Jogadores." + p.getName()) != null;
	}
	
	public static String pegarSenha(Player p) {
		return kAuth.getString("Jogadores." + p.getName() + ".Senha");
	}
	
	public static void registrar(Player p, String senha) {
		double l = kAuth.getDouble("Jogadores registrados");
		kAuth.set("Jogadores registrados", l + Double.valueOf(1.0D));
		kAuth.set("Jogadores." + p.getName() + ".UUID", p.getUniqueId().toString());
		kAuth.set("Jogadores." + p.getName() + ".Senha", senha);
		kAuth.set("Jogadores." + p.getName() + ".Data de registro", HorarioAPI.getHorario());
		save();
	}
	
	public static void unregistrar(Player p) {
		double l = kAuth.getDouble("Jogadores registrados");
		kAuth.set("Jogadores registrados", l - Double.valueOf(1.0D));
		kAuth.set("Jogadores." + p.getName(), null);
		save();
	}
	
	public static void save() {
		try {
			kAuth.save(Auth);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
