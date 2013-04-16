package me.criztovyl.clickless;

import java.util.ArrayList;

import me.criztovyl.clickless.tools.LocationTool;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
/**
 * \brief The object the controls all click less activity
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
		Bukkit.getPluginManager().registerEvents(this, Bukkit.getPluginManager().getPlugin("Clickless"));
	}
	/**
	 * Adds a new {@link ClicklessSign} to {@link Clickless}
	 * @param sign The {@link ClicklessSign}
	 */
	public void addClicklessSign(ClicklessSign sign){
		signs.add(sign);
		ClicklessPlugin.log("A Sign was Registered");
	}
	/**
	 * Removes a ClicklessSign by his trigger location (if exists)
	 * @param trigger The trigger location
	 */
	public void removeClicklessSignByTrigger(Location trigger){
		for(int i = 0; i < signs.size(); i++){
			if(signs.get(i).getTrigger().equals(trigger)){
				signs.remove(i);
			}
		}
		
	}
	/**
	 * Removes a ClicklessSign by his location (if exists)
	 * @param loc The Sign location
	 */
	public void removeClicklessSign(Location loc){
		loc = new LocationTool(loc).simplify();
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
		LocationTool toTool, fromTool;
		toTool = new LocationTool(evt.getTo());
		fromTool = new LocationTool(evt.getFrom());
		Location to = toTool.simplify();
		Location from = fromTool.simplify();
		if(!toTool.sameBlock(fromTool.getLoc())){
			if(hasTrigger(to)){
				if(getSignByTrigger(to).getQuestioner() != null){
					getSignByTrigger(to).getQuestioner().addPlayer(p_n);
					return;
				}
				else{
					getSignByTrigger(to).action(p_n);
					return;
				}
			}
			if(hasTrigger(from)){
				if(getSignByTrigger(from).getQuestioner() != null){
					getSignByTrigger(from).getQuestioner().removePlayer(p_n);
					return;
				}
			}
		}
	}
	/**
	 * Bukkit Event Stuff
	 * @param evt
	 */
	@EventHandler
	void onPlayerChat(AsyncPlayerChatEvent evt){
		for(int i = 0; i < signs.size(); i++){
			if(signs.get(i).getQuestioner() != null){
				if(signs.get(i).getQuestioner().hasPlayer(evt.getPlayer().getName())){
					signs.get(i).getQuestioner().onChatAction(evt);
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
		trigger =  new LocationTool(trigger).simplify();
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
	/**
	 * @return All Signs
	 */
	public ArrayList<ClicklessSign> getSigns() {
		return signs;
	}
}
