package xyz.magmabits.echomistfs;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.magmabits.echomistfs.blocks.ModBlocks;
import xyz.magmabits.echomistfs.item.ModItemGroups;
import xyz.magmabits.echomistfs.item.ModItems;
import xyz.magmabits.echomistfs.util.ModEffects;

public class Echomistfs implements ModInitializer {
	public static final String MOD_ID = "echomist-fs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModEffects.registerEffects();
	}
}