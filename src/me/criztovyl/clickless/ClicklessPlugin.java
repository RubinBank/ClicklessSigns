package me.criztovyl.clickless;

import java.util.ArrayList;
import java.util.logging.Logger;

import me.criztovyl.clickless.tools.ConsolePlayerMessage;
import me.criztovyl.clickless.tools.LocationTool;
import me.criztovyl.questioner.MicroQuestioner;
import me.criztovyl.questioner.MicroQuestiones;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
/**
 * \brief thos class is loaded by the CraftBukkit Server.
 * The "Main" Class for Bukkit.
 * @author criztovyl
 *
 */
public class ClicklessPlugin extends JavaPlugin{
        private static Logger log;
        private static Clickless clickless;
        private static MicroQuestiones questiones;
        /**
         * Bukkit Stuff
         */
        public void onEnable(){
                log = this.getLogger();
                clickless = new Clickless();
                questiones = new MicroQuestiones();
                this.saveDefaultConfig();
                log.info("I'm there!");
        }
        /**
         * Bukkit Stuff
         */
        public void onDisable(){
                log.info("CU");
        }
        /**
         * Logs a "[INFO]" Message
         * @param msg The Message
         */
        public static void log(String msg){
                log.info(msg);
        }
        /**
         * Logs a "[SEVERE]" Message
         * @param msg
         */
        static void severe(String msg){
                log.severe(msg);
        }
        /**
         * @return The Clickless Instance/Object
         */
        public static Clickless getClickless(){
                return clickless;
        }
        /**
         * @return The MicroQuestiones Object
         */
        public static MicroQuestiones getMicroQuestions(){
                return questiones;
        }
        /**
         * Bukkit Command Stuff
         */
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
                ConsolePlayerMessage send = new ConsolePlayerMessage(sender);
                if(cmd.getName().equalsIgnoreCase("clickless")){
                        ArrayList<ClicklessSign> signs = getClickless().getSigns();
                        if(args.length >= 0){
                                if(args[0].toLowerCase().equals("signs")){
                                        String msg = signs.size() +" Signs:";
                                        for(int i = 0; i < signs.size(); i++){
                                                msg += new LocationTool(signs.get(i).getLocation()).getLocationString() + "\n";
                                        }
                                        send.sendMessage(msg);
                                }
                                if(args[0].toLowerCase().equals("questioner")){
                                    ArrayList<MicroQuestioner> questiones_ = questiones.getQuestioners();
                                    for(int i = 0; i < questiones_.size(); i++){
                                        log.info(questiones_.get(i).getPlayer() + ": '" + questiones_.get(i).getQuestion() + "'");
                                    }
                                    return true;
                                }
                                if(args[0].toLowerCase().equals("help")){
                                        send.sendMessage("/clickless signs: list all registered signs\n" +
                                                        "/clickless help: this help text");
                                }
                        }
                }
                return true;
        }
        public static void msg(String playername, String msg){
                Player p = Bukkit.getPlayer(playername);
                if(p != null){
                        p.sendMessage(msg);
                }
        }
}
