package com.blastercraft.mentimjojo.networksystem.friends;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        // Give item
        Friends.skullHead(event.getPlayer());
    }

}
