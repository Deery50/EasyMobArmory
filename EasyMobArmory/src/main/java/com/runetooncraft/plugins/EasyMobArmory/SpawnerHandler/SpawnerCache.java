package com.runetooncraft.plugins.EasyMobArmory.SpawnerHandler;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SpawnerCache {
	Block SpawnerBlock = null;
	Location SpawnerLocation = null;
	Inventory SpawnerInventory = null;
	ItemStack[] Eggs = null;
	public SpawnerCache(Block SpawnerBlock, Location SpawnerLocation, Inventory SpawnerInventory) {
		this.SpawnerBlock = SpawnerBlock;
		this.SpawnerLocation = SpawnerLocation;
		this.SpawnerInventory = SpawnerInventory;
		this.Eggs = SpawnerInventory.getContents();
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
	public ItemStack[] getEggs() {
		return Eggs;
	}
}
