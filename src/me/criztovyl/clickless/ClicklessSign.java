package me.criztovyl.clickless;

import org.bukkit.Location;

import me.criztovyl.timeshift.TimeShifter;
/**
 * The Interface of an click less sign
 * @author criztovyl
 *
 */
public interface ClicklessSign {
	/**
	 * Sets the Action, e.g. bar("foo");
	 * To use a TimeShifter leave blank.
	 */
	void action(String p_n);
	/**
	 * @return The {@link TimeShifter}
	 * If you want to use no TimeShifter leave blank.
	 */
	TimeShifter getTimeShifter();
	/**
	 * @return The {@link Location} of the Sign
	 */
	Location getLocation();
	/**
	 * @return The {@link Location} of the Sign Trigger 
	 */
	Location getTrigger();
}
