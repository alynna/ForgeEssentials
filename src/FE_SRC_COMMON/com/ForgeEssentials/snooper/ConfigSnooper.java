package com.ForgeEssentials.snooper;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.ForgeEssentials.core.ForgeEssentials;
import com.ForgeEssentials.snooper.responce.ServerInfo;

public class ConfigSnooper 
{
	public static boolean send_Mods;
	public static boolean send_IP;
	public static boolean send_Motd;
	public static boolean send_WB;
	public static boolean send_Players;
	public static boolean send_Player_info;
	public static boolean send_Player_armor;
	public static boolean send_Player_inv;
	public static int[] TPSList;	
	
	public static final File wbconfig = new File(ForgeEssentials.FEDIR, "Snooper.cfg");
	public final Configuration config;
	
	public ConfigSnooper()
	{
		config = new Configuration(wbconfig, true);
		
		String cat = "Snooper";
		
		ModuleSnooper.port = config.get(cat, "port", 25565, "The query port").getInt();
		ModuleSnooper.hostname = config.get(cat, "hostname", "", "The query hostname/IP").value;
		ModuleSnooper.enable = config.get(cat, "enable", false).getBoolean(false);
		
		ModuleSnooper.overrideIP = config.get(cat, "overrideIP", false, "If set to true, will send 'overrideIPValue' instead of IP").getBoolean(false);
		ModuleSnooper.overrideIPValue = config.get(cat, "overrideIPValue", "", "Value to send if overrideIP = true").value;
		
		ModuleSnooper.autoReboot = config.get(cat, "autoReload", true, "Automaticly reload the query system if a fatal error occures").getBoolean(true);
		
		ServerInfo.ServerID = config.get(cat, "serverID", 0, "This is here to make it easy for other sites (server lists) to authenticate the server").getInt();
		ServerInfo.serverHash = config.get(cat, "serverHash", "", "This is here to make it easy for other sites (server lists) to authenticate the server").value;
		
		send_Mods = config.get(cat, "send_Mods", true, "Send mod info").getBoolean(true);
		send_IP = config.get(cat, "send_IP", true, "Send ip & port").getBoolean(true);
		send_Motd = config.get(cat, "send_Motd", true, "Send motd").getBoolean(true);
		send_WB = config.get(cat, "send_WorldBorder", true, "Send World border info (size)").getBoolean(true);
		send_Players = config.get(cat, "send_Players", true, "Send online player list").getBoolean(true);
		send_Player_info = config.get(cat, "send_Player_info", true, "Send player info").getBoolean(true);
		send_Player_armor = config.get(cat, "send_Player_armor", true, "Send player armor").getBoolean(true);
		send_Player_inv = config.get(cat, "send_Player_inv", true, "Send player inventory").getBoolean(true);
		
		TPSList = config.get(cat, "TPS_dim", new int[]{-1 ,0 ,1}, "Dimentions to send TPS of").getIntList();
		
		config.save();
	}
}
