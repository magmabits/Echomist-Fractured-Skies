package xyz.magmabits.echomistfs.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import xyz.magmabits.echomistfs.util.ModEffects;

import java.util.List;

public class SylviteToken extends Item {
    public SylviteToken(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            if (user.getItemCooldownManager().isCoolingDown(this)) {
                return TypedActionResult.fail(stack);
            }

            user.heal(2.0f);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 5, 1));

            user.getItemCooldownManager().set(this, 20 * 45);
            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }

        return TypedActionResult.success(stack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable("tooltip.echomist-fs.sylvite_token.ability"));
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("item.echomist-fs.sylvite_token").setStyle(Style.EMPTY.withColor(0x817fc9));
    }
}
