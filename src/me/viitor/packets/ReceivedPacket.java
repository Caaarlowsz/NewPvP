package me.viitor.packets;

import org.bukkit.entity.Player;

public class ReceivedPacket extends Packet {

	public ReceivedPacket(Object packet, Cancellable cancel, Player player) {
		super(packet, cancel, player);
	}

}
