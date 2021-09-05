package me.viitor.menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.viitor.configura��o.cfGrupo;
import me.viitor.configura��o.cfPermiss�o;

public class Loja2Menu {
	
	public static ItemStack criarItemMenu(Material material, String nome, String[] habilidade){
		
		ItemStack item = new ItemStack(material);
		ItemMeta kitem = item.getItemMeta();
		kitem.setDisplayName(nome);
		kitem.setLore(Arrays.asList(habilidade));
		item.setItemMeta(kitem);
		
		return item;
	}
	public static void inventory(Player p){
		
		Inventory menu = Bukkit.createInventory(p, 54, "�aLoja de Kits 2/2");
		
		ItemStack maiskits = new ItemStack(Material.getMaterial(171), 1, (short)5);
		ItemMeta kmaiskits = maiskits.getItemMeta();
		kmaiskits.setDisplayName("�aPagina anterior");
		maiskits.setItemMeta(kmaiskits);
		
		ItemStack kits = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta kkits = kits.getItemMeta();
		kkits.setDisplayName("�7Seus Kits");
		kits.setItemMeta(kkits);
		
		ItemStack lojadekits = new ItemStack(Material.getMaterial(351), 1, (short)10);
		ItemMeta klojadekits = lojadekits.getItemMeta();
		klojadekits.setDisplayName("�aLoja de kits");
		lojadekits.setItemMeta(klojadekits);
		
		ItemStack padraokit = new ItemStack(Material.getMaterial(351),1,(short)8);
		ItemMeta kpadraokit = padraokit.getItemMeta();
		kpadraokit.setDisplayName("�7Kit padrao");
		kpadraokit.setLore(Arrays.asList("�7Facilite seu modo de jogo", "�7usando o sistema de �6�lKITS PADRAO�7.", " "));
		padraokit.setItemMeta(kpadraokit);
		
		ItemStack todososkits = new ItemStack(Material.getMaterial(351), 1, (short)8);
		ItemMeta ktodososkits = todososkits.getItemMeta();
		ktodososkits.setDisplayName("�7Todos os kits");
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
		
		menu.setItem(8, vidro);
		menu.setItem(0, maiskits);
		
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

		if(cfGrupo.ChecarGrupo(p, "Membro") || (cfGrupo.ChecarGrupo(p, "Light") || (cfGrupo.ChecarGrupo(p, "Mvp") || (cfGrupo.ChecarGrupo(p, "Trial"))))){
			
			if(!cfPermiss�o.getPermissao(p, "kit.strong")){
			menu.addItem(criarItemMenu(Material.WATCH, "�cStrong �c�l30.000", new String[] {"�7Fique fulliron por 10s"}));
			}else{
				menu.remove(Material.WATCH);
			}
			if(!cfPermiss�o.getPermissao(p, "kit.sumo")){
			menu.addItem(criarItemMenu(Material.APPLE, "�cSumo �c�l15.000", new String[] {"�7Você é tão gordo que joga ", "�7seus inimigos pro alto"}));
			}else{
				menu.remove(Material.APPLE);
			}
		}
		ItemStack PossuiTodos = new ItemStack(Material.SKULL_ITEM);
		ItemMeta kPossuiTodos = kits.getItemMeta();
		kPossuiTodos.setDisplayName("�7Voce possui todos os kits");
		PossuiTodos.setItemMeta(kPossuiTodos);
		
		if(cfGrupo.ChecarGrupo(p, "Pro") || cfGrupo.ChecarGrupo(p, "Youtuber+") || cfGrupo.ChecarGrupo(p, "Mod+") || cfGrupo.ChecarGrupo(p, "Gerente") || cfGrupo.ChecarGrupo(p, "Helper") || cfGrupo.ChecarGrupo(p, "Builder") || (cfGrupo.ChecarGrupo(p, "Youtuber") || (cfGrupo.ChecarGrupo(p, "Mod") || (cfGrupo.ChecarGrupo(p, "Admin") || (cfGrupo.ChecarGrupo(p, "Dono")))))){
		menu.setItem(31, PossuiTodos);
		}
		
		if((cfPermiss�o.getPermissao(p, "kit.monk") &&
		cfPermiss�o.getPermissao(p, "kit.ninja") && cfPermiss�o.getPermissao(p, "kit.phantom") && cfPermiss�o.getPermissao(p, "kit.grappler") &&
		cfPermiss�o.getPermissao(p, "kit.viper") && cfPermiss�o.getPermissao(p, "kit.snail") && cfPermiss�o.getPermissao(p, "kit.hulk") &&
		cfPermiss�o.getPermissao(p, "kit.timelord") && (cfPermiss�o.getPermissao(p, "kit.thor") && cfPermiss�o.getPermissao(p, "kit.switcher") &&
		cfPermiss�o.getPermissao(p, "kit.gladiator") && cfPermiss�o.getPermissao(p, "kit.endermage") && cfPermiss�o.getPermissao(p, "kit.stomper") &&
		cfPermiss�o.getPermissao(p, "kit.firelauncher") && cfPermiss�o.getPermissao(p, "kit.strong") && cfPermiss�o.getPermissao(p, "kit.sumo") &&
		cfPermiss�o.getPermissao(p, "kit.magma") && cfPermiss�o.getPermissao(p, "kit.grandpa") && cfPermiss�o.getPermissao(p, "kit.ajnin") ))){
		
		menu.setItem(31, PossuiTodos);
			
		}
		
		p.openInventory(menu);
	}
}
