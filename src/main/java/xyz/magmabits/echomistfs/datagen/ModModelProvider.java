package xyz.magmabits.echomistfs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import xyz.magmabits.echomistfs.blocks.ModBlocks;
import xyz.magmabits.echomistfs.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYLVITE_BLOCK)
                .stairs(ModBlocks.SYLVITE_STAIRS)
                .slab(ModBlocks.SYLVITE_SLAB)
                .wall(ModBlocks.SYLVITE_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYLVITE_BRICKS)
                .stairs(ModBlocks.SYLVITE_BRICK_STAIRS)
                .slab(ModBlocks.SYLVITE_BRICK_SLAB)
                .wall(ModBlocks.SYLVITE_BRICK_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SYLVITE_TILES)
                .stairs(ModBlocks.SYLVITE_TILE_STAIRS)
                .slab(ModBlocks.SYLVITE_TILE_SLAB)
                .wall(ModBlocks.SYLVITE_TILE_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SYLVITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_SYLVITE);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_SYLVITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_SYLVITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_SYLVITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SYLVITE_CLUSTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SYLVITE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SYLVITE_TOKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SYLVITE_HALBERD, Models.HANDHELD_MACE);
    }
}
