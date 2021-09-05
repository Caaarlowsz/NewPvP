package me.viitor.anticheat.hacks.flyspeed;

import org.bukkit.Location;

public class Jump {
	public MoveLog start;
	public MoveLog apex;
	public MoveLog end;
	public double height;
	public double fallDistance;
	public double length;
	public double time;
	public double jumpTime;
	public double fallTime;
	public double verticalSpeed;
	public double jumpSpeed;
	public double fallSpeed;
	public double horizontalSpeed;
	public boolean isFloating = false;
	public boolean isOnGround = false;
	public boolean isOnLadder = false;
	public boolean isOnFire = false;
	public static double nextexpectedY;

	public Jump(MoveLog start, MoveLog apex, MoveLog end) {
		this.start = start;
		this.apex = apex;
		this.end = end;

		if ((start.location.getY() == apex.location.getY()) && (apex.location.getY() == end.location.getY()) && (!start.isAir) && (!apex.isAir) && (!end.isAir)) {
			this.isOnGround = true;
		}
		this.height = (apex.location.getY() - start.location.getY());
		this.fallDistance = (apex.location.getY() - end.location.getY());
		this.length = (GetHorzDistance(start.location, apex.location) + GetHorzDistance(apex.location, end.location));

		this.time = ((end.time - start.time) / 1000.0D);
		this.jumpTime = ((apex.time - start.time) / 1000.0D);
		this.fallTime = ((end.time - apex.time) / 1000.0D);
		this.jumpSpeed = (this.height / this.jumpTime);
		this.fallSpeed = (this.fallDistance / this.fallTime);
		this.verticalSpeed = ((this.height + this.fallDistance) / this.time);

		this.horizontalSpeed = (this.length / this.time);
 	}
	public static double getNextExpectedY() {
		return nextexpectedY;
	}
 	public static void setNextExpectedY(double d) {
 		nextexpectedY = d;
 	}

 	private double GetHorzDistance(Location a, Location b) {
 		double x = Math.abs(a.getX() - b.getX());
 		double z = Math.abs(a.getZ() - b.getZ());

 		return Math.sqrt(x * x + z * z);
 	}
}