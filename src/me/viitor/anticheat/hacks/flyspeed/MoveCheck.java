package me.viitor.anticheat.hacks.flyspeed;

import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.viitor.anticheat.Utills;

public class MoveCheck implements Runnable {
	
	public static HashMap<Player, Location> LastLocation;
	public static HashMap<Player, ArrayList<MoveLog>> Moves;
	public static HashMap<Player, Long> InvalidateExpires;
	public static MoveCheck Instance;
	public static int CheckCounter = 0;
	public static Player LastHacker;
	public static Server server;
  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void AddMove(Player Jogador, Location Local) {
		if ((Utills.Flight(Jogador)) && (Utills.Speeding(Jogador))) {
			return;
		}
		Long expires = (Long)InvalidateExpires.get(Jogador);
		if ((expires != null) && (expires.longValue() > System.currentTimeMillis())) {
			return;
		}
		if (!Moves.containsKey(Jogador)) {
			Moves.put(Jogador, new ArrayList<>());
		} synchronized ((ArrayList)Moves.get(Jogador)) {
			MoveCheck tmp97_94 = Instance;
			tmp97_94.getClass();
			((ArrayList)Moves.get(Jogador)).add(new MoveLog(Jogador, Local));
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void Invalidate(Player Jogador, long Tempo) {
		if (Moves.containsKey(Jogador)) {
			((ArrayList)Moves.get(Jogador)).clear();
		}
		Tempo += System.currentTimeMillis();
		Long expires = (Long)InvalidateExpires.get(Jogador);
		if ((expires == null) || (expires.longValue() < Tempo)) {
			InvalidateExpires.put(Jogador, Long.valueOf(Tempo));
		}
	}
  
	public static void Clear(Player player) {
		if (Moves.containsKey(player)) {
			Moves.remove(player);
		}
		if (LastLocation.containsKey(player)) {
			LastLocation.remove(player);
		}
	}
  
	public MoveCheck() {
		LastLocation = new HashMap<>();
		Moves = new HashMap<>();
		InvalidateExpires = new HashMap<>();
    
		Instance = this;
	}
  
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void run() {
		Player[] arrayOfJogador;
		int j = (arrayOfJogador = Bukkit.getOnlinePlayers()).length;
		for (int i = 0; i < j; i++) {
			Player Jogador = arrayOfJogador[i];
			if ((!Moves.containsKey(Jogador)) || (!LastLocation.containsKey(Jogador))) {
				LastLocation.put(Jogador, Jogador.getLocation().clone());
			} else {
				try {
					synchronized ((ArrayList)Moves.get(Jogador)) {
						ArrayList<Jump> jumps = GetJumps((ArrayList)Moves.get(Jogador));
						for (Jump jump : jumps) {
							int Ping = ((CraftPlayer)Jogador).getHandle().ping;
							if ((!jump.isOnGround) && (!Utills.Flight(Jogador))) {
								Utills.Hack Fly = Utills.Hack.FLY;
								
								if ((jump.height > 5.0D) || (jump.isFloating)) {
									Utills.Fly = Fly.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosFly.get(Jogador) + "").replace("ping", Ping + "");
									if (Utills.Fly != null) {
										Utills.AvisosFly.put(Jogador, Utills.AvisosFly.get(Jogador) + 1);
										Utills.sendAntiCheat(Utills.Fly);
									}
									Utills.Fly = null;
								} else if (((jump.height >= 1.3D) && (!jump.isOnFire)) || (jump.height >= 2.0D)) {
									Utills.Fly = Fly.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosFly.get(Jogador) + "").replace("ping", Ping + "");
									if (Utills.Fly != null) {
										Utills.AvisosFly.put(Jogador, Utills.AvisosFly.get(Jogador) + 1);
										Utills.sendAntiCheat(Utills.Fly);
									}
									Utills.Fly = null;
								}
							}
							if (!Utills.Speeding(Jogador)) {
								
								Utills.Hack Speed = Utills.Hack.SPEED;
								if (((jump.horizontalSpeed > 10.0D) && (jump.time > 0.5D)) || ((jump.horizontalSpeed > 9.0D) && (jump.time > 1.5D))) {
									Utills.Speed = Speed.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosSpeed.get(Jogador) + "").replace("ping", Ping + "");
									if (Utills.Speed != null) {
										Utills.AvisosSpeed.put(Jogador, Utills.AvisosSpeed.get(Jogador) + 1);
										Utills.sendAntiCheat(Utills.Speed);
									}
									Utills.Speed = null;
								}
								else if ((jump.horizontalSpeed > 11.0D) && (jump.time > 0.5D)) {
									Utills.Speed = Speed.getMenssagem().replace("nick", Jogador.getName()).replace("avisos", Utills.AvisosSpeed.get(Jogador) + "").replace("ping", Ping + "");
									if (Utills.Speed != null) {
										Utills.AvisosSpeed.put(Jogador, Utills.AvisosSpeed.get(Jogador) + 1);
										Utills.sendAntiCheat(Utills.Speed);
									}
									Utills.Speed = null;
								}
							}
						}
						((ArrayList)Moves.get(Jogador)).clear();
					}
					LastLocation.put(Jogador, Jogador.getLocation());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (Moves.keySet().size() > Bukkit.getMaxPlayers() * 3) {
			Moves.clear();
			Moves = new HashMap();
		}
	}
  
	public String GetLocationString(Location l) {
		return "(" + l.getX() + ", " + l.getY() + ", " + l.getZ() + ")";
	}
  
	public static ArrayList<Jump> GetJumps(ArrayList<MoveLog> moves) {
		int inc = 1;
    
		ArrayList<Jump> jumps = new ArrayList<>();
		while (inc < moves.size()) {
			if (((MoveLog)moves.get(inc)).isInVehicle) {
				return new ArrayList<>();
			}
			int startInc = inc;
			while ((inc < moves.size()) && (!((MoveLog)moves.get(inc)).isAir)) {
				inc++;
			}
			if (inc > startInc + 5) {
				MoveCheck tmp79_76 = Instance;tmp79_76.getClass();Jump jump = new Jump((MoveLog)moves.get(startInc), (MoveLog)moves.get((inc + startInc - 1) / 2), (MoveLog)moves.get(inc - 1));
				jump.isOnGround = true;
				jumps.add(jump);
			}
			if (inc >= moves.size()) {
				break;
			}	
			MoveLog start = (MoveLog)moves.get(inc - 1);
			while ((inc < moves.size()) && (((MoveLog)moves.get(inc)).isAir) && (((MoveLog)moves.get(inc)).location.getY() > ((MoveLog)moves.get(inc - 1)).location.getY())) {
				inc++;
			}
			if (inc >= moves.size()) {
				MoveCheck tmp235_232 = Instance;tmp235_232.getClass();jumps.add(new Jump(start, (MoveLog)moves.get(inc - 1), (MoveLog)moves.get(inc - 1)));
				break;
			}
			MoveLog apex = (MoveLog)moves.get(inc - 1);
			boolean isFloating = false;
			boolean isOnFire = false;
			int floatCount = 0;
			while ((inc < moves.size()) && (((MoveLog)moves.get(inc)).isAir)) {
				if ((((MoveLog)moves.get(inc - 1)).location.getY() == ((MoveLog)moves.get(inc)).location.getY()) && (!((MoveLog)moves.get(inc)).isOnLadder)) {
					floatCount++;
					if (floatCount > 3) {
						isFloating = true;
					}
				} else {
					floatCount = 0;
				}
				if (((MoveLog)moves.get(inc)).isOnFire) {
					isOnFire = true;
				}
				inc++;
			}
			MoveLog end;
			if (inc >= moves.size()) {
				end = (MoveLog)moves.get(moves.size() - 1);
			} else {
				end = (MoveLog)moves.get(inc);
			}
			MoveCheck tmp433_430 = Instance;
			tmp433_430.getClass();
			Jump jump = new Jump(start, apex, end);
			jump.isFloating = isFloating;
			jump.isOnFire = isOnFire;
			jumps.add(jump);
		}
		return jumps;
	}
}
