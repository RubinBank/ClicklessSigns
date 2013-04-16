package me.criztovyl.clickless.tools;

import org.bukkit.Location;
import org.bukkit.World;
/**
 * Tool for do things with a org.bukkit.Location
 * @author criztovyl
 *
 */
public class LocationTool {
	private Location loc;
	/**
	 * @param loc The Location
	 */
	public LocationTool(Location loc){
		this.loc = loc;
	}
	/**
	 * Checks if the Location are the same Block
	 * @param loc2
	 * @return True if its the same Block, otherwise false
	 */
	public boolean sameBlock(Location loc2){
		int loc1X = loc.getBlockX();
		int loc1Y = loc.getBlockY();
		int loc1Z = loc.getBlockZ();
		World loc1World = loc.getWorld();
		int loc2X = loc2.getBlockX();
		int loc2Y = loc2.getBlockY();
		int loc2Z = loc2.getBlockZ();
		World loc2World = loc2.getWorld();
		return loc1X == loc2X && loc1Y == loc2Y && loc1Z == loc2Z && loc1World.equals(loc2World);
	}
	/**
	 * @return The floored Location
	 */
	public Location simplify(){
		return new Location(loc.getWorld(), loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}
	/**
	 * @return The Location stored in the Tool.
	 */
	public Location getLoc() {
		return loc;
	}
	public String getLocationString(){
		return loc.getBlockX() + " X , " + loc.getBlockY() + " Y, "
		+ loc.getBlockZ() + " Z. World: " + loc.getWorld().getName();
	}
}
