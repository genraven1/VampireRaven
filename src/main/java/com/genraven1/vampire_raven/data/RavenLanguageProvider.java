package com.genraven1.vampire_raven.data;

import com.genraven1.vampire_raven.VampireRaven;
import com.genraven1.vampire_raven.block.ModBlocks;
import com.genraven1.vampire_raven.item.ModItems;
import com.genraven1.vampire_raven.item.VampireRavenCreativeTab;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class RavenLanguageProvider extends LanguageProvider {

    public RavenLanguageProvider(final DataGenerator dataGenerator, final String locale) {
        super(dataGenerator, VampireRaven.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        addItemTranslations();
        addBlockTranslations();
        add("itemGroup." + VampireRavenCreativeTab.TabName, VampireRavenCreativeTab.EnglishTabName);
    }

    private void addItemTranslations() {
        ModItems.getRawGemstones().forEach(item -> add(item.getLanguageCodeName(), item.getEnglishName()));
        ModItems.getGemstones().forEach(item -> add(item.getLanguageCodeName(), item.getEnglishName()));
        ModItems.getBats().forEach(bat -> add(bat.getLanguageCodeName(), bat.getEnglishName()));
    }

    private void addBlockTranslations() {
        ModBlocks.getMushroomBlocks().forEach(ravenMushroomBlock -> add(ravenMushroomBlock.getLanguageCodeName(), ravenMushroomBlock.getEnglishName()));
        ModBlocks.getMushroomPotBlocks().forEach(mushroomPot -> add(mushroomPot.getLanguageCodeName(), mushroomPot.getEnglishName()));
        ModBlocks.getMushroomPottedBlocks().forEach(mushroomPot -> add(mushroomPot.getLanguageCodeName(), mushroomPot.getEnglishName()));
        ModBlocks.getBloodPlants().forEach(bloodPlant -> add(bloodPlant.getLanguageCodeName(), bloodPlant.getEnglishName()));
    }
}
