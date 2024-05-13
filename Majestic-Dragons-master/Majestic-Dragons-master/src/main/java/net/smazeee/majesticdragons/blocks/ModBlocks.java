package net.smazeee.majesticdragons.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smazeee.majesticdragons.MajesticDragons;
import net.smazeee.majesticdragons.blocks.custom.LavaberryCropBlock;
import net.smazeee.majesticdragons.items.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MajesticDragons.MODID);

    public static final RegistryObject<Block> LAVABERRY_CROP = BLOCKS.register("Lavaberry_crop",
            () -> new LavaberryCropBlock(BlockBehaviour.Properties.copy(Blocks.PUMPKIN_STEM).noOcclusion().noCollission()));

    public static final RegistryObject<Block> LAVABERRY_BLOCK = BLOCKS.register("Lavaberry",
            () -> new LavaberryCropBlock(BlockBehaviour.Properties.copy(Blocks.PUMPKIN).noOcclusion().noCollission()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
