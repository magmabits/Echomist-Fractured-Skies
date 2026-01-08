package xyz.magmabits.echomistfs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import xyz.magmabits.echomistfs.blocks.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BUDDING_SYLVITE)
                .add(ModBlocks.SMALL_SYLVITE_BUD)
                .add(ModBlocks.MEDIUM_SYLVITE_BUD)
                .add(ModBlocks.LARGE_SYLVITE_BUD)
                .add(ModBlocks.SYLVITE_CLUSTER)
                .add(ModBlocks.SYLVITE_BLOCK)
                .add(ModBlocks.SYLVITE_STAIRS)
                .add(ModBlocks.SYLVITE_SLAB)
                .add(ModBlocks.SYLVITE_WALL)
                .add(ModBlocks.SYLVITE_BRICKS)
                .add(ModBlocks.SYLVITE_BRICK_STAIRS)
                .add(ModBlocks.SYLVITE_BRICK_SLAB)
                .add(ModBlocks.SYLVITE_BRICK_WALL)
                .add(ModBlocks.SYLVITE_TILES)
                .add(ModBlocks.SYLVITE_TILE_STAIRS)
                .add(ModBlocks.SYLVITE_TILE_SLAB)
                .add(ModBlocks.SYLVITE_TILE_WALL)
                .add(ModBlocks.CHISELED_SYLVITE)
                .add(ModBlocks.SYLVITE_PILLAR);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BUDDING_SYLVITE)
                .add(ModBlocks.SMALL_SYLVITE_BUD)
                .add(ModBlocks.MEDIUM_SYLVITE_BUD)
                .add(ModBlocks.LARGE_SYLVITE_BUD)
                .add(ModBlocks.SYLVITE_CLUSTER)
                .add(ModBlocks.SYLVITE_BLOCK)
                .add(ModBlocks.SYLVITE_STAIRS)
                .add(ModBlocks.SYLVITE_SLAB)
                .add(ModBlocks.SYLVITE_WALL)
                .add(ModBlocks.SYLVITE_BRICKS)
                .add(ModBlocks.SYLVITE_BRICK_STAIRS)
                .add(ModBlocks.SYLVITE_BRICK_SLAB)
                .add(ModBlocks.SYLVITE_BRICK_WALL)
                .add(ModBlocks.SYLVITE_TILES)
                .add(ModBlocks.SYLVITE_TILE_STAIRS)
                .add(ModBlocks.SYLVITE_TILE_SLAB)
                .add(ModBlocks.SYLVITE_TILE_WALL)
                .add(ModBlocks.CHISELED_SYLVITE)
                .add(ModBlocks.SYLVITE_PILLAR);

        getOrCreateTagBuilder(BlockTags.CRYSTAL_SOUND_BLOCKS)
                .add(ModBlocks.BUDDING_SYLVITE)
                .add(ModBlocks.SMALL_SYLVITE_BUD)
                .add(ModBlocks.MEDIUM_SYLVITE_BUD)
                .add(ModBlocks.LARGE_SYLVITE_BUD)
                .add(ModBlocks.SYLVITE_CLUSTER)
                .add(ModBlocks.SYLVITE_BLOCK)
                .add(ModBlocks.SYLVITE_STAIRS)
                .add(ModBlocks.SYLVITE_SLAB)
                .add(ModBlocks.SYLVITE_WALL)
                .add(ModBlocks.SYLVITE_BRICKS)
                .add(ModBlocks.SYLVITE_BRICK_STAIRS)
                .add(ModBlocks.SYLVITE_BRICK_SLAB)
                .add(ModBlocks.SYLVITE_BRICK_WALL)
                .add(ModBlocks.SYLVITE_TILES)
                .add(ModBlocks.SYLVITE_TILE_STAIRS)
                .add(ModBlocks.SYLVITE_TILE_SLAB)
                .add(ModBlocks.SYLVITE_TILE_WALL)
                .add(ModBlocks.CHISELED_SYLVITE)
                .add(ModBlocks.SYLVITE_PILLAR);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.SYLVITE_STAIRS)
                .add(ModBlocks.SYLVITE_BRICK_STAIRS)
                .add(ModBlocks.SYLVITE_TILE_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.SYLVITE_SLAB)
                .add(ModBlocks.SYLVITE_BRICK_SLAB)
                .add(ModBlocks.SYLVITE_TILE_SLAB);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SYLVITE_WALL)
                .add(ModBlocks.SYLVITE_BRICK_WALL)
                .add(ModBlocks.SYLVITE_TILE_WALL);

    }
}
