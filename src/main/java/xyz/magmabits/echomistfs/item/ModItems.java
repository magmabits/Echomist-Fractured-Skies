package xyz.magmabits.echomistfs.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.magmabits.echomistfs.Echomistfs;

public class ModItems {
    public static final Item SYLVITE_SHARD = registerItem("sylvite_shard", new Item(new Item.Settings()));
    public static final Item SYLVITE_HALBERD = registerItem("sylvite_halberd",
            new SylviteHalberd(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(SylviteHalberd.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.6f))));
    public static final Item SYLVITE_TOKEN = registerItem("sylvite_token", new SylviteToken(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Echomistfs.MOD_ID, name), item);
    }
    public static void registerModItems() {
    }
}
