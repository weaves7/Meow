package com.weaves.meow;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Meow extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");

		logger.info(pdfFile.getName() + " has been enabled " + pdfFile.getVersion() + ")");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");

		logger.info(pdfFile.getName() + " has been disabled " + pdfFile.getVersion() + ")");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// <---what is the blue bar over there? Oh duh lol
		if (cmd.getName().equalsIgnoreCase("meow") && sender instanceof Player) {

			// This code WORKS! But the Entity seems fishy lol.
			Location location = ((Entity) sender).getLocation();
			String playername = sender.getName();
			
			Bukkit.getPlayer(playername).sendMessage(ChatColor.GREEN + "Server says, " + ChatColor.BLUE + "\"Meow\"" + ChatColor.GREEN + "!"  );
//		    Bukkit.getPlayer(playername).chat(ChatColor.GREEN + "Server says, " + ChatColor.BLUE + "Meow" + ChatColor.GREEN + "!"  );
			Bukkit.getPlayer(playername).getWorld().playSound(location, Sound.ENTITY_CAT_AMBIENT, 1.0f, 0.75f);

		}
		return true;
	}

}
