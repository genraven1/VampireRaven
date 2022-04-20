package com.genraven1.raven_magical.item;

import com.genraven1.raven_magical.util.RavenUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Ruby extends RavenItem {

    public static final String CODE_NAME = "ruby";

    @Override
    public String getCodeName() {
        return CODE_NAME;
    }

    @Override
    public String getEnglishName() {
        return "Ruby";
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
