package me.criztovyl.clickless.tools;

import java.util.HashMap;
/**
 * \brief A Interface for a object store
 * Attention! The ID's are unique and overwritten if already there.
 * @author criztovyl
 *
 * @param <T> The object that should be stored.
 */
public interface Store<T> {
	/**
	 * Store the Object with an ID
	 * @param arg0 The Object
	 * @param arg1 The ID
	 */
	public void store(T arg0, String arg1);
	/**
	 * @return The complete Store value(s)
	 */
	public HashMap<String, T> fetch();
	/**
	 * @param arg0 The ID
	 * @return The object stored at this ID.
	 */
	public T fetch(String arg0);
}
