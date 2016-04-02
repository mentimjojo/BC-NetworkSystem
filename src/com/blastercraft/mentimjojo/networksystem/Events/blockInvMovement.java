package com.blastercraft.mentimjojo.networksystem.events;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class blockInvMovement implements Listener {

    /*
      Block inv movement
     */
    @EventHandler
    public void invClick(InventoryClickEvent event) {
        if (!event.getWhoClicked().hasPermission("network.inventory")) {
            // Cancel inventory movement
            event.setCancelled(true);
        } else {
            if (event.getWhoClicked().getGameMode() != GameMode.CREATIVE) {
                event.setCancelled(true);
            }
        }
    }

    /*
    Block swap player event
     */
    @EventHandler
    public void onSwapItems(PlayerSwapHandItemsEvent event) {
        // So nobody can swipe items
        event.setCancelled(true);
    }

    /*
      Block weather
     */
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        // Check when rain
        if (event.toWeatherState()) {
            // Disable rain
            event.setCancelled(true);
        }
    }

    /*
    Block block breaking
     */
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!event.getPlayer().hasPermission("network.break")) {
            // Stop block break
            event.setCancelled(true);
        } else {
            if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
                event.setCancelled(true);
            }
        }
    }

    /*
    block block placing
     */
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!event.getPlayer().hasPermission("network.place")) {
            // Stop block place
            event.setCancelled(true);
        } else {
            if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
                event.setCancelled(true);
            }
        }
    }

    /*
    Block drop event
     */
    @EventHandler
    public void blockDrop(PlayerDropItemEvent event){
        if (!event.getPlayer().hasPermission("hub.drop")) {
            // Stop block place
            event.setCancelled(true);
        } else {
            if (event.getPlayer().getGameMode() != GameMode.CREATIVE) {
                event.setCancelled(true);
            }
        }
    }

}
