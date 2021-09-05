package me.viitor.nametag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;      
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
         
public class NametagManager {
	
	@SuppressWarnings("unused")
	private static final String TEAM_NAME_PREFIX = "NTE";
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static List<Integer> list = new ArrayList();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static HashMap<TeamInfo, List<String>> teams = new HashMap();   
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void AdicinarTeam(TeamInfo Team, String Jogador) {
		RemoverTeam(Jogador);
        List<String> List = (List)teams.get(Team);
        if (List != null) {
        	List.add(Jogador);
        	Player Jogadores = Bukkit.getPlayerExact(Jogador);
        	if (Jogadores != null) {
        		MandarPacketsAdicinarTeams(Team, Jogadores.getName());
        	} else {
        		OfflinePlayer JogadoresOff = Bukkit.getOfflinePlayer(Jogador);
        		MandarPacketsAdicinarTeams(Team, JogadoresOff.getName());
        	}
        }
	}
        
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void register(TeamInfo Team) {
        teams.put(Team, new ArrayList());
        MandarPacketsAdicionarTeams(Team);
	}
        
	@SuppressWarnings("unused")
	private static boolean removeTeam(String Nome) {
		for (TeamInfo Team : (TeamInfo[])teams.keySet().toArray(new TeamInfo[teams.size()])) {
			if (Team.PegarNome().equals(Nome)) {
				removeTeam(Team);
				return true;
			}
		}
		return false;
	}
        
	private static void removeTeam(TeamInfo Team) {
		MandarPacketsRemoverTeams(Team);
		teams.remove(Team);
	}
        
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static TeamInfo RemoverTeam(String Jogador) {
        for (TeamInfo Team : (TeamInfo[])teams.keySet().toArray(new TeamInfo[teams.size()])) {
        	List<String> list = (List)teams.get(Team);
        	for (String Tags : (String[])list.toArray(new String[list.size()])) {
        		if (Tags.equals(Jogador)) {
        			Player Jogador1 = Bukkit.getPlayerExact(Jogador);
        			if (Jogador1 != null) {
        				MandarPacketsRemoverTeams(Team, Jogador1.getName());
             	  } else {
                	OfflinePlayer Jogador2 = Bukkit.getOfflinePlayer(Tags);
                	MandarPacketsRemoverTeams(Team, Jogador2.getName());
             	  }
        			list.remove(Tags);
                
        			return Team;
        		}
        	}
        }
        return null;
	}
        
	private static TeamInfo getTeam(String name) {
		for (TeamInfo team : (TeamInfo[])teams.keySet().toArray(new TeamInfo[teams.size()])) {
			if (team.PegarNome().equals(name)) {
				return team;
			}
		}
		return null;
	}
        
	private static TeamInfo[] PegarTeams() {
		TeamInfo[] list = new TeamInfo[teams.size()];
		int at = 0;
		for (TeamInfo team : (TeamInfo[])teams.keySet().toArray(new TeamInfo[teams.size()])) {
			list[at] = team;
			at++;
		}
		return list;
	}
        
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static String[] PegarTeamJogadores(TeamInfo Team) {
		List<String> List = (List)teams.get(Team);
		if (List != null) {
			return (String[])List.toArray(new String[List.size()]);
		}
		return new String[0];
	}
        
	public static void Atualizar(String Jogador, String Prefix, String Suffix) {
		if ((Prefix == null) || (Prefix.isEmpty())) {
			Prefix = PegarPrefix(Jogador);
		} 
		if ((Suffix == null) || (Suffix.isEmpty())) {
			Suffix = PegarSuffix(Jogador);
		}
		TeamInfo t = Pegar(Prefix, Suffix); 
		AdicinarTeam(t, Jogador);
	}

	public static void Overlap(String Jogador, String Prefix, String Suffix) {
		if (Prefix == null) {
			Prefix = "";
		}
		if (Suffix == null) {
			Suffix = "";
		}
		TeamInfo t = Pegar(Prefix, Suffix);  
		AdicinarTeam(t, Jogador);
	}
        
	public static void Limpar(String player) {
		RemoverTeam(player);
	}
        
	public static String PegarPrefix(String Jogador) {
		for (TeamInfo Team : PegarTeams()) {
			for (String Tags : PegarTeamJogadores(Team)) {
				if (Tags.equals(Jogador)) {
					return Team.PegarPrefix();
				}
			}
		}
		return "";
	}
        
	public static String PegarSuffix(String Jogador) {
		for (TeamInfo Team : PegarTeams()) {
			for (String Tags : PegarTeamJogadores(Team)) {
				if (Tags.equals(Jogador)) {
					return Team.PegarSuffix();
				}
			}
		}
		return "";
	}

	public static String PegarFormattedName(String Jogador) {
		return PegarPrefix(Jogador) + Jogador + PegarSuffix(Jogador);
	}

	private static TeamInfo DeclareTeam(String Nome, String Prefix, String Suffix) {
		if (getTeam(Nome) != null) {
      	  TeamInfo Team = getTeam(Nome);
      	  removeTeam(Team);
		}
          
   	   TeamInfo Team = new TeamInfo(Nome);
	          
   	   Team.SetarPrefix(Prefix);
   	   Team.SetarSuffix(Suffix);
   	      
       register(Team);
       
       return Team;
	}

	private static TeamInfo Pegar(String Prefix, String Suffix) {
		Atualizar();
          
		Integer[] arr$ = (Integer[])list.toArray(new Integer[list.size()]);int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int t = arr$[i$].intValue();
            
		if (getTeam("NTE" + t) != null) {
			TeamInfo team = getTeam("NTE" + t);
			
			if ((team.PegarSuffix().equals(Suffix)) && (team.PegarPrefix().equals(Prefix))) {
				return team;
			}
		}
		}
          
		return DeclareTeam("NTE" + NextName(), Prefix, Suffix);
	}
 
	private static int NextName() {
     	 int at = 0;
     	 boolean cont = true;
     	 while (cont) {
       	 cont = false;
         Integer[] arr$ = (Integer[])list.toArray(new Integer[list.size()]);int len$ = arr$.length; for (int i$ = 0; i$ < len$; i$++) { int t = arr$[i$].intValue();
         if (t == at) {
        	 at++;
           	 cont = true;
    	    }
         }
     	 }
          
     	 list.add(Integer.valueOf(at));
     	 return at;
	}
       
	private static void Atualizar() {
		for (TeamInfo Team : PegarTeams()) {
			int Entry = -1;
			try {
				Entry = Integer.parseInt(Team .PegarNome());
			} catch (Exception e) {}
            
			if ((Entry != -1) && (PegarTeamJogadores(Team).length == 0)) {
				removeTeam(Team);
				list.remove(new Integer(Entry));
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static void MandarTeamsParaJogador(Player Jogador) {
		try {
			for (TeamInfo Team : PegarTeams()) {
				PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 0);
              
				PacketPlayOut.sendToPlayer(Jogador);
				PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(PegarTeamJogadores(Team)), 3);
              
				PacketPlayOut.sendToPlayer(Jogador);
			}
		} catch (Exception e) {
			System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
            
			e.printStackTrace();
		}
	}
 
	@SuppressWarnings("rawtypes")
	private static void MandarPacketsAdicionarTeams(TeamInfo Team) {
		try {
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 0);
				PacketPlayOut.sendToPlayer(Jogadores);
			}
		} catch (Exception e) {
			System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
			
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	private static void MandarPacketsRemoverTeams(TeamInfo Team) {
		boolean Cont = false;
		for (TeamInfo Team2 : PegarTeams()) {
			if (Team2 == Team) {
				Cont = true;
            }
		}
		if (!Cont) {
			return;
		}
          
		try {
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Team.PegarPrefix(), Team.PegarSuffix(), new ArrayList(), 1);
				PacketPlayOut.sendToPlayer(Jogadores);
			}
		} catch (Exception e) {
			System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
			e.printStackTrace();
		}
	}
	
	private static void MandarPacketsAdicinarTeams(TeamInfo Team, String Jogador) {
		boolean Cont = false;
		for (TeamInfo Team2 : PegarTeams()) {
			if (Team2 == Team) {
				Cont = true;
			}
		}
		if (!Cont) {
			return;
		}
		
		try {
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(new String[] { Jogador }), 3);
           
				PacketPlayOut.sendToPlayer(Jogadores);
			}
		} catch (Exception e) {
			System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
            
			e.printStackTrace();
		}
	}
	
	private static void MandarPacketsRemoverTeams(TeamInfo Team, String Jogador) {
		boolean Cont = false;
		for (TeamInfo Team2 : PegarTeams()) {
			if (Team2 == Team) {
				for (String NomeDoJogador : PegarTeamJogadores(Team2)) {
					if (NomeDoJogador.equals(Jogador)) {
						Cont = true;
					}
				}
			}
		}
		if (!Cont) {
			return;
		}
          
		try {
			for (Player Jogadores : Bukkit.getOnlinePlayers()) {
				PacketPlayOut PacketPlayOut = new PacketPlayOut(Team.PegarNome(), Arrays.asList(new String[] { Jogador }), 4);
				PacketPlayOut.sendToPlayer(Jogadores );
            }
		} catch (Exception e) {
			System.out.println("Failed to send packet for player (Packet209SetScoreboardTeam) : ");
            
			e.printStackTrace();
		}
	}

	public static void Resetar() {
		for (TeamInfo Team : PegarTeams()) {
			removeTeam(Team);
		}
	}
}