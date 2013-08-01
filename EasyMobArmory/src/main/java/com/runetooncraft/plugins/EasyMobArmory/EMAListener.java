package com.runetooncraft.plugins.EasyMobArmory;



import net.minecraft.server.v1_6_R2.TileEntityChest;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Config;
import com.runetooncraft.plugins.EasyMobArmory.core.InventorySerializer;

public class EMAListener implements Listener {
	Config config;
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
				TileEntityChest chest = new TileEntityChest();
				Inventory ZombieEquip = InventorySerializer.getArmorEntityInventory(z.getEquipment());
				p.openInventory(ZombieEquip);
//				for(ItemStack a: ZombieEquip) {
//					net.minecraft.server.v1_6_R2.ItemStack b = null;
//					b.setData(a.getTypeId());
//					count++;
//					chest.setItem(count, b);
//				}
			}else{
				z.getEquipment().setItemInHand(i);
			}
		}
	}
}
