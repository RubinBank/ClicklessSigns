package me.criztovyl.clicklesssigns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import me.criztovyl.clicklesssigns.listeners.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ClicklessSigns  extends JavaPlugin{
	private static ArrayList<Location> triggers;
	private static HashMap<Location, ClicklessSign> signsOfTriggers;
	private static HashMap<Location, Location> triggerOfSign;
	private static Logger log;
	public void onEnable(){
		log = this.getLogger();
		this.saveDefaultConfig();
		triggers = new ArrayList<Location>();
		signsOfTriggers = new HashMap<Location, ClicklessSign>();
		triggerOfSign = new HashMap<Location, Location>();
		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
		log.info("I'm there!");
	}
	public void onDisable(){
		log.info("Bye Bye.");
	}
	public static void log(String msg){
		log.info(msg);
	}
	static void severe(String msg){
		log.severe(msg);
	}
	public static enum SignPos{
		UP, DOWN;
	}
	public static void addSign(Location loc, SignPos pos, ClicklessSign sign){
		if(loc != null && pos != null){
			int locX = loc.getBlockX();
			int locY = loc.getBlockY();
			int locZ = loc.getBlockZ();
			World locWorld = loc.getWorld();
			switch(pos){
			case UP:
				triggers.add(new Location(locWorld, locX, locY+2, locZ));
				triggerOfSign.put(loc, new Location(locWorld, locX, locY+2, locZ));
				signsOfTriggers.put(new Location(locWorld, locX, locY+2, locZ), sign);
				break;
			case DOWN:
				triggers.add(new Location(locWorld, locX, locY-1, locZ));
				triggerOfSign.put(loc, new Location(locWorld, locX, locY-1, locZ));
				signsOfTriggers.put(new Location(locWorld, locX, locY-1, locZ), sign);
				break;
			}
		}
	}
	public static void removeSign(Location loc){
		if(loc != null && triggerOfSign.get(loc) != null){
			triggers.remove(triggerOfSign.get(loc));
			signsOfTriggers.remove(triggerOfSign.get(loc));
		}
	}
	public static boolean isClicklessSignTrigger(Location loc){
		return triggers.contains(loc);
	}
	public static void callSignAction(Location trigger, String p_n){
		signsOfTriggers.get(trigger).action(p_n);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(cmd.getName().equalsIgnoreCase("ClicklessSigns")){
			if(args.length >= 1)
				if(args[0].toLowerCase().equals("triggerlist")){
					for(int i = 0; i < triggers.size(); i++){
						Location loc = triggers.get(i);
						log("World: " + loc.getWorld().getName() + ", X: " + loc.getBlockX() + ", Y: "+ loc.getBlockY() + ", Z: " + loc.getBlockZ());
					}
					return true;
				}
			return true;
		}
		return true;
	}
}
