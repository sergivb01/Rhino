package me.sergivb01.rhino.listeners;

import me.sergivb01.rhino.RhinoPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener{

	public PlayerListener(RhinoPlugin plugin){
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();

		//TODO: Handle player join
	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		Player player = event.getPlayer();

		//TODO: Handle player quit
	}


}
