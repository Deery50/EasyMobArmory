package com.runetooncraft.plugins.EasyMobArmory.egghandler;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import com.runetooncraft.plugins.EasyMobArmory.core.Messenger;

public class Eggs {
	private YamlConfiguration Eggs;
	private File EggsFile;
	
	public Eggs(File Eggsfile) {
		this.Eggs = new YamlConfiguration();
		this.EggsFile = Eggsfile;
	}
	public boolean load() {
		try {
			if (!EggsFile.exists()) {
				EggsFile.createNewFile();
				loaddefaults();
			}
			Eggs.load(EggsFile);
			return true;
		}
		catch (Exception e) {
			Messenger.severe("The Eggs data file did not load correctly, returned error:\n" + e.getMessage());
			return false;
		}
	}
	private void loaddefaults() {
		String[] eggslist = {};
		Eggs.addDefault("Eggs.List", Arrays.asList(eggslist));
		Eggs.options().copyDefaults(true);
		save();
	}
	public boolean save() {
		try {
			Eggs.save(EggsFile);
		} catch (Exception e) { 
			Messenger.severe("The Eggs data file failed to save, returned error:\n" + e.getMessage());
		}
		return true;
	}
	public YamlConfiguration GetConfig() {
		return Eggs;
	}
	public void addtolist(String path, String item) {
		List<String> l = Eggs.getStringList(path);
		l.add(item);
		Eggs.set(path, l);
		save();
	}
	public List<String> getList(String path) {
		return (List<String>) Eggs.getList(path);
	}
	public int getInt(String path) {
		return Eggs.getInt(path);
	}
	public Boolean getBoolean(String path) {
		return Eggs.getBoolean(path);
	}
	public String getString(String path) {
		return Eggs.getString(path);
	}
}
