package com.runetooncraft.plugins.EasyMobArmory.MobCache;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class SkeletonCache {
	public ItemStack[] Equip = null;
	public ItemStack handitem = null;
	public SkeletonCache(ItemStack[] equip, ItemStack handitem) {
		this.Equip = equip;
		this.handitem = handitem;
	}
}
