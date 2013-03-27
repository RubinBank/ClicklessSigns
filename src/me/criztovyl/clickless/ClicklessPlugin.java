package me.criztovyl.clickless;

import java.util.logging.Logger;

import me.criztovyl.clickless.listeners.Listeners;
import me.criztovyl.timeshift.ShiftHelper;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
/**
 * The "Main" Class for Bukkit.
 * @author criztovyl
 *
 */
public class ClicklessPlugin extends JavaPlugin{
	private static Logger log;
	private static Clickless clickless;
	private static ShiftHelper shifthelper;
	/**
	 * Bukkit Stuff
	 */
	public void onEnable(){
		log = this.getLogger();
		clickless = new Clickless();
		shifthelper = new ShiftHelper();
		this.saveDefaultConfig();
		Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
		log.info("I'm there!");
	}
	/**
	 * Bukkit Stuff
	 */
	public void onDisable(){
		log.info("CU");
	}
	/**
	 * Logs a "[INFO]" Message
	 * @param msg The Message
	 */
	public static void log(String msg){
		log.info(msg);
	}
	/**
	 * Logs a "[SEVERE]" Message
	 * @param msg
	 */
	static void severe(String msg){
		log.severe(msg);
	}
	/**
	 * @return The Clickless Instance/Object
	 */
	public static Clickless getClickless(){
		return clickless;
	}
	/**
	 * @return The ShiftHelper Instance/Object
	 */
	public static ShiftHelper getShiftHelper(){
		return shifthelper;
	}
	/**
	 * Bukkit Stuff
	 */
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		return true;
	}
}
