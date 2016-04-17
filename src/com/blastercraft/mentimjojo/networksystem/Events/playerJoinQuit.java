package com.blastercraft.mentimjojo.networksystem.events;

import com.blastercraft.mentimjojo.networksystem.core.Settings;
import com.blastercraft.mentimjojo.networksystem.core.Title;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerJoinQuit implements Listener{

    /*
    Teleport on join
    */
    @EventHandler
    public void DoStuffOnJoin(PlayerJoinEvent event){
        // Set message null
        event.setJoinMessage(null);
        // Setup title
        Title title = new Title("&B" + Settings.pluginServerName.toUpperCase(),"&AYou are on " + Settings.pluginServerName,1,3,2);
        title.setTitleColor(ChatColor.AQUA);
        title.setSubtitleColor(ChatColor.GREEN);
        // Send title
        title.send(event.getPlayer());
        // Check if can run
        if(!Settings.exServers.contains(Settings.pluginServerName)) {
            // Set right slot
            event.getPlayer().getInventory().setHeldItemSlot(0);
            // Clear inventory
            event.getPlayer().getInventory().clear();
        }
    }

    /*
    On quit event
     */
    @EventHandler
    public void DoStuffOnQuit(PlayerQuitEvent event){
        // Remove quit message
        event.setQuitMessage(null);
    }

}
