package com.blastercraft.mentimjojo.networksystem;

import com.blastercraft.mentimjojo.networksystem.events.blockInvMovement;
import com.blastercraft.mentimjojo.networksystem.events.lobbySpecicals;
import com.blastercraft.mentimjojo.networksystem.events.playerJoinQuit;
import com.blastercraft.mentimjojo.networksystem.core.*;
import com.blastercraft.mentimjojo.networksystem.friends.*;
import com.blastercraft.mentimjojo.networksystem.friends.Events;
import com.blastercraft.mentimjojo.networksystem.selector.*;
import com.blastercraft.mentimjojo.networksystem.toggler.Toggler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Selector
    Selector selector;

    // Channels
    Channels channels;

    // Toggler
    Toggler toggler;

    // Friends
    Friends friends;

    /*
    * On Enable runs when running plugin
     */
    @Override
    public void onEnable(){
        // Register global events
        registerEvents();
        // Register BungeeCord channel
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        // Get plugin yml
        Functions.startupFunctions(this);
        // Register classes
        registerClasses();
        // Send console message
        Functions.sendConsoleMsg("NetworkSystem By Mentimjojo (Version: " + Settings.pluginVersion + ") is Enabled on Server : " + Settings.pluginServerName);
    }

    /*
    * On disable when server close
     */
    @Override
    public void onDisable(){
        // Send console message
        Functions.sendConsoleMsg("NetworkSystem By Mentimjojo (Version: " + Settings.pluginVersion + ") is Disabled on Server : " + Settings.pluginServerName);
    }


    /*
    * Register couple of classes
     */
    public void registerClasses(){
        // Setup channels
        channels = new Channels(this);
        // Setup selector
        selector = new Selector(this);
        // Register toggler
        toggler =  new Toggler(this);
        // Friends item
        friends = new Friends(this);
    }

    /*
    * Block things when needed
     */
    public void registerEvents(){
        // Normal join/quit events
        Functions.registerEvents(this, new playerJoinQuit());

        // Block inventory/weather
        if(!Settings.exServers.contains(Settings.pluginServerName)){
            Functions.registerEvents(this, new blockInvMovement(), new Events());
        }

        // Lobby specs
        if(Settings.Lobbys.contains(Settings.pluginServerName)){
            Functions.registerEvents(this, new lobbySpecicals());
        }
    }
}
