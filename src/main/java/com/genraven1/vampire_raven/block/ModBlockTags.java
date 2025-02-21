package com.genraven1.vampire_raven.block;

import com.genraven1.vampire_raven.block.crop.BloodPlant;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModBlockTags {
    public static final TagKey<Block> MAGIC_MUSHROOM = TagKey.create(Registry.BLOCK_REGISTRY, RavenMushroomBlock.RESOURCE_LOCATION);
    public static final TagKey<Block> BLOOD_PLANT = TagKey.create(Registry.BLOCK_REGISTRY, BloodPlant.RESOURCE_LOCATION);
}
