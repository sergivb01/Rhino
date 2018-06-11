package me.sergivb01.rhino.commands;

import me.sergivb01.rhino.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.ChatColor.RED;

public class ReportCommand implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command, String s, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(RED + "This command may not be executed by Console.");
			return true;
		}

		Player player = (Player) sender;
		if(args.length < 2){
			player.sendMessage(RED + "Invalid usage: `/report <playername> <reason...>`");
			return true;
		}

		String reported = args[0];
		String reason = StringUtils.join(args, 1);

		//TODO: Send report


		return true;
	}


}
