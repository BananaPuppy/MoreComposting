package net.bruhcraft.morecomposting;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "morecomposting";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	//public static final MyConfig CONFIG = MyConfig.createAndLoad();

	@Override
	public void onInitialize() {
		LOGGER.info("More Composting Initializing");
		registerCompost();
		LOGGER.info("More Composting Initialized");
	}

	public void registerCompost(){

	}
}