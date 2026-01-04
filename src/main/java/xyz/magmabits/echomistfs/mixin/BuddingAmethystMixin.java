package xyz.magmabits.echomistfs.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BuddingAmethystBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.magmabits.echomistfs.blocks.ModBlocks;


@Mixin(BuddingAmethystBlock.class)
public class BuddingAmethystMixin {
    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void handleSylviteTransformation(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        BlockState below = world.getBlockState(pos.down());

        if (below.getBlock() == Blocks.SCULK_CATALYST) {
            if (random.nextInt(4) == 0) {
                world.setBlockState(pos, ModBlocks.BUDDING_SYLVITE.getDefaultState());

                Vec3d center = Vec3d.ofCenter(pos);
                world.spawnParticles(ParticleTypes.END_ROD, center.x, center.y, center.z, 16, 0.3, 0.3, 0.3, 0.01);
                world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS, 1.0F, 0.5F + random.nextFloat() * 0.4F);
            }

            ci.cancel();
        }
    }
}
