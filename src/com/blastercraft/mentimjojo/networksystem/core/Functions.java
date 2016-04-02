package com.blastercraft.mentimjojo.networksystem.core;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class Functions {

    /*
    * All general methods will be found here
    * And also be static to.
     */

    // Register console
    private static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    /*
    * Send console messages also with colors
     */
    public static void sendConsoleMsg(String text){
        // Replace colors
        text = stringColors(text);
        // Send text in console
        console.sendMessage(Settings.pluginPrefix + text);
    }

    /*
    * Rework colors codes
     */
    public static String stringColors(String text){
        // Return chat colors
        text = ChatColor.translateAlternateColorCodes('&', text);
        // Return text
        return text;
    }

    /*
    * Register events
     */
    public static void registerEvents(Plugin plugin, Listener... listeners){
        for(Listener listener : listeners){
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

}
