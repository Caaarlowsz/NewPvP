package me.viitor.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class TodosKitsMenu {
	
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 54, "�aTodos os Kits 1/2");
		
		ItemStack maiskits = new ItemStack(Material.getMaterial(171), 1, (short)5);
		ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("�aProxima pagina");
		maiskits.setItemMeta(kmaiskits);
		
		ItemStack kits = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("�7Seus Kits");
		kits.setItemMeta(kkits);
		
		ItemStack lojadekits = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta klojadekits = lojadekits.getItemMeta();
		klojadekits.setDisplayName("�7Loja de kits");
		lojadekits.setItemMeta(klojadekits);
		
		ItemStack padraokit = new ItemStack(Material.getMaterial(351),1,(short)8);
		ItemMeta kpadraokit = padraokit.getItemMeta();
		kpadraokit.setDisplayName("�7Kit padrao");
		kpadraokit.setLore(Arrays.asList("�7Facilite seu modo de jogo", "�7usando o sistema de �6�lKITS PADRAO�7.", " "));
		padraokit.setItemMeta(kpadraokit);
		
		ItemStack todososkits = new ItemStack(Material.getMaterial(351), 1, (short)10);
		ItemMeta ktodososkits = todososkits.getItemMeta();
		ktodososkits.setDisplayName("�aTodos os kits");
		todososkits.setItemMeta(ktodososkits);
		
		ItemStack ConfigureKit = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta kConfigureKit = ConfigureKit.getItemMeta();
		kConfigureKit.setDisplayName("�7Configure seu kit");
		kConfigureKit.setLore(Arrays.asList("�c�lEM BREVE", "�7Facilite sua jogabilidade", "�7selecionando seu kit padrao", " "));
		ConfigureKit.setItemMeta(kConfigureKit);
		
		ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)0);
		ItemMeta kvidro = vidro.getItemMeta();
		kvidro.setDisplayName("�7-");
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
		
		menu.addItem(criarItemMenu(Material.STONE_SWORD, "�aPvP", new String[] {"�7O Unico kit que possui", "�7espada de pedra"}));
		menu.addItem(criarItemMenu(Material.BOW, "�aArcher", new String[] {"�7Vire um arqueiro e de", "�7flechadas em seus ininimigos"}));
		menu.addItem(criarItemMenu(Material.FIREWORK, "�aKangaroo", new String[] {"�7Use seu firework para", "�7da double jumps"}));
		menu.addItem(criarItemMenu(Material.FISHING_ROD, "�aFisherman", new String[] {"�7Pesque seus inimigos"}));
		menu.addItem(criarItemMenu(Material.CACTUS, "�aCactus", new String[] {"�7Vire um cactu e", "�7devolva o dano em seu inimigo"}));
		menu.addItem(criarItemMenu(Material.BLAZE_ROD, "�aMonk", new String[] {"�7Confuda o inventraio de", "�7seus inimigos"}));
		menu.addItem(criarItemMenu(Material.COMPASS, "�aNinja", new String[] {"�7Aperte shift para teleportar ao", "�7ultimo jogador hitado"}));
		menu.addItem(criarItemMenu(Material.FEATHER, "�aPhantom", new String[] {"�7Use a pena para virar", "�7um passaro e voar"}));
		menu.addItem(criarItemMenu(Material.LEASH, "�aGrappler", new String[] {"�7Use seu la�o para se", "�7locomover pelo mapa"}));
		menu.addItem(criarItemMenu(Material.SPIDER_EYE, "�aViper", new String[] {"�7Invenene seus inimigos", "�7ao bater neles"}));
		menu.addItem(criarItemMenu(Material.STRING, "�aSnail", new String[] {"�7Deixe seus inimigos lerdos"}));
		menu.addItem(criarItemMenu(Material.SADDLE, "�aHulk", new String[] {"�7Puxe seus inimigos para carcunda", "�7e critique eles"}));
		menu.addItem(criarItemMenu(Material.WATCH, "�aTimelord", new String[] {"�7Congele os players de", "�7sua volta"}));
		menu.addItem(criarItemMenu(Material.WOOD_AXE, "�aThor", new String[] {"�7Vire o thor e lan�e raios", "�7em seus inimigos"}));
		menu.addItem(criarItemMenu(Material.SNOW_BALL, "�aSwitcher", new String[] {"�7Troque de lugar com seus inimigos ao", "�7acertar uma bola de neve nele"}));
		menu.addItem(criarItemMenu(Material.IRON_FENCE, "�aGladiator", new String[] {"�7Puxe seus inimigos para", "�7um 1v1 na jaula"}));
		menu.addItem(criarItemMenu(Material.IRON_BOOTS, "�aStomper", new String[] {"�7Ao cair em cima de seus", "�7inimigos esmague-os"}));
		menu.addItem(criarItemMenu(Material.FIRE, "�aMagma", new String[] {"�7Ao bater em seu inimigo", "�7tenha chan�e de colocar fogo nele"}));
		menu.addItem(criarItemMenu(Material.STICK, "�aGrandpa", new String[] {"�7Jogue seu inimigo longe", "�7usando seu stick"}));
		menu.addItem(criarItemMenu(Material.NETHER_STAR, "�aAjnin", new String[] {"�7Ao apertar shift o ultimo", "�7jogador hitado é teleportado a voc�"}));
		menu.addItem(criarItemMenu(Material.FIREBALL, "�aFireLauncher", new String[] {"�7Use seu kit para", "�7queimar seus inimigos"}));
		p.openInventory(menu);
	}
}
