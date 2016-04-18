package com.blastercraft.mentimjojo.networksystem.core;

import java.util.ArrayList;

public class Settings {

    /*
    * All the settings of the plugin will be listed here.
    * Also all things has to be static.
     */

    // Plugin prefix
    public static String pluginPrefix = Functions.stringColors("&F[&BBlasterCraft&F] ");

    // Plugin version
    public static String pluginVersion;

    // Server name where plugin is running
    public static String pluginServerName;

    // Servers where selector is not in hotbar
    public static ArrayList<String> exServers = new ArrayList<String>();

    // Server lobbys
    public static ArrayList<String> Lobbys = new ArrayList<String>();

    // Slot count selector
    public static int selectorSlots = 27;

}
