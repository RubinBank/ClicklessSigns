package me.criztovyl.timeshift;

import org.bukkit.event.player.AsyncPlayerChatEvent;
/**
 * A Interface for TimeShift.
 * @author criztovyl
 *
 */
public interface TimeShifter{
	/**
	 * @return If the Action was success true, otherwise false
	 */
	boolean getSuccess(String playername);
	/**
	 * The Action executed if the Player added to the Shifter
	 * @param playername
	 */
	void preChatAction(String playername);
	/**
	 * The Action executed if the Player entered something into the Chat
	 * @param evt The {@link AsyncPlayerChatEvent}
	 */
	void onChatAction(AsyncPlayerChatEvent evt);
	/**
	 * The Action executed if the Shifter was success.
	 * @param playername
	 */
	void afterChatAction(String playername);
	/**
	 * Removes a Player from the Shifter.
	 * @param playername
	 */
	void removePlayer(String playername);
	/**
	 * Adds a Player to the Shifter
	 * @param playername
	 */
	void addPlayer(String playername);
	/**
	 * @param playername The Players name
	 * @return true if the player is in the shifter, otherwise false
	 */
	boolean hasPlayer(String playername);
}
