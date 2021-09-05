package me.viitor.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.API.API;
import me.viitor.API.KitAPI;
import me.viitor.configura��o.cfGrupo;
import me.viitor.configura��o.cfPermiss�o;
import me.viitor.scoreboard.sScoreAPI;

public class KitCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		if(Cmd.getName().equalsIgnoreCase("kit")){
			
			if(API.getWarp(p) != "Spawn"){
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce n�o pode executar esse comando nesse local.");
				return true;
			}
			if(Args.length == 0){
				p.sendMessage("�6�lNew�f�lPvP �6� �7Utilize /kit <Kit>");
				return true;
			}
			if(KitAPI.getKit(p) != "Nenhum"){
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce j� est� usando o kit �6" + KitAPI.getKit(p));
				return true;
			}
			if(Args[0].equalsIgnoreCase("pvp")){
				if((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "PvP");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("archer")){
				if((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Archer");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("kangaroo")){
				if(((cfPermiss�o.getPermissao(p, "kit.kangaroo") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Kangaroo");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("fisherman")){
				if((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono") || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Fisherman");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("cactus")){
				if((cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Cactus");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("monk")){
				if(((cfPermiss�o.getPermissao(p, "kit.monk") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Monk");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("ninja")){
				if(((cfPermiss�o.getPermissao(p, "kit.ninja") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Ninja");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("phantom")){
				if(((cfPermiss�o.getPermissao(p, "kit.phantom") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Phantom");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("grappler")){
				if(((cfPermiss�o.getPermissao(p, "kit.grappler") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Grappler");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("viper")){
				if(((cfPermiss�o.getPermissao(p, "kit.viper") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Viper");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("snail")){
				if(((cfPermiss�o.getPermissao(p, "kit.snail") || cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Trial") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.light || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))))){
				KitAPI.setKitAntes(p, "Snail");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("hulk")){
				if((((cfPermiss�o.getPermissao(p, "kit.hulk") || cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))){
				KitAPI.setKitAntes(p, "Hulk");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("timelord")){
				if((((cfPermiss�o.getPermissao(p, "kit.timelord") || cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "S-Pro") || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro)))))))))))))){
				KitAPI.setKitAntes(p, "Timelord");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("thor")){
				if((((cfPermiss�o.getPermissao(p, "kit.thor") || cfGrupo.ChecarGrupo(p, "Mvp")  || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Thor");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("switcher")){
				if((((cfPermiss�o.getPermissao(p, "kit.switcher") || cfGrupo.ChecarGrupo(p, "Mvp")  || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Switcher");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("gladiator")){
				if((((cfPermiss�o.getPermissao(p, "kit.gladiator") || cfGrupo.ChecarGrupo(p, "Mvp")  || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.mvp || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Gladiator");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("stomper")){
				if(((((cfPermiss�o.getPermissao(p, "kit.stomper") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Builder")  || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Stomper");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("magma")){
				if(((((cfPermiss�o.getPermissao(p, "kit.magma") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit|| GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Magma");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("grandpa")){
				if(((((cfPermiss�o.getPermissao(p, "kit.grandpa")  || (cfGrupo.ChecarGrupo(p, "Builder") || cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Grandpa");
				
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("ajnin")){
				if(((((cfPermiss�o.getPermissao(p, "kit.ajnin") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Ajnin");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("firelauncher")){
				if(((((cfPermiss�o.getPermissao(p, "kit.firelauncher") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "FireLauncher");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("strong")){
				if(((((cfPermiss�o.getPermissao(p, "kit.strong") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Strong");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
			if(Args[0].equalsIgnoreCase("sumo")){
				if(((((cfPermiss�o.getPermissao(p, "kit.sumo") || cfGrupo.ChecarGrupo(p, "Pro")  || (cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")  || GiveAllCommand.fullkit || GiveAllCommand.pro))))))))))))){
				KitAPI.setKitAntes(p, "Sumo");
				p.sendMessage("�6�lNew�f�lPvP �6� �7Voce selecionou o kit �6" + KitAPI.getKitAntes(p));

				sScoreAPI.scoreboard(p);
				if(p.getGameMode() == GameMode.CREATIVE){
					p.setGameMode(GameMode.SURVIVAL);
				}
				}else{
					p.sendMessage("�6�lNew�f�lPvP �6� �7Voce nao possui esta permissao");
					return true;
				}
			}
		}
		return false;
	}

}
