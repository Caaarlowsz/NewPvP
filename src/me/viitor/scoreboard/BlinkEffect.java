package me.viitor.scoreboard;

public class BlinkEffect {
	
	public BlinkEffect() {
		
	}
	
	private int i = 1;
	private String texto = "§6§lKITPVP";
	
	public void next() {
		if(i == 1) {
			texto = "§f§lK§6§lITPVP";
		}
		if(i == 2) {
			texto = "§6§lK§f§lI§6§lTPVP";
		}
		if(i == 3) {
			texto = "§6§lKI§f§lT§6§lPVP";
		}
		if(i == 4) {
			texto = "§6§lKIT§f§lP§6§lVP";
		}
		if(i == 5) {
			texto = "§6§lKITPV§f§lP";
		}
		if(i == 6) {
			texto = "§6§lKITP§f§lV§6§lP";
		}
		if(i == 7) {
			texto = "§6§lKIT§f§lP§6§lVP";
		}
		if(i == 8) {
			texto = "§6§lKI§f§lT§6§lPVP";
		}
		if(i == 9) {
			texto = "§6§lK§f§lI§6§lTPVP";
		}
		if(i == 10) {
			texto = "§f§lK§6§lITPVP";
		}
		if(i == 11) {
			texto = "";
		}
		if(i == 12) {
			texto = "§6§lKITPVP";
		}
		if(i == 13) {
			texto = "";
		}
		if(i == 14) {
			texto = "§6§lKITPVP";
		}
		if(i == 15) {
			texto = "§f§lKITPVP";
		}
		if(i == 16) {
			texto = "§6§lKITPVP";
		}
		if(i == 17) {
			texto = "§f§lKITPVP";
		}
		if(i == 18) {
			texto = "§6§lKITPVP";
			i = 0;
		}
		i++;
	}
	
	public String getText() {
		return texto;
	}

}
