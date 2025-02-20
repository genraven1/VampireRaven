package com.genraven1.vampire_raven.block.altar;

import com.genraven1.vampire_raven.block.RavenBlockEntityBlock;
import com.genraven1.vampire_raven.block.entity.BloodInfusionAltarBlockEntity;
import com.genraven1.vampire_raven.util.RavenUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class BloodInfusionAltarBlock extends RavenBlockEntityBlock {

    public static final String CODE_NAME = "blood_infusion_altar";

    public BloodInfusionAltarBlock() {
        super(Properties.of(Material.STONE));
    }

    @Override
    public String getCodeName() {
        return CODE_NAME;
    }

    @Override
    public String getEnglishName() {
        return "Blood Infusion Altar";
    }

    @Override
    public String getLanguageCodeName() {
        return RavenUtils.LANG_BLOCK + CODE_NAME;
    }

    @Override
    public String getCodePath() {
        return RavenUtils.BLOCK_PATH + CODE_NAME;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BloodInfusionAltarBlockEntity(blockPos, blockState);
    }
}
