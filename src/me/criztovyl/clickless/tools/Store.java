package me.criztovyl.clickless.tools;

import java.util.HashMap;

public interface Store<T> {
	public void store(HashMap<String, T> arg);
	public void store(T arg0, String arg1);
	public HashMap<String, T> fetch();
	public String fetch(T arg0);
}
