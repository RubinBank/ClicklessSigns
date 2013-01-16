package me.criztovyl.clicklesssigns.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	private static FileConfiguration conf = Bukkit.getServer().getPluginManager().getPlugin("ClicklessSigns").getConfig();
	public static String getDbURL(){
		return "jdbc:mysql://" + HostAddress() + "/" + HostDatabase() + "?user=" + HostUser() + "&password=" + HostPassword();
	}
	public static String HostAddress(){
		return conf.getString("MySQL.Host.Address");
	}
	public static String HostUser(){
		return conf.getString("MySQL.Host.User");
	}
	public static String HostPassword(){
		return conf.getString("MySQL.Host.Password");
	}
	public static String HostDatabase(){
		return conf.getString("MySQL.Host.Database");
	}
	public static String Table_Signs(){
		return HostDatabase() + "." + conf.getString("MySQL.Host.Table_Signs");
	}
	public static boolean isSet(String path){
		return conf.isSet(path);
	}
}
