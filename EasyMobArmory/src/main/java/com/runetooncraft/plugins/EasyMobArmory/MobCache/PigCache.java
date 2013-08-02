package com.runetooncraft.plugins.EasyMobArmory.MobCache;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class PigCache {
	public Boolean isbaby = null;
	public Boolean saddled = null;
	public Boolean agelock = null;
	public PigCache(Boolean isbaby, Boolean saddled, Boolean agelock) {
		this.isbaby = isbaby;
		this.saddled = saddled;
		this.agelock = agelock;
	}
}
