package me.viitor.rdmautomatica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.viitor.API.API;
import me.viitor.API.CalendarioAPI;
import me.viitor.API.GrupoAPI;
import me.viitor.API.CalendarioAPI.Calendario;
import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfTempGrupo;
import me.viitor.invencivel.Proteção;
import me.viitor.main.Main;
import me.viitor.scoreboard.sScoreAPI;

public class PlayerAPI {

	public static ArrayList<Player> Participando = new ArrayList<Player>();
	public static ArrayList<Player> Batalhando = new ArrayList<Player>();
	public static ArrayList<Player> Esperando = new ArrayList<Player>();
	public static ArrayList<Player> NaoComandos = new ArrayList<Player>();
	
	private static ItemStack CriarItem(Player player, Material material, int quantia, short cor, String[] lore, String nome, int slot, int slotitem) {
		
		ItemStack item = new ItemStack(material, quantia, cor);
		ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		itemmeta.setLore(Arrays.asList(lore));
		item.setItemMeta(itemmeta);
		
		player.getInventory().setItem(slot, item);
		player.getInventory().setHeldItemSlot(slotitem);
		return item;
	}
	
	public static boolean RDM1;
	public static boolean RDM2;
	public static boolean RDM3;
	public static boolean RDM4;
	public static boolean RDM5;
	public static boolean RDM6;
	public static boolean RDM7;
	public static boolean RDM8;
	public static boolean RDM9;
	public static boolean RDM10;
	public static boolean RDM11;
	public static boolean RDM12;
	public static boolean RDM13;
	public static boolean RDM14;
	public static boolean RDM15;
	public static boolean RDM16;
	public static boolean RDM17;
	public static boolean RDM18;
	public static boolean RDM19;
	public static boolean RDM20;
	public static boolean RDM21;
	public static boolean RDM22;
	public static boolean RDM23;
	public static boolean RDM24;
	public static boolean RDM25;
	public static boolean RDM26;
	public static boolean RDM27;
	public static boolean RDM28;
	public static boolean RDM29;
	public static boolean RDM30;
	
	public static HashMap<Player, String> Ganhador = new HashMap<Player, String>();
	public static HashMap<Player, String> Batalhando1 = new HashMap<Player, String>();
	public static HashMap<Player, String> Batalhando2 = new HashMap<Player, String>();
	
	public static HashMap<Player, String> jogador1 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador2 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador3 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador4 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador5 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador6 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador7 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador8 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador9 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador10 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador11 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador12 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador13 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador14 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador15 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador16 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador17 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador18 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador19 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador20 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador21 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador22 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador23 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador24 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador25 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador26 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador27 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador28 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador29 = new HashMap<Player, String>();
	public static HashMap<Player, String> jogador30 = new HashMap<Player, String>();
	
	public static void LimparPlayers() {
		for (Player Jogadores : Bukkit.getOnlinePlayers()) {
			Ganhador.remove(Jogadores);
			Batalhando.remove(Jogadores);
			Batalhando1.remove(Jogadores);
			Batalhando2.remove(Jogadores);
			Esperando.remove(Jogadores);
			Participando.remove(Jogadores);
			jogador1.remove(Jogadores);
			jogador2.remove(Jogadores);
			jogador3.remove(Jogadores);
			jogador4.remove(Jogadores);
			jogador5.remove(Jogadores);
			jogador6.remove(Jogadores);
			jogador7.remove(Jogadores);
			jogador8.remove(Jogadores);
			jogador9.remove(Jogadores);
			jogador10.remove(Jogadores);
			jogador11.remove(Jogadores);
			jogador12.remove(Jogadores);
			jogador13.remove(Jogadores);
			jogador14.remove(Jogadores);
			jogador15.remove(Jogadores);
			jogador16.remove(Jogadores);
			jogador17.remove(Jogadores);
			jogador18.remove(Jogadores);
			jogador19.remove(Jogadores);
			jogador20.remove(Jogadores);
			jogador21.remove(Jogadores);
			jogador22.remove(Jogadores);
			jogador23.remove(Jogadores);
			jogador24.remove(Jogadores);
			jogador25.remove(Jogadores);
			jogador26.remove(Jogadores);
			jogador27.remove(Jogadores);
			jogador28.remove(Jogadores);
			jogador29.remove(Jogadores);
			jogador30.remove(Jogadores);
		}
		RDM1 = false;
		RDM2 = false;
		RDM3 = false;
		RDM4 = false;
		RDM5 = false;
		RDM6 = false;
		RDM7 = false;
		RDM8 = false;
		RDM10 = false;
		RDM11 = false;
		RDM12 = false;
		RDM13 = false;
		RDM14 = false;
		RDM15 = false;
		RDM16 = false;
		RDM17 = false;
		RDM18 = false;
		RDM19 = false;
		RDM20 = false;
		RDM21 = false;
		RDM22 = false;
		RDM23 = false;
		RDM24 = false;
		RDM25 = false;
		RDM26 = false;
		RDM27 = false;
		RDM28 = false;
		RDM29 = false;
		RDM30 = false;
	}
	
	public static void LimparPlayer(Player Jogador) {

		Ganhador.remove(Jogador);
		Batalhando.remove(Jogador);
		Batalhando1.remove(Jogador);
		Batalhando2.remove(Jogador);
		Esperando.remove(Jogador);
		Participando.remove(Jogador);
		jogador1.remove(Jogador);
		jogador2.remove(Jogador);
		jogador3.remove(Jogador);
		jogador4.remove(Jogador);
		jogador5.remove(Jogador);
		jogador6.remove(Jogador);
		jogador7.remove(Jogador);
		jogador8.remove(Jogador);
		jogador9.remove(Jogador);
		jogador10.remove(Jogador);
		jogador11.remove(Jogador);
		jogador12.remove(Jogador);
		jogador13.remove(Jogador);
		jogador14.remove(Jogador);
		jogador15.remove(Jogador);
		jogador16.remove(Jogador);
		jogador17.remove(Jogador);
		jogador18.remove(Jogador);
		jogador19.remove(Jogador);
		jogador20.remove(Jogador);
		jogador21.remove(Jogador);
		jogador22.remove(Jogador);
		jogador23.remove(Jogador);
		jogador24.remove(Jogador);
		jogador25.remove(Jogador);
		jogador26.remove(Jogador);
		jogador27.remove(Jogador);
		jogador28.remove(Jogador);
		jogador29.remove(Jogador);
		jogador30.remove(Jogador);
		
		RDM1 = false;
		RDM2 = false;
		RDM3 = false;
		RDM4 = false;
		RDM5 = false;
		RDM6 = false;
		RDM7 = false;
		RDM8 = false;
		RDM10 = false;
		RDM11 = false;
		RDM12 = false;
		RDM13 = false;
		RDM14 = false;
		RDM15 = false;
		RDM16 = false;
		RDM17 = false;
		RDM18 = false;
		RDM19 = false;
		RDM20 = false;
		RDM21 = false;
		RDM22 = false;
		RDM23 = false;
		RDM24 = false;
		RDM25 = false;
		RDM26 = false;
		RDM27 = false;
		RDM28 = false;
		RDM29 = false;
		RDM30 = false;
	}
	
	public static void SelecionarPrimeirosJogadores(Player Jogador) {
		
		if (Main.Evento == Estado.INICIANDO || Main.Evento == Estado.FECHADO) {
			return;
		}
		
		if (RDM1) {
			Player Selecionado = Bukkit.getPlayer(jogador1.get(Jogador));
			if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM2) {
			Player Selecionado = Bukkit.getPlayer(jogador2.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM3) {
			Player Selecionado = Bukkit.getPlayer(jogador3.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM4) {
			Player Selecionado = Bukkit.getPlayer(jogador4.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM5) {
			Player Selecionado = Bukkit.getPlayer(jogador5.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM6) {
			Player Selecionado = Bukkit.getPlayer(jogador6.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM7) {
			Player Selecionado = Bukkit.getPlayer(jogador7.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM8) {
			Player Selecionado = Bukkit.getPlayer(jogador8.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM9) {
			Player Selecionado = Bukkit.getPlayer(jogador9.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM10) {
			Player Selecionado = Bukkit.getPlayer(jogador10.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM11) {
			Player Selecionado = Bukkit.getPlayer(jogador11.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM12) {
			Player Selecionado = Bukkit.getPlayer(jogador12.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM13) {
			Player Selecionado = Bukkit.getPlayer(jogador13.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM14) {
			Player Selecionado = Bukkit.getPlayer(jogador14.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM15) {
			Player Selecionado = Bukkit.getPlayer(jogador15.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM16) {
			Player Selecionado = Bukkit.getPlayer(jogador16.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM17) {
			Player Selecionado = Bukkit.getPlayer(jogador17.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM18) {
			Player Selecionado = Bukkit.getPlayer(jogador18.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM19) {
			Player Selecionado = Bukkit.getPlayer(jogador19.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM20) {
			Player Selecionado = Bukkit.getPlayer(jogador20.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM21) {
			Player Selecionado = Bukkit.getPlayer(jogador21.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM22) {
			Player Selecionado = Bukkit.getPlayer(jogador22.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM23) {
			Player Selecionado = Bukkit.getPlayer(jogador23.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM24) {
			Player Selecionado = Bukkit.getPlayer(jogador24.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM25) {
			Player Selecionado = Bukkit.getPlayer(jogador25.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM26) {
			Player Selecionado = Bukkit.getPlayer(jogador26.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM27) {
			Player Selecionado = Bukkit.getPlayer(jogador27.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM28) {
			Player Selecionado = Bukkit.getPlayer(jogador28.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM29) {
			Player Selecionado = Bukkit.getPlayer(jogador29.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM30) {
				Player Selecionado2 = Bukkit.getPlayer(jogador30.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
		else if (RDM30) {
			Player Selecionado = Bukkit.getPlayer(jogador30.get(Jogador));
			if (RDM1) {
				Player Selecionado2 = Bukkit.getPlayer(jogador1.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM2) {
				Player Selecionado2 = Bukkit.getPlayer(jogador2.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM3) {
				Player Selecionado2 = Bukkit.getPlayer(jogador3.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM4) {
				Player Selecionado2 = Bukkit.getPlayer(jogador4.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM5) {
				Player Selecionado2 = Bukkit.getPlayer(jogador5.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM6) {
				Player Selecionado2 = Bukkit.getPlayer(jogador6.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM7) {
				Player Selecionado2 = Bukkit.getPlayer(jogador7.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM8) {
				Player Selecionado2 = Bukkit.getPlayer(jogador8.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM9) {
				Player Selecionado2 = Bukkit.getPlayer(jogador9.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM10) {
				Player Selecionado2 = Bukkit.getPlayer(jogador10.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM11) {
				Player Selecionado2 = Bukkit.getPlayer(jogador11.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM12) {
				Player Selecionado2 = Bukkit.getPlayer(jogador12.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM13) {
				Player Selecionado2 = Bukkit.getPlayer(jogador13.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM14) {
				Player Selecionado2 = Bukkit.getPlayer(jogador14.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM15) {
				Player Selecionado2 = Bukkit.getPlayer(jogador15.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM16) {
				Player Selecionado2 = Bukkit.getPlayer(jogador16.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM17) {
				Player Selecionado2 = Bukkit.getPlayer(jogador17.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM18) {
				Player Selecionado2 = Bukkit.getPlayer(jogador18.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM19) {
				Player Selecionado2 = Bukkit.getPlayer(jogador19.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM20) {
				Player Selecionado2 = Bukkit.getPlayer(jogador20.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM21) {
				Player Selecionado2 = Bukkit.getPlayer(jogador21.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM22) {
				Player Selecionado2 = Bukkit.getPlayer(jogador22.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM23) {
				Player Selecionado2 = Bukkit.getPlayer(jogador23.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM24) {
				Player Selecionado2 = Bukkit.getPlayer(jogador24.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM25) {
				Player Selecionado2 = Bukkit.getPlayer(jogador25.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM26) {
				Player Selecionado2 = Bukkit.getPlayer(jogador26.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM27) {
				Player Selecionado2 = Bukkit.getPlayer(jogador27.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM28) {
				Player Selecionado2 = Bukkit.getPlayer(jogador28.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
			else if (RDM29) {
				Player Selecionado2 = Bukkit.getPlayer(jogador29.get(Jogador));
				IrParaPrimeiraBatalha(Selecionado, Selecionado2);
			}
		}
	}
	
	public static void IrParaPrimeiraBatalha(Player Jogador1, Player Jogador2) {
		
		if (Main.Evento == Estado.INICIANDO || Main.Evento == Estado.FECHADO) {
			return;
		}
		
		Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Escolhendo Primeiro Jogador!");
		new BukkitRunnable() {
			
			@Override
			public void run() {
				Jogador1.sendMessage(ChatColor.GREEN + "Você é o primeiro Jogador da RDM!");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Primeiro Jogador: " + ChatColor.RED + Jogador1.getName() + ChatColor.GRAY + "!");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Escolhendo Segundo Jogador!");
				EventoAPI.TeleportarWarp(Jogador1, "Loc1");
				
				Batalhando1.put(Jogador1, Jogador1.getName());
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					Batalhando1.put(Jogadores, Jogador1.getName());
				}
				RemoverSoBoolean(Jogador1);
				Batalhando.add(Jogador1);
				Proteção.setImortal(Jogador1, false);
				
				Iterator<?> Interator = Jogador1.getActivePotionEffects().iterator();
				while (Interator.hasNext()) {
					PotionEffect Efeito = (PotionEffect)Interator.next();
					Jogador1.removePotionEffect(Efeito.getType());
				}
				        
				Jogador1.setMaxHealth(20);
				Jogador1.setHealth(20.0D);
				Jogador1.setFoodLevel(20);
				Jogador1.setFlySpeed(0.1F);
				Jogador1.setAllowFlight(false);
				Jogador1.setWalkSpeed(0.2F);
				Jogador1.getInventory().clear();
				Jogador1.setGameMode(GameMode.SURVIVAL);
						
				Jogador1.getInventory().setBoots(null);
				Jogador1.getInventory().setChestplate(null);
				Jogador1.getInventory().setHelmet(null);
				Jogador1.getInventory().setLeggings(null);
				
				Esperando.add(Jogador1);
				new BukkitRunnable() {
					
					@Override
					public void run() {
						Jogador1.sendMessage(ChatColor.GREEN + "Você é o segundo Jogador da RDM!");
						Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Segundo Jogador: " + ChatColor.RED + Jogador2.getName() + ChatColor.GRAY + "!");
						Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.YELLOW + Jogador1.getName() + ChatColor.GRAY + " vs " + ChatColor.YELLOW + Jogador2.getName() + ChatColor.GRAY + "!");
						EventoAPI.TeleportarWarp(Jogador2, "Loc2");
						
						Batalhando2.put(Jogador2, Jogador2.getName());
						for (Player Jogadores : Bukkit.getOnlinePlayers()) {
							Batalhando2.put(Jogadores, Jogador2.getName());
						}
						RemoverSoBoolean(Jogador2);
						Batalhando.add(Jogador2);
						Proteção.setImortal(Jogador2, false);
						Iterator<?> Interator = Jogador2.getActivePotionEffects().iterator();
						while (Interator.hasNext()) {
							PotionEffect Efeito = (PotionEffect)Interator.next();
							Jogador2.removePotionEffect(Efeito.getType());
						}
						        
						Jogador2.setMaxHealth(20);
						Jogador2.setHealth(20.0D);
						Jogador2.setFoodLevel(20);
						Jogador2.setFlySpeed(0.1F);
						Jogador2.setAllowFlight(false);
						Jogador2.setWalkSpeed(0.2F);
						Jogador2.getInventory().clear();
						Jogador2.setGameMode(GameMode.SURVIVAL);

						Jogador2.getInventory().setBoots(null);
						Jogador2.getInventory().setChestplate(null);
						Jogador2.getInventory().setHelmet(null);
						Jogador2.getInventory().setLeggings(null);
						
						Esperando.add(Jogador2);
						new BukkitRunnable() {
							
							@Override
							public void run() {
								Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Valendo!");
								Esperando.remove(Jogador1);
								Esperando.remove(Jogador2);
	
								for (int slot = 0; slot < Jogador1.getInventory().getSize(); slot++) {
									CriarItem(Jogador1, Material.MUSHROOM_SOUP, 1, (short)0, new String[] {}, ChatColor.GOLD + "Sopa", slot, 0);
								}
								for (int slot = 0; slot < Jogador2.getInventory().getSize(); slot++) {
									CriarItem(Jogador2, Material.MUSHROOM_SOUP, 1, (short)0, new String[] {}, ChatColor.GOLD + "Sopa", slot, 0);
								}
								
								CriarItem(Jogador1, Material.STONE_SWORD, 1, (short)0, new String[] {}, ChatColor.RED + "Rei da Mesa", 0, 0);
								CriarItem(Jogador2, Material.STONE_SWORD, 1, (short)0, new String[] {}, ChatColor.RED + "Rei da Mesa", 0, 0);
							}
						}.runTaskLater(Main.getPlugin(), 20L);
					}
				}.runTaskLaterAsynchronously(Main.getPlugin(), 20L);
			}
		}.runTaskLater(Main.getPlugin(), 20L);
	}

	public static void IrParaProximaBatalha(Player Jogador) {
		
		if (Main.Evento == Estado.INICIANDO || Main.Evento == Estado.FECHADO) {
			return;
		}
			
		Player Jogador1 = Bukkit.getPlayer(Ganhador.get(Jogador));
		
		Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Escolhendo Próximo Jogador" + ChatColor.GRAY + "!");
		
		EventoAPI.TeleportarWarp(Jogador1, "Loc1");
		
		Batalhando1.put(Jogador1, Jogador1.getName());
		for (Player Jogadores : Bukkit.getOnlinePlayers()) {
			Batalhando1.put(Jogadores, Jogador1.getName());
		}
		RemoverSoBoolean(Jogador1);
		Proteção.setImortal(Jogador1, false);
		Proteção.setImortal(Jogador, false);
		
		Iterator<?> Interator = Jogador1.getActivePotionEffects().iterator();
		while (Interator.hasNext()) {
			PotionEffect Efeito = (PotionEffect)Interator.next();
			Jogador1.removePotionEffect(Efeito.getType());
		}
		        
		Jogador1.setMaxHealth(20);
		Jogador1.setHealth(20.0D);
		Jogador1.setFoodLevel(20);
		Jogador1.setFlySpeed(0.1F);
		Jogador1.setAllowFlight(false);
		Jogador1.setWalkSpeed(0.2F);
		Jogador1.getInventory().clear();
		Jogador1.setGameMode(GameMode.SURVIVAL);
				
		Jogador1.getInventory().setBoots(null);
		Jogador1.getInventory().setChestplate(null);
		Jogador1.getInventory().setHelmet(null);
		Jogador1.getInventory().setLeggings(null);
		
		Esperando.add(Jogador1);
		new BukkitRunnable() {
					
			@Override
			public void run() {
				Jogador.sendMessage(ChatColor.GREEN + "Você é o Próximo Jogador da RDM!");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Próximo Jogador: " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + "!");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.YELLOW + Jogador1.getName() + ChatColor.GRAY + " vs " + ChatColor.YELLOW + Jogador.getName() + ChatColor.GRAY + "!");
				EventoAPI.TeleportarWarp(Jogador, "Loc2");
						
				Batalhando2.put(Jogador, Jogador.getName());
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					Batalhando2.put(Jogadores, Jogador.getName());
				}
				RemoverSoBoolean(Jogador);
				Proteção.setImortal(Jogador, false);
				
				Iterator<?> Interator = Jogador.getActivePotionEffects().iterator();
				while (Interator.hasNext()) {
					PotionEffect Efeito = (PotionEffect)Interator.next();
					Jogador.removePotionEffect(Efeito.getType());
				}
						        
				Jogador.setMaxHealth(20);
				Jogador.setHealth(20.0D);
				Jogador.setFoodLevel(20);
				Jogador.setFlySpeed(0.1F);
				Jogador.setAllowFlight(false);
				Jogador.setWalkSpeed(0.2F);
				Jogador.getInventory().clear();
				Jogador.setGameMode(GameMode.SURVIVAL);

				Jogador.getInventory().setBoots(null);
				Jogador.getInventory().setChestplate(null);
				Jogador.getInventory().setHelmet(null);
				Jogador.getInventory().setLeggings(null);
			
						
				Esperando.add(Jogador);
				new BukkitRunnable() {
							
					@Override
					public void run() {
						Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "Valendo!");
						Esperando.remove(Jogador1);
						Esperando.remove(Jogador);
						Batalhando.add(Jogador1);
						Batalhando.add(Jogador);
							
						for (int slot = 0; slot < Jogador1.getInventory().getSize(); slot++) {
							CriarItem(Jogador1, Material.MUSHROOM_SOUP, 1, (short)0, new String[] {}, ChatColor.GOLD + "Sopa", slot, 0);
						}
						for (int slot = 0; slot < Jogador.getInventory().getSize(); slot++) {
							CriarItem(Jogador, Material.MUSHROOM_SOUP, 1, (short)0, new String[] {}, ChatColor.GOLD + "Sopa", slot, 0);
						}
								
						CriarItem(Jogador1, Material.STONE_SWORD, 1, (short)0, new String[] {}, ChatColor.RED + "Rei da Mesa", 0, 0);
						CriarItem(Jogador, Material.STONE_SWORD, 1, (short)0, new String[] {}, ChatColor.RED + "Rei da Mesa", 0, 0);
					}
				}.runTaskLater(Main.getPlugin(), 20L);
			}
		}.runTaskLaterAsynchronously(Main.getPlugin(), 20L);
	}
	
	public static void AdicionarRDM(Player Jogador) {
		
		if (Main.Evento == Estado.ANDAMENTO || Main.Evento == Estado.FECHADO) {
			return;
		}
		
		if (!RDM1) {
			RDM1 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador1.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM2) {
			RDM2 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador2.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM3) {
			RDM3 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador3.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM4) {
			RDM4 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador4.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM5) {
			RDM5 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador5.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM6) {
			RDM6 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador6.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM7) {
			RDM7 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador7.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM8) {
			RDM8 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador8.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM9) {
			RDM9 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador9.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM10) {
			RDM10 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador10.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM11) {
			RDM11 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador11.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM12) {
			RDM12 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador12.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM13) {
			RDM13 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador13.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM14) {
			RDM14 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador14.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM15) {
			RDM15 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador15.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM16) {
			RDM16 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador16.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM17) {
			RDM17 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador17.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM18) {
			RDM18 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador18.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM19) {
			RDM19 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador19.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM20) {
			RDM20 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador20.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM21) {
			RDM21 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador21.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM22) {
			RDM22 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador22.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM23) {
			RDM23 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador23.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM24) {
			RDM24 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador24.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM25) {
			RDM25 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador25.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM26) {
			RDM26 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador26.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM27) {
			RDM27 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador27.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM28) {
			RDM28 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador28.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM29) {
			RDM29 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador29.put(Jogadores, Jogador.getName());
			}
		} else if (!RDM30) {
			RDM30 = true;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador30.put(Jogadores, Jogador.getName());
			}
		}
	}
	
	public static void AdicionarRDMCheio(Player Jogador) {
		
		if (Main.Evento == Estado.ANDAMENTO || Main.Evento == Estado.FECHADO) {
			return;
		}
		
		if (RDM1) {
			Player Expulso = Bukkit.getPlayer(jogador1.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM1 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador1.put(Jogadores, Jogador.getName());
				}
				return;
			}
		}
		if (RDM2) {
			Player Expulso = Bukkit.getPlayer(jogador2.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM2 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador2.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} else if (RDM3) {
			Player Expulso = Bukkit.getPlayer(jogador3.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM3 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador3.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM4) {
			Player Expulso = Bukkit.getPlayer(jogador4.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM4 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador4.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM5) {
			Player Expulso = Bukkit.getPlayer(jogador5.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM5 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador5.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM6) {
			Player Expulso = Bukkit.getPlayer(jogador6.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM6 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador6.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM7) {
			Player Expulso = Bukkit.getPlayer(jogador7.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM7 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador7.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM8) {
			Player Expulso = Bukkit.getPlayer(jogador8.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM8 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador8.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM9) {
			Player Expulso = Bukkit.getPlayer(jogador9.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM9 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador9.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM10) {
			Player Expulso = Bukkit.getPlayer(jogador10.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM10 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador10.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM11) {
			Player Expulso = Bukkit.getPlayer(jogador11.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM11 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador11.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM12) {
			Player Expulso = Bukkit.getPlayer(jogador12.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM12 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador12.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM13) {
			Player Expulso = Bukkit.getPlayer(jogador13.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM13 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador13.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM14) {
			Player Expulso = Bukkit.getPlayer(jogador14.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM14 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador14.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM15) {
			Player Expulso = Bukkit.getPlayer(jogador15.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM15 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador15.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM16) {
			Player Expulso = Bukkit.getPlayer(jogador16.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM16 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador16.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM17) {
			Player Expulso = Bukkit.getPlayer(jogador17.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM17 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador17.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM18) {
			Player Expulso = Bukkit.getPlayer(jogador18.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM18 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador18.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM19) {
			Player Expulso = Bukkit.getPlayer(jogador19.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM19 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador19.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM20) {
			Player Expulso = Bukkit.getPlayer(jogador20.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM20 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador20.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM21) {
			Player Expulso = Bukkit.getPlayer(jogador21.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM21 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador21.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM22) {
			Player Expulso = Bukkit.getPlayer(jogador22.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM22 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador22.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM23) {
			Player Expulso = Bukkit.getPlayer(jogador23.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM23 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador23.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM24) {
			Player Expulso = Bukkit.getPlayer(jogador24.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM24 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador24.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM25) {
			Player Expulso = Bukkit.getPlayer(jogador25.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM25 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador25.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM26) {
			Player Expulso = Bukkit.getPlayer(jogador26.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM26 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador26.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM27) {
			Player Expulso = Bukkit.getPlayer(jogador27.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM27 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador27.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM28) {
			Player Expulso = Bukkit.getPlayer(jogador28.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM28 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador28.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM29) {
			Player Expulso = Bukkit.getPlayer(jogador29.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM29 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador29.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} if (RDM30) {
			Player Expulso = Bukkit.getPlayer(jogador30.get(Jogador));
			if (!Expulso.hasPermission("RDM.Full")) {
				PlayerAPI.Participando.remove(Expulso);
				EventoAPI.TeleportarWarp(Expulso, "Saida");
				Expulso.sendMessage(ChatColor.RED + "O " + ChatColor.DARK_RED + Jogador.getName() + ChatColor.RED + " te expulsou do evento!");
				Expulso.sendMessage(ChatColor.RED + "Motivo: " + ChatColor.WHITE + "O Evento estava cheio, como ele é vip ele pode entrar, e acabou que o sistema de random expulsar jogador escolheu você, desculpe!");
				Jogador.sendMessage(ChatColor.GREEN + "Teleporte foi concluido com sucesso!");
				Jogador.sendMessage(ChatColor.GREEN + "Você expulsou o " + ChatColor.WHITE + Expulso.getName() + ChatColor.GREEN + " do Evento!");
				Jogador.sendMessage(ChatColor.GREEN + "Agora você está participando do Evento!");
				EventoAPI.TeleportarWarp(Jogador, "Spawn");
				PlayerAPI.Participando.add(Jogador);
				EventoAPI.AntiBug.remove(Jogador);
				EventoAPI.Teleportando.remove(Jogador);
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Expulso.getName() + ChatColor.GRAY + " foi expulso do Evento, pelo " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + ", pelo motivo que ele é vip e pode entrar no evento cheio expulsando alguém aleatório.");
				Tempo.mandarBroadcast(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "RDM: " + ChatColor.GRAY + "O " + ChatColor.RED + Jogador.getName() + ChatColor.GRAY + " entrou no Evento! " + ChatColor.WHITE + "(" + PlayerAPI.Participando.size() + "/30)" + ChatColor.GRAY + "!");
				RDM30 = true;
				for (Player Jogadores : Bukkit.getOnlinePlayers()) {
					jogador30.put(Jogadores, Jogador.getName());
				}
				return;
			}
		} 
		if (RDM1 && RDM2 && RDM3 && RDM4 && RDM5 && RDM6 && RDM7 && RDM8 && RDM9 && RDM10 && RDM11 && RDM12 && RDM13 && RDM14 && RDM15 && RDM16 && RDM17 && RDM18 && RDM19 && RDM20 && RDM21 && RDM22 && RDM23 && RDM24 && RDM25 && RDM26 && RDM27 && RDM28 && RDM29 && RDM30) {
			Jogador.sendMessage(ChatColor.RED + "Desculpe, todos os participantes do Evento são vips, e você não pode expusar eles.");
			return;
		}
	}

	public static void RemoverRDM(Player Jogador) {
		
		if (Main.Evento == Estado.FECHADO) {
			return;
		}
		
		if (jogador1.get(Jogador) == Jogador.getName()) {
			RDM1 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador1.remove(Jogadores);
			}
		}
		else if (jogador2.get(Jogador) == Jogador.getName()) {
			RDM2 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador2.remove(Jogadores);
			}
		}
		else if (jogador3.get(Jogador) == Jogador.getName()) {
			RDM3 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador3.remove(Jogadores);
			}
		}
		else if (jogador4.get(Jogador) == Jogador.getName()) {
			RDM4 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador4.remove(Jogadores);
			}
		}
		else if (jogador5.get(Jogador) == Jogador.getName()) {
			RDM5 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador5.remove(Jogadores);
			}
		}
		else if (jogador6.get(Jogador) == Jogador.getName()) {
			RDM6 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador6.remove(Jogadores);
			}
		}
		else if (jogador7.get(Jogador) == Jogador.getName()) {
			RDM7 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador7.remove(Jogadores);
			}
		}
		else if (jogador8.get(Jogador) == Jogador.getName()) {
			RDM8 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador8.remove(Jogadores);
			}
		}
		else if (jogador9.get(Jogador) == Jogador.getName()) {
			RDM9 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador9.remove(Jogadores);
			}
		}
		else if (jogador10.get(Jogador) == Jogador.getName()) {
			RDM10 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador10.remove(Jogadores);
			}
		}
		else if (jogador11.get(Jogador) == Jogador.getName()) {
			RDM11 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador11.remove(Jogadores);
			}
		}
		else if (jogador12.get(Jogador) == Jogador.getName()) {
			RDM12 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador12.remove(Jogadores);
			}
		}
		else if (jogador13.get(Jogador) == Jogador.getName()) {
			RDM13 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador13.remove(Jogadores);
			}
		}
		else if (jogador14.get(Jogador) == Jogador.getName()) {
			RDM14 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador14.remove(Jogadores);
			}
		}
		else if (jogador15.get(Jogador) == Jogador.getName()) {
			RDM15 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador15.remove(Jogadores);
			}
		}
		else if (jogador16.get(Jogador) == Jogador.getName()) {
			RDM16 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador16.remove(Jogadores);
			}
		}
		else if (jogador17.get(Jogador) == Jogador.getName()) {
			RDM17 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador17.remove(Jogadores);
			}
		}
		else if (jogador18.get(Jogador) == Jogador.getName()) {
			RDM18 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador18.remove(Jogadores);
			}
		}
		else if (jogador19.get(Jogador) == Jogador.getName()) {
			RDM19 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador19.remove(Jogadores);
			}
		}
		else if (jogador20.get(Jogador) == Jogador.getName()) {
			RDM20 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador20.remove(Jogadores);
			}
		}
		else if (jogador21.get(Jogador) == Jogador.getName()) {
			RDM21 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador21.remove(Jogadores);
			}
		}
		else if (jogador22.get(Jogador) == Jogador.getName()) {
			RDM22 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador22.remove(Jogadores);
			}
		}
		else if (jogador23.get(Jogador) == Jogador.getName()) {
			RDM23 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador23.remove(Jogadores);
			}
		}
		else if (jogador24.get(Jogador) == Jogador.getName()) {
			RDM24 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador24.remove(Jogadores);
			}
		}
		else if (jogador25.get(Jogador) == Jogador.getName()) {
			RDM25 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador25.remove(Jogadores);
			}
		}
		else if (jogador26.get(Jogador) == Jogador.getName()) {
			RDM26 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador26.remove(Jogadores);
			}
		}
		else if (jogador27.get(Jogador) == Jogador.getName()) {
			RDM27 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador27.remove(Jogadores);
			}
		}
		else if (jogador28.get(Jogador) == Jogador.getName()) {
			RDM28 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador28.remove(Jogadores);
			}
		}
		else if (jogador29.get(Jogador) == Jogador.getName()) {
			RDM29 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador29.remove(Jogadores);
			}
		}
		else if (jogador30.get(Jogador) == Jogador.getName()) {
			RDM30 = false;
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				jogador30.remove(Jogadores);
			}
		}
	}
	
	public static void RemoverSoBoolean(Player Jogador) {
		
		if (jogador1.get(Jogador) == Jogador.getName()) {
			RDM1 = false;
		}
		else if (jogador2.get(Jogador) == Jogador.getName()) {
			RDM2 = false;
		}
		else if (jogador3.get(Jogador) == Jogador.getName()) {
			RDM3 = false;
		}
		else if (jogador4.get(Jogador) == Jogador.getName()) {
			RDM4 = false;
		}
		else if (jogador5.get(Jogador) == Jogador.getName()) {
			RDM5 = false;
		}
		else if (jogador6.get(Jogador) == Jogador.getName()) {
			RDM6 = false;
		}
		else if (jogador7.get(Jogador) == Jogador.getName()) {
			RDM7 = false;
		}
		else if (jogador8.get(Jogador) == Jogador.getName()) {
			RDM8 = false;
		}
		else if (jogador9.get(Jogador) == Jogador.getName()) {
			RDM9 = false;
		}
		else if (jogador10.get(Jogador) == Jogador.getName()) {
			RDM10 = false;
		}
		else if (jogador11.get(Jogador) == Jogador.getName()) {
			RDM11 = false;
		}
		else if (jogador12.get(Jogador) == Jogador.getName()) {
			RDM12 = false;
		}
		else if (jogador13.get(Jogador) == Jogador.getName()) {
			RDM13 = false;
		}
		else if (jogador14.get(Jogador) == Jogador.getName()) {
			RDM14 = false;
		}
		else if (jogador15.get(Jogador) == Jogador.getName()) {
			RDM15 = false;
		}
		else if (jogador16.get(Jogador) == Jogador.getName()) {
			RDM16 = false;
		}
		else if (jogador17.get(Jogador) == Jogador.getName()) {
			RDM17 = false;
		}
		else if (jogador18.get(Jogador) == Jogador.getName()) {
			RDM18 = false;
		}
		else if (jogador19.get(Jogador) == Jogador.getName()) {
			RDM19 = false;
		}
		else if (jogador20.get(Jogador) == Jogador.getName()) {
			RDM20 = false;
		}
		else if (jogador21.get(Jogador) == Jogador.getName()) {
			RDM21 = false;
		}
		else if (jogador22.get(Jogador) == Jogador.getName()) {
			RDM22 = false;
		}
		else if (jogador23.get(Jogador) == Jogador.getName()) {
			RDM23 = false;
		}
		else if (jogador24.get(Jogador) == Jogador.getName()) {
			RDM24 = false;
		}
		else if (jogador25.get(Jogador) == Jogador.getName()) {
			RDM25 = false;
		}
		else if (jogador26.get(Jogador) == Jogador.getName()) {
			RDM26 = false;
		}
		else if (jogador27.get(Jogador) == Jogador.getName()) {
			RDM27 = false;
		}
		else if (jogador28.get(Jogador) == Jogador.getName()) {
			RDM28 = false;
		}
		else if (jogador29.get(Jogador) == Jogador.getName()) {
			RDM29 = false;
		}
		else if (jogador30.get(Jogador) == Jogador.getName()) {
			RDM30 = false;
		}
	}

	public static void SelecionarProximoJogador(Player Jogador) {
	
		if (RDM1) {
			Player Jogador2 = Bukkit.getPlayer(jogador1.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM2) {
			Player Jogador2 = Bukkit.getPlayer(jogador2.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM3) {
			Player Jogador2 = Bukkit.getPlayer(jogador3.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM4) {
			Player Jogador2 = Bukkit.getPlayer(jogador4.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM5) {
			Player Jogador2 = Bukkit.getPlayer(jogador5.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM6) {
			Player Jogador2 = Bukkit.getPlayer(jogador6.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM7) {
			Player Jogador2 = Bukkit.getPlayer(jogador7.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM8) {
			Player Jogador2 = Bukkit.getPlayer(jogador8.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM9) {
			Player Jogador2 = Bukkit.getPlayer(jogador9.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM10) {
			Player Jogador2 = Bukkit.getPlayer(jogador10.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM11) {
			Player Jogador2 = Bukkit.getPlayer(jogador11.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM12) {
			Player Jogador2 = Bukkit.getPlayer(jogador12.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM13) {
			Player Jogador2 = Bukkit.getPlayer(jogador13.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM14) {
			Player Jogador2 = Bukkit.getPlayer(jogador14.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM15) {
			Player Jogador2 = Bukkit.getPlayer(jogador15.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM16) {
			Player Jogador2 = Bukkit.getPlayer(jogador16.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM17) {
			Player Jogador2 = Bukkit.getPlayer(jogador17.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM18) {
			Player Jogador2 = Bukkit.getPlayer(jogador18.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM19) {
			Player Jogador2 = Bukkit.getPlayer(jogador19.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM20) {
			Player Jogador2 = Bukkit.getPlayer(jogador20.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM21) {
			Player Jogador2 = Bukkit.getPlayer(jogador21.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM22) {
			Player Jogador2 = Bukkit.getPlayer(jogador22.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM23) {
			Player Jogador2 = Bukkit.getPlayer(jogador23.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM24) {
			Player Jogador2 = Bukkit.getPlayer(jogador24.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM25) {
			Player Jogador2 = Bukkit.getPlayer(jogador25.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM26) {
			Player Jogador2 = Bukkit.getPlayer(jogador26.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM27) {
			Player Jogador2 = Bukkit.getPlayer(jogador27.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM28) {
			Player Jogador2 = Bukkit.getPlayer(jogador28.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM29) {
			Player Jogador2 = Bukkit.getPlayer(jogador29.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
		else if (RDM30) {
			Player Jogador2 = Bukkit.getPlayer(jogador30.get(Jogador));
			IrParaProximaBatalha(Jogador2);
		}
	}

	public static void CheckarGanhador(Player Jogador) {
		
		if (Participando.size() == 1) {
			Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce foi o ganhador do evento, parabens!");
			
			Proteção.setImortal(Jogador, true);
			
			Jogador.setMaxHealth(20);
			Jogador.setHealth(20.0D);
			Jogador.setFoodLevel(20);
			Jogador.setFlySpeed(0.1F);
			Jogador.setAllowFlight(false);
			Jogador.setWalkSpeed(0.2F);
			Jogador.getInventory().clear();
			Jogador.setGameMode(GameMode.SURVIVAL);
			Jogador.getInventory().setBoots(null);
			Jogador.getInventory().setChestplate(null);
			Jogador.getInventory().setHelmet(null);
			Jogador.getInventory().setLeggings(null);
			
			Tempo.mandarBroadcast(" " + "\n" + "§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7foi o ganhador do evento" + "\n" + " ");
			Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20F, 20F);
			Vector Vector = Jogador.getLocation().getDirection().multiply(0).setY(4);
			Jogador.setVelocity(Vector);
			if (!Jogador.getAllowFlight()) {
				Jogador.setAllowFlight(true);
			} else {	
				Jogador.setAllowFlight(true);
			}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce foi o ganhador do evento, parabens!");
					Tempo.mandarBroadcast(" " + "\n" + "§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7foi o ganhador do evento" + "\n" + " ");
					Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20F, 20F);
				}
			}.runTaskLaterAsynchronously(Main.getPlugin(), 20L);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce foi o ganhador do evento, parabens!");
					Tempo.mandarBroadcast(" " + "\n" + "§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7foi o ganhador do evento" + "\n" + " ");
					Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20F, 20F);
				}
			}.runTaskLaterAsynchronously(Main.getPlugin(), 60L);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce foi o ganhador do evento, parabens!");
					Tempo.mandarBroadcast(" " + "\n" + "§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7foi o ganhador do evento" + "\n" + " ");
					Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20F, 20F);
				}
			}.runTaskLaterAsynchronously(Main.getPlugin(), 100L);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce foi o ganhador do evento, parabens!");
					Tempo.mandarBroadcast(" " + "\n" + "§6§lNew§f§lPvP §6» §7O jogador §6" + Jogador.getName() + " §7foi o ganhador do evento" + "\n" + " ");
					Tempo.mandarBroadcast("§6§lNew§f§lPvP §6» §7O evento foi finalizado");
					EventoAPI.TeleportarWarp(Jogador, "Saida");
					
					LimparPlayers();
					LimparPlayer(Jogador);
					Main.Evento = Estado.FECHADO;
					Tempo.Iniciando = 301;
					Tempo.CancelarTempo();
					Jogador.playSound(Jogador.getLocation(), Sound.LEVEL_UP, 20F, 20F);
					API.setWarp(Jogador, "Spawn");
					
					if(cfGrupo.ChecarGrupo(Jogador, "Membro")|| cfGrupo.ChecarGrupo(Jogador, "Light") || cfGrupo.ChecarGrupo(Jogador, "Mvp")){
					cfGrupo.setarGrupo(Jogador, "Pro");
					GrupoAPI.expirar(Jogador, CalendarioAPI.PegarCalendario(Calendario.Dia)+1, CalendarioAPI.PegarCalendario(Calendario.Mes), CalendarioAPI.PegarCalendario(Calendario.Ano), CalendarioAPI.PegarCalendario(Calendario.Hora), CalendarioAPI.PegarCalendario(Calendario.Minuto)+1, CalendarioAPI.PegarCalendario(Calendario.Segundo)+1);
					GrupoAPI.checarVip(Jogador);
					Jogador.chat("/tag pro");
					sScoreAPI.scoreboard(Jogador);
					Jogador.setAllowFlight(false);
					Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce ganhou o vip §6§lPRO §7por um dia");
				if(CalendarioAPI.PegarCalendario(Calendario.Dia)== 30){
					cfTempGrupo.pegargrupo().set("tempgrupo." + Jogador.getUniqueId() + ".dia", 1);
					}
				}
					else if(!cfGrupo.ChecarGrupo(Jogador, "Membro")|| !cfGrupo.ChecarGrupo(Jogador, "Light") || !cfGrupo.ChecarGrupo(Jogador, "Mvp")){
						Jogador.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao recebeu nenhuma recompensa pois seu rank e maior do que o dado pela vitoria do evento");
					}
					API.sendItems(Jogador);
				}
			}.runTaskLaterAsynchronously(Main.getPlugin(), 140L);
		} else {
			return;
		}
	}
}
