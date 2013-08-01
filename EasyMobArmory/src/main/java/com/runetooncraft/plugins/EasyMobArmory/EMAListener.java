package com.runetooncraft.plugins.EasyMobArmory;



import java.util.HashMap;

import net.minecraft.server.v1_6_R2.TileEntityChest;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_6_R2.inventory.CraftInventory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Config;
import com.runetooncraft.plugins.EasyMobArmory.core.InventorySerializer;


public class EMAListener implements Listener {
	Config config;
	public static HashMap<Player, Zombie> PlayerZombieDataMap = new HashMap<Player, Zombie>();
	public EMAListener(Config config) {
		this.config = config;
	}
	@EventHandler
	public void OnPlayerEntityInteract(PlayerInteractEntityEvent event) {
		Entity e = event.getRightClicked();
		Player p = event.getPlayer();
		if(e.getType().equals(EntityType.ZOMBIE)) {
			ItemStack i = p.getItemInHand();
			Zombie z = (Zombie) e;
			if(EMA.Helmets.contains(i)) {
				z.getEquipment().setHelmet(i);
			}else if(EMA.Chestplates.contains(i)) {
				z.getEquipment().setChestplate(i);
			}else if(EMA.Leggings.contains(i)) {
				z.getEquipment().setLeggings(i);
			}else if(EMA.Boots.contains(i)) {
				z.getEquipment().setBoots(i);
			}else if(i.getType().equals(Material.BONE)){
				Inventory inv = Bukkit.createInventory(p, 9, "zombieinv");
				ItemStack[] zombieinv = z.getEquipment().getArmorContents();
				inv.setContents(zombieinv);
				inv.addItem(z.getEquipment().getItemInHand());
				p.openInventory(inv);
				PlayerZombieDataMap.put(p, z);
			}else{
				z.getEquipment().setItemInHand(i);
			}
		}
	}
	@EventHandler
	public void OnInventoryCloseEvent(InventoryCloseEvent event) {
		if(event.getInventory().getName().equals("zombieinv")) {
			Inventory i = event.getInventory();
			Zombie z = PlayerZombieDataMap.get(event.getPlayer());
			z.getEquipment().setHelmet(i.getItem(0));
			z.getEquipment().setChestplate(i.getItem(1));
			z.getEquipment().setLeggings(i.getItem(2));
			z.getEquipment().setBoots(i.getItem(3));
			z.getEquipment().setItemInHand(i.getItem(4));
		}
	}
}
