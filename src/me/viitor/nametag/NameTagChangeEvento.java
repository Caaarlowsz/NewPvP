package me.viitor.nametag;
     
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;   
     
public class NameTagChangeEvento extends Event implements Cancellable {
	
	private static final HandlerList handlers = new HandlerList();
       
	private String OldJogador;
	private String OldPrefix;
	private String OldSuffix;
	private String NewPrefix;
	private String NewSuffix;
	private NametagChangeType Tipo;
	private NametagChangeReason Reação;
	private boolean Cancelar = false;
     
	public static HandlerList getHandlerList() {
		return handlers;
	}
       
	public HandlerList getHandlers() {
		return handlers;
	}
     
	public NameTagChangeEvento(String Jogador, String OldPrefix, String OldSuffix, String NewPrefix, String NewSuffix, NametagChangeType Tipo, NametagChangeReason Reação) {
		this.OldJogador = Jogador;
  	    this.OldPrefix = OldPrefix;
  	    this.OldSuffix = OldSuffix;
  	    this.NewPrefix = NewPrefix;
  	    this.NewSuffix = NewSuffix;
  	    this.Tipo = Tipo;
  	    this.Reação = Reação;
	}
       
	public String PegarPlayerName() {
		return this.OldJogador;
	}
     
	public String PegarCurrentPrefix() {
   	   return this.OldPrefix;
	}
 
	public String PegarCurrentSuffix() {
		return this.OldSuffix;
	}
	
	public String PegarPrefix() {
		return this.NewPrefix;
	}
      
	public String PegarSuffix() {
		return this.NewSuffix;
	}
       
	public void SetarPrefix(String Prefix) {
		this.NewPrefix = Prefix;
	}
       
    public void SetarSufix(String Suffix) {
    	this.NewSuffix = Suffix;
    }
    
    public NametagChangeType PegarTipo() {
    	return this.Tipo;
    }
 
    public NametagChangeReason PegarReason() {
    	return this.Reação;
    }
    
    public void setCancelled(boolean Cancelar) {
    	this.Cancelar = Cancelar;
    }

    public boolean isCancelled() {
    	return this.Cancelar;
    }

    public static enum NametagChangeType {
    	HARD,  SOFT;
         
    	private NametagChangeType() {}
    }
       
    public static enum NametagChangeReason {
    	SET_PREFIX,  SET_SUFFIX,  GROUP_NODE,  CUSTOM;
    	private NametagChangeReason() {}
    }
}

