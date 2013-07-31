package com.runetooncraft.plugins.EasyMobArmory;



import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import com.runetooncraft.plugins.EasyMobArmory.core.Config;

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
			}
		}
	}
}
