package com.runetooncraft.plugins.EasyMobArmory.MobCache;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class PigCache {
	public Boolean isbaby = null;
	public Boolean saddled = null;
	public PigCache(Boolean isbaby, Boolean saddled) {
		this.isbaby = isbaby;
		this.saddled = saddled;
	}
}
