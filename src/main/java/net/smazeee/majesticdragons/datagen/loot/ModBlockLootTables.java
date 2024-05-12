package net.smazeee.majesticdragons.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.smazeee.majesticdragons.blocks.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    private void drop(RegistryObject<Block> block) {
        this.dropSelf(block.get());
    }

    private void dropOre(RegistryObject<Block> block, RegistryObject<Item> item) {
        this.add(block.get(), block1 -> createOreDrop(block.get(), item.get()));
    }

    @Override
    protected void generate() {
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
