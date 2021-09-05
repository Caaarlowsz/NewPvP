package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.ChatInterativo;
import me.viitor.configuração.cfGrupo;

public class TagsCommand implements CommandExecutor{
	
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("tags")){
			
			if(cfGrupo.ChecarGrupo(p, "Dono")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §4§lDONO", "/tag dono", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §c§lADMIN", "/tag admin", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §c§lGERENTE", "/tag gerente", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lMODPLUS", "/tag modplus", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lMOD", "/tag mod", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lTRIAL", "/tag trial", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSTAFF", "/tag staff", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §2§lBUILDER", "/tag builder", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lHELPER", "/tag helper", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §3§lYTPLUS", "/tag ytplus", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §b§lYT", "/tag yt", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSEMIPRO", "/tag semipro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Admin")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §c§lADMIN", "/tag admin", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §c§lGERENTE", "/tag gerente", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lMODPLUS", "/tag modplus", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lMOD", "/tag mod", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lTRIAL", "/tag trial", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSTAFF", "/tag staff", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §2§lBUILDER", "/tag builder", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lHELPER", "/tag helper", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §3§lYTPLUS", "/tag ytplus", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §b§lYT", "/tag yt", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSEMIPRO", "/tag semipro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §c§lGERENTE", "/tag gerente", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lMODPLUS", "/tag modplus", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lMOD", "/tag mod", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lTRIAL", "/tag trial", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSTAFF", "/tag staff", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §2§lBUILDER", "/tag builder", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lHELPER", "/tag helper", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §3§lYTPLUS", "/tag ytplus", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §b§lYT", "/tag yt", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSEMIPRO", "/tag semipro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Mod+")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lMODPLUS", "/tag modplus", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSTAFF", "/tag staff", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Mod")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lMOD", "/tag mod", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSTAFF", "/tag staff", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Trial")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §5§lTRIAL", "/tag trial", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSTAFF", "/tag staff", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Builder")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §2§lBUILDER", "/tag builder", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Helper")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lHELPER", "/tag helper", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Youtuber+")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §3§lYTPLUS", "/tag ytplus", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §b§lYT", "/tag yt", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSEMIPRO", "/tag semipro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Youtuber")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §b§lYT", "/tag yt", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSEMIPRO", "/tag semipro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "S-Pro")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §e§lSEMIPRO", "/tag semipro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Pro")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §6§lPRO", "/tag pro", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Mvp")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §9§lMVP", "/tag mvp", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Light")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §a§lLIGHT", "/tag light", "§7Clique para selecionar esta tag");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
			if(cfGrupo.ChecarGrupo(p, "Membro")){
				p.sendMessage(" ");
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tags que voce possui:");
				p.sendMessage(" ");
				ChatInterativo.Comando(p.getName(), "§7▪ §7§lNORMAL", "/tag normal", "§7Clique para selecionar esta tag");
				p.sendMessage(" ");
				return true;
			}
		}
		return false;
	}
	
}
