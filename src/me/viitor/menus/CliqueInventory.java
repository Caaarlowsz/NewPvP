package me.viitor.menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.viitor.API.PadraoAPI;
import me.viitor.configuração.cfConfig;
import me.viitor.configuração.cfPermissão;
import me.viitor.configuração.cfStatus;


public class CliqueInventory implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickartodoskits(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aTodos os Kits 1/2") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Seus kits")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTodos os kits")){
			e.setCancelled(true);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Loja de kits")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit padrao")){
			e.setCancelled(true);
			PadraoMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aProxima pagina")){
			e.setCancelled(true);
			TodosKits2Menu.inventory(p);
			return;
	    	}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickartodoskits2(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aTodos os Kits 2/2") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Seus kits")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTodos os kits")){
			e.setCancelled(true);
			TodosKitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Loja de kits")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit padrao")){
			e.setCancelled(true);
			PadraoMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPagina anterior")){
			e.setCancelled(true);
			TodosKitsMenu.inventory(p);
			return;
	    	}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarlojavips(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aQual {VIP} deseja?") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7{VIP} §a§lLIGHT")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§6§lNash§f§lPvP §6» §7Loja: §6mc-new.tk/loja");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7{VIP} §9§lMVP")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§6§lNash§f§lPvP §6» §7Loja: §6mc-new.tk/loja");
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7{VIP} §6§lPRO")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§6§lNash§f§lPvP §6» §7Loja: §6mc-new.tk/loja");
			return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarwarps(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§6Warps") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Warp §6§lFPS")){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/warp fps");
			return;
	    	}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Warp §6§l1V1")){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/warp 1v1");
			return;
    	}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Warp §6§lKNOCKBACK")){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/warp knockback");
			return;
    	}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Warp §6§lMAIN")){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/warp main");
			return;
    	}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Warp §6§lFISHERMAN")){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/warp fisherman");
			return;
    	}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Warp §6§lMLG")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§6§lNash§f§lPvP §6» §7Warp em manutenã§ão.");
			return;
    	}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Warp §c§lEM BREVE")){
			e.setCancelled(true);
			p.closeInventory();
			p.sendMessage("§6§lNash§f§lPvP §6» §7Warp em breve.");
			return;
    	}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7-")){
			e.setCancelled(true);
			p.closeInventory();
			return;
    	}
	if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Warp §6§lCHALLENGE")){
		e.setCancelled(true);
		p.closeInventory();
		p.chat("/warp challenge");
		return;
		}
	  }
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarloja2(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aLoja de Kits 2/2") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Seus kits")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLoja de kits")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Todos os kits")){
			e.setCancelled(true);
			TodosKitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit padrao")){
			e.setCancelled(true);
			PadraoMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPagina anterior")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cStrong §c§l30.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 30000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.strong", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Strong.");
				cfStatus.RemoveMoney(p, 30000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cForcefield §c§l20.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 20000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.forcefield", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Forcefield.");
				cfStatus.RemoveMoney(p, 20000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSumo §c§l15.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.sumo", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Sumo.");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarloja(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aLoja de Kits 1/2") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Seus kits")){
				e.setCancelled(true);
				KitsMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aLoja de kits")){
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Todos os kits")){
				e.setCancelled(true);
				TodosKitsMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit padrao")){
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aProxima pagina")){
				e.setCancelled(true);
				Loja2Menu.inventory(p);
				return;
			}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMonk §c§l15.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.monk", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Monk.");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cNinja §c§l17.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 17000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.ninja", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Ninja.");
				cfStatus.RemoveMoney(p, 17000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cPhantom §c§l15.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.phantom", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Phantom.");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cGrappler §c§l17.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 17000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.grappler", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Grappler.");
				cfStatus.RemoveMoney(p, 17000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cViper §c§l10.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 10000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.viper", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Viper.");
				cfStatus.RemoveMoney(p, 10000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSnail §c§l10.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 10000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.snail", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Snail.");
				cfStatus.RemoveMoney(p, 10000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cHulk §c§l15.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.hulk", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Hulk.");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTimelord §c§l15.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.timelord", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Timelord.");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cThor §c§l15.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.thor", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Thor.");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSwitcher §c§l10.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 10000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.switcher", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Switcher.");
				cfStatus.RemoveMoney(p, 10000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cGladiator §c§l30.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 30000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.gladiator", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Gladiator.");
				cfStatus.RemoveMoney(p, 30000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cEndermage §c§l17.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 17000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.endermage", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Endermage.");
				cfStatus.RemoveMoney(p, 17000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cStomper §c§l35.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 35000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.stomper", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Stomper.");
				cfStatus.RemoveMoney(p, 35000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMagma §c§l17.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 17000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.magma", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Magma.");
				cfStatus.RemoveMoney(p, 17000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cGrandpa §c§l10.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 10000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.grandpa", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Grandpa.");
				cfStatus.RemoveMoney(p, 10000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cAjnin §c§l20.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 20000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.ajnin", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6Ajnin.");
				cfStatus.RemoveMoney(p, 20000);
			}
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cFireLauncher §c§l15.000")){
			e.setCancelled(true);
			if(cfStatus.getMoney(p) < 15000){
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª não possui coins suficientes para comprar esse kit.");
			}else{
				cfPermissão.setarPermissao(p, "kit.firelauncher", "true");
				p.sendMessage("§6§lNash§f§lPvP §6» §7Vocãª comprou o kit §6FireLauncher.");
				cfStatus.RemoveMoney(p, 15000);
			}
			p.closeInventory();
			return;
		  }
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarkits2(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aSeus Kits 2/2") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Todos os kits")){
			e.setCancelled(true);
			TodosKitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSeus kits")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit padrao")){
			e.setCancelled(true);
			PadraoMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Loja de kits")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPagina anterior")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getType() == Material.IRON_CHESTPLATE){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/kit strong");
			return;
		}
		if(e.getCurrentItem().getType() == Material.GOLDEN_APPLE){
			e.setCancelled(true);
			p.closeInventory();
			p.chat("/kit sumo");
			return;
		}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarkits(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aSeus Kits 1/2") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Todos os kits")){
				e.setCancelled(true);
				TodosKitsMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSeus kits")){
				e.setCancelled(true);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit padrao")){
				e.setCancelled(true);
				PadraoMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Loja de kits")){
				e.setCancelled(true);
				LojaMenu.inventory(p);
				return;
			}
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aProxima pagina")){
				e.setCancelled(true);
				Kits2Menu.inventory(p);
				return;
			}
		if(e.getCurrentItem().getType() == Material.STONE_SWORD){
			e.setCancelled(true);
			p.chat("/kit pvp");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.BOW){
			e.setCancelled(true);
			p.chat("/kit archer");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FIREWORK){
			e.setCancelled(true);
			p.chat("/kit kangaroo");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FISHING_ROD){
			e.setCancelled(true);
			p.chat("/kit fisherman");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.CACTUS){
			e.setCancelled(true);
			p.chat("/kit cactus");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.BLAZE_ROD){
			e.setCancelled(true);
			p.chat("/kit monk");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.COMPASS){
			e.setCancelled(true);
			p.chat("/kit ninja");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FEATHER){
			e.setCancelled(true);
			p.chat("/kit phantom");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.LEASH){
			e.setCancelled(true);
			p.chat("/kit grappler");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.SPIDER_EYE){
			e.setCancelled(true);
			p.chat("/kit viper");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.STRING){
			e.setCancelled(true);
			p.chat("/kit snail");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.SADDLE){
			e.setCancelled(true);
			p.chat("/kit hulk");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.WATCH){
			e.setCancelled(true);
			p.chat("/kit timelord");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.WOOD_AXE){
			e.setCancelled(true);
			p.chat("/kit thor");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.SNOW_BALL){
			e.setCancelled(true);
			p.chat("/kit switcher");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.IRON_FENCE){
			e.setCancelled(true);
			p.chat("/kit gladiator");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEndermage")){
			e.setCancelled(true);
			p.chat("/kit endermage");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.IRON_BOOTS){
			e.setCancelled(true);
			p.chat("/kit stomper");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FIRE){
			e.setCancelled(true);
			p.chat("/kit magma");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.STICK){
			e.setCancelled(true);
			p.chat("/kit grandpa");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.getMaterial(406)){
			e.setCancelled(true);
			p.chat("/kit ajnin");
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getType() == Material.FIREBALL){
			e.setCancelled(true);
			p.chat("/kit firelauncher");
			p.closeInventory();
			return;
			}
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarkitspadrao2(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aEscolha o Kit Padrao 2/2") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVoltar")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPagina anterior")){
			e.setCancelled(true);
			PadraoMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Todos os kits")){
			e.setCancelled(true);
			TodosKitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Seus kits")){
			e.setCancelled(true);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit padrao")){
			e.setCancelled(true);
			PadraoMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Loja de kits")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aStrong")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Strong");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aForcefield")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Forcefield");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSumo")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Sumo");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		}
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void clickarkitspadrao(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		if((e.getInventory().getTitle().equals("§aEscolha o Kit Padrao 1/2") && (e.getCurrentItem() != null) && (e.getCurrentItem().getTypeId() != 0))){
			e.setCancelled(true);
			
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVoltar")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aProxima pagina")){
			e.setCancelled(true);
				Padrao2Menu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cVoltar")){
			e.setCancelled(true);
			KitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Todos os kits")){
			e.setCancelled(true);
			TodosKitsMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Seus kits")){
			e.setCancelled(true);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit padrao")){
			e.setCancelled(true);
			PadraoMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Loja de kits")){
			e.setCancelled(true);
			LojaMenu.inventory(p);
			return;
		}
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPvP")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "PvP");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aArcher")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Archer");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKangaroo")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Kangaroo");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFisherman")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Fisherman");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aCactus")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Cactus");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMonk")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Monk");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aNinja")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Ninja");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aPhantom")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Phantom");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrappler")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Grappler");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aViper")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Viper");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSnail")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Snail");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aHulk")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Hulk");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTimelord")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Timelord");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aThor")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Thor");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSwitcher")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Switcher");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGladiator")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Gladiator");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aEndermage")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Endermage");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aStomper")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Stomper");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMagma")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Magma");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aGrandpa")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Grandpa");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aAjnin")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "Ajnin");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
		  }
		if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aFireLauncher")){
			e.setCancelled(true);
			PadraoAPI.setKit(p, "FireLauncher");
			p.sendMessage("§7Agora seu kit padrão é §6" + 			cfConfig.pegarconfig().get("configuraã§ão." + p.getUniqueId() + ".PadraoKit"));
			p.closeInventory();
			return;
			}
		}
	}
}
