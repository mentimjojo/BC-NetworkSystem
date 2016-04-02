package com.blastercraft.mentimjojo.networksystem.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class lobbySpecicals implements Listener{

    // Hub location
    Location location = new Location(Bukkit.getWorld("lobby2"), -252.500, 42, -979.300);

    /*
    Teleport on join
    */
    @EventHandler
    public void DoStuffOnJoin(PlayerJoinEvent event){
        // Teleport right location
        event.getPlayer().teleport(location);
    }

    /*
    Teleport on void
    */
    @EventHandler
    public void teleportOnVoid(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                event.getEntity().teleport(location);
                event.setCancelled(true);
            }
        }
    }

    /*
    Give jump/Run boost
     */
    @EventHandler
    public void giveBoost(PlayerMoveEvent event) {
        // Get player
        Player player = event.getPlayer();
        // Give Boost
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 999999999, 3));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 3));
    }

}
