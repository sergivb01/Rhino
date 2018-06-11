package me.sergivb01.rhino.utils;

import me.sergivb01.rhino.RhinoPlugin;

public class ConfigUtils{
	public static String SERVER_NAME = RhinoPlugin.getInstance().getConfig().getString("server-name");
	public static String REDIS_HOST = RhinoPlugin.getInstance().getConfig().getString("redis.host");
	public static int REDIS_PORT = RhinoPlugin.getInstance().getConfig().getInt("redis.port");
	public static boolean REDIS_AUTH = RhinoPlugin.getInstance().getConfig().getBoolean("redis.auth.enabled");
	public static String REDIS_PASSWORD = RhinoPlugin.getInstance().getConfig().getString("redis.auth.password");
	public static String REDIS_CHANNEL = RhinoPlugin.getInstance().getConfig().getString("redis.channel");

}
