package com.genraven1.vampire_raven.item.bat;

import com.genraven1.vampire_raven.util.RavenUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IronBat extends BaseBatItem {

    public static final String CODE_NAME = "iron_bat";
    @Override
    public String getCodeName() {
        return CODE_NAME;
    }

    @Override
    public String getEnglishName() {
        return "Iron Bat";
    }

    @Override
    public String getLanguageCodeName() {
        return RavenUtils.LANG_ITEM + CODE_NAME;
    }

    @Override
    public String getCodePath() {
        return RavenUtils.ITEM_PATH + CODE_NAME;
    }
}
