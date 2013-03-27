package me.criztovyl.timeshift;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
/**
 * This class manages time shifted chats. The chat will be removed if the shifter return success.
 * @author criztovyl
 *
 */
public class ShiftHelper implements Listener{
	private ArrayList<MicroShift> shifter;
	/**
	 * Tool to Manage {@link MicroShift}'s.
	 */
	public ShiftHelper(){
		shifter = new ArrayList<MicroShift>();
		Bukkit.getPluginManager().registerEvents(this, Bukkit.getPluginManager()
				.getPlugin("Clickless"));
	}
	/**
	 * Adds a Micro Shifter
	 * @param shifter The {@link MicroShift}
	 */
	public void addShifted(MicroShift shifter){
		this.shifter.add(shifter);
	}
	/**
	 * Called when there is a {@link AsyncPlayerChatEvent}, and executes the {@link MicroShift}'s action.
	 * @param evt The {@link AsyncPlayerChatEvent}
	 */
	@EventHandler
	public void onChatEvent(AsyncPlayerChatEvent evt){
		for(int i = 0; i < shifter.size(); i++){
			if(!shifter.get(i).getSuccess()){
				if(evt.getPlayer().getName().toLowerCase().equals(shifter.get(i).getPlayer().toLowerCase())){
					shifter.get(i).executeAction(evt);
					evt.setCancelled(true);
				}
			}
			else{
				shifter.remove(i);
				i--;
			}
		}
	}
}
