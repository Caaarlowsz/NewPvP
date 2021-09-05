package me.viitor.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfPermissão;
import me.viitor.nametag.Array;
import me.viitor.nametag.NameTagChangeEvento;
import me.viitor.nametag.NametagUtils;
import me.viitor.nametag.PlayerLoader;
import me.viitor.scoreboard.sScoreAPI;


public class TagCommand implements CommandExecutor{

	public boolean onCommand(CommandSender Sender, Command Cmd, String Label, String[] Args) {
		
		Player p = (Player)Sender;
		
		if(Cmd.getName().equalsIgnoreCase("tag")){
			
			if(Args.length == 0){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Utilize /tag <Tag> ou /tags");
				return true;
			}
			if(Args[0].equalsIgnoreCase("bot")){
				if(p.getName().equalsIgnoreCase("MoradorDeRua") || p.getName().equalsIgnoreCase("Hoooligans") || p.getName().equalsIgnoreCase("NewNetworkMC")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §3§l§oBOT");
					p.setDisplayName("§3§l§oBOT §3§o" + p.getName());
					 String prefix = "§0§3§l§oBOT §3§o";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("winner")){
				if(p.getName().equalsIgnoreCase("MoradorDeRua") || p.getName().equalsIgnoreCase("Hoooligans")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §2§lWINNER");
					p.setDisplayName("§2§lWINNER §2" + p.getName());
					 String prefix = "§0§2§lWINNER §2";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("estrela")){
				if(p.getName().equalsIgnoreCase("MoradorDeRua") || p.getName().equalsIgnoreCase("Hoooligans")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §1§lESTRELA");
					p.setDisplayName("§1§lESTRELA §1" + p.getName());
					 String prefix = "§0§1§lESTRELA §1";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("delicia")){
				if(p.getName().equalsIgnoreCase("MoradorDeRua") || p.getName().equalsIgnoreCase("Hoooligans")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §d§lDELICIA");
					p.setDisplayName("§d§lDELICIA §d" + p.getName());
					 String prefix = "§0§d§lDELICIA §d";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("coder")){
				if(p.getName().equalsIgnoreCase("MoradorDeRua") || p.getName().equalsIgnoreCase("Hoooligans")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §3§lCODER");
					p.setDisplayName("§3§lCODER §3" + p.getName());
					 String prefix = "§0§3§lCODER §3";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("client")){
				if(p.getName().equalsIgnoreCase("MoradorDeRua") || p.getName().equalsIgnoreCase("Hoooligans")) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §c§lCLIENT");
					p.setDisplayName("§c§lCLIENT §4" + p.getName());
					 String prefix = "§0§c§lCLIENT §4";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Tag inexistente");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("dono")){
				if(cfGrupo.ChecarGrupo(p, "Dono")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §4§lDONO");
					p.setDisplayName("§4§lDONO §4" + p.getName());
					 String prefix = "§0§4§lDONO §4";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("gerente")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §c§lGERENTE");
					p.setDisplayName("§c§lGERENTE §c" + p.getName());
					 String prefix = "§0§c§lGERENTE §c";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("admin")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §c§lADMIN");
					p.setDisplayName("§c§lADMIN §c" + p.getName());
					 String prefix = "§0§c§lADMIN §c";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("modplus")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §5§lMODPLUS");
					p.setDisplayName("§5§lMOD+ §5" + p.getName());
					 String prefix = "§0§5§lMOD+ §5";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("mod")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §5§lMOD");
					p.setDisplayName("§5§lMOD §5" + p.getName());
					 String prefix = "§0§5§lMOD §5";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("trial")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Trial")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §5§lTRIAL");
					p.setDisplayName("§5§lTRIAL §5" + p.getName());
					 String prefix = "§0§5§lTRIAL §5";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("builder")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Builder")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §2§lBUILDER");
					p.setDisplayName("§2§lBUILDER §2" + p.getName());
					 String prefix = "§0§2§lBUILDER §2";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("helper")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Helper")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §9§lHELPER");
					p.setDisplayName("§9§lHELPER §9" + p.getName());
					 String prefix = "§0§9§lHELPER §9";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("ytplus")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Youtuber+")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §3§lYOUTUBERPLUS");
					p.setDisplayName("§3§lYT+ §3" + p.getName());
					 String prefix = "§0§3§lYT+ §3";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("staff")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Trial")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §e§lSTAFF");
					p.setDisplayName("§e§lSTAFF §e" + p.getName());
					 String prefix = "§0§e§lSTAFF §e";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("exstaff")){
				if(cfPermissão.getPermissao(p, "tag.exstaff")) {
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §8§lEXSTAFF");
					p.setDisplayName("§8§lEXSTAFF §8" + p.getName());
					 String prefix = "§0§8§lEXSTAFF §8";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("yt")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Youtuber")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §b§lYOUTUBER");
					p.setDisplayName("§b§lYT §b" + p.getName());
					 String prefix = "§0§b§lYT §b";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("semipro")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "S-Pro")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §e§lSEMIPRO");
					p.setDisplayName("§e§lSEMIPRO §e" + p.getName());
					 String prefix = "§0§e§lSEMIPRO §e";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("pro")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §6§lPRO");
					p.setDisplayName("§6§lPRO §6" + p.getName());
					 String prefix = "§0§6§lPRO §6";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("mvp")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mvp") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §9§lMVP");
					p.setDisplayName("§9§lMVP §9" + p.getName());
					 String prefix = "§0§9§lMVP §9";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("light")){
				if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Light") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod")){
					p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §a§lLIGHT");
					p.setDisplayName("§a§lLIGHT §a" + p.getName());
					 String prefix = "§0§a§lLIGHT §a";
					 NameTagChangeEvento.NametagChangeReason reason = null;
			          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
			          prefix = NametagUtils.formatColors(prefix);
			          
			          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
			          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
			          suffix = NametagUtils.formatColors(suffix);
			          
			           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
			           PlayerLoader.update(p.getName(), prefix , suffix);
				}else{
				p.sendMessage("§6§lNew§f§lPvP §6» §7Voce nao possui esta tag");
				}
				return true;
			}
			if(Args[0].equalsIgnoreCase("normal")){
				p.sendMessage("§6§lNew§f§lPvP §6» §7Sua tag foi alterada para: §7§lNORMAL");
				p.setDisplayName("§7" + p.getName());
				 String prefix = "§0§7";
				 NameTagChangeEvento.NametagChangeReason reason = null;
		          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
		          prefix = NametagUtils.formatColors(prefix);
		          
			      String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
		          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
		          suffix = NametagUtils.formatColors(suffix);
		          
		           Array.SetarNameTagSoft(p.getName(), prefix , suffix , reason);
		           PlayerLoader.update(p.getName(), prefix , suffix);
			}else{
			p.sendMessage("§6§lNew§f§lPvP §6» §7Tag inexistente");
			}
			return true;
		}
		return false;
	}

}
