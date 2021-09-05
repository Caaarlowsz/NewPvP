package me.viitor.nametag;
     
     
public class TeamInfo {
	
	private String name;

	private String prefix;
	private String suffix;
       
	TeamInfo(String name) {
		this.name = name;
	}
	
	void SetarPrefix(String prefix) {
		this.prefix = prefix;
	}
       
	void SetarSuffix(String suffix) {
		this.suffix = suffix;
	}
       
	String PegarPrefix() {
		return this.prefix;
	}
       
	String PegarSuffix() {
		return this.suffix;
	}
       
	String PegarNome() {
		return this.name;
	}
}