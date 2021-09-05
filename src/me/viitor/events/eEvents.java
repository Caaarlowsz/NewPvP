package me.viitor.events;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.potion.PotionEffectType;

import me.viitor.API.API;
import me.viitor.API.ArraysAPI;
import me.viitor.API.KitAPI;
import me.viitor.API.KitdiarioAPI;
import me.viitor.API.TopKillStreak;
import me.viitor.API.WarpsAPI;
import me.viitor.bans.Config;
import me.viitor.combatlog.CombatLog;
import me.viitor.commands.AdminCommand;
import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfStatus;
import me.viitor.invencivel.Proteção;
import me.viitor.main.Main;
import me.viitor.nametag.Array;
import me.viitor.nametag.NameTagChangeEvento;
import me.viitor.nametag.NametagUtils;
import me.viitor.nametag.PlayerLoader;
import me.viitor.scoreboard.sScoreAPI;
import net.md_5.bungee.api.ChatColor;

public class eEvents implements Listener{
	
	public static void acharTag(Player p) {
		if(cfGrupo.ChecarGrupo(p, "Dono")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Admin")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Gerente")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Mod+")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Mod")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Trial")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Youtuber+")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Helper")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Builder")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Youtuber")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "S-Pro")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Pro")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Mvp")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Light")) {
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
		}
		if(cfGrupo.ChecarGrupo(p, "Membro")) {
			p.setDisplayName("§7" + p.getName());
			 String prefix = "§0§7";
			 NameTagChangeEvento.NametagChangeReason reason = null;
	          reason = NameTagChangeEvento.NametagChangeReason.SET_PREFIX;
	          prefix = NametagUtils.formatColors(prefix);
	          
	          String suffix = " §0§7(" + sScoreAPI.getRank(p) + "§7)";
	          reason = NameTagChangeEvento.NametagChangeReason.SET_SUFFIX;
	          suffix = NametagUtils.formatColors(suffix);
	          
	           Array.SetarNameTagSoft(p.getName(), prefix , suffix, reason);
	           PlayerLoader.update(p.getName(), prefix , suffix);
		}
	}
	
	
	@SuppressWarnings("static-access")
	@EventHandler
	public void login(PlayerLoginEvent e){
		
		Player p = e.getPlayer();
		if(e.getResult() != e.getResult().KICK_WHITELIST){
				API.checarNameTag(p);
	  }
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void join(PlayerJoinEvent e){
		
		e.setJoinMessage(null);
		
		Player p = e.getPlayer();
		
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Nome", p.getName());
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".UUID", p.getUniqueId().toString());
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".IP", p.getAddress().getHostString());
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Grupo", cfGrupo.pegargrupo().get("grupos." + p.getUniqueId() + ".grupo"));
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Rank", sScoreAPI.getNomeRankConfig(p));
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Coins", cfStatus.getMoney(p));
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Kills", cfStatus.getKills(p));
		Config.getConfig().getJogadores().set("Jogadores." + p.getUniqueId() + ".Deaths", cfStatus.getDeaths(p));
		Config.getConfig().saveJogadores();
		
		p.setWalkSpeed(0.2F);
		Proteção.setImortal(p, true);
		Proteção.isImortal(p);
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		p.setGameMode(GameMode.ADVENTURE);
		
		sScoreAPI.Score.add(p);
		ArraysAPI.Jogando.add(p);
		ArraysAPI.Admin.remove(p);
		
		API.setWarp(p, "Spawn");
		WarpsAPI.Ir(p, "Spawn");
		
		API.sendItems(p);
		
		API.mandarTitulo(p, "§6§lNash§f§lPvP §6» §7");
		API.mandarSubTitulo(p, "§7Olá, §e" + p.getName());
		
		API.checarPermissao(p);
		
		API.checarGrupo(p);
		API.corGrupo(p);
		API.checarConfig(p);
		API.checarAlgumasCoisas(p);
		API.setarKitPadrao(p);
		
		ArraysAPI.CooldownChat.remove(p);
		
		KitdiarioAPI.iniciarContagem(p);
					
		KitAPI.removeKits(p);
		AdminCommand.checarAdmin();
		cfStatus.FirstJoin(p);
		
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		
		p.setHealth(20.0D);
		p.setMaxHealth(20.0D);
		
		sScoreAPI.scoreboard(p);
		
				
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					API.sendItems(p);
				}
			}, 1L);
			
	for(int i = 1; i < 100; i++) {
		p.sendMessage(" ");
	}
	p.sendMessage("§6§lNash§f§lPvP §6» §7");
	p.sendMessage(" ");
	p.sendMessage("§7Seja bem-vindo ao servidor de KitPvP");
	p.sendMessage("§7Compre VIPs, KITs, UNBANs e muito mais em nosso site: §6§nmc-new.com.br");
	p.sendMessage(" ");
	p.sendMessage("§7Agradecemos sua jogatina em nosso servidor");
	p.sendMessage(" ");
	
	if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Admin") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Mod") || cfGrupo.ChecarGrupo(p, "Trial") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Helper")) {
		p.chat("/admin");
	}
	
	for(Player todos : Bukkit.getOnlinePlayers()) {
		if(ArraysAPI.Admin.contains(todos)) {
			if(!cfGrupo.ChecarGrupo(p, "Dono") && !cfGrupo.ChecarGrupo(p, "Admin") && !cfGrupo.ChecarGrupo(p, "Gerente") && !cfGrupo.ChecarGrupo(p, "Mod+") && !cfGrupo.ChecarGrupo(p, "Mod") && !cfGrupo.ChecarGrupo(p, "Trial") && !cfGrupo.ChecarGrupo(p, "Youtuber+")) {
				p.hidePlayer(todos);
				todos.showPlayer(p);
			}
		}
	}
	
	  TopKillStreak.Ks.put(p, Integer.valueOf(0));
	  for (Player players : Bukkit.getOnlinePlayers()) {
		  TopKillStreak.KsTop.put(p, TopKillStreak.getKsTop(players));
		  TopKillStreak.Name.put(p, TopKillStreak.getNameTop(players));
	 }
		if(cfGrupo.ChecarGrupo(p, "Dono") || cfGrupo.ChecarGrupo(p, "Gerente")) {
			ArraysAPI.Monitor.add(p);
		}
		ArraysAPI.CooldownChat.remove(p);
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void death(PlayerDeathEvent e){
		
		Player p = e.getEntity();
		Player d = e.getEntity().getKiller();
		WarpsAPI.Ir(p, "Spawn");
		API.setWarp(p, "Spawn");
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				p.spigot().respawn();
			}
		  }, 1L);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
			public void run() {
				API.sendItems(p);
			}
		}, 2L);
		
		
        if(KitAPI.getKit(p) != "1v1"){			
		WarpsAPI.Ir(p, "Spawn");
		API.setWarp(p, "Spawn");
		KitAPI.removeKits(p);
		
		
				if(d != null){
					
			p.sendMessage("§7Você morreu para o jogador §c" + d.getName());
			d.sendMessage("§7Você matou o jogador §a" + p.getName());
			
			cfStatus.setKills(d);
			cfStatus.setDeaths(p);
			cfStatus.setMoney(d, 100);
			cfStatus.addXP(d, 100);
			cfStatus.RemoveMoney(p, 50);
			cfStatus.removeXp(p, 50);
			cfStatus.RemoverKS(p);
			
			TopKillStreak.createTopKillStreak(d);
			
			e.setDeathMessage(null);
			e.getDrops().clear();
			
			if(cfStatus.getKills(d) == 100) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 200) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 300) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 400) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 500) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 600) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 700) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 800) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 900) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			if(cfStatus.getKills(d) == 1500) {
				d.sendMessage("§6§lNash§f§lPvP §6» §7Paranéns, você upou de rank!");
				d.sendMessage("§6§lNash§f§lPvP §6» §7Seu novo rank é " + sScoreAPI.getRank(d) + " " + sScoreAPI.getNomeRank(d));
				eEvents.acharTag(d);
				sScoreAPI.scoreboard(d);
			}
			
			if(CombatLog.combat.contains(p)) {
				CombatLog.combat.remove(d);
			} else {
				return;
			}
			
			if(TopKillStreak.getKsTop(p) == 5){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n5");
			}
			if(TopKillStreak.getKsTop(p) == 10){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n10");
			}
			if(TopKillStreak.getKsTop(p) == 15){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n15");
			}
			if(TopKillStreak.getKsTop(p) == 20){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n20");
			}
			if(TopKillStreak.getKsTop(p) == 25){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n25");
			}
			if(TopKillStreak.getKsTop(p) == 30){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n30");
			}
			if(TopKillStreak.getKsTop(p) == 35){
				Bukkit.broadcastMessage("§6" +d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n35");
			}
			if(TopKillStreak.getKsTop(p) == 40){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n40");
			}
			if(TopKillStreak.getKsTop(p) == 45){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n45");
			}
			if(TopKillStreak.getKsTop(p) == 50){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n50");
			}
			if(TopKillStreak.getKsTop(p) == 55){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n55");
			}
			if(TopKillStreak.getKsTop(p) == 60){
				Bukkit.broadcastMessage("§6" +d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n60");
			}
			if(TopKillStreak.getKsTop(p) == 65){
				Bukkit.broadcastMessage("§6" +d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n65");
			}
			if(TopKillStreak.getKsTop(p) == 70){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n75");
			}
			if(TopKillStreak.getKsTop(p) == 75){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n80");
			}
			if(TopKillStreak.getKsTop(p) == 80){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n85");
			}
			if(TopKillStreak.getKsTop(p) == 85){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n85");
			}
			if(TopKillStreak.getKsTop(p) == 90){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n90");
			}
			if(TopKillStreak.getKsTop(p) == 95){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n95");
			}
			if(TopKillStreak.getKsTop(p) == 100){
				Bukkit.broadcastMessage("§6" + d.getName() + " §7esta com um §6§lKILLSTREAK §7de §6§n100");
			}else{
			e.setDeathMessage(null);
			e.getDrops().clear();
			
			  TopKillStreak.Ks.put(p, Integer.valueOf(0));
			  for (Player players : Bukkit.getOnlinePlayers()) {
		          TopKillStreak.createTopKillStreak(players);
			 }
			  sScoreAPI.scoreboard(p);
				sScoreAPI.scoreboard(d);
		  }
		}
	}
 }
	@EventHandler
	public void quit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
		ArraysAPI.Jogando.remove(p);
		KitAPI.removeKits(p);
		e.setQuitMessage(null);
		
		
		
		
	}
	@EventHandler
	public void cmdnotfound(PlayerCommandPreprocessEvent e) {
		if(e.isCancelled()) {
			return;
		}
		Player p = e.getPlayer();
		String msg = e.getMessage().split(" ")[0];
		HelpTopic t = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		if(t == null) {
			e.setCancelled(true);
			p.sendMessage("§6§lNash§f§lPvP §6» §7O comando " + ChatColor.GOLD + ChatColor.BOLD.toString() + e.getMessage() + ChatColor.GRAY + " nao foi encontrado");
		}
	}
	@EventHandler
	void BuildConstruct(BlockPlaceEvent evento) {
		
		Player jogador = evento.getPlayer();
		if (jogador.getGameMode() != GameMode.CREATIVE) {
			evento.setCancelled(true);
		} else {
			evento.setCancelled(false);	
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	void BuildBreak(BlockBreakEvent evento) {
		
		Player jogador = evento.getPlayer();
		if (jogador.getGameMode() != GameMode.CREATIVE) {
			evento.setCancelled(true);
		} else {
			if ((jogador.getItemInHand().getTypeId() == 268) || (jogador.getItemInHand().getTypeId() == 272) || (jogador.getItemInHand().getTypeId() == 267) || (jogador.getItemInHand().getTypeId() == 276) || (jogador.getItemInHand().getTypeId() == 283)) {
				evento.setCancelled(true);
			} else {
				evento.setCancelled(false);
			}
		}
	}
}