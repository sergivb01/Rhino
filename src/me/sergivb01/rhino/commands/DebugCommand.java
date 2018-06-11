package me.sergivb01.rhino.commands;

import me.sergivb01.rhino.Cache;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DebugCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command, String s, String[] args){
		Cache.payloads.forEach(payload -> sender.sendMessage(payload.toDocument().toJson()));
		sender.sendMessage("=================================================================");
		Cache.commandDelay.forEach(((uuid, last) -> sender.sendMessage("UUID=" + uuid.toString() + " // Timestamp=" + last)));
		return true;
	}


}
