package com.runetooncraft.plugins.EasyMobArmory.MobCache;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class PigZombieCache {
	public ItemStack[] Equip = null;
	public ItemStack handitem = null;
	public Boolean isbaby = null;
	public PigZombieCache(ItemStack[] equip, ItemStack handitem, Boolean isbaby) {
		this.isbaby = isbaby;
		this.Equip = equip;
		this.handitem = handitem;
	}
}
