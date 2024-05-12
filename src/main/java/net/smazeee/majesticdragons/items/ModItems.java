package net.smazeee.majesticdragons.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smazeee.majesticdragons.MajesticDragons;
import net.smazeee.majesticdragons.items.custom.GloveItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MajesticDragons.MODID);

    public static final RegistryObject<Item> GLOVES = ITEMS.register("gloves", () -> new GloveItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
