package xyz.magmabits.echomistfs.util;

import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import xyz.magmabits.echomistfs.Echomistfs;
import xyz.magmabits.echomistfs.item.ModItems;

import java.util.Map;

public class SylviteTrimMaterial {
    public static final RegistryKey<ArmorTrimMaterial> SYLVITE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(Echomistfs.MOD_ID, "sylvite"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, SYLVITE, Registries.ITEM.getEntry(ModItems.SYLVITE_SHARD), Style.EMPTY.withColor(TextColor.parse("#5a5ea2").getOrThrow()), 1.0f);
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimMaterialKey, RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimMaterialKey.getValue().getPath(), item, itemModelIndex, Map.of(), Text.translatable(Util.createTranslationKey("trim_material", armorTrimMaterialKey.getValue())).fillStyle(style));

        registerable.register(armorTrimMaterialKey, trimMaterial);
    }
}
