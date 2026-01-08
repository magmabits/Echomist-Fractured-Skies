package xyz.magmabits.echomistfs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import xyz.magmabits.echomistfs.blocks.ModBlocks;
import xyz.magmabits.echomistfs.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BLOCK, 1)
                .pattern("##")
                .pattern("##")
                .input('#', ModItems.SYLVITE_SHARD)
                .criterion("has_sylvite", conditionsFromItem(ModItems.SYLVITE_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILES, 4)
                .pattern("##")
                .pattern("##")
                .input('#', ModBlocks.SYLVITE_BRICKS)
                .criterion("has_sylvite_bricks", conditionsFromItem(ModBlocks.SYLVITE_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_PILLAR, 1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBlocks.SYLVITE_BRICKS)
                .criterion("has_sylvite_bricks", conditionsFromItem(ModBlocks.SYLVITE_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SYLVITE, 1)
                .pattern("#")
                .pattern("#")
                .input('#', ModBlocks.SYLVITE_BRICK_SLAB)
                .criterion("has_sylvite_brick_slab", conditionsFromItem(ModBlocks.SYLVITE_BRICK_SLAB))
                .offerTo(exporter);

        createStairsRecipe(ModBlocks.SYLVITE_STAIRS, Ingredient.ofItems(ModBlocks.SYLVITE_BLOCK))
                .criterion(hasItem(ModBlocks.SYLVITE_BLOCK), conditionsFromItem(ModBlocks.SYLVITE_BLOCK))
                .offerTo(exporter);
        createStairsRecipe(ModBlocks.SYLVITE_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.SYLVITE_BRICKS))
                .criterion(hasItem(ModBlocks.SYLVITE_BRICKS), conditionsFromItem(ModBlocks.SYLVITE_BRICKS))
                .offerTo(exporter);
        createStairsRecipe(ModBlocks.SYLVITE_TILE_STAIRS, Ingredient.ofItems(ModBlocks.SYLVITE_TILES))
                .criterion(hasItem(ModBlocks.SYLVITE_TILES), conditionsFromItem(ModBlocks.SYLVITE_TILES))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_SLAB, Ingredient.ofItems(ModBlocks.SYLVITE_BLOCK))
                .criterion(hasItem(ModBlocks.SYLVITE_BLOCK), conditionsFromItem(ModBlocks.SYLVITE_BLOCK))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICK_SLAB, Ingredient.ofItems(ModBlocks.SYLVITE_BRICKS))
                .criterion(hasItem(ModBlocks.SYLVITE_BRICKS), conditionsFromItem(ModBlocks.SYLVITE_BRICKS))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILE_SLAB, Ingredient.ofItems(ModBlocks.SYLVITE_TILES))
                .criterion(hasItem(ModBlocks.SYLVITE_TILES), conditionsFromItem(ModBlocks.SYLVITE_TILES))
                .offerTo(exporter);

        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_WALL, ModBlocks.SYLVITE_BLOCK);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICK_WALL, ModBlocks.SYLVITE_BRICKS);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILE_WALL, ModBlocks.SYLVITE_TILES);

        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_STAIRS, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_SLAB, ModBlocks.SYLVITE_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_WALL, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICKS, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICK_STAIRS, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICK_STAIRS, ModBlocks.SYLVITE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICK_SLAB, ModBlocks.SYLVITE_BLOCK, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICK_SLAB, ModBlocks.SYLVITE_BRICKS, 2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICK_WALL, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_BRICK_WALL, ModBlocks.SYLVITE_BRICKS);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILES, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILE_STAIRS, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILE_STAIRS, ModBlocks.SYLVITE_TILES);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILE_SLAB, ModBlocks.SYLVITE_BLOCK,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILE_SLAB, ModBlocks.SYLVITE_TILES,2);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILE_WALL, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_TILE_WALL, ModBlocks.SYLVITE_TILES);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SYLVITE, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_PILLAR, ModBlocks.SYLVITE_BLOCK);
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SYLVITE_PILLAR, ModBlocks.SYLVITE_BRICKS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SYLVITE_HALBERD, 1)
                .pattern(" ##")
                .pattern("sd#")
                .pattern("es ")
                .input('d', Items.DIAMOND_AXE)
                .input('s', Items.NETHERITE_SCRAP)
                .input('#', ModItems.SYLVITE_SHARD)
                .input('e', Items.ECHO_SHARD)
                .criterion("has_sylvite_shard", conditionsFromItem(ModItems.SYLVITE_SHARD))
                .criterion("has_netherite_scrap", conditionsFromItem(Items.NETHERITE_SCRAP))
                .criterion("has_diamond", conditionsFromItem(Items.DIAMOND))
                .criterion("has_echo_shard", conditionsFromItem(Items.ECHO_SHARD))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SYLVITE_TOKEN, 1)
                .pattern(" # ")
                .pattern("#a#")
                .pattern("g#g")
                .input('g', Items.GHAST_TEAR)
                .input('a', Items.GOLDEN_APPLE)
                .input('#', ModItems.SYLVITE_SHARD)
                .criterion("has_sylvite_shard", conditionsFromItem(ModItems.SYLVITE_SHARD))
                .criterion("has_ghast_tear", conditionsFromItem(Items.GHAST_TEAR))
                .criterion("has_golden_apple", conditionsFromItem(Items.GOLDEN_APPLE))
                .offerTo(exporter);
    }
}
