package com.runetooncraft.plugins.EasyMobArmory.egghandler;

import java.util.HashMap;
import java.util.List;

import net.minecraft.server.v1_6_R2.NBTTagCompound;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.runetooncraft.plugins.EasyMobArmory.EMA;
import com.runetooncraft.plugins.EasyMobArmory.core.InventorySerializer;

public class EggHandler {
	public static Eggs eggs = EMA.eggs;
	public static HashMap<Integer, Entity> EntityEggIdList = new HashMap<Integer, Entity>();
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
	public static void addegg(Entity e) {
		YamlConfiguration eggsyml = eggs.GetConfig();
		if(eggsyml.getList("Eggs.List") != null) {
			if(!eggsyml.getList("Eggs.List").contains(Integer.toString(e.getEntityId()))) {
				eggs.addtolist("Eggs.List", Integer.toString(e.getEntityId()));
				eggsyml.set("Eggs.id." + e.getEntityId() + ".Type", e.getType().getTypeId());
				if(e.getType().equals(EntityType.ZOMBIE)) {
					Zombie z = (Zombie) e;
					eggsyml.set("Eggs.id." + e.getEntityId() + ".Armor", InventorySerializer.tobase64(InventorySerializer.getArmorEntityInventory(z.getEquipment())));
					Inventory HandItem = Bukkit.getServer().createInventory(null, InventoryType.PLAYER);
					HandItem.setItem(0, z.getEquipment().getItemInHand());
					eggsyml.set("Eggs.id." + e.getEntityId() + ".Hand", InventorySerializer.tobase64(HandItem));
					eggsyml.set("Eggs.id." + e.getEntityId() + ".isbaby", z.isBaby());
					eggs.save();
				}
			}else{
				//Egg already existent
			}
		}
	}
//	public static void loadEggs() {
//		YamlConfiguration eggsyml = eggs.GetConfig();
//		List<String> EggList = (List<String>) eggsyml.getList("Eggs.List");
//		for(String s: EggList) {
//			
//		}
//	}
}
