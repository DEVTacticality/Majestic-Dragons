package net.smazeee.majesticdragons.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.smazeee.majesticdragons.blocks.ModBlocks;
import net.smazeee.majesticdragons.blocks.custom.LavaberryCropBlock;
import net.smazeee.majesticdragons.items.ModItems;

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

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LAVABERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LavaberryCropBlock.AGE, 4));

        this.add(ModBlocks.LAVABERRY_CROP.get(), createCropDrops(ModBlocks.LAVABERRY_CROP.get(), ModItems.LAVABERRY.get(),
                ModItems.LAVABERRY_SEEDS.get(), lootitemcondition$builder));
    }

    @Override
    protected void generate() {
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
