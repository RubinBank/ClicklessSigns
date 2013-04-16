package me.criztovyl.clickless;

import java.util.HashMap;

import me.criztovyl.questioner.Questioner;

import org.bukkit.Location;

/**
 * \brief The Interface for a click less sign
 * The Interface of an click less sign
 * @author criztovyl
 *
 */
public interface ClicklessSign {
	/**
	 * Sets the Action, e.g. foo("bar");
	 * Won't executed if there is a Questioner.
	 */
	void action(String p_n);
	/**
	 * @return The {@link Questioner}
	 * If you wont to use a Questioner return null.
	 */
	Questioner getQuestioner();
	/**
	 * @return The {@link Location} of the Sign
	 */
	Location getLocation();
	/**
	 * @return The {@link Location} of the Sign Trigger 
	 */
	Location getTrigger();
	/**
	 * @return extra Options, e.g. Creator or Place
	 */
	HashMap<String, String> getOptions();
}
