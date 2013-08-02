package com.runetooncraft.plugins.EasyMobArmory.MobCache;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class HorseCache {
	public Boolean isbaby = null;
	public Boolean agelock = null;
	public Boolean tamed = null;
	public Player tamer = null;
	public Boolean chest = null;
	public Variant variant = null;
	public Inventory horseinv = null;
	public Color color = null;
	public HorseCache(Boolean isbaby, Boolean agelock, Boolean tamed, Boolean chest, Variant variant, Inventory horseinv, Player horsetamer, Color color) {
		this.isbaby = isbaby;
		this.agelock = agelock;
		this.tamed = tamed;
		this.tamer = horsetamer;
		this.chest = chest;
		this.horseinv = horseinv;
		this.color = color;
	}
}
