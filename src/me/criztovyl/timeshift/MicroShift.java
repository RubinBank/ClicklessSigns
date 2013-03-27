package me.criztovyl.timeshift;

import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * A Micro TimeShifter
 * @author criztovyl
 *
 */
public interface MicroShift {
/**
 * The Player who should be asked
 */
public String getPlayer();
/**
 * The Action, executed when the Player answers the question
 * @param evt
 */
public void executeAction(AsyncPlayerChatEvent evt);
/**
 * The Question
 */
public String getQuestion();
/**
 * @return the success
 */
public boolean getSuccess();
}
