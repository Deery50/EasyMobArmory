package com.runetooncraft.plugins.EasyMobArmory.MobCache;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class SheepCache {
	public Boolean isbaby = null;
	public Boolean sheared = null;
	public SheepCache(Boolean isbaby, Boolean sheared) {
		this.isbaby = isbaby;
		this.sheared = sheared;
	}
}
