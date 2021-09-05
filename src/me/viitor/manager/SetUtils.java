package me.viitor.manager;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.cfStatus;
import me.viitor.bans.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.scoreboard.sScoreAPI;

public class SetUtils implements CommandExecutor {
	
	private boolean ChecarNumero(String Numero){
		try {
			Integer.parseInt(Numero);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
	}
	
	private static int getKills(Player p) {
		return cfStatus.getKills(p);
	}
	
	private static int getDeaths(Player p) {
		return cfStatus.getDeaths(p);
	}
	
	private static int getMoney(Player p) {
		return cfStatus.getMoney(p);
	}
	
	private static void addKills(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Kills", getKills(p) + valor);
	}
	
	private static void setKills(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Kills", valor);
	}
	
	private static void removeKills(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Kills", getKills(p) - valor);
	}
	
	private static void addDeaths(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Deaths", getDeaths(p) + valor);
	}
	
	private static void setDeaths(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Deaths", valor);
	}
	
	private static void removeDeaths(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Deaths", getDeaths(p) - valor);
	}
	
	private static void addMoney(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Money", getMoney(p) + valor);
	}
	
	private static void setMoney(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Money", valor);
	}
	
	private static void removeMoney(Player p, int valor) {
		cfStatus.cfile.set(p.getName() + ".Money", getMoney(p) - valor);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("kills")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")) {
				API.sendMsg(p, "§6§lNash§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /kills <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /kills <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 2) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /kills <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 3) {
				Player k = Bukkit.getPlayer(args[1]);
				String valor = args[2];
				int valori = valor.length();
				if(!ChecarNumero(valor)) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize apenas numeros");
					return true;
				}
				if(k == null) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + args[1] + " §7encontra-se §6§lOFFLINE");
					return true;
				}
				if(k != null) {
					if(args[0].equalsIgnoreCase("add")) {
						addKills(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce adicionou §6" + valor + " kills §7ao jogador §6" + k.getName());
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7adicionou §6" + valor + " kills §7a sua conta");
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
					if(args[0].equalsIgnoreCase("set")) {
						setKills(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce setou as kills de §6" + k.getName() + "§7 para §6" + valor);
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7setou suas kills para §6" + valor);
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
					if(args[0].equalsIgnoreCase("remove")) {
						removeKills(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce removeu §6" + valor + " kills §7do jogador §6" + k.getName());
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7removeu §6" + valor + " kills §7da sua conta");
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("deaths")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")) {
				API.sendMsg(p, "§6§lNash§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /deaths <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /deaths <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 2) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /deaths <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 3) {
				Player k = Bukkit.getPlayer(args[1]);
				String valor = args[2];
				int valori = valor.length();
				if(!ChecarNumero(valor)) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize apenas numeros");
					return true;
				}
				if(k == null) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + args[1] + " §7encontra-se §6§lOFFLINE");
					return true;
				}
				if(k != null) {
					if(args[0].equalsIgnoreCase("add")) {
						addDeaths(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce adicionou §6" + valor + " deaths §7ao jogador §6" + k.getName());
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7adicionou §6" + valor + " deaths §7a sua conta");
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
					if(args[0].equalsIgnoreCase("set")) {
						setDeaths(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce setou as deaths de §6" + k.getName() + "§7 para §6" + valor);
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7setou suas deaths para §6" + valor);
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
					if(args[0].equalsIgnoreCase("remove")) {
						removeDeaths(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce removeu §6" + valor + " deaths §7do jogador §6" + k.getName());
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7removeu §6" + valor + " deaths §7da sua conta");
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
				}
			}
		}
		if(cmd.getName().equalsIgnoreCase("money")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")) {
				API.sendMsg(p, "§6§lNash§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /money <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 1) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /money <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 2) {
				p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize /money <Add/Set/Remove> <Jogador> <Quantia>");
				return true;
			}
			if(args.length == 3) {
				Player k = Bukkit.getPlayer(args[1]);
				String valor = args[2];
				int valori = valor.length();
				if(!ChecarNumero(valor)) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7Utilize apenas numeros");
					return true;
				}
				if(k == null) {
					p.sendMessage("§6§lNash§f§lPvP §6» §7O jogador §6" + args[1] + " §7encontra-se §6§lOFFLINE");
					return true;
				}
				if(k != null) {
					if(args[0].equalsIgnoreCase("add")) {
						addMoney(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce adicionou §6" + valor + " coins §7ao jogador §6" + k.getName());
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7adicionou §6" + valor + " coins §7a sua conta");
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
					if(args[0].equalsIgnoreCase("set")) {
						setMoney(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce setou os coins de §6" + k.getName() + "§7 para §6" + valor);
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7setou seus coins para §6" + valor);
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
					if(args[0].equalsIgnoreCase("remove")) {
						removeMoney(k, valori);
						p.sendMessage("§6§lNash§f§lPvP §6» §7Voce removeu §6" + valor + " coins §7do jogador §6" + k.getName());
						k.sendMessage("§6§lNash§f§lPvP §6» §7O staffer §6" + p.getName() + " §7removeu §6" + valor + " coins §7da sua conta");
						cfStatus.Save();
						sScoreAPI.scoreboard(k);
						return true;
					}
				}
			}
		}
		return false;
	}
}
