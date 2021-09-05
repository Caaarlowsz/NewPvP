package me.viitor.bans;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;
public class API {
	
	public static ArrayList<Player> Online = new ArrayList<Player>();
	public static ArrayList<Player> Combate = new ArrayList<Player>();
	public static ArrayList<Player> ScoreBoard = new ArrayList<Player>();
	public static ArrayList<Player> ModoSilent = new ArrayList<Player>();
	public static ArrayList<Player> ModoAdmin = new ArrayList<Player>();
	
	public static boolean FeastSpawn;
	public static int FeastSpawnTime = 300;

	public static String CMD = "comando.";
	public static String TAG = "api.tag.";
	public static String VERCMDS = "api.ver.cmds";
	public static String ENTRARFULL = "api.entrar.full";
	public static String VERADMINS = "api.ver.admin";
	
	public static void sendMsg(CommandSender jogador, String Msg) {
		
		jogador.sendMessage(Msg);
	}
	
	public static void sendBC(String Msg) {
		
		Bukkit.broadcastMessage(Msg);
	}
	public static void clearChat(Player p) {
		for(int i = 1; i < 100; i++) {
			p.sendMessage(" ");
		}
	}
	public static void sendSound(Player jogador, Sound som, int time) {
		
		jogador.playSound(jogador.getLocation(), som, time, time);
	}
	public static void sendEnchant(Player jogador, Enchantment encantamento, int level) {
		
		jogador.getItemInHand().addUnsafeEnchantment(encantamento, level);
		
	}
	
	public static void feastSpawnMin(int timer) {

		sendBC(ChatColor.GRAY + "O Feast spawnara em " + ChatColor.RED + ChatColor.BOLD + timer + ChatColor.GRAY + " minuto(s)" + ChatColor.GRAY + "!" );
	}
	public static void feastSpawnSeg(int timer) {
	
		sendBC(ChatColor.GRAY + "O Feast spawnara em " + ChatColor.RED + ChatColor.BOLD + timer + ChatColor.GRAY + " segundo(s)" + ChatColor.GRAY + "!" );
	}
	
	public static String getFormato(int number)  {
	    int ms = number / 60;
	    int ss = number % 60;
	    String m = (ms < 10 ? "0" : "") + ms;
	    String s = (ss < 10 ? "0" : "") + ss;
	    String f = m + "m " + s + "s";
	    return f;
	}
	
	
	public static void sendStaff(String Msg) {
		
		for (Player jogadores : Bukkit.getOnlinePlayers()) {
			if (cfGrupo.ChecarGrupo(jogadores, "Dono") || cfGrupo.ChecarGrupo(jogadores, "Gerente") || cfGrupo.ChecarGrupo(jogadores, "Admin") || cfGrupo.ChecarGrupo(jogadores, "Mod+") || cfGrupo.ChecarGrupo(jogadores, "Mod") || cfGrupo.ChecarGrupo(jogadores, "Trial")) {
					sendMsg(jogadores, Msg);
				}
			}
	}
}
