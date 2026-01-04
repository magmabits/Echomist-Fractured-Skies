package xyz.magmabits.echomistfs.item;

import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import xyz.magmabits.echomistfs.util.ModEffects;

import java.util.List;

public class SylviteHalberd extends AxeItem {
    public SylviteHalberd(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(!(attacker instanceof PlayerEntity) || ((PlayerEntity) attacker).getItemCooldownManager().isCoolingDown(this)) return false;

        PlayerEntity player = (PlayerEntity) attacker;
        target.addStatusEffect(new StatusEffectInstance(ModEffects.AFFLICTED, 20 * 20, 1), attacker);
        player.getItemCooldownManager().set(this, 20 * 40);
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("tooltip.echomist-fs.sylvite_halberd.ability"));
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("item.echomist-fs.sylvite_halberd").setStyle(Style.EMPTY.withColor(0x817fc9));
    }

    
}
