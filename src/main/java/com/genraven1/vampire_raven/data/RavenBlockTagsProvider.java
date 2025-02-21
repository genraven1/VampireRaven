package com.genraven1.vampire_raven.data;

import com.genraven1.vampire_raven.VampireRaven;
import com.genraven1.vampire_raven.block.ModBlockTags;
import com.genraven1.vampire_raven.block.ModBlocks;
import com.genraven1.vampire_raven.block.RavenMushroomBlock;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class RavenBlockTagsProvider extends BlockTagsProvider {

    public RavenBlockTagsProvider(final DataGenerator dataGenerator, @Nullable final ExistingFileHelper existingFileHelper) {
        super(dataGenerator, VampireRaven.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(ModBlockTags.MAGIC_MUSHROOM).add(ModBlocks.getMushroomBlocks().toArray(new Block[0]));
        this.tag(ModBlockTags.BLOOD_PLANT).add(ModBlocks.getBloodPlants().toArray(new Block[0]));
    }
}
