package com.genraven1.vampire_raven.block;

import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.NotNull;

public abstract class RavenBaseEntityBlock extends BaseEntityBlock {
    protected RavenBaseEntityBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL).noOcclusion());
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull final BlockState pState) {
        return RenderShape.MODEL;
    }

    public abstract String getCodeName();

    public abstract String getEnglishName();

    public abstract String getLanguageCodeName();

    public abstract String getCodePath();
}
