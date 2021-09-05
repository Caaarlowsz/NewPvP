package me.viitor.bans;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {

	public static Config Config = new Config();
	
	FileConfiguration kStats;
	File Stats;
	
	FileConfiguration kDamageCoins;
	File DamageCoins;
	
	FileConfiguration kRanks;
	File Ranks;
	
	FileConfiguration kBans;
	File Bans;
	
	FileConfiguration kIpBans;
	File IpBans;
	
	public FileConfiguration kTempBans;
	File TempBans;
	
	FileConfiguration kMute;
	File Mute;
	
	public FileConfiguration kTempMute;
	File TempMute;
	
	FileConfiguration kFeast;
	File Feast;
	
	FileConfiguration kTroll;
	File Troll;
	
	FileConfiguration kJogadores;
	File Jogadores;
	
	FileConfiguration kAuth;
	File auth;
	
	FileConfiguration kManutencao;
	File Manutencao;
	
	public static Config getConfig() {
		return Config;
	}
	
	public void setupConfig(Plugin plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		Stats = new File(plugin.getDataFolder(), "Status.yml");
		
		if (Stats.exists()) {
			try {
				Stats.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kStats = YamlConfiguration.loadConfiguration(Stats);
		
		DamageCoins = new File(plugin.getDataFolder(), "DamageCoins.yml");
		
		if (DamageCoins.exists()) {
			try {
				DamageCoins.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kDamageCoins = YamlConfiguration.loadConfiguration(DamageCoins);
		
		Ranks = new File(plugin.getDataFolder(), "Ranks.yml");
		
		if (Ranks.exists()) {
			try {
				Ranks.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kRanks = YamlConfiguration.loadConfiguration(Ranks);
		
		Bans = new File(plugin.getDataFolder(), "Bans.yml");
		
		if (Bans.exists()) {
			try {
				Bans.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kBans = YamlConfiguration.loadConfiguration(Bans);
		
		TempBans = new File(plugin.getDataFolder(), "TempBans.yml");
		
		if (TempBans.exists()) {
			try {
				TempBans.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kTempBans = YamlConfiguration.loadConfiguration(TempBans);
		
		Mute = new File(plugin.getDataFolder(), "Mute.yml");
		
		if (Mute.exists()) {
			try {
				Mute.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kMute = YamlConfiguration.loadConfiguration(Mute);
		
		TempMute = new File(plugin.getDataFolder(), "TempMute.yml");
		
		if (TempMute.exists()) {
			try {
				TempMute.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kTempMute = YamlConfiguration.loadConfiguration(TempMute);
		
		IpBans = new File(plugin.getDataFolder(), "IpBans.yml");
		
		if (IpBans.exists()) {
			try {
				IpBans.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kIpBans = YamlConfiguration.loadConfiguration(IpBans);
		
		Feast = new File(plugin.getDataFolder(), "Feast.yml");
		
		if (Feast.exists()) {
			try {
				Feast.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kFeast = YamlConfiguration.loadConfiguration(Feast);
		
		Troll = new File(plugin.getDataFolder(), "Troll.yml");
		
		if (Troll.exists()) {
			try {
				Troll.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kTroll = YamlConfiguration.loadConfiguration(Troll);
		
		Jogadores = new File(plugin.getDataFolder(), "Jogadores.yml");
		
		if(Jogadores.exists()) {
			try {
				Jogadores.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kJogadores = YamlConfiguration.loadConfiguration(Jogadores);
		
		auth = new File(plugin.getDataFolder(), "auth.yml");
		
		if(auth.exists()) {
			try {
				auth.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kAuth = YamlConfiguration.loadConfiguration(auth);
		
		Manutencao = new File(plugin.getDataFolder(), "Manutencao.yml");
		
		if(Manutencao.exists()) {
			try {
				Manutencao.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		kManutencao = YamlConfiguration.loadConfiguration(Manutencao);
	}
	public FileConfiguration getStats() {
		return kStats;
	}
	public FileConfiguration getDC() {
		return kDamageCoins;
	}
	public FileConfiguration getRank() {
		return kRanks;
	}
	public FileConfiguration getBans() {
		return kBans;
	}
	public FileConfiguration getIpBans() {
		return kIpBans;
	}
	public FileConfiguration getTempBans() {
		return kTempBans;
	}
	public FileConfiguration getMute() {
		return kMute;
	}
	public FileConfiguration getTempMute() {
		return kTempMute;
	}
	public FileConfiguration getWarp() {
		return kFeast;
	}
	public FileConfiguration getTroll() {
		return kTroll;
	}
	public FileConfiguration getJogadores() {
		return kJogadores;
	}
	public FileConfiguration getAuth() {
		return kAuth;
	}
	public FileConfiguration getManutencao() {
		return kManutencao;
	}
	
	public void saveStats() {
		try {
			kStats.save(Stats);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveDamageCoins() {
		try {
			kDamageCoins.save(DamageCoins);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveRanks() {
		try {
			kRanks.save(Ranks);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveBans() {
		try {
			kBans.save(Bans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveTempBans() {
		try {
			kTempBans.save(TempBans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveMute() {
		try {
			kMute.save(Mute);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveTempMute() {
		try {
			kTempMute.save(TempMute);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveIpBans() {
		try {
			kIpBans.save(IpBans);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveFeast() {
		try {
			kFeast.save(Feast);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveTroll() {
		try {
			kTroll.save(Troll);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveJogadores() {
		try {
			kJogadores.save(Jogadores);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveAuth() {
		try {
			kAuth.save(auth);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void saveManutencao() {
		try {
			kManutencao.save(Manutencao);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
