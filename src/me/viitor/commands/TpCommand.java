package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.configuração.cfGrupo;
import me.viitor.events.CorGrupo;

public class TpCommand implements CommandExecutor{
	
	private boolean CheckarNumero(String Numero){
		try {
			Integer.parseInt(Numero);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
		
	}
	
	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("tp")){
			
			if((!cfGrupo.ChecarGrupo(p, "Dono") && (!cfGrupo.ChecarGrupo(p, "Gerente") && (!cfGrupo.ChecarGrupo(p, "Admin") && (!cfGrupo.ChecarGrupo(p, "Mod+") && (!cfGrupo.ChecarGrupo(p, "Mod") && (!cfGrupo.ChecarGrupo(p, "Trial") && (!cfGrupo.ChecarGrupo(p, "Youtuber+") && (!cfGrupo.ChecarGrupo(p, "Helper")))))))))){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			
			if(Args.length == 0){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /tp <Jogador> [Alvo] ou /tp <X> <Y> <Z>");
				return true;
			}
			if(Args.length > 2 || Args.length == 3){
				if (!CheckarNumero(Args[0])) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Use apenas numeros nas coordenadas");
					return true;
				}
				Integer X = Integer.parseInt(Args[0]);
				if(Args.length == 1){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /tp <Jogador> [Alvo] ou /tp <X> <Y> <Z>");
					return true;
				}
				if (!CheckarNumero(Args[1])) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Use apenas numeros nas coordenadas");
					return true;
				}
				Integer Y = Integer.parseInt(Args[1]);
				if(Args.length == 2){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /tp <Jogador> [Alvo] ou /tp <X> <Y> <Z>");
					return true;
				}
				if (!CheckarNumero(Args[2])) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Use apenas numeros nas coordenadas");
					return true;
				}
				Integer Z = Integer.parseInt(Args[2]);
				p.teleport(new Location(p.getWorld(), X, Y, Z));
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce foi teleportado para as coordenadas: §6" + X + " " + Y + " " + Z);
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) teleportou-se para as coordenadas: " + X + " " + Y + " " + Z);
				return true;
			}
			Player t = Bukkit.getPlayerExact(Args[0]);
			if((t == null || (!(t instanceof Player)))){
				return true;
			}
			if (Args.length > 1) {
				if (Args.length == 1) {
					return true;
				}
				Player t2 = Bukkit.getPlayer(Args[1]);
				t.teleport(t2.getLocation());
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce teleportou o jogador §6" + t.getName() + " §7ate sua localizacao atual");
				API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) puxou o jogador " + t.getDisplayName() + " §7(" + CorGrupo.getTag(t) + cfGrupo.pegargrupo().get("grupos." + t.getUniqueId() + ".grupo") + "§7)");
				return true;
			}
			p.teleport(t.getLocation());
			p.sendMessage("§6§lNew§f§lPvP §6» §7Voce foi teleportado ate o jogador §6" + t.getName());
			API.sendWarn("§6§lNew§f§lPvP §6» §7O staffer " + p.getDisplayName() + "§7 (" + CorGrupo.getTag(p) + cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo") + "§7) teleportou-se ate o jogador " + t.getDisplayName() + " §7(" + CorGrupo.getTag(t) + cfGrupo.pegargrupo().get("grupos." + t.getUniqueId() + ".grupo") + "§7)");
		
		}
		return false;	
	}
}
