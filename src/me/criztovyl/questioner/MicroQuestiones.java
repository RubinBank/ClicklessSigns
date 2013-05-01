package me.criztovyl.questioner;

import java.util.ArrayList;

import me.criztovyl.clickless.ClicklessPlugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
/**
 * \brief Manages MicroQuestioner's
 * Manages MicroQuestioner's.
 * @author criztovyl
 *
 */
public class MicroQuestiones implements Listener{
        private ArrayList<MicroQuestioner> questioners;
        /**
         * Tool to Manage MicroQuestioner
         */
        public MicroQuestiones(){
                questioners = new ArrayList<MicroQuestioner>();
                Bukkit.getPluginManager().registerEvents(this, Bukkit.getPluginManager()
                                .getPlugin("Clickless"));
                ClicklessPlugin.log("ShiftManager Registered Chat Event.");
        }
        /**
         * Adds a MicroQuestioner
         * @param questioner The {@link MicroQuestioner}
         */
        public void addQuestioner(MicroQuestioner questioner){
                ClicklessPlugin.msg(questioner.getPlayer(), questioner.getQuestion());
                this.questioners.add(questioner);
                Bukkit.getLogger().info("Added Questioner...");
        }
        /**
         * Called when there is a {@link AsyncPlayerChatEvent}, and executes the {@link MicroQuestioner}'s action.
         * @param evt The {@link AsyncPlayerChatEvent}
         */
        @EventHandler
        public void onChatEvent(AsyncPlayerChatEvent evt){
                for(int i = 0; i < questioners.size(); i++){
                        if(!questioners.get(i).getSuccess()){
                                if(evt.getPlayer().getName().toLowerCase().equals(questioners.get(i).getPlayer().toLowerCase())){
                                        questioners.get(i).executeAction(evt);
                                        evt.setCancelled(true);
                                }
                        }
                        else{
                                questioners.remove(i);
                                i--;
                        }
                }
        }
        public ArrayList<MicroQuestioner> getQuestioners(){
            return questioners;
        }
}
