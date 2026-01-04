package xyz.magmabits.echomistfs.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import xyz.magmabits.echomistfs.Echomistfs;
import xyz.magmabits.echomistfs.EchomistfsDataGenerator;
import xyz.magmabits.echomistfs.blocks.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup FS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Echomistfs.MOD_ID, "fs_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.SYLVITE_BLOCK))
                    .displayName(Text.translatable("itemgroup.echomist-fs.fs_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SYLVITE_SHARD);
                        entries.add(ModItems.SYLVITE_HALBERD);
                        entries.add(ModItems.SYLVITE_TOKEN);

                        entries.add(ModBlocks.BUDDING_SYLVITE);
                        entries.add(ModBlocks.SMALL_SYLVITE_BUD);
                        entries.add(ModBlocks.MEDIUM_SYLVITE_BUD);
                        entries.add(ModBlocks.LARGE_SYLVITE_BUD);
                        entries.add(ModBlocks.SYLVITE_CLUSTER);

                        entries.add(ModBlocks.SYLVITE_BLOCK);
                        entries.add(ModBlocks.SYLVITE_STAIRS);
                        entries.add(ModBlocks.SYLVITE_SLAB);
                        entries.add(ModBlocks.SYLVITE_WALL);

                        entries.add(ModBlocks.SYLVITE_BRICKS);
                        entries.add(ModBlocks.SYLVITE_BRICK_STAIRS);
                        entries.add(ModBlocks.SYLVITE_BRICK_SLAB);
                        entries.add(ModBlocks.SYLVITE_BRICK_WALL);

                        entries.add(ModBlocks.SYLVITE_TILES);
                        entries.add(ModBlocks.SYLVITE_TILE_STAIRS);
                        entries.add(ModBlocks.SYLVITE_TILE_SLAB);
                        entries.add(ModBlocks.SYLVITE_TILE_WALL);

                        entries.add(ModBlocks.CHISELED_SYLVITE);

                        entries.add(ModBlocks.SYLVITE_PILLAR.asItem());
                    })
                    .build());

    public static void registerItemGroups() {

    }
}
