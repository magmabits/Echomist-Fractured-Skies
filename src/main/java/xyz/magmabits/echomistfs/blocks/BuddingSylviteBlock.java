package xyz.magmabits.echomistfs.blocks;

import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public class BuddingSylviteBlock extends SylviteBlock {
    public BuddingSylviteBlock(Settings settings) {
        super(settings);
    }

    public static final int GROW_CHANCE = 3;
    private static final Direction[] DIRECTIONS = Direction.values();

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockState below = world.getBlockState(pos.down());
        if (below.getBlock() != Blocks.SCULK_CATALYST) {
            return;
        }

        if (random.nextInt(GROW_CHANCE) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;

            if (canGrowIn(blockState)) {
                block = ModBlocks.SMALL_SYLVITE_BUD;
            } else if (blockState.isOf(ModBlocks.SMALL_SYLVITE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction)  {
                block = ModBlocks.MEDIUM_SYLVITE_BUD;
            } else if (blockState.isOf(ModBlocks.MEDIUM_SYLVITE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction)  {
                block = ModBlocks.LARGE_SYLVITE_BUD;
            } else if (blockState.isOf(ModBlocks.LARGE_SYLVITE_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction)  {
                block = ModBlocks.SYLVITE_CLUSTER;
            }

            Vec3d center = Vec3d.ofCenter(pos);
            world.spawnParticles(ParticleTypes.END_ROD, center.x, center.y, center.z, 16, 0.3, 0.3, 0.3, 0.01);
            world.playSound(null, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, SoundCategory.BLOCKS, 1.0F, 0.5F + random.nextFloat() * 0.4F);

            if (block != null) {
                BlockState blockState2 = block.getDefaultState()
                        .with(AmethystClusterBlock.FACING, direction)
                        .with(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
                world.setBlockState(blockPos, blockState2);
            }
        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}
