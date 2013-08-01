package com.runetooncraft.plugins.EasyMobArmory.egghandler;

import net.minecraft.server.v1_6_R2.NBTTagCompound;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_6_R2.inventory.CraftItemStack;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EggHandler {
	public static ItemStack GetEggitem(Entity e,String name) {
		ItemStack egg = new ItemStack(Material.MONSTER_EGG, 1, (short) e.getEntityId());
		return renameItem(egg, name);
	}
	public static ItemStack renameItem(ItemStack is, String newName){
		  ItemMeta meta = is.getItemMeta();
		  meta.setDisplayName(newName);
		  is.setItemMeta(meta);
		  return is;
	}
}
