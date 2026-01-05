package xyz.magmabits.echomistfs.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import xyz.magmabits.echomistfs.Echomistfs;
import xyz.magmabits.echomistfs.util.SylviteToolMaterial;

public class ModItems {
    public static final Item SYLVITE_SHARD = registerItem("sylvite_shard", new Item(new Item.Settings()));
    public static final Item SYLVITE_HALBERD = registerItem("sylvite_halberd",
            new SylviteHalberd(SylviteToolMaterial.SYLVITE, new Item.Settings()
                    .attributeModifiers(SylviteHalberd.createAttributeModifiers(SylviteToolMaterial.SYLVITE, 5, -2.8f))));
    public static final Item SYLVITE_TOKEN = registerItem("sylvite_token", new SylviteToken(new Item.Settings().maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Echomistfs.MOD_ID, name), item);
    }
    public static void registerModItems() {
    }
}
