package com.genraven1.vampire_raven.data;

import com.genraven1.vampire_raven.VampireRaven;
import com.genraven1.vampire_raven.block.ModBlockTags;
import com.genraven1.vampire_raven.item.ModItemTags;
import com.genraven1.vampire_raven.item.ModItems;
import com.genraven1.vampire_raven.item.bat.BaseBatItem;
import com.genraven1.vampire_raven.item.block.ModBlockItemTags;
import com.genraven1.vampire_raven.item.gemstone.GemstoneItem;
import com.genraven1.vampire_raven.item.gemstone.RawGemstoneItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class RavenItemTagProvider extends ItemTagsProvider {

    public RavenItemTagProvider(final DataGenerator dataGenerator, final BlockTagsProvider blockTagsProvider, @Nullable final ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, VampireRaven.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.copy(ModBlockTags.MAGIC_MUSHROOM, ModBlockItemTags.MAGIC_MUSHROOM);
        this.copy(ModBlockTags.BLOOD_PLANT, ModBlockItemTags.BLOOD_PLANT);
        this.tag(ModItemTags.RAW_GEMSTONES).add(ModItems.getRawGemstones().toArray(new RawGemstoneItem[0]));
        this.tag(ModItemTags.GEMSTONES).add(ModItems.getGemstones().toArray(new GemstoneItem[0]));
        this.tag(ModItemTags.BATS).add(ModItems.getBats().toArray(new BaseBatItem[0]));
    }
}
