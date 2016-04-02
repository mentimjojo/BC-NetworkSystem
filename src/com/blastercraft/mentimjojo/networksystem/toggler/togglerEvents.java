package com.blastercraft.mentimjojo.networksystem.toggler;

import com.blastercraft.mentimjojo.networksystem.Main;
import com.blastercraft.mentimjojo.networksystem.core.Functions;
import com.blastercraft.mentimjojo.networksystem.core.Settings;
import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class togglerEvents implements Listener {

    // Main main;
    Main main;

    public togglerEvents(Main plugin){
        this.main = plugin;
    }

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        // check if good server
        if(!Settings.exServers.contains(Settings.pluginServerName)){
            // Give item
            Toggler.giveHideItem(event.getPlayer());
        }
    }

    @EventHandler
    @Deprecated
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Get the player
        Player player = (Player) event.getPlayer();

        // Check if hide
        if ((event.getAction() != Action.PHYSICAL) && (player.getItemInHand().isSimilar(Toggler.hideItem))) {
            // Cancel event
            event.setCancelled(true);
            // Check if cooldown
            if (!Toggler.cooldown.contains(player)) {
                // Give show
                Toggler.giveShowItem(player);
                // Send message
                player.sendMessage(Settings.pluginPrefix + ChatColor.RED + "All players are now hidden.");
                // Add to cooldown
                Toggler.cooldown.add(player);
                // Remove all player
                for (Player p : Bukkit.getOnlinePlayers()) {
                    player.hidePlayer(p);
                }
                // After 5 seconds remove from cooldown
                main.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                    public void run() {
                        // Remove
                        Toggler.cooldown.remove(player);
                    }
                }, 20 * 5);
            } else {
                ActionBarAPI.sendActionBar(player , Functions.stringColors("&CWait 5 seconds before you use this tool again!"), 100);
            }
        } else if ((event.getAction() != Action.PHYSICAL) && (player.getItemInHand().isSimilar(Toggler.showItem))) {
            // Cancel event
            event.setCancelled(true);
            // Check if cooldown
            if (!Toggler.cooldown.contains(player)) {
                // Give hide
                Toggler.giveHideItem(player);
                // Send message
                player.sendMessage(Settings.pluginPrefix + ChatColor.GREEN + "All players are now visible.");
                // Add to cooldown
                Toggler.cooldown.add(player);
                // Show all player
                for (Player p : Bukkit.getOnlinePlayers()) {
                    player.showPlayer(p);
                }
                // After 5 seconds remove from cooldown
                main.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
                    public void run() {
                        // Remove
                        Toggler.cooldown.remove(player);
                    }
                }, 20 * 5);
            } else {
                ActionBarAPI.sendActionBar(player , Functions.stringColors("&CWait 5 seconds before you use this tool again!"), 100);
            }
        }
    }

}
