package me.sergivb01.rhino;

import lombok.Getter;
import me.sergivb01.rhino.listeners.PlayerListener;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Map;

public class RhinoPlugin extends JavaPlugin{
	@Getter public static RhinoPlugin instance;

	public void onEnable(){
		instance = this;

		getLogger().info("Enabling Rhino plugin - Developed by sergivb01 (twitter.com/sergivb01 - github.com/sergivb01)");

		//Load configuration
		final File configFile = new File(this.getDataFolder() + "/config.yml");
		if(!configFile.exists()){
			this.saveDefaultConfig();
		}
		this.getConfig().options().copyDefaults(true);


		registerCommands();

		//Create listeners - auto registers
		new PlayerListener(this);
	}


	private void registerCommands(){

		Map<String, Map<String, Object>> map = getDescription().getCommands();
		for(Map.Entry<String, Map<String, Object>> entry : map.entrySet()){
			PluginCommand command = getCommand(entry.getKey());
			command.setPermission("rhino.command." + entry.getKey());
			command.setPermissionMessage(ChatColor.translateAlternateColorCodes('&', "&e&l⚠ &cYou do not have permissions to execute this command."));
		}
	}

	public void onDisable(){
		getLogger().info("Shutting down Rhino plugin - Developed by sergivb01 (twitter.com/sergivb01 - github.com/sergivb01)");
	}


}
