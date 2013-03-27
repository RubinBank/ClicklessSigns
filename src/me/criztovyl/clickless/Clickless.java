package me.criztovyl.clickless;

import java.util.ArrayList;

import me.criztovyl.clickless.tools.LocationTools;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
/**
 * A class that manages ingame actions click less
 * @author criztovyl
 *
 */
public class Clickless implements Listener{
	private ArrayList<ClicklessSign> signs;
	/**
	 * Creates a new {@link Clickless} Object
	 */
	public Clickless(){
		signs = new ArrayList<ClicklessSign>();
		Bukkit.getPluginManager().registerEvents(this, Bukkit.getPluginManager().getPlugin("ClicklessSigns"));
	}
	/**
	 * Adds a new {@link ClicklessSign} to {@link Clickless}
	 * @param loc The Sign Location
	 * @param trigger The Sign Trigger
	 * @param sign The {@link ClicklessSign}
	 */
	public void addClicklessSign(ClicklessSign sign){
		signs.add(sign);
	}
	public void removeClicklessSignByTrigger(Location trigger){
		for(int i = 0; i < signs.size(); i++){
			if(signs.get(i).getTrigger().equals(trigger)){
				signs.remove(i);
			}
		}
		
	}
	public void removeClicklessSign(Location loc){
		for(int i = 0; i < signs.size(); i++){
			if(signs.get(i).getLocation().equals(loc)){
				signs.remove(i);
			}
		}
	}
	/**
	 * Bukkit Event Stuff
	 * @param evt
	 */
	@EventHandler
	void onPlayerMove(PlayerMoveEvent evt){
		String p_n = evt.getPlayer().getName();
		Location to = LocationTools.simplify(evt.getTo());
		Location from = LocationTools.simplify(evt.getFrom());
		if(!to.equals(from)){//Works
			if(hasTrigger(to)){//Works
				if(getSignByTrigger(to).getTimeShifter() != null){
					//evt.getPlayer().sendMessage("Has Time Shifter"); Works
					getSignByTrigger(to).getTimeShifter().addPlayer(p_n);
					return;
				}
				else{
					getSignByTrigger(to).action(p_n);
					return;
				}
			}
			if(hasTrigger(from)){
				if(getSignByTrigger(from).getTimeShifter() != null){
					getSignByTrigger(from).getTimeShifter().removePlayer(p_n);
					return;
				}
			}
		}
	}
	/**
	 * Bukkit Stuff
	 * @param evt
	 */
	@EventHandler
	void onPlayerChat(AsyncPlayerChatEvent evt){
		for(int i = 0; i < signs.size(); i++){
			if(signs.get(i).getTimeShifter() != null){
				if(signs.get(i).getTimeShifter().hasPlayer(evt.getPlayer().getName())){
					signs.get(i).getTimeShifter().onChatAction(evt);
				}
			}
		}
	}
	/**
	 * Checks if the given Trigger is a ClicklessSign Trigger
	 * @param trigger - The Trigger {@link Location}
	 * @return true if it's a Trigger, otherwise false;
	 */
	boolean hasTrigger(Location trigger){
		trigger = LocationTools.simplify(trigger);
		for(int i = 0; i < signs.size(); i++){
			if(signs.get(i).getTrigger().equals(trigger)){
				return true;
			}
		}
		return false;
	}
	/**
	 * get a Clickless Sign by Location
	 * @param loc The Sign Location
	 * @return If there is a Sign on the Location, the {@link ClicklessSign}, otherwise null
	 */
	public ClicklessSign getSignByLoc(Location loc){
		for(int i = 0; i < signs.size(); i++){
			if(signs.get(i).getLocation().equals(loc)){
				return signs.get(i);
			}
		}
		return null;
	}
	/**
	 * Get a Clickless Sign by his Trigger
	 * @param trigger The Trigger
	 * @return If there is a Sign with this trigger, the {@link ClicklessSign}, otherwise null
	 */
	public ClicklessSign getSignByTrigger(Location trigger){
		for(int i = 0; i < signs.size(); i++){
			if(signs.get(i).getTrigger().equals(trigger)){
				return signs.get(i);
			}
		}
		return null;
	}
}
