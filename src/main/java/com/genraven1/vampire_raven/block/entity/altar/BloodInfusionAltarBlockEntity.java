package com.genraven1.vampire_raven.block.entity.altar;

import com.genraven1.vampire_raven.block.entity.ModBlockEntities;
import com.genraven1.vampire_raven.block.entity.RavenInventoryBlockEntity;
import com.genraven1.vampire_raven.tileentity.RavenItemStackHandler;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import static com.genraven1.vampire_raven.tileentity.BasicMushroomPotTileEntity.createInventoryHandler;

@Getter
public class BloodInfusionAltarBlockEntity extends RavenInventoryBlockEntity {
    private final RavenItemStackHandler inventory;

    public BloodInfusionAltarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLOOD_INFUSION_ALTAR.get(), pos, state);
        this.inventory = createInventoryHandler(this::markDirtyAndDispatch);
    }
}
