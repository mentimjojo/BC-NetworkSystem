package com.blastercraft.mentimjojo.networksystem.core;

import com.blastercraft.mentimjojo.networksystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.Random;

public class Functions {

    /*
    * All general methods will be found here
    * And also be static to.
     */

    // Register console
    private static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    /*
    * Startup some functions
     */
    public static void startupFunctions(Main main){
        // Get general data
        getGeneralData(main);
        // Ex servers
        addExServers();
    }

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
    * Send message to player
     */
    public static void sendPlayerMsg(Player player, String text){
        // Set colors
        text = stringColors(text);
        // Send message
        player.sendMessage(Settings.pluginPrefix + text);
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
    * Add ex servers
     */
    private static void addExServers(){
        // Add servers
        Settings.exServers.add("survival-1");
        Settings.exServers.add("survival-2");
        Settings.exServers.add("bouw-1");
        // Add lobbys
        Settings.Lobbys.add("lobby-1");
    }

    /*
     * Get plugin.yml data
     */
    private static void getGeneralData(Main main){
        // Get plugin.yml
        PluginDescriptionFile pdf = main.getDescription();
        // Set the version
        Settings.pluginVersion = pdf.getVersion();
        // Get Bukkit server name
        Settings.pluginServerName = Bukkit.getServerName();
    }

    /*
    * Register events
     */
    public static void registerEvents(Plugin plugin, Listener... listeners){
        for(Listener listener : listeners){
            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }


    /*
    * Get random Lobby
     */
    public static String getRandomLobby(){
        // New random
        Random rand = new Random();
        // Next
        int next = rand.nextInt(Settings.Lobbys.size());
        // Return lobby
        return Settings.Lobbys.get(next);
    }
}
