package me.viitor.anticheat.hacks.flyspeed;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class MoveLog {
	public Player player;
	public long time;
	public Location location;
	public Vector velocity;
	public boolean isSprinting;
	public boolean isSneaking;
	public boolean isAir;
	public boolean isOnFire;
	public boolean isInVehicle;
	public boolean isOnLadder;

	public MoveLog(Player Jogador, Location Local) {
		this.player = Jogador;
		this.location = Local.clone();
		this.time = System.currentTimeMillis();
		this.velocity = Jogador.getVelocity();
		this.isSprinting = Jogador.isSprinting();
		this.isSneaking = Jogador.isSneaking();
		this.isInVehicle = Jogador.isInsideVehicle();
		this.isOnFire = (Jogador.getFireTicks() > 0);

		if (Math.abs(this.velocity.getX()) < 0.001D)
			this.velocity.setX(0);
		if (Math.abs(this.velocity.getY()) < 0.001D)
			this.velocity.setY(0);
		if (Math.abs(this.velocity.getZ()) < 0.001D) {
			this.velocity.setZ(0);
		}
		this.isOnLadder = isInBlock(this.location.getBlock().getType());
		this.isAir = isBlockAir(this.location);
	}

	public double Speed(MoveLog Mover) {
		if (Mover == null) {
			return 0.0D;
		}
		long Time = Math.abs(this.time - Mover.time);
		double Distancia = this.location.distance(Mover.location);

		return Distancia / Time;
	}

	private boolean isMaterialAir(Material Tipo) {
		return (Tipo == Material.AIR) || (Tipo == Material.TORCH) || (Tipo == Material.REDSTONE_TORCH_OFF) || (Tipo == Material.REDSTONE_TORCH_ON) || (Tipo == Material.SIGN);
	}

	private boolean isInBlock(Material Tipo) {
		return (Tipo != Material.AIR) || (Tipo != Material.TORCH) || (Tipo != Material.REDSTONE_TORCH_OFF) || (Tipo != Material.REDSTONE_TORCH_ON) || (Tipo != Material.SIGN);
	}

	private boolean isBlockAir(Location Local) {
		Location Localização = Local.clone();
		double X = Localização.getX();
		double Y = Localização.getY();
    	double Z = Localização.getZ();

    	Y = Math.floor(Y) - 0.001D;

    	Material Tipo = new Location(Localização.getWorld(), X, Y, Z).getBlock().getType();

    	if (!isMaterialAir(Tipo)) {
    		return false;
    	}
    	boolean Boolean1 = false;
    	boolean Boolean2 = false;
    	boolean Boolean3 = false;
    	boolean Boolean4 = false;

    	if ((int)X != (int)(Y + 0.32D)) {
    		Boolean1 = true;
    		Tipo = new Location(Localização.getWorld(), X + 0.32D, Y, Z).getBlock().getType();

    		if (!isMaterialAir(Tipo)) {
    			return false;
    		}
    	}
    	if ((int)X != (int)(X - 0.32D)) {
    		Boolean2 = true;
    		Tipo = new Location(Localização.getWorld(), X - 0.32D, Y, Z).getBlock().getType();

    		if (!isMaterialAir(Tipo)) {
    			return false;
    		}
    	}
    	if ((int)Z != (int)(Z + 0.32D)) {
    		Boolean3 = true;
    		Tipo = new Location(Localização.getWorld(), X, Y, Z + 0.32D).getBlock().getType();

    		if (!isMaterialAir(Tipo)) {
    			return false;
    		}
    	}
    	if ((int)Z != (int)(Z - 0.32D)) {
    		Boolean4 = true;
    		Tipo = new Location(Localização.getWorld(), X, Y, Z - 0.32D).getBlock().getType();
    		
    		if (!isMaterialAir(Tipo)) {
    			return false;
    		}
    	}
    	if ((Boolean1) && (Boolean3)) {
    		Tipo = new Location(Localização.getWorld(), X + 0.32D, Y, Z + 0.32D).getBlock().getType();

    		if (!isMaterialAir(Tipo)) {
    			return false;
    		}
    	}
    	if ((Boolean1) && (Boolean4)) {
    		Tipo = new Location(Localização.getWorld(), X + 0.32D, Y, Z - 0.32D).getBlock().getType();

    		if (!isMaterialAir(Tipo)) {
    			return false;
    		}
    	}
    	if ((Boolean2) && (Boolean3)) {
    		Tipo = new Location(Localização.getWorld(), X - 0.32D, Y, Z + 0.32D).getBlock().getType();

    		if (!isMaterialAir(Tipo)) {
    			return false;
    		}
    	}
    	if ((Boolean2) && (Boolean4)) {
    		Tipo = new Location(Localização.getWorld(), X - 0.32D, Y, Z - 0.32D).getBlock().getType();

    		if (!isMaterialAir(Tipo)) {
    			return false;
    		}
    	}
    	return true;
	}
}