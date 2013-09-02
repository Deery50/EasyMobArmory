package com.runetooncraft.plugins.EasyMobArmory.MobCache;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class ZombieCache {
	public ItemStack[] Equip = null;
	public ItemStack handitem = null;
	public Boolean isbaby = null;
	public Boolean isVillager = null;
	public ZombieCache(ItemStack[] equip, ItemStack handitem, Boolean isbaby, Boolean isVillager) {
		this.isbaby = isbaby;
		this.Equip = equip;
		this.handitem = handitem;
		this.isVillager = isVillager;
	}
}
