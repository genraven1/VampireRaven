package com.genraven1.vampire_raven.data.loot.tables;

import com.genraven1.vampire_raven.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;

import java.util.List;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        super.addTables();
        ModBlocks.getMushroomBlocks().forEach(this::dropSelf);
        ModBlocks.getMushroomPotBlocks().forEach(this::dropSelf);
        ModBlocks.getMushroomPottedBlocks().forEach(this::dropSelf);
        ModBlocks.getBloodPlants().forEach(this::dropSelf);
        dropSelf(ModBlocks.BLOOD_INFUSION_ALTAR.get());
    }
}
