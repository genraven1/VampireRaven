package com.genraven1.vampire_raven.block.entity;

import com.genraven1.vampire_raven.VampireRaven;
import com.genraven1.vampire_raven.block.ModBlocks;
import com.genraven1.vampire_raven.block.RavenBlockEntityBlock;
import com.genraven1.vampire_raven.block.altar.BloodInfusionAltarBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, VampireRaven.MOD_ID);

    public static final RegistryObject<BlockEntityType<BloodInfusionAltarBlockEntity>> BLOOD_INFUSION_ALTAR =
            registerBlockEntity(BloodInfusionAltarBlock.CODE_NAME, BloodInfusionAltarBlockEntity::new, ModBlocks.BLOOD_INFUSION_ALTAR.get());

    public static final RegistryObject<BlockEntityType<BatHouseBlockEntity>> BAT_HOUSE =
            BLOCK_ENTITIES.register(BatHouseBlockEntity.CODE_NAME,
                    () -> BlockEntityType.Builder.of(BatHouseBlockEntity::new, ModBlocks.BAT_HOUSE.get()).build(null));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> registerBlockEntity(final String codeName, BlockEntityType.BlockEntitySupplier<T> supplier, RavenBlockEntityBlock block) {
//        ModBlocks.registerBlock(codeName, )
        return BLOCK_ENTITIES.register(codeName, () -> BlockEntityType.Builder.of(supplier, block).build(null));
    }

    public static void register(final IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
