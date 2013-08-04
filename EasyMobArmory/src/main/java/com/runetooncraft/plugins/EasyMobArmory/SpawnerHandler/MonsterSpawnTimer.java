package com.runetooncraft.plugins.EasyMobArmory.SpawnerHandler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_6_R2.inventory.CraftInventory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.runetooncraft.plugins.EasyMobArmory.egghandler.EggHandler;

public class MonsterSpawnTimer extends BukkitRunnable {
	SpawnerCache sc = null;
	public MonsterSpawnTimer(SpawnerCache sc) {
		this.sc = sc;
	}
	@Override
	public void run() {
		Inventory RunningInv = sc.getInventory();
		RunningInv.clear();
		RunningInv.setContents(sc.getEggs());
		int EggInt = sc.getEggs().length;
		EggInt++;
		if(RunningInv.contains(Material.MONSTER_EGG)) {
			int RandomInt = (int) Math.random() * EggInt;
			ItemStack is = RunningInv.getItem(RandomInt);
			EggHandler.Loadentity(EggHandler.getEggID(is), sc.RandomSpawnLocation());
		}
	}

}
