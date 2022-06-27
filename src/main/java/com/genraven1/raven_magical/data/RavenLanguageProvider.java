package com.genraven1.raven_magical.data;

import com.genraven1.raven_magical.RavenMagical;
import com.genraven1.raven_magical.block.ModBlocks;
import com.genraven1.raven_magical.block.RavenMushroomBlock;
import com.genraven1.raven_magical.item.ModItems;
import com.genraven1.raven_magical.item.RavenItem;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.List;

public class RavenLanguageProvider extends LanguageProvider {

    public RavenLanguageProvider(final DataGenerator dataGenerator, final String locale) {
        super(dataGenerator, RavenMagical.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        addItemTranslations();
        addBlockTranslations();
    }

    private void addItemTranslations() {
        ModItems.getRawGemstones().forEach(item -> add(item.getLanguageCodeName(), item.getEnglishName()));
        ModItems.getGemstones().forEach(item -> add(item.getLanguageCodeName(), item.getEnglishName()));
        ModItems.getKnives().forEach(item -> add(item.getLanguageCodeName(), item.getEnglishName()));
    }

    private void addBlockTranslations() {
        ModBlocks.getMushroomBlocks().forEach(ravenMushroomBlock -> add(ravenMushroomBlock.getLanguageCodeName(), ravenMushroomBlock.getEnglishName()));
    }
}
