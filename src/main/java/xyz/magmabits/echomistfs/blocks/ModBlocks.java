package xyz.magmabits.echomistfs.blocks;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import xyz.magmabits.echomistfs.Echomistfs;

public class ModBlocks {
    public static final Block SYLVITE_BLOCK = registerBlock("sylvite_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_STAIRS = registerBlock("sylvite_stairs",
            new StairsBlock(ModBlocks.SYLVITE_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_SLAB = registerBlock("sylvite_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_WALL = registerBlock("sylvite_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block SYLVITE_BRICKS = registerBlock("sylvite_bricks",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_BRICK_STAIRS = registerBlock("sylvite_brick_stairs",
            new StairsBlock(ModBlocks.SYLVITE_BRICKS.getDefaultState(), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_BRICK_SLAB = registerBlock("sylvite_brick_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_BRICK_WALL = registerBlock("sylvite_brick_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block SYLVITE_TILES = registerBlock("sylvite_tiles",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_TILE_STAIRS = registerBlock("sylvite_tile_stairs",
            new StairsBlock(ModBlocks.SYLVITE_TILES.getDefaultState(), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_TILE_SLAB = registerBlock("sylvite_tile_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block SYLVITE_TILE_WALL = registerBlock("sylvite_tile_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block CHISELED_SYLVITE = registerBlock("chiseled_sylvite",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block SYLVITE_PILLAR = registerBlock("sylvite_pillar",
            new PillarBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block BUDDING_SYLVITE = registerBlock("budding_sylvite",
            new BuddingSylviteBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block SYLVITE_CLUSTER = registerBlock("sylvite_cluster",
            new SylviteClusterBlock(7,3, AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .strength(1.5f)
                    .solid()
                    .nonOpaque()
                    .luminance(state -> 5)
                    .ticksRandomly()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block LARGE_SYLVITE_BUD = registerBlock("large_sylvite_bud",
            new SylviteClusterBlock(5,3, AbstractBlock.Settings.copy(SYLVITE_CLUSTER)
                    .luminance(state -> 4)));

    public static final Block MEDIUM_SYLVITE_BUD = registerBlock("medium_sylvite_bud",
            new SylviteClusterBlock(4,3, AbstractBlock.Settings.copy(SYLVITE_CLUSTER)
                    .luminance(state -> 4)));

    public static final Block SMALL_SYLVITE_BUD = registerBlock("small_sylvite_bud",
            new SylviteClusterBlock(3,4, AbstractBlock.Settings.copy(SYLVITE_CLUSTER)
                    .luminance(state -> 3)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Echomistfs.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Echomistfs.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        // ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {});
    }
}
