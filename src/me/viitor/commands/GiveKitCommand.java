package me.viitor.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configura��o.cfGrupo;
import me.viitor.configura��o.cfPermiss�o;

public class GiveKitCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("givekit")) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente")){
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui permissao para utilizar este comando.");
				return true;
			}
			if(args.length == 0) {
				p.sendMessage("�6�lNew�f�lPvP �6� �7Utilize /givekit <Jogador> <Kit>");
				return true;
			}
			if(args.length == 1) {
				
			}
			if(args.length == 2) {
				String kit = args[1];
				Player k = Bukkit.getPlayer(args[0]);
				if(kit.equalsIgnoreCase("pvp")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6PvP �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6PvP");
					cfPermiss�o.setarPermissao(k, "kit.pvp", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("archer")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Archer �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Archer");
					cfPermiss�o.setarPermissao(k, "kit.archer", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("kangaroo")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Kangaroo �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Kangaroo");
					cfPermiss�o.setarPermissao(k, "kit.kangaroo", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("fisherman")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Fisherman �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Fisherman");
					cfPermiss�o.setarPermissao(k, "kit.fisherman", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("cactus")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Cactus �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Cactus");
					cfPermiss�o.setarPermissao(k, "kit.cactus", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("monk")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Monk �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Monk");
					cfPermiss�o.setarPermissao(k, "kit.", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("ninja")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Ninja �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Ninja");
					cfPermiss�o.setarPermissao(k, "kit.ninja", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("phantom")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Phantom �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Phantom");
					cfPermiss�o.setarPermissao(k, "kit.phantom", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("grappler")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Grappler �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Grappler");
					cfPermiss�o.setarPermissao(k, "kit.grappler", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("viper")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Vipder �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Viper");
					cfPermiss�o.setarPermissao(k, "kit.viper", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("snail")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Snail �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Snail");
					cfPermiss�o.setarPermissao(k, "kit.snail", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("hulk")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Hulk �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Hulk");
					cfPermiss�o.setarPermissao(k, "kit.hulk", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("timelord")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6TimeLord �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6TimeLord");
					cfPermiss�o.setarPermissao(k, "kit.timelord", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("thor")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Thor �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Thor");
					cfPermiss�o.setarPermissao(k, "kit.thor", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("switcher")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Switcher �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Switcher");
					cfPermiss�o.setarPermissao(k, "kit.switcher", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("gladiator")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Gladiator �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Gladiator");
					cfPermiss�o.setarPermissao(k, "kit.gladiator", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("stomper")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Stomper �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Stomper");
					cfPermiss�o.setarPermissao(k, "kit.stomper", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("magma")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Magma �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Magma");
					cfPermiss�o.setarPermissao(k, "kit.magma", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("grandpa")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Grandpa �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Grandpa");
					cfPermiss�o.setarPermissao(k, "kit.grandpa", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("ajnin")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Ajnin �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Ajnin");
					cfPermiss�o.setarPermissao(k, "kit.ajnin", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("firelauncher")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6FireLauncher �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6FireLauncher");
					cfPermiss�o.setarPermissao(k, "kit.firelauncher", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("strong")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �Strong �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Strong");
					cfPermiss�o.setarPermissao(k, "kit.strong", "true");
					return true;
				}
				if(kit.equalsIgnoreCase("sumo")) {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce deu o KIT �6Sumo �7ao jogador �6" + k.getName());
					k.sendMessage("�6�lNew�f�lPvP �6� �7Voce ganhou o KIT �6Sumo");
					cfPermiss�o.setarPermissao(k, "kit.sumo", "true");
					return true;
				} else {
					p.sendMessage("�6�lNew�f�lPvP �6� �7Kit inexistente");
					return true;
				}
			}
		}
		return false;
	}
}
