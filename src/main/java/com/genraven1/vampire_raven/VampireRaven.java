package com.genraven1.vampire_raven;

import com.genraven1.vampire_raven.block.ModBlocks;
import com.genraven1.vampire_raven.data.loot.global.ModLootModifiers;
import com.genraven1.vampire_raven.item.ModItems;
import com.genraven1.vampire_raven.recipes.ModRecipes;
import com.genraven1.vampire_raven.tileentity.ModTileEntities;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(VampireRaven.MOD_ID)
public class VampireRaven {
    public static final String MOD_ID = "vampire_raven";
    private static final Logger LOGGER = LogUtils.getLogger();

    public VampireRaven() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        registerRegistries(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerRegistries(final IEventBus eventBus) {
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModLootModifiers.register(eventBus);
        ModRecipes.register(eventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BLACK_MUSHROOM.getId(), ModBlocks.POTTED_BLACK_MUSHROOM);
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ModBlocks.getMushroomBlocks().forEach(mushroom -> ItemBlockRenderTypes.setRenderLayer(mushroom, RenderType.cutout()));
        ModBlocks.getMushroomPottedBlocks().forEach(mushroomPot -> ItemBlockRenderTypes.setRenderLayer(mushroomPot, RenderType.cutout()));
        ModBlocks.getBloodPlants().forEach(bloodPlant -> ItemBlockRenderTypes.setRenderLayer(bloodPlant, RenderType.cutout()));
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }
}
