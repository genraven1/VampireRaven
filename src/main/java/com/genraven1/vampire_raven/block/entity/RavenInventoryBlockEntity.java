package com.genraven1.vampire_raven.block.entity;

import com.genraven1.vampire_raven.tileentity.RavenItemStackHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public abstract class RavenInventoryBlockEntity extends RavenBlockEntity {
    private final LazyOptional<IItemHandler> capability = LazyOptional.of(this::getInventory);

    public RavenInventoryBlockEntity(final BlockEntityType<?> type, final BlockPos pos, final BlockState state) {
        super(type, pos, state);
    }

    public abstract @NotNull RavenItemStackHandler getInventory();

    @Override
    public void load(@NotNull final CompoundTag tag) {
        super.load(tag);
        this.getInventory().deserializeNBT(tag);
    }

    @Override
    public void saveAdditional(final CompoundTag tag) {
        tag.merge(this.getInventory().serializeNBT());
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(final Capability<T> cap, final Direction side) {
        if (!this.isRemoved() && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, this.capability);
        }

        return super.getCapability(cap, side);
    }

    public boolean isUsableByPlayer(final Player player) {
        var pos = this.getBlockPos();
        return player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64;
    }
}
