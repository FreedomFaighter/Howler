package com.skylarostler.howler;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Howler extends JavaPlugin {
	final static String commandToAcceptForHowler = "howl";

	static public String getCommand()
	{
		return Howler.commandToAcceptForHowler;
	}

    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (cmd.getName().equalsIgnoreCase(Howler.getCommand())) { // If the player typed /howl then do the following...
    		if (!(sender instanceof Player)) {
    			sender.sendMessage("This command can only be run by a player.");
    		} else {
    			Player player = (Player) sender;
    			// Howl
    			player.getWorld().playSound(player.getLocation(), Sound.WOLF_HOWL, 10.0F, 1.0F);
    			this.getServer().broadcastMessage(ChatColor.GOLD + player.getDisplayName() + " howls up to the sky");
    		}
    		return true;
    	}
    	return false; 
    }
}