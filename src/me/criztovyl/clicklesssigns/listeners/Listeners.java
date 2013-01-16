package me.criztovyl.clicklesssigns.listeners;

import me.criztovyl.clicklesssigns.ClicklessSigns;
import me.criztovyl.clicklesssigns.tools.LocationTools;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Listeners implements Listener{
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent evt){
		Location from = LocationTools.simpleize(evt.getFrom());
		Location to = LocationTools.simpleize(evt.getTo());
		if(!LocationTools.sameLocation(from, to)){
			if(ClicklessSigns.isClicklessSignTrigger(to)){
				ClicklessSigns.log("Call Sign Action");
				ClicklessSigns.callSignAction(to, evt.getPlayer().getName());
			}
		}
	}
}
