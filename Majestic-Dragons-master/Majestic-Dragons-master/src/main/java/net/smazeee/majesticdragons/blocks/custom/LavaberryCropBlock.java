package net.smazeee.majesticdragons.blocks.custom;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.smazeee.majesticdragons.blocks.ModBlocks;
import net.smazeee.majesticdragons.items.ModItems;

public class LavaberryCropBlock extends CropBlock {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;

    public LavaberryCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike  getBaseSeedId() {
        return ModItems.LAVABERRY_SEEDS.get();
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return 6;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public void randomTick(BlockState state, Level world, BlockPos pos, Random random) {
        if (!world.isClientSide) {
            if (world.getBrightness(LightLayer.BLOCK, pos) >= 8) {
                int age = state.getValue(AGE);
                if (age < this.getMaxAge()) {
                    if (random.nextFloat() < 0.5f) { // Adjust growth rate as needed
                        world.setBlockAndUpdate(pos, state.setValue(AGE, age + 1));
                    }
                } else {

                    spawnFruit((ServerLevel) world, pos);
                }
            }
        }
    }

    private void spawnFruit(ServerLevel world, BlockPos pos) {
        // Check adjacent blocks and replace with fruit block if suitable
        for (Direction direction : Direction.values()) {
            if (direction.getAxis().isHorizontal()) {
                BlockPos fruitPos = pos.relative(direction);
                if (world.isEmptyBlock(fruitPos)) {
                    world.setBlock(fruitPos, ModBlocks.LAVABERRY_BLOCK.get().defaultBlockState(), 2);
                    return;
                }
            }
        }
    }


