package com.genraven1.vampire_raven.item;

import com.genraven1.vampire_raven.util.RavenUtils;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModItemTags {
    public static final TagKey<Item> RAW_GEMSTONES = TagKey.create(Registry.ITEM_REGISTRY, RavenUtils.getResourceLocation("raw_gemstones"));
    public static final TagKey<Item> GEMSTONES = TagKey.create(Registry.ITEM_REGISTRY, RavenUtils.getResourceLocation("gemstones"));
    public static final TagKey<Item> BATS = TagKey.create(Registry.ITEM_REGISTRY, RavenUtils.getResourceLocation("bats"));
    public static final TagKey<Item> KNIVES = TagKey.create(Registry.ITEM_REGISTRY, RavenUtils.getResourceLocation("knives"));
}
