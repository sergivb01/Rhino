package me.sergivb01.rhino.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerUtils{

	public List<Player> getStaffMembers(){
		//TODO: check if they have staff alerts enabled
		return Bukkit.getOnlinePlayers().stream().filter(p -> p.hasPermission("rhino.utils.staff")).collect(Collectors.toList());
	}

}
