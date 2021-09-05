package me.viitor.packets;

public class Cancellable {

	private boolean	cancelled	= false;
	
	public boolean isCancelled() {
		return this.cancelled;
	}
	
	public void setCancelled(boolean paramBoolean) {
		this.cancelled = paramBoolean;
	}

}
