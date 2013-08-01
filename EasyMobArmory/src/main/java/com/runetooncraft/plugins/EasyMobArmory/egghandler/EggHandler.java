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

import com.bergerkiller.bukkit.common.entity.CommonEntity;
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
	public static List<String> GetEggList() {
		YamlConfiguration eggsyml = eggs.GetConfig();
		return (List<String>) eggsyml.getList("Eggs.List");
	}
	public static Entity Loadentity(String id) {
		YamlConfiguration eggsyml = eggs.GetConfig();
		int Entityid = eggsyml.getInt("Eggs.id." + id + ".Type");
		CommonEntity entity = CommonEntity.create(EntityType.fromId(Entityid));
		Zombie z = (Zombie) entity;
		z.getEquipment().setArmorContents(InventorySerializer.frombase64(eggsyml.getString("Eggs.id." + id + ".Armor")).getContents());
		z.getEquipment().setItemInHand(InventorySerializer.frombase64(eggsyml.getString("eggs.id" + id + ".Hand")).getItem(0));
		z.setBaby(eggsyml.getBoolean("Eggs.id." + id + ".isbaby"));
		return z;
	}
}
