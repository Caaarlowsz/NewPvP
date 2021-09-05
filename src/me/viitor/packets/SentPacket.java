package me.viitor.packets;

import org.bukkit.entity.Player;

public class SentPacket extends Packet {

	public SentPacket(Object packet, Cancellable cancel, Player player) {
		super(packet, cancel, player);
	}

}
