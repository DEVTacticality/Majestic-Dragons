package net.smazeee.majesticdragons.blocks.custom;

import net.minecraft.
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.antlr.v4.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;



public class LavaberryBlock extends Block {
    public LavaberryBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    // Override the method to define behavior when the block is harvested
    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        // Check if the block was harvested without Silk Touch
        ItemStack heldItem = player.getMainHandItem();
        if (!player.isCreative() && !hasSilkTouchEnchantment(heldItem)) {
            // If so, spawn a lava source block at the same position
            world.setBlockAndUpdate(pos, Blocks.LAVA.defaultBlockState()); // Set the lava block
        } else {
            // If Silk Touch was used or the player is in creative mode, drop the block as usual
            boolean b = super.onDestroyedByPlayer(world, pos, state, player);
        }
    }

    // Helper method to check if the held item has Silk Touch enchantment
    private boolean hasSilkTouchEnchantment(ItemStack itemStack) {
        return EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, itemStack) > 0;
    }
}