package com.blastercraft.mentimjojo.networksystem.events;

import com.blastercraft.mentimjojo.networksystem.core.Settings;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class teleports implements Listener {

    // Hub location
    Location paintball_spawn = new Location(Bukkit.getWorld("paintball"), -1108.100, 100, -7.140);

    /*
    *Teleport on void
    */
    @EventHandler
    public void teleportOnVoid(EntityDamageEvent event) {
        if (Settings.pluginServerName.equals("paintball-1")) {
            if (event.getEntity() instanceof Player) {
                if (event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                    event.getEntity().teleport(paintball_spawn);
                    event.setCancelled(true);
                }
            }
        }
    }
}
