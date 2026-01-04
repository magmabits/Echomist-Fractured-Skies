package xyz.magmabits.echomistfs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import xyz.magmabits.echomistfs.blocks.ModBlocks;
import xyz.magmabits.echomistfs.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SMALL_SYLVITE_BUD, dropsWithSilkTouch(ModBlocks.SMALL_SYLVITE_BUD));
        addDrop(ModBlocks.MEDIUM_SYLVITE_BUD, dropsWithSilkTouch(ModBlocks.MEDIUM_SYLVITE_BUD));
        addDrop(ModBlocks.LARGE_SYLVITE_BUD, dropsWithSilkTouch(ModBlocks.LARGE_SYLVITE_BUD));
        addDrop(ModBlocks.SYLVITE_CLUSTER, sylviteClusterDrops(ModBlocks.SYLVITE_CLUSTER, ModItems.SYLVITE_SHARD));
        addDrop(ModBlocks.SYLVITE_BLOCK);
        addDrop(ModBlocks.SYLVITE_STAIRS);
        addDrop(ModBlocks.SYLVITE_SLAB, slabDrops(ModBlocks.SYLVITE_SLAB));
        addDrop(ModBlocks.SYLVITE_WALL);
        addDrop(ModBlocks.SYLVITE_BRICKS);
        addDrop(ModBlocks.SYLVITE_BRICK_STAIRS);
        addDrop(ModBlocks.SYLVITE_BRICK_SLAB, slabDrops(ModBlocks.SYLVITE_BRICK_SLAB));
        addDrop(ModBlocks.SYLVITE_BRICK_WALL);
        addDrop(ModBlocks.SYLVITE_TILES);
        addDrop(ModBlocks.SYLVITE_TILE_STAIRS);
        addDrop(ModBlocks.SYLVITE_TILE_SLAB, slabDrops(ModBlocks.SYLVITE_TILE_SLAB));
        addDrop(ModBlocks.SYLVITE_TILE_WALL);
        addDrop(ModBlocks.CHISELED_SYLVITE);
        addDrop(ModBlocks.SYLVITE_PILLAR);
    }

    public LootTable.Builder sylviteClusterDrops(Block block, Item item) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(block, this.applyExplosionDecay(block,
                (LeafEntry.Builder<?>)ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4.0f))))
                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 1)));
    }
}
