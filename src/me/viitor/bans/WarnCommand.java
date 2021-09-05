package me.viitor.bans;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.viitor.API.HorarioAPI;
import me.viitor.configuração.cfGrupo;
import me.viitor.main.Main;

public class WarnCommand implements CommandExecutor {
	
	public static HashMap<Player, String> Aviso = new HashMap<Player, String>();
	
	public static FileConfiguration kAvisos;
	public static File Avisos;
	
	public WarnCommand() {
		Plugin plugin = Main.getPlugin();
		
		if (plugin.getDataFolder().exists() == false) {
			plugin.getDataFolder().mkdir();
		}
		Avisos = new File(plugin.getDataFolder(), "playersstatus.yml");
		if (Avisos.exists() == false) {
			try {
				Avisos.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		kAvisos = YamlConfiguration.loadConfiguration(Avisos);
	}
	
    public static void Save() {
        try {
            kAvisos.save(Avisos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("aviso")) {
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+"))))))))){
				API.sendMsg(p, "§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /aviso <Jogador> <Aviso>");
				return true;
			}
			Player aviso = Bukkit.getPlayer(args[0]);
			if(aviso == null) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7O jogador §6" + args[0] + " §7encontra-se §6§lOFFLINE");
				return true;
			}
			if(aviso.getName() == p.getName()) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao pode se avisar");
				return true;
			}
			String motivo = "";
			for(int i = 1; i < args.length; i++) {
				motivo = motivo + args[i] + " ";
			}
			if(Aviso.get(aviso) == "0") {
				Aviso.put(aviso, "1");
				double l = kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("§c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo + "(1/3)");
				API.sendMsg(p, "§aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(1/3)");
				API.sendStaff("§7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName() + " pelo motivo " + motivo + "(1/3)");
				API.sendMsg(aviso, "§cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(1/3");
				kAvisos.set("Jogadores advertidos", Double.valueOf(l + 1.0D));
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", aviso.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", p.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", motivo);
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento", HorarioAPI.getHorario());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", "1");
				Save();
			}
			else if(Aviso.get(aviso) == "1") {
				Aviso.put(aviso, "2");
				double l = kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("§c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo + "(2/3)");
				API.sendMsg(p, "§aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(2/3)");
				API.sendStaff("§7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName() + " pelo motivo " + motivo + "(2/3)");
				API.sendMsg(aviso, "§cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(2/3");
				kAvisos.set("Jogadores advertidos", Double.valueOf(l + 1.0D));
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", aviso.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", p.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", motivo);
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento", HorarioAPI.getHorario());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", "2");
				Save();
			}
			else if(Aviso.get(aviso) == "2") {
				Aviso.put(aviso, "3");
				double l = kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("§c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo + "(3/3)");
				API.sendMsg(p, "§aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(3/3)");
				API.sendStaff("§7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName() + " pelo motivo " + motivo + "(3/3)");
				API.sendMsg(aviso, "§cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(3/3");
				kAvisos.set("Jogadores advertidos", Double.valueOf(l + 1.0D));
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", aviso.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", p.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", motivo);
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento", HorarioAPI.getHorario());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", "3");
				Save();
			}
			else if(Aviso.get(aviso) == "3") {
				Aviso.put(aviso, "4");
				double l = kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("§c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo + "(4/3)");
				API.sendMsg(p, "§aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(4/3)");
				API.sendStaff("§7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName() + " pelo motivo " + motivo + "(4/3)");
				API.sendMsg(aviso, "§cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(4/3");
				
				kAvisos.set("Jogadores advertidos", Double.valueOf(l + 1.0D));
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", aviso.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", p.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", motivo);
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento", HorarioAPI.getHorario());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", "3");
				Save();
				
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
					
					@Override
					public void run() {
						API.sendBC("§c" + aviso.getName() + " foi kickado do servidor por exceder o numero maximo de avisos (4/3)");
						API.sendMsg(p, "§aO jogador " + p.getName() + " foi kickado do servidor por exceder o numero maximo de avisos (4/3)");
						API.sendStaff("§7O jogador " + aviso.getName() + " foi kickado do servidor por exceder o numero maximo de avisos (4/3)");
						aviso.kickPlayer("§cVoce foi §c§nkickado§c do servidor." + "\n" + "§cJogador kickado: " + aviso.getName() + "\n" + "§cKickado por: " + p.getName() + "\n" + "§cMotivo: Exceder o numero maximo de avisos (4/3)");
					}
				}, 20L);
			}
			else if(Aviso.get(aviso) == "4") {
				Aviso.put(aviso, "5");
				double l = kAvisos.getDouble("Jogadores advertidos");
				API.sendBC("§c" + aviso.getName() + " recebeu uma advertencia de " + p.getName() + " por " + motivo + "(5/3)");
				API.sendMsg(p, "§aVoce deu uma advertencia a " + aviso.getName() + " por " + motivo + "(5/3)");
				API.sendStaff("§7O staffer " + p.getName() + " deu uma advertencia ao jogador " + aviso.getName() + " pelo motivo " + motivo + "(5/3)");
				API.sendMsg(aviso, "§cVoce recebeu uma advertencia de " + p.getName() + " por " + motivo + "(5/3");
				
				kAvisos.set("Jogadores advertidos", Double.valueOf(l + 1.0D));
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Nome", aviso.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Advertido por", p.getName());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Motivo", motivo);
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Data do advertimento", HorarioAPI.getHorario());
				kAvisos.set("Advertencias." + aviso.getUniqueId() + ".Avisos", "3");
				Save();
				
				Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
					
					@Override
					public void run() {
						API.sendBC("§c" + aviso.getName() + " foi banido temporariamente do servidor por exceder o numero maximo de avisos (5/3)");
						API.sendMsg(p, "§aO jogador " + p.getName() + " foi banido temporariamente do servidor por exceder o numero maximo de avisos (5/3)");
						API.sendStaff("§7O jogador " + aviso.getName() + " foi banido temporariamente do servidor por exceder o numero maximo de avisos (5/3)");
						aviso.kickPlayer( "§cVoce foi §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + aviso.getName() + "\n" + "§cBanido por: " + p.getName() + "\n" + "§cMotivo: Exceder o numero maximo de avisos (5/3)" + "\n" + "§cDuracao do banimento: 1 dia" + "\n" + "Data do banimento: " + HorarioAPI.getHorario() + "\n" + "§cVenda de UNBANS em: §c§nloja.cakekits.tk" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@CakeKitsMC§c)");
						
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Nome", aviso.getName());
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Banido por", p.getName());
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Motivo", "Exceder o numero maximo de avisos (5/3)");
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Tempo do Ban", "1 dia");
						Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId() + ".Data do banimento", HorarioAPI.getHorario());
						Config.getConfig().saveTempBans();
						
						Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, new Runnable() {
							
							@Override
							public void run() {
								if (Config.getConfig().getTempBans().get("TempBans." + aviso.getUniqueId()) != null) {
									Config.getConfig().getTempBans().set("TempBans." + aviso.getUniqueId(), null);
									kAvisos.set("Advertencias." + aviso.getUniqueId(), null);
									Aviso.put(aviso, "0");
									Config.getConfig().saveTempBans();
									API.sendBC("§cO jogador " +  aviso.getName() +  " foi desbanido automaticamente");
									API.sendStaff("§7O jogador " + aviso.getName() + " foi desbanido automaticamente");
								}
							}
						}, 1728000L);
					}
				}, 20L);
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /aviso <Jogador> <Aviso>");
				return true;
			}
		}
		return false;
	}
}
