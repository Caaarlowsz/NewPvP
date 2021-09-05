package me.viitor.packets;

import org.bukkit.entity.Player;

public abstract interface Handler {

	abstract void addChannel(Player player);

	abstract void removeChannel(Player player);

	abstract void addServerConnectionChannel();
}
