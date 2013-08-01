package com.runetooncraft.plugins.EasyMobArmory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.runetooncraft.plugins.EasyMobArmory.core.Config;

public class EMA extends JavaPlugin {
	public static Config config = null;
	public static List<ItemStack> Helmets = new ArrayList<ItemStack>();
	public static List<ItemStack> Chestplates = new ArrayList<ItemStack>();
	public static List<ItemStack> Leggings = new ArrayList<ItemStack>();
	public static List<ItemStack> Boots = new ArrayList<ItemStack>();
	public void onEnable() {
		loadconfig();
		getServer().getPluginManager().registerEvents(new EMAListener(config), this);
		getCommand("EasyMobArmory").setExecutor(new Commandlistener());
		SetItemStacks();
	}

	private void SetItemStacks() {
		List<Integer> helmetints = config.getConfig().getIntegerList("List.Helmets");
		List<Integer> chestplateints = config.getConfig().getIntegerList("List.Chestplates");
		List<Integer> leggingints = config.getConfig().getIntegerList("List.Leggings");
		List<Integer> Bootints = config.getConfig().getIntegerList("List.Boots");
		for(int i : helmetints) {
			Helmets.add(new ItemStack(Material.getMaterial(i)));
		}
		for(int i : chestplateints) {
			Chestplates.add(new ItemStack(Material.getMaterial(i)));
		}
		for(int i : leggingints) {
			Leggings.add(new ItemStack(Material.getMaterial(i)));
		}
		for(int i : Bootints) {
			Boots.add(new ItemStack(Material.getMaterial(i)));
		}
	}

	private void loadconfig() {
		File dir = this.getDataFolder();
		if (!dir.exists()) dir.mkdir();
		File file = new File(this.getDataFolder(), "config.yml");
		config = new Config(file);
		if (!config.load()) {
			this.getServer().getPluginManager().disablePlugin(this);
			throw new IllegalStateException("The config-file was not loaded correctly!");
		}
	}
}
