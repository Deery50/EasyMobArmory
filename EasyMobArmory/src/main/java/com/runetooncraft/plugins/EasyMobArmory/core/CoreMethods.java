package com.runetooncraft.plugins.EasyMobArmory.core;

import org.bukkit.Location;

public class CoreMethods {

	public static Location CheckIfAirBlock(Location loc) {
		if(loc.getBlock().getTypeId() == 0) {
			return loc;
		}else{
			loc.setY(loc.getBlockY() + 1);
			return CheckIfAirBlock(loc);
		}
	}

}
