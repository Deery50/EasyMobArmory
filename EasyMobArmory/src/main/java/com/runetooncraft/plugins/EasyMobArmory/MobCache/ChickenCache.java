package com.runetooncraft.plugins.EasyMobArmory.MobCache;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class ChickenCache {
	public Boolean isbaby = null;
	public Boolean agelock = null;
	public ChickenCache(Boolean isbaby, Boolean agelock) {
		this.isbaby = isbaby;
		this.agelock = agelock;
	}
}
