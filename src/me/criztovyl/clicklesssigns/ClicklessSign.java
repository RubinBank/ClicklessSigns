package me.criztovyl.clicklesssigns;

import org.bukkit.Location;

public interface ClicklessSign {
	/**
	 * Sets the Action, e.g. bar("foo");
	 */
	void action(String p_n);
	/**
	 * The Location of the Sign-Block
	 * @return Location of the Sign-Block
	 */
	Location getLocation();
	/**
	 * The Trigger Location of the Click less Sign
	 * @return Location of the Sign Trigger
	 */
	Location getTrigger();
}
