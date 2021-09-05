package me.viitor.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.viitor.configuração.cfGrupo;
import me.viitor.configuração.cfPermissão;


public class LojaMenu {
	
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 54, "§aLoja de Kits 1/2");
		
		ItemStack maiskits = new ItemStack(Material.getMaterial(171), 1, (short)5);
		ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("§aProxima pagina");
		maiskits.setItemMeta(kmaiskits);
		
		ItemStack kits = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("§7Seus Kits");
		kits.setItemMeta(kkits);
		
		ItemStack lojadekits = new ItemStack(Material.getMaterial(351), 1, (short)10);
		ItemMeta klojadekits = lojadekits.getItemMeta();
		klojadekits.setDisplayName("§aLoja de kits");
		lojadekits.setItemMeta(klojadekits);
		
		ItemStack padraokit = new ItemStack(Material.getMaterial(351),1,(short)8);
		ItemMeta kpadraokit = padraokit.getItemMeta();
		kpadraokit.setDisplayName("§7Kit padrao");
		kpadraokit.setLore(Arrays.asList("§7Facilite seu modo de jogo", "§7usando o sistema de §6§lKITS PADRAO§7.", " "));
		padraokit.setItemMeta(kpadraokit);
		
		ItemStack todososkits = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta ktodososkits = todososkits.getItemMeta();
		ktodososkits.setDisplayName("§7Todos os kits");
		todososkits.setItemMeta(ktodososkits);
		
		ItemStack ConfigureKit = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta kConfigureKit = ConfigureKit.getItemMeta();
		kConfigureKit.setDisplayName("§7Configure seu kit");
		kConfigureKit.setLore(Arrays.asList("§c§lEM BREVE", "§7Facilite sua jogabilidade", "§7selecionando seu kit padrao", " "));
		ConfigureKit.setItemMeta(kConfigureKit);
		
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)0);
		ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("§7-");
		vidro.setItemMeta(kvidro);
		
		menu.setItem(0, vidro);
		menu.setItem(8, maiskits);
		
		menu.setItem(1, vidro);
		
		menu.setItem(9, vidro);
		menu.setItem(10, vidro);
		menu.setItem(11, vidro);
		menu.setItem(12, vidro);
		menu.setItem(13, vidro);
		menu.setItem(14, vidro);
		menu.setItem(15, vidro);
		menu.setItem(16, vidro);
		menu.setItem(17, vidro);
		
		menu.setItem(18, vidro);
		menu.setItem(26, vidro);
		
		menu.setItem(27, vidro);
		menu.setItem(35, vidro);
		
		menu.setItem(36, vidro);
		menu.setItem(44, vidro);
		
		menu.setItem(45, vidro);
		menu.setItem(46, vidro);
		menu.setItem(47, vidro);
		menu.setItem(48, vidro);
		menu.setItem(49, vidro);
		menu.setItem(50, vidro);
		menu.setItem(51, vidro);
		menu.setItem(52, vidro);
		menu.setItem(53, vidro);
		
		menu.setItem(2, ConfigureKit);
		menu.setItem(3, todososkits);
		menu.setItem(4, kits);
		menu.setItem(5, lojadekits);
		menu.setItem(6, padraokit);
		
		menu.setItem(7, vidro);
		
		
		if(cfGrupo.ChecarGrupo(p, "Membro")){
			
			if(!cfPermissão.getPermissao(p, "kit.monk")){
			menu.addItem(criarItemMenu(Material.BLAZE_ROD, "§cMonk §c§l15.000", new String[] {"§7Confuda o inventraio de", "§7seus inimigos"}));
			}else{
				menu.remove(Material.BLAZE_ROD);
			}
			if(!cfPermissão.getPermissao(p, "kit.ninja")){
			menu.addItem(criarItemMenu(Material.COMPASS, "§cNinja §c§l17.000", new String[] {"§7Aperte shift para teleportar ao", "§7ultimo jogador hitado"}));
			}else{
				menu.remove(Material.COMPASS);
			}
			if(!cfPermissão.getPermissao(p, "kit.phantom")){
			menu.addItem(criarItemMenu(Material.FEATHER, "§cPhantom §c§l15.000", new String[] {"§7Use a pena para virar", "§7um passaro e voar"}));
			}else{
				menu.remove(Material.FEATHER);
			}
			if(!cfPermissão.getPermissao(p, "kit.grappler")){
			menu.addItem(criarItemMenu(Material.LEASH, "§cGrappler §c§l17.000", new String[] {"§7Use seu laÃ§o para se", "§7locomover pelo mapa"}));
			}else{
				menu.remove(Material.LEASH);
			}
			if(!cfPermissão.getPermissao(p, "kit.viper")){
			menu.addItem(criarItemMenu(Material.SPIDER_EYE, "§cViper §c§l10.000", new String[] {"§7Invenene seus inimigos", "§7ao bater neles"}));
			}else{
				menu.remove(Material.SPIDER_EYE);
			}
			if(!cfPermissão.getPermissao(p, "kit.snail")){
			menu.addItem(criarItemMenu(Material.STRING, "§cSnail §c§l10.000", new String[] {"§7Deixe seus inimigos lerdos"}));
			}else{
				menu.remove(Material.STRING);
			}
		}
		if(cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "Trial")))){
		
			if(!cfPermissão.getPermissao(p, "kit.hulk")){
			menu.addItem(criarItemMenu(Material.SADDLE, "§cHulk §c§l15.000", new String[] {"§7Puxe seus inimigos para carcunda", "§7e critique eles"}));
			}else{
				menu.remove(Material.SADDLE);
			}
			if(!cfPermissão.getPermissao(p, "kit.timelord")){
			menu.addItem(criarItemMenu(Material.WATCH, "§cTimelord §c§l15.000", new String[] {"§7Congele os players de", "§7sua volta"}));
			}else{
				menu.remove(Material.WATCH);
			}
			if(!cfPermissão.getPermissao(p, "kit.thor")){
			menu.addItem(criarItemMenu(Material.WOOD_AXE, "§cThor §c§l15.000", new String[] {"§7Vire o thor e lanÃ§e raios", "§7em seus inimigos"}));
			}else{
				menu.remove(Material.WOOD_AXE);
			}
			if(!cfPermissão.getPermissao(p, "kit.switcher")){
			menu.addItem(criarItemMenu(Material.SNOW_BALL, "§cSwitcher §c§l10.000", new String[] {"§7Troque de lugar com seus inimigos ao", "§7acertar uma bola de neve nele"}));
			}else{
				menu.remove(Material.SNOW_BALL);
			}
			if(!cfPermissão.getPermissao(p, "kit.gladiator")){
			menu.addItem(criarItemMenu(Material.IRON_FENCE, "§cGladiator §c§l30.000", new String[] {"§7Puxe seus inimigos para", "§7um 1v1 na jaula"}));
			}else{
				menu.remove(Material.IRON_FENCE);
			}
		}
		if(cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Trial"))))){
			
			
			if(!cfPermissão.getPermissao(p, "kit.stomper")){
			menu.addItem(criarItemMenu(Material.IRON_BOOTS, "§cStomper §c§l35.000", new String[] {"§7Ao cair em cima de seus", "§7inimigos esmague-os"}));
			}else{
				menu.remove(Material.IRON_BOOTS);
			}
			if(!cfPermissão.getPermissao(p, "kit.magma")){
			menu.addItem(criarItemMenu(Material.FIRE, "§cMagma §c§l17.000", new String[] {"§7Ao bater em seu inimigo", "§7tenha chanÃ§e de colocar fogo nele"}));
			}else{
				menu.remove(Material.FIRE);
			}
			if(!cfPermissão.getPermissao(p, "kit.grandpa")){
			menu.addItem(criarItemMenu(Material.STICK, "§cGrandpa §c§l10.000", new String[] {"§7Jogue seu inimigo longe", "§7usando seu stick"}));
			}else{
				menu.remove(Material.STICK);
			}
			if(!cfPermissão.getPermissao(p, "kit.ajnin")){
			menu.addItem(criarItemMenu(Material.NETHER_STAR, "§cAjnin §c§l20.000", new String[] {"§7Ao apertar shift o ultimo", "§7jogador hitado Ã© teleportado a vocÃª"}));
			}else{
				menu.remove(Material.NETHER_STAR);
			}
			if(!cfPermissão.getPermissao(p, "kit.firelauncher")){
			menu.addItem(criarItemMenu(Material.FIREBALL, "§cFireLauncher §c§l15.000",  new String[] {"§7Use seu kit para", "§7queimar seus inimigos"}));
			}else{
				menu.remove(Material.FIREBALL);
			}
		}
		ItemStack PossuiTodos = new ItemStack(Material.SKULL_ITEM);
		ItemMeta kPossuiTodos = kits.getItemMeta();
		kPossuiTodos.setDisplayName("§7Voce possui todos os kits");
		PossuiTodos.setItemMeta(kPossuiTodos);
		
		if(cfGrupo.ChecarGrupo(p, "Pro") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Youtuber+") || (cfGrupo.ChecarGrupo(p, "Mod+") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Gerente") || (cfGrupo.ChecarGrupo(p, "Dono"))))))))){
		menu.setItem(31, PossuiTodos);
		}
		
		if((cfPermissão.getPermissao(p, "kit.monk") &&
		cfPermissão.getPermissao(p, "kit.ninja") && cfPermissão.getPermissao(p, "kit.phantom") && cfPermissão.getPermissao(p, "kit.grappler") &&
		cfPermissão.getPermissao(p, "kit.viper") && cfPermissão.getPermissao(p, "kit.snail") && cfPermissão.getPermissao(p, "kit.hulk") &&
		cfPermissão.getPermissao(p, "kit.timelord") && (cfPermissão.getPermissao(p, "kit.thor") && cfPermissão.getPermissao(p, "kit.switcher") &&
		cfPermissão.getPermissao(p, "kit.gladiator") && cfPermissão.getPermissao(p, "kit.endermage") && cfPermissão.getPermissao(p, "kit.stomper") &&
		cfPermissão.getPermissao(p, "kit.firelauncher") && cfPermissão.getPermissao(p, "kit.strong") && cfPermissão.getPermissao(p, "kit.sumo") &&
		 cfPermissão.getPermissao(p, "kit.forcefield") &&
		cfPermissão.getPermissao(p, "kit.magma") && cfPermissão.getPermissao(p, "kit.grandpa") && cfPermissão.getPermissao(p, "kit.ajnin") ))){
		
		menu.setItem(31, PossuiTodos);
			
		}
		
		p.openInventory(menu);
	}
}
