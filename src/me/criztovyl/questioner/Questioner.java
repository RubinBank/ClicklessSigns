package me.criztovyl.questioner;

import org.bukkit.event.player.AsyncPlayerChatEvent;
/**
 * \brief A Interface to do something with the answer the player gives to a question
 * A Interface to do something with the answer the player gives to a question
 * @author criztovyl
 *
 */
public interface Questioner{
	/**
	 * The action to add a player to the questioner
	 * @param playername
	 */
	void preChatAction(String playername);
	/**
	 * The action executed if the player entered something into the Chat
	 * @param evt The {@link AsyncPlayerChatEvent}
	 */
	void onChatAction(AsyncPlayerChatEvent evt);
	/**
	 * Removes a player from the questioner.
	 * @param playername
	 */
	void removePlayer(String playername);
	/**
	 * Adds a player to the Questioner
	 * @param playername
	 */
	void addPlayer(String playername);
	/**
	 * @param playername The player's name
	 * @return true if the questioner have the player, otherwise false
	 */
	boolean hasPlayer(String playername);
}
