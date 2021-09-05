package me.viitor.commands;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;

public class CorTextoCommand implements CommandExecutor {
	
	public static HashMap<Player, String> Cortexto = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("cortexto")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") || !cfGrupo.ChecarGrupo(p, "Gerente") || !cfGrupo.ChecarGrupo(p, "Admin") || !cfGrupo.ChecarGrupo(p, "Mod+") || !cfGrupo.ChecarGrupo(p, "Mod") || !cfGrupo.ChecarGrupo(p, "Trial") || !cfGrupo.ChecarGrupo(p, "Youtuber+") || !cfGrupo.ChecarGrupo(p, "Youtuber") || !cfGrupo.ChecarGrupo(p, "S-Pro") || !cfGrupo.ChecarGrupo(p, "Pro") || !cfGrupo.ChecarGrupo(p, "Mvp")) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /cortexto <ColorID>");
				return true;
			}
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("a")) {
					Cortexto.put(p, "a");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §aVerde claro");
					return true;
				}
				if(args[0].equalsIgnoreCase("b")) {
					Cortexto.put(p, "b");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §bAzul claro");
					return true;
				}
				if(args[0].equalsIgnoreCase("c")) {
					Cortexto.put(p, "c");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §cVermelho claro");
					return true;
				}
				if(args[0].equalsIgnoreCase("d")) {
					Cortexto.put(p, "d");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §dRosa");
					return true;
				}
				if(args[0].equalsIgnoreCase("e")) {
					Cortexto.put(p, "e");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §eAmarelo");
					return true;
				}
				if(args[0].equalsIgnoreCase("f")) {
					Cortexto.put(p, "f");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §fBranco");
					return true;
				}
				if(args[0].equalsIgnoreCase("0")) {
					Cortexto.put(p, "0");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §0Preto");
					return true;
				}
				if(args[0].equalsIgnoreCase("1")) {
					Cortexto.put(p, "1");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §1Azul escuro");
					return true;
				}
				if(args[0].equalsIgnoreCase("2")) {
					Cortexto.put(p, "2");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §2Verde escuro");
					return true;
				}
				if(args[0].equalsIgnoreCase("3")) {
					Cortexto.put(p, "3");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §3Azul ciano");
					return true;
				}
				if(args[0].equalsIgnoreCase("4")) {
					Cortexto.put(p, "4");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §4Vermelho escuro");
					return true;
				}
				if(args[0].equalsIgnoreCase("5")) {
					Cortexto.put(p, "5");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §5Roxo");
					return true;
				}
				if(args[0].equalsIgnoreCase("6")) {
					Cortexto.put(p, "6");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §6Dourado");
					return true;
				}
				if(args[0].equalsIgnoreCase("7")) {
					Cortexto.put(p, "7");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §7Cinza claro");
					return true;
				}
				if(args[0].equalsIgnoreCase("8")) {
					Cortexto.put(p, "8");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §8Cinza escuro");
					return true;
				}
				if(args[0].equalsIgnoreCase("9")) {
					Cortexto.put(p, "9");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §9Azul");
					return true;
				}
				if(args[0].equalsIgnoreCase("l")) {
					Cortexto.put(p, "l");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §lNegrito");
					return true;
				}
				if(args[0].equalsIgnoreCase("n")) {
					Cortexto.put(p, "n");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §nSublinhado");
					return true;
				}
				if(args[0].equalsIgnoreCase("o")) {
					Cortexto.put(p, "o");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §oItalico");
					return true;
				}
				if(args[0].equalsIgnoreCase("r")) {
					Cortexto.put(p, "r");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §7Resetar");
					return true;
				}
				if(args[0].equalsIgnoreCase("m")) {
					Cortexto.put(p, "m");
					p.sendMessage("§6§lNew§f§lPvP §6» §7A cor de suas mensagens foram alteradas para: §mCortado");
					return true;
				} else {
					p.sendMessage("§6§lNew§f§lPvP §6» §7O ColorID §6§l" + args[0] + " §7nao foi encontrado");
					return true;
				}
			}
		}
		return false;
	}

}
