package net.bruhcraft.morecomposting;

import net.fabricmc.api.ModInitializer;

import net.bruhcraft.morecomposting.MyConfig;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MainClass implements ModInitializer {
	public static final String MOD_ID = "morecomposting";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final MyConfig CONFIG = MyConfig.createAndLoad();

	@Override
	public void onInitialize() {
		LOGGER.info("More Composting Initializing");
		registerCompost();
		LOGGER.info("More Composting Initialized");
	}

	public void registerCompost() {
		CompostingChanceRegistry registry = CompostingChanceRegistry.INSTANCE;
		List<String> toCompost = CONFIG.CompostItems();

		for(String input : toCompost) {
			boolean add = input.charAt(0) != '-';
			String namespace;
			String path;
			if (add) {
				namespace = input.substring(0, input.indexOf(":"));
				path = input.substring(input.indexOf(":") + 1, input.indexOf(" "));
			} else {
				namespace = input.substring(1, input.indexOf(":"));
				path = input.substring(input.indexOf(":") + 1);
			}

			Item item = Registries.ITEM.get(new Identifier(namespace, path));
			if (add) {
				float chance = Float.parseFloat(input.substring(input.indexOf(" ") + 1, input.indexOf("%"))) / 100.0F;
				if (registry.get(item) != null) {
					registry.remove(item);
				}

				registry.add(item, chance);
			} else {
				registry.remove(item);
			}
		}

	}
}