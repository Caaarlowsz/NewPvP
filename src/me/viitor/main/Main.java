package me.viitor.main;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.viitor.API.API;
import me.viitor.API.GrupoAPI;
import me.viitor.API.WarpsAPI;
import me.viitor.anticheat.hacks.AutoSoup;
import me.viitor.anticheat.hacks.FastClick;
import me.viitor.anticheat.hacks.ForceField;
import me.viitor.anticheat.hacks.Macro;
import me.viitor.anticheat.hacks.flyspeed.FlySpeed;
import me.viitor.anticheat.hacks.flyspeed.MoveCheck;
import me.viitor.auth.Auth;
import me.viitor.auth.AuthCommands;
import me.viitor.auth.AuthEvents;
import me.viitor.bans.BanCommand;
import me.viitor.bans.Config;
import me.viitor.bans.Eventos;
import me.viitor.bans.IPBanCommand;
import me.viitor.bans.KickCommand;
import me.viitor.bans.MuteCommand;
import me.viitor.bans.PardonCommand;
import me.viitor.bans.PunishCheckCommand;
import me.viitor.bans.TempBanCommand;
import me.viitor.bans.TempMuteCommand;
import me.viitor.bans.WarnCommand;
import me.viitor.check.CheckCommand;
import me.viitor.combatlog.CombatLog;
import me.viitor.commands.AccountCommand;
import me.viitor.commands.AddPermissaoCommand;
import me.viitor.commands.AdminCommand;
import me.viitor.commands.AutoSoupCommand;
import me.viitor.commands.BcCommand;
import me.viitor.commands.CageCommand;
import me.viitor.commands.ChatCommand;
import me.viitor.commands.CheckPermissionCommand;
import me.viitor.commands.ClearAllCommand;
import me.viitor.commands.DanoCommand;
import me.viitor.commands.DicaCommand;
import me.viitor.commands.FlyCommand;
import me.viitor.commands.GamemodeCommand;
import me.viitor.commands.GetIPCommand;
import me.viitor.commands.GiveAllCommand;
import me.viitor.commands.GiveCommand;
import me.viitor.commands.GiveKitCommand;
import me.viitor.commands.GiveVipCommand;
import me.viitor.commands.GroupSetCommand;
import me.viitor.commands.HeadCommand;
import me.viitor.commands.HorasCommand;
import me.viitor.commands.InvisCommand;
import me.viitor.commands.InvseeCommand;
import me.viitor.commands.KickAllCommand;
import me.viitor.commands.KitCommand;
import me.viitor.commands.ManutencaoCommand;
import me.viitor.commands.MonitorarCommand;
import me.viitor.commands.PingCommand;
import me.viitor.commands.PvPCommand;
import me.viitor.commands.RankCommand;
import me.viitor.commands.RemoveAllCommand;
import me.viitor.commands.RemoveHeadCommand;
import me.viitor.commands.ReportCommand;
import me.viitor.commands.ResetKitCommand;
import me.viitor.commands.SKitCommand;
import me.viitor.commands.ScCommand;
import me.viitor.commands.ScoreCommand;
import me.viitor.commands.SetCommand;
import me.viitor.commands.SpawnCommand;
import me.viitor.commands.SpecCommand;
import me.viitor.commands.StopServerCommand;
import me.viitor.commands.TagCommand;
import me.viitor.commands.TagsCommand;
import me.viitor.commands.TellCommand;
import me.viitor.commands.TempGroupSetCommand;
import me.viitor.commands.TpAllCommand;
import me.viitor.commands.TpCommand;
import me.viitor.commands.TpHereCommand;
import me.viitor.commands.UpdateVisCommand;
import me.viitor.commands.VisCommand;
import me.viitor.commands.WarpCommand;
import me.viitor.commands.YoutuberCommand;
import me.viitor.configuração.WarpsConfig;
import me.viitor.configuração.cfConfig;
import me.viitor.configuração.cfEntrou;
import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfKitdiario;
import me.viitor.configuração.cfPermissão;
import me.viitor.configuração.cfStatus;
import me.viitor.configuração.cfTempGrupo;
import me.viitor.events.ColorSigns;
import me.viitor.events.PlacaLC;
import me.viitor.events.PlacaRecraft;
import me.viitor.events.PlacaSopas;
import me.viitor.events.PlacaVIP;
import me.viitor.events.eEvents;
import me.viitor.events.eMoveSpawn;
import me.viitor.events.eTab;
import me.viitor.events.eUtills;
import me.viitor.habilidades.Ajnin;
import me.viitor.habilidades.FireLauncher;
import me.viitor.habilidades.Fisherman;
import me.viitor.habilidades.Gladiator;
import me.viitor.habilidades.Grappler;
import me.viitor.habilidades.Hulk;
import me.viitor.habilidades.Kangaroo;
import me.viitor.habilidades.Magma;
import me.viitor.habilidades.Monk;
import me.viitor.habilidades.Ninja;
import me.viitor.habilidades.Phantom;
import me.viitor.habilidades.Snail;
import me.viitor.habilidades.Stomper;
import me.viitor.habilidades.Strong;
import me.viitor.habilidades.Sumo;
import me.viitor.habilidades.Switcher;
import me.viitor.habilidades.Thor;
import me.viitor.habilidades.Timelord;
import me.viitor.habilidades.Viper;
import me.viitor.invencivel.Proteção;
import me.viitor.jumps.Diamante;
import me.viitor.jumps.Esmeralda;
import me.viitor.jumps.Esponja;
import me.viitor.jumps.Ferro;
import me.viitor.menus.CliqueInventory;
import me.viitor.menus.HeadsMenu;
import me.viitor.menus.LojaItemMenu;
import me.viitor.menus.OpenInventory;
import me.viitor.nametag.Array;
import me.viitor.nametag.PlayerLoader;
import me.viitor.packets.Cancellable;
import me.viitor.packets.Injector;
import me.viitor.packets.PacketHandler;
import me.viitor.packets.PacketReceiveEvent;
import me.viitor.packets.PacketSendEvent;
import me.viitor.packets.ReceivedPacket;
import me.viitor.packets.SentPacket;
import me.viitor.rdmautomatica.Comando;
import me.viitor.rdmautomatica.Configuração;
import me.viitor.rdmautomatica.Estado;
import me.viitor.rdmautomatica.EventoAPI;
import me.viitor.rdmautomatica.PlayerAPI;
import me.viitor.rdmautomatica.Tempo;
import me.viitor.scoreboard.BlinkEffect;
import me.viitor.scoreboard.sScoreAPI;
import me.viitor.screenshare.ScreenShare;
import me.viitor.staffmanager.StaffListCommand;
import me.viitor.twitter.cTweetar;
import me.viitor.umVum.CmdsSpeed;
import me.viitor.umVum.Events1v1;
import me.viitor.umVum.Speed1v1;

@SuppressWarnings("deprecation")
public class Main extends JavaPlugin{
	
	public static BlinkEffect bk = new BlinkEffect();
	public static sScoreAPI sc = new sScoreAPI();
	
	public static Main main;
	public static Main getInstance() {
		return main;
	}
	
	public static Plugin plugin;
	public static Plugin getPlugin(){
		return plugin;
	}
	public static Estado Evento;
	
	public static Injector injector;
	public static boolean disableEvents = false;
	public static BukkitRunnable cleanupTask;
	
	public static ArrayList<String> JogadoresLogados = new ArrayList<>();
	
	public void onEnable(){
		plugin = this;
		main = this;
		Bukkit.getConsoleSender().sendMessage("§6§lNash§f§lPvP §6» §7Plugin iniciado com sucesso.");
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new MoveCheck(), 41L, 40L);
		for(Player todos : Bukkit.getOnlinePlayers()){
			todos.kickPlayer("   §6§lNash§f§lPvP §6» §7 \n§7Servidor reiniciando\n§7Estamos, com certeza, melhorando sua jogabilidade, espero que entendam");
		}
		

		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
			public void run() {
				API.AutomaticMessage();
			}
		}, 0L, 120 * 20);
		
		LoadConfig();
		GrupoAPI.Checando = true;
		Evento = Estado.FECHADO;
		Tempo.CancelarTempo();
		Tempo.Iniciando = 301;
		for (OfflinePlayer jogadores : getServer().getOfflinePlayers()) {
			if (Config.getConfig().kTempBans.get("TempBans." + jogadores.getUniqueId()) != null) {
				Config.getConfig().kTempBans.set("TempBans." + jogadores.getUniqueId(), null);
				Config.getConfig().saveTempBans();	
			}
			if (Config.getConfig().kTempMute.get("TempMute." + jogadores.getUniqueId()) != null) {
				Config.getConfig().kTempMute.set("TempMute." + jogadores.getUniqueId(), null);
				Config.getConfig().saveTempMute();	
			}
	}
		
			
		
		PacketsIniciar();
		PlayerAPI.LimparPlayers();
		PlayerLoader.load(this);
		Array.InciarTag();
		LoadEvents();
		LoadCommands();
		CarregarComandosRDM();
		DanoCommand.dano = true;
		PvPCommand.pvp = true;
	}
		
	public void onDisable(){
		PacketsDesabilitar();
		Bukkit.getConsoleSender().sendMessage("§6§lNash§f§lPvP §6» §7Plugin desativado com sucesso.");
		
	}
	private void CarregarComandosRDM() {
		getCommand("RDM").setExecutor(new Comando());
		getCommand("ReiDaMesa").setExecutor(new Comando());
		getCommand("Entrar").setExecutor(new Comando());
		getCommand("Join").setExecutor(new Comando());
		getCommand("Sair").setExecutor(new Comando());
		getCommand("Leave").setExecutor(new Comando());
	}
	
	public void onLoad() {
		
		injector = new Injector();
		boolean injected = injector.inject();
		if (injected) {
			injector.addServerConnectionChannel();
		} else {
		}
	}
	
	private void LoadEvents(){
		
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new Eventos(), this);
		pm.registerEvents(new eEvents(), this);
		pm.registerEvents(new eUtills(), this);
		pm.registerEvents(new Proteção(), this);
		pm.registerEvents(new OpenInventory(), this);
		pm.registerEvents(new CliqueInventory(), this);
		pm.registerEvents(new HeadsMenu(), this);
		pm.registerEvents(new WarpsAPI(), this);
		pm.registerEvents(new PlacaRecraft(), this);
		pm.registerEvents(new PlacaSopas(), this);
		pm.registerEvents(new PlacaLC(), this);
		pm.registerEvents(new eMoveSpawn(), this);
		pm.registerEvents(new eTab(), this);
		pm.registerEvents(new LojaItemMenu(), this);
		pm.registerEvents(new ColorSigns(), this);
		pm.registerEvents(new PlacaVIP(), this);
		
		pm.registerEvents(new AdminCommand(), this);
		pm.registerEvents(new ChatCommand(), this);
		pm.registerEvents(new ScCommand(), this);
		pm.registerEvents(new ManutencaoCommand(), this);
		pm.registerEvents(new DanoCommand(), this);
		pm.registerEvents(new PvPCommand(), this);
		
		pm.registerEvents(new ScreenShare(), this);
		
		pm.registerEvents(new Esmeralda(), this);
		pm.registerEvents(new Esponja(), this);
		pm.registerEvents(new Diamante(), this);
		pm.registerEvents(new Ferro(), this);
		
		pm.registerEvents(new EventoAPI(), this);
		pm.registerEvents(new me.viitor.rdmautomatica.Eventos(), this);
		
		pm.registerEvents(new Ajnin(), this);
		pm.registerEvents(new Fisherman(), this);
		pm.registerEvents(new Gladiator(), this);
		pm.registerEvents(new Grappler(), this);
		pm.registerEvents(new Hulk(), this);
		pm.registerEvents(new Kangaroo(), this);
		pm.registerEvents(new Magma(), this);
		pm.registerEvents(new Monk(), this);
		pm.registerEvents(new Ninja(), this);
		pm.registerEvents(new Phantom(), this);
		pm.registerEvents(new Snail(), this);
		pm.registerEvents(new Stomper(), this);
		pm.registerEvents(new Switcher(), this);
		pm.registerEvents(new Thor(), this);
		pm.registerEvents(new Timelord(), this);
		pm.registerEvents(new Viper(), this);
		pm.registerEvents(new FireLauncher(), this);
		pm.registerEvents(new Strong(), this);
		pm.registerEvents(new Sumo(), this);
		
		pm.registerEvents(new AuthEvents(), this);
		
		pm.registerEvents(new Events1v1(), this);
		pm.registerEvents(new Speed1v1(), this);
		pm.registerEvents(new EventoAPI(), this);
		pm.registerEvents(new me.viitor.anticheat.Events(), this);
		pm.registerEvents(new AutoSoup(), this);
		pm.registerEvents(new FastClick(), this);
		pm.registerEvents(new Macro(), this);
		pm.registerEvents(new ForceField(), this);
		pm.registerEvents(new FlySpeed(), this);
		pm.registerEvents(new CombatLog(), this);
		pm.registerEvents(new WarpCommand(), this);
		
	}
	
	private void LoadCommands(){
		
		
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("ipban").setExecutor(new IPBanCommand());
		getCommand("tempban").setExecutor(new TempBanCommand());
		getCommand("tempmute").setExecutor(new TempMuteCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("Pardon").setExecutor(new PardonCommand());
		getCommand("mute").setExecutor(new MuteCommand());
		getCommand("sc").setExecutor(new ScCommand());
		getCommand("groupset").setExecutor(new GroupSetCommand());
		getCommand("tempgroupset").setExecutor(new TempGroupSetCommand());
		getCommand("admin").setExecutor(new AdminCommand());
		getCommand("kit").setExecutor(new KitCommand());
		getCommand("giveall").setExecutor(new GiveAllCommand());
		getCommand("removeall").setExecutor(new RemoveAllCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("score").setExecutor(new ScoreCommand());
		getCommand("tag").setExecutor(new TagCommand());
		getCommand("tags").setExecutor(new TagsCommand());
		getCommand("tp").setExecutor(new TpCommand());
		getCommand("gamemode").setExecutor(new GamemodeCommand());
		getCommand("gm").setExecutor(new GamemodeCommand());
		getCommand("youtuber").setExecutor(new YoutuberCommand());
		getCommand("spro").setExecutor(new YoutuberCommand());
		getCommand("chat").setExecutor(new ChatCommand());
		getCommand("report").setExecutor(new ReportCommand());
		getCommand("set").setExecutor(new SetCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("warp").setExecutor(new WarpCommand());
		getCommand("speed1v1").setExecutor(new CmdsSpeed());
		getCommand("tell").setExecutor(new TellCommand());
		getCommand("specs").setExecutor(new SpecCommand());
		getCommand("dica").setExecutor(new DicaCommand());
		getCommand("bancheck").setExecutor(new PunishCheckCommand());
		getCommand("mutecheck").setExecutor(new PunishCheckCommand());
		getCommand("bc").setExecutor(new BcCommand());
		getCommand("account").setExecutor(new AccountCommand());
		getCommand("inv").setExecutor(new InvseeCommand());
		getCommand("invsee").setExecutor(new InvseeCommand());
		getCommand("getip").setExecutor(new GetIPCommand());
		getCommand("horas").setExecutor(new HorasCommand());
		getCommand("rank").setExecutor(new RankCommand());
		getCommand("ranks").setExecutor(new RankCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("acc").setExecutor(new AccountCommand());
		getCommand("tpall").setExecutor(new TpAllCommand());
		getCommand("vis").setExecutor(new VisCommand());
		getCommand("invis").setExecutor(new InvisCommand());
		getCommand("removerhead").setExecutor(new RemoveHeadCommand());
		getCommand("removerhat").setExecutor(new RemoveHeadCommand());
		getCommand("removehead").setExecutor(new RemoveHeadCommand());
		getCommand("removehat").setExecutor(new RemoveHeadCommand());
		getCommand("manutencao").setExecutor(new ManutencaoCommand());
		getCommand("cage").setExecutor(new CageCommand());
		getCommand("autosoup").setExecutor(new AutoSoupCommand());
		getCommand("tphere").setExecutor(new TpHereCommand());
		getCommand("s").setExecutor(new TpHereCommand());
		getCommand("stopserver").setExecutor(new StopServerCommand());
		getCommand("kickall").setExecutor(new KickAllCommand());
		getCommand("monitorar").setExecutor(new MonitorarCommand());
		getCommand("skit").setExecutor(new SKitCommand());
		getCommand("dano").setExecutor(new DanoCommand());
		getCommand("pvp").setExecutor(new PvPCommand());
		getCommand("clearall").setExecutor(new ClearAllCommand());
		getCommand("tweetar").setExecutor(new cTweetar());
		getCommand("head").setExecutor(new HeadCommand());
		getCommand("addpermission").setExecutor(new AddPermissaoCommand());
		getCommand("removepermission").setExecutor(new AddPermissaoCommand());
		getCommand("check").setExecutor(new CheckCommand());
		getCommand("givevip").setExecutor(new GiveVipCommand());
		getCommand("giveyoutuber").setExecutor(new GiveCommand());
		getCommand("givebuilder").setExecutor(new GiveCommand());
		getCommand("givekit").setExecutor(new GiveKitCommand());
		getCommand("updatevis").setExecutor(new UpdateVisCommand());
		getCommand("checkpermission").setExecutor(new CheckPermissionCommand());
		getCommand("resetkit").setExecutor(new ResetKitCommand());
		getCommand("kitreset").setExecutor(new ResetKitCommand());
		getCommand("stafflist").setExecutor(new StaffListCommand());
		getCommand("ss").setExecutor(new ScreenShare());
		getCommand("login").setExecutor(new AuthCommands());
		getCommand("register").setExecutor(new AuthCommands());
		getCommand("unregister").setExecutor(new AuthCommands());
		getCommand("changepassword").setExecutor(new AuthCommands());
		getCommand("setpassword").setExecutor(new AuthCommands());
		
	}
	
	private void LoadConfig(){
		
		WarpsConfig.getConfig().ConfigEnable(this);
		Config.getConfig().setupConfig(this);
		cfEntrou.setarConfig(this);
		cfEntrou.setarConfig1(this);
		cfGrupo.setarconfig(this);
		cfKitdiario.setarconfig(this);
		cfTempGrupo.setarconfig(this);
		cfPermissão.setarconfig(this);
		Configuração.getConfig(this);
		cfConfig.setarConfig(this);
		new cfStatus();
		new WarnCommand();
		new Auth();
	}
	
	 public static void PacketsIniciar(){
		 
		 if (cleanupTask == null) { (cleanupTask = new BukkitRunnable() {
			 @Override
			 public void run() {
				 // System.out.println("[PacketListenerAPI] Running cleanup task...");
				 int handlers = PacketHandler.getHandlers().size();
				 int plugins = Bukkit.getPluginManager().getPlugins().length;
				 if (handlers > plugins) {
				 }
			 }
		 }).runTaskTimer(getPlugin(), 20 * 300, 20 * 300);
		 }
	 }
	 
	 public static void PacketsDesabilitar(){

		 for (Player p : Bukkit.getOnlinePlayers()) {
			 injector.removeChannel(p);
		 }
		 
		 while (!PacketHandler.getHandlers().isEmpty()) {
			 PacketHandler.removeHandler(PacketHandler.getHandlers().get(0));
		 }
	 }
	 
	 public static boolean addPacketHandler(PacketHandler handler) {
		 return PacketHandler.addHandler(handler);
	 }

	 public static boolean removePacketHandler(PacketHandler handler) {
		 return PacketHandler.removeHandler(handler);
	 }

	 private void callEvent(final Event e) {
		 
		 if (disableEvents) return;
		 if (!this.isEnabled()) return;
		 Bukkit.getScheduler().runTaskAsynchronously(this, new Runnable() {

			 @Override
			 public void run() {
				 try {
					 Bukkit.getPluginManager().callEvent(e);
				 } catch (IllegalStateException ex) {
					 System.out.println("[PacketListenerAPI] Error while calling event (" + e.getEventName() + ")");
					 ex.printStackTrace();
				 }
			 }
		 });
	 }

	 public Object onPacketReceive(Player p, Object packet, Cancellable cancellable) {
		 if (!packet.getClass().getName().startsWith("net.minecraft.server.")) return packet;
		 if (!disableEvents) {
			 PacketReceiveEvent event = new PacketReceiveEvent(packet, cancellable, p);
			 this.callEvent(event);
		 }

		 ReceivedPacket pckt = new ReceivedPacket(packet, cancellable, p);
		 PacketHandler.notifyHandlers(pckt);
		 return pckt.getPacket();
	 }

	 public Object onPacketSend(Player p, Object packet, Cancellable cancellable) {
		 if (!packet.getClass().getName().startsWith("net.minecraft.server.")) return packet;
		 if (!disableEvents) {
			 PacketSendEvent event = new PacketSendEvent(packet, cancellable, p);
			 this.callEvent(event);
		 }

		 SentPacket pckt = new SentPacket(packet, cancellable, p);
		 PacketHandler.notifyHandlers(pckt);
		 return pckt.getPacket();
	 }
}