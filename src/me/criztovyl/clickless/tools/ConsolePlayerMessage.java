package me.criztovyl.clickless.tools;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConsolePlayerMessage {
	private CommandSender sender;
	public ConsolePlayerMessage(CommandSender sender){
		this.sender = sender;
	}
	public void sendMessage(String msg){
		if(sender instanceof Player){
			sender.sendMessage(msg);
		}
		else{
			Bukkit.getLogger().info(msg);
		}
	}
}
