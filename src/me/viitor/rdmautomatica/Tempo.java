package me.viitor.rdmautomatica;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import me.viitor.main.Main;

public class Tempo {

	public static Integer Tempo;
	public static int Iniciando = 301;
	
	public static void CancelarTempo() {
		if (Tempo != null) {
			Bukkit.getScheduler().cancelTask(Tempo);
			Tempo = null;
		}
	}
	
	public static void mandarBroadcast(String Menssagem) {
		for (Player Jogadores : Bukkit.getOnlinePlayers()) {
			Jogadores.sendMessage(Menssagem);
		}
	}
	
	private void mandarAvisos() {
		mandarBroadcast("§6§lNew§f§lPvP §6» §7O evento sera iniciado em §6" + FormatoTempo(Iniciando) + "§7. §6(" + PlayerAPI.Participando.size() + "/30)");
		mandarBroadcast("§6§lNew§f§lPvP §6» §7Para entrar no evento, digite /entrar");
		for (Player Jogadores : Bukkit.getOnlinePlayers()) {
			Jogadores.playSound(Jogadores.getLocation(), Sound.CLICK, 10.0F, 10.0F);
		}
	}
	
	public static String FormatoTempo(int Tempo) {
		int Minuto = Tempo/60, Segundo = Tempo%60;
		
		String MinutoTexto = null;
		String SegundoTexto = null;
		
		if (Minuto > 10) {
			MinutoTexto = " " + Minuto + " minuto(s)";
		} else {
			MinutoTexto = " " + Minuto + " minuto(s)";
		}
		if (Segundo > 10) {
			SegundoTexto = " " + Segundo + " segundo(s)";
		} else {
			SegundoTexto = " " + Segundo + " segundo(s)";
		}
		if (Minuto == 0) {
			MinutoTexto = "";
		}
		if (Segundo == 0) {
			SegundoTexto = "";
		}
		
		return MinutoTexto + SegundoTexto;
	}
	
	public Tempo(Player Jogador) {
		if (Main.Evento == Estado.INICIANDO) {
			Tempo = Integer.valueOf(Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
					
				public void run() {
					Iniciando -= 1;
					if (Iniciando == 300) {
						mandarAvisos();
					}
					if (Iniciando == 240) {
						mandarAvisos();
					}
					if (Iniciando == 180) {
						mandarAvisos();
					}
					if (Iniciando == 120) {
						mandarAvisos();
					}
					if (Iniciando == 60) {
						mandarAvisos();
					}
					if (Iniciando == 30) {
						mandarAvisos();
					}
					if (Iniciando == 15) {
						mandarAvisos();
					}
					if (Iniciando == 5) {
						mandarAvisos();
					}
					if (Iniciando == 4) {
						mandarAvisos();
					}
					if (Iniciando == 3) {
						mandarAvisos();
					}
					if (Iniciando == 2) {
						mandarAvisos();
					}
					if (Iniciando == 1) {
						mandarAvisos();
					}
					if (Iniciando == 0) {
						if (PlayerAPI.Participando.size() < 2) {
							mandarBroadcast("§6§lNew§f§lPvP §6» §7Lamentamos, mas a contagem foi reiniciada pela falta de jogadores");
							mandarBroadcast("§6§lNew§f§lPvP §6» §7O evento nao atingiu a quantidade minima de jogadores para ser iniciado. Contagem reiniciada para §62 minutos");
							Iniciando = 121;
							return;
						} else {
							mandarBroadcast("§6§lNew§f§lPvP §6» §7O evento foi iniciado!");
							mandarBroadcast("§6§lNew§f§lPvP §6» §7Boa sorte aos §6" + PlayerAPI.Participando.size() + " §7participantes");
							for (Player Jogadores : Bukkit.getOnlinePlayers()) {
								if (PlayerAPI.Participando.contains(Jogadores)) {
									Jogadores.playSound(Jogadores.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
								}
							}
							CancelarTempo();
							Iniciando = 301;
							Main.Evento = Estado.ANDAMENTO;
							PlayerAPI.SelecionarPrimeirosJogadores(Jogador);
						}
					}
				}
			}, 0L, 20L));
		}
	}
}
