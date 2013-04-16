package me.criztovyl.questioner;

import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * \brief A Questioner for only one player and one question.
 * A Questioner for only one player and one question.
 * @author criztovyl
 *
 */
public interface MicroQuestioner {
/**
 * The Player who should be questioned
 */
public String getPlayer();
/**
 * The Action, executed when the Player answers the question
 * @param evt A CraftBukkit (asynchronous) Chat Event
 */
public void executeAction(AsyncPlayerChatEvent evt);
/**
 * The Question
 */
public String getQuestion();
/**
 * @return The success
 */
public boolean getSuccess();
}
