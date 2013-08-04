package com.runetooncraft.plugins.EasyMobArmory;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.runetooncraft.plugins.EasyMobArmory.SpawnerHandler.SpawnerHandler;
import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;


public class Commandlistener implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if(commandLabel.equalsIgnoreCase("ema") || commandLabel.equalsIgnoreCase("easymobarmory")) {
			if(args.length == 0) {
				Usage(p);
			}else if(args.length == 1) {
				if(p.hasPermission("ema.use")) {
					if(args[0].equalsIgnoreCase("enable")) {EMAListener.Armoryenabled.put(p, true); Messenger.playermessage("EasyMobArmory enabled", p);}
					else if(args[0].equalsIgnoreCase("disable")) {EMAListener.Armoryenabled.put(p, false); Messenger.playermessage("EasyMobArmory disabled", p);}
					else{Usage(p);}
				}else{
					Messenger.playermessage("You do not have permission for this command", p);
				}
			}else if(args.length == 2) {
				if(p.hasPermission("ema.use")) {
					if(args[0].equalsIgnoreCase("setspawntick")) {SpawnerHandler.SetSpawnTick(p,args[1]);}
					else{Usage(p);}
				}else{
					Messenger.playermessage("You do not have permission for this command", p);
				}
			}else{
				Usage(p);
			}
		}
		return false;
	}
	private void Usage(Player p) {
		Messenger.playermessage("Usage: /EMA enable, /EMA disable, /EMA setspawntick <Seconds>", p);
	}
}
