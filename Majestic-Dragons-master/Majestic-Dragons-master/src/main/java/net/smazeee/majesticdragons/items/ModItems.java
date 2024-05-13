package net.smazeee.majesticdragons.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smazeee.majesticdragons.MajesticDragons;
import net.smazeee.majesticdragons.blocks.ModBlocks;
import net.smazeee.majesticdragons.items.custom.GloveItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MajesticDragons.MODID);

    public static final RegistryObject<Item> GLOVES = ITEMS.register("gloves", () -> new GloveItem(new Item.Properties()));

    public static final RegistryObject<Item> LAVABERRY_SEEDS = ITEMS.register("Lavaberry seeds", () -> new ItemNameBlockItem(ModBlocks.LAVABERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> LAVABERRY = ITEMS.register("Lavaberry", () -> new Item(new Item.Properties())

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
