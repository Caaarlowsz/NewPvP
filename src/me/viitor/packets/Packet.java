package me.viitor.packets;

import java.lang.reflect.Field;

import org.bukkit.entity.Player;

public abstract class Packet {

	private Player		player;
	private Object		packet;
	private Cancellable	cancel;

	public Packet(Object packet, Cancellable cancel, Player player) {
		this.player = player;
		this.packet = packet;
		this.cancel = cancel;
	}

	public void setPacketValue(String field, Object value) {
		try {
			Field f = this.packet.getClass().getDeclaredField(field);
			f.setAccessible(true);
			f.set(this.packet, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getPacketValue(String field) {
		Object value = null;
		try {
			Field f = this.packet.getClass().getDeclaredField(field);
			f.setAccessible(true);
			value = f.get(this.packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public void setCancelled(boolean b) {
		this.cancel.setCancelled(b);
	}

	public boolean isCancelled() {
		return this.cancel.isCancelled();
	}

	public Player getPlayer() {
		return this.player;
	}

	public boolean hasPlayer() {
		return this.player != null;
	}

	public String getPlayername() {
		if (!this.hasPlayer()) return null;
		return this.player.getName();
	}

	public void setPacket(Object packet) {
		this.packet = packet;
	}

	public Object getPacket() {
		return this.packet;
	}

	public String getPacketName() {
		return this.packet.getClass().getSimpleName();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.cancel == null ? 0 : this.cancel.hashCode());
		result = prime * result + (this.packet == null ? 0 : this.packet.hashCode());
		result = prime * result + (this.player == null ? 0 : this.player.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		Packet other = (Packet) obj;
		if (this.cancel == null) {
			if (other.cancel != null) return false;
		} else if (!this.cancel.equals(other.cancel)) return false;
		if (this.packet == null) {
			if (other.packet != null) return false;
		} else if (!this.packet.equals(other.packet)) return false;
		if (this.player == null) {
			if (other.player != null) return false;
		} else if (!this.player.equals(other.player)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Packet{ " + (this.getClass().equals(SentPacket.class) ? "[> OUT >]" : "[< IN <]") + " " + this.getPacketName() + " " + (this.hasPlayer() ? this.getPlayername() : "#server#") + " }";
	}

}
