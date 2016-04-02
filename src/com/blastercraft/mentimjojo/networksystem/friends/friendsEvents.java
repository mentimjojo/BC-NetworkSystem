package com.blastercraft.mentimjojo.networksystem.friends;

import com.blastercraft.mentimjojo.networksystem.core.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class friendsEvents implements Listener {

    /*
    * Give item
     */
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        if(!Settings.exServers.contains(Settings.pluginServerName)) {
            // Give item
            Friends.skullHead(event.getPlayer());
        }
    }


    /*
    * On player inventory click
    */
    @EventHandler
    @Deprecated
    public void onPlayerInteract(PlayerInteractEvent event){
        if(!Settings.exServers.contains(Settings.pluginServerName)) {
            // Get player
            Player player = event.getPlayer();
            // Check if selector item
            if ((event.getAction() != Action.PHYSICAL) && player.getItemInHand().getType() == Material.SKULL_ITEM) {
                // Cancel event
                event.setCancelled(true);
                // Open friends menu
                Bukkit.getServer().dispatchCommand(player.getServer().getConsoleSender(), "sudo " + player.getName() + " friendsgui");
            }
        }
    }

}
