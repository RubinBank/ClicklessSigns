package me.criztovyl.clickless.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
/**
 *\brief as summary of configuration methods.
 * The configuration method summary
 * @author criztovyl
 *
 */
public class Config {
	private static FileConfiguration conf = Bukkit.getServer().getPluginManager().getPlugin("ClicklessSigns").getConfig();
	/**
	 * @return The Database URL
	 */
	public static String getDbURL(){
		return "jdbc:mysql://" + HostAddress() + "/" + HostDatabase() + "?user=" + HostUser() + "&password=" + HostPassword();
	}
	/**
	 * @return The database address
	 */
	public static String HostAddress(){
		return conf.getString("MySQL.Host.Address");
	}
	/**
	 * @return The database user
	 */
	public static String HostUser(){
		return conf.getString("MySQL.Host.User");
	}
	/**
	 * @return The password of the database user.
	 */
	public static String HostPassword(){
		return conf.getString("MySQL.Host.Password");
	}
	/**
	 * @return The name of the database
	 */
	public static String HostDatabase(){
		return conf.getString("MySQL.Host.Database");
	}
	/**
	 * Signs not stored by this plugin!
	 * @return The table the signs saved in
	 */
	@Deprecated
	public static String Table_Signs(){
		return HostDatabase() + "." + conf.getString("MySQL.Host.Table_Signs");
	}
	/**
	 * @param path The path in the YAML configuration file wich should be checked
	 * @return True if is set, else false
	 */
	public static boolean isSet(String path){
		return conf.isSet(path);
	}
}
