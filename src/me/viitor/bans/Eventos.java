package me.viitor.bans;

import java.util.Iterator;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.spigotmc.ProtocolInjector;
import org.spigotmc.event.entity.EntityMountEvent;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.EnumClientCommand;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PacketPlayInClientCommand;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import me.viitor.bans.API;
import me.viitor.bans.Config;
import me.viitor.main.Main;

@SuppressWarnings("unused")
public class Eventos implements Listener {

	@EventHandler
	void chatevent(PlayerChatEvent evento) {
		
		Player jogador = evento.getPlayer();
		
		if (Config.getConfig().getMute().get("Mute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, "§cVoce esta MUTADO PERMAMENTEMENTE pelo " + Config.getConfig().getMute().get("Mute." + jogador.getUniqueId() + ".Mutado por") + " por " + Config.getConfig().getMute().get("Mute." + jogador.getUniqueId() + ".Motivo"));
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
		else if (Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId()) != null) {
			API.sendMsg(jogador, "§cVoce esta MUTADO TEMPORARIAMENTE pelo " + Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId() + ".Mutado por") + " por " + Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId() + ".Motivo") + ". Tempo do mute: " + Config.getConfig().getTempMute().get("TempMute." + jogador.getUniqueId() + ".Tempo do Mute"));
			API.sendSound(jogador, Sound.ANVIL_USE, 10);
			evento.setCancelled(true);
		}
	}
	@EventHandler
	public void loginEvent(PlayerLoginEvent evento) {
		
		Player jogador = evento.getPlayer();
		if (Config.getConfig().getBans().get("Bans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY + "§cVoce esta §c§nbanido permanentemente§c do servidor." + "\n" + "§cJogador banido: " + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Nome") + "\n" + "§cBanido por: " + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Banido por") + "\n" + "§cMotivo: " + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Motivo") + "\n" + "§cDuracao do banimento: Permanente" + "\n" + "Data do banimento: " + Config.getConfig().getBans().get("Bans." + jogador.getUniqueId() + ".Data do banimento") + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)");
		}
		else if (Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY + "§cVoce esta §c§nbanido temporariamente§c do servidor." + "\n" + "§cJogador banido: " + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Nome") + "\n" + "§cBanido por: " + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Banido por") + "\n" + "§cMotivo: " + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Motivo") + "\n" + "§cDuracao do banimento: " + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Tempo do Ban") + "\n" + "§cData do banimento: " + Config.getConfig().getTempBans().get("TempBans." + jogador.getUniqueId() + ".Data do banimento") + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)");
		}
		else if (Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId()) != null) {
			evento.disallow(PlayerLoginEvent.Result.KICK_OTHER, ChatColor.GRAY + "§cVoce esta §c§nbanido por ip permanentemente§c do servidor." + "\n" + "§cJogador banido: " + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Nome") + "\n" + "§cIP banido: " + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".IP do Jogador") + "\n" + "§cBanido por: " + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Banido por") + "\n" + "§cMotivo: " + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Motivo") + "\n" + "§cDuracao do banimento: Permanente" + "\n" + "§cData do banimento: " + Config.getConfig().getIpBans().get("IPBans." + jogador.getUniqueId() + ".Data do banimento") + "\n" + "§cVenda de UNBANS em: §c§nmc-new.tk/loja" + "\n" + "§cFoi banido injustamente? Contate-nos via Twitter (§c§n@NewNetworkMC§c)");
		}
		else if (evento.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			evento.setKickMessage("§7Erro ao conectar-se ao servidor" + "\n" + "§4§lWHITELIST §7Ativada" + "\n" + "§7Voce nao esta listado em nossa §4§lWHITELIST §7e por isso" + "\n" + "esta impossibilitado de entrar no servidor." + "\n" + "Nosso servidor se encontra em manutencao no momento." + "\n" + "Com certeza estamos realizando alguma mudanca para melhorar" + "\n" + "sua jogabilidade e diversao no servidor." + "\n" + "§7Contamos com a compreensao de todos." + "\n" + "§7§oAtenciosamente, Equipe NewNetworkMC.");
 		}
	}
}