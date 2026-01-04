package xyz.magmabits.echomistfs.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import xyz.magmabits.echomistfs.util.ModEffects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @ModifyArg(method = "heal(F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setHealth(F)V"), index = 0)
    private float reduceHealing(float amount) {
        if((Object) this instanceof LivingEntity livingEntity && livingEntity.hasStatusEffect(ModEffects.AFFLICTED)) {
            return amount * 0.5f;
        }
        return amount;
    }
}
