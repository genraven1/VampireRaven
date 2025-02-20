package com.genraven1.vampire_raven.block;

import com.genraven1.vampire_raven.VampireRaven;
import com.genraven1.vampire_raven.block.altar.BloodInfusionAltarBlock;
import com.genraven1.vampire_raven.block.crop.BloodPlant;
import com.genraven1.vampire_raven.block.crop.WeakBloodPlant;
import com.genraven1.vampire_raven.item.ModItems;
import com.genraven1.vampire_raven.item.block.RavenBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VampireRaven.MOD_ID);

    // Mushrooms
    public static final RegistryObject<RavenMushroomBlock> BLACK_MUSHROOM = registerBlock(BlackMushroom.CODE_NAME, BlackMushroom::new);

    public static List<RavenMushroomBlock> getMushroomBlocks() {
        return List.of(BLACK_MUSHROOM.get());
    }

    // Mushroom Pots
    public static final RegistryObject<BaseMushroomPot> BASIC_MUSHROOM_POT = registerBlock(BasicEmptyMushroomPot.CODE_NAME, BasicEmptyMushroomPot::new);
    public static final RegistryObject<BaseMushroomPot> POTTED_BLACK_MUSHROOM = registerBlock(BasicBlackMushroomPot.CODE_NAME, BasicBlackMushroomPot::new);

    public static List<BaseMushroomPot> getMushroomPotBlocks() {
        return List.of(BASIC_MUSHROOM_POT.get());
    }

    public static List<BaseMushroomPot> getMushroomPottedBlocks() {
        return List.of(POTTED_BLACK_MUSHROOM.get());
    }

    // Blood Plants
    public static final RegistryObject<BloodPlant> WEAK_BLOOD_PLANT = registerBlock(WeakBloodPlant.CODE_NAME, WeakBloodPlant::new);

    public static List<BloodPlant> getBloodPlants() {
        return List.of(WEAK_BLOOD_PLANT.get());
    }

    // Bat Houses
    public static final RegistryObject<RavenBaseEntityBlock> BAT_HOUSE = registerBlock(BatHouseBlock.CODE_NAME, BatHouseBlock::new);

    public static List<RavenBaseEntityBlock> getBatHouses() {
        return List.of(BAT_HOUSE.get());
    }

    public static final RegistryObject<RavenBlockEntityBlock> BLOOD_INFUSION_ALTAR = registerBlock(BloodInfusionAltarBlock.CODE_NAME, BloodInfusionAltarBlock::new);

    public static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<T> block) {
        ModItems.ITEMS.register(name, () -> new RavenBlockItem(block.get()));
        return BLOCKS.register(name, block);
    }

    public static void register(final IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
