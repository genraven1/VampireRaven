package com.genraven1.vampire_raven.block.entity;

import com.genraven1.vampire_raven.VampireRaven;
import com.genraven1.vampire_raven.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, VampireRaven.MOD_ID);

    public static final RegistryObject<BlockEntityType<BatHouseBlockEntity>> BAT_HOUSE =
            BLOCK_ENTITIES.register(BatHouseBlockEntity.CODE_NAME,
                    () -> BlockEntityType.Builder.of(BatHouseBlockEntity::new, ModBlocks.BAT_HOUSE.get()).build(null));

    public static void register(final IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
