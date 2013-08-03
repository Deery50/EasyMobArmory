package com.runetooncraft.plugins.EasyMobArmory.SpawnerHandler;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;

public class SpawnerCache {
	Block SpawnerBlock = null;
	Location SpawnerLocation = null;
	Inventory SpawnerInventory = null;
	public SpawnerCache(Block SpawnerBlock, Location SpawnerLocation, Inventory SpawnerInventory) {
		this.SpawnerBlock = SpawnerBlock;
		this.SpawnerLocation = SpawnerLocation;
		this.SpawnerInventory = SpawnerInventory;
	}
	public Block getBlock() {
		return SpawnerBlock;
	}
	public Location getLocation() {
		return SpawnerLocation;
	}
	public Inventory getInventory() {
		return SpawnerInventory;
	}
}
