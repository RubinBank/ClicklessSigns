package me.criztovyl.clickless.tools;

import org.bukkit.Location;
import org.bukkit.World;

public class LocationTools {
	public static boolean sameLocation(Location loc1, Location loc2){
		int loc1X = loc1.getBlockX();
		int loc1Y = loc1.getBlockY();
		int loc1Z = loc1.getBlockZ();
		World loc1World = loc1.getWorld();
		int loc2X = loc2.getBlockX();
		int loc2Y = loc2.getBlockY();
		int loc2Z = loc2.getBlockZ();
		World loc2World = loc2.getWorld();
		return loc1X == loc2X && loc1Y == loc2Y && loc1Z == loc2Z && loc1World.equals(loc2World);
	}
	public static Location simplify(Location loc){
		return new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}
}
