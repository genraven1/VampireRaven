package com.genraven1.vampire_raven.util;

import com.genraven1.vampire_raven.VampireRaven;
import net.minecraft.resources.ResourceLocation;

public class RavenUtils {

    public static final String BLANK = " ";
    public static final String LANG_BLOCK = "block." + VampireRaven.MOD_ID + ".";
    public static final String LANG_ITEM =  "item." + VampireRaven.MOD_ID + ".";
    public static final String BLOCK_PATH = "block/";
    public static final String ITEM_PATH = "item/";
    public static final String HAS_PREFIX = "has_";
    public static final String SMITHING_SUFFIX = "_smithing";
    public static final String MODEL_TOP_SUFFIX = "_top";
    public static final String MODEL_BOTTOM_SUFFIX = "_bottom";
    public static final String MODEL_SIDE_SUFFIX = "_side";

    public static ResourceLocation getResourceLocation(final String name) {
        return new ResourceLocation(VampireRaven.MOD_ID, name);
    }
}
