package com.blastercraft.mentimjojo.networksystem;

import com.blastercraft.mentimjojo.networksystem.events.blockInvMovement;
import com.blastercraft.mentimjojo.networksystem.events.lobbySpecicals;
import com.blastercraft.mentimjojo.networksystem.events.playerJoinQuit;
import com.blastercraft.mentimjojo.networksystem.core.*;
import com.blastercraft.mentimjojo.networksystem.friends.*;
import com.blastercraft.mentimjojo.networksystem.networkMenu.networkMenu;
import com.blastercraft.mentimjojo.networksystem.networkMenu.networkMenuEvents;
import com.blastercraft.mentimjojo.networksystem.selector.*;
import com.blastercraft.mentimjojo.networksystem.toggler.Toggler;
import com.blastercraft.mentimjojo.networksystem.toggler.togglerEvents;
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

    // Networkmenu
    networkMenu networkMenu;

    /*
    * On Enable runs when running plugin
     */
    @Override
    public void onEnable(){
        // Get plugin yml
        Functions.startupFunctions(this);
        // Register global events
        registerEvents();
        // Register BungeeCord channel
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
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
        // Network menu
        networkMenu = new networkMenu(this);
    }

    /*
    * Block things when needed
     */
    public void registerEvents(){
        // Normal join/quit events
        Functions.registerEvents(this, new playerJoinQuit(), new selectorEvents(this), new friendsEvents());

        // Block inventory/weather
        if(!Settings.exServers.contains(Settings.pluginServerName)){
            Functions.registerEvents(this, new blockInvMovement(), new togglerEvents(this));
        } else {
            Functions.registerEvents(this, new networkMenuEvents());
        }

        if(Settings.Lobbys.contains(Settings.pluginServerName)){
            Functions.registerEvents(this, new lobbySpecicals());
        }
    }
}
