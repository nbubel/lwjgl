package com.bit.lake.lwjgl.components.hashtag;

import com.bit.lake.lwjgl.components.AbstractComponent;
import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.components.TargetAction;
import com.bit.lake.lwjgl.texture.EmptyTexture;

/**
 * @author Patrick Wilmes
 */
public final class Hashtag extends AbstractComponent {
    public Hashtag(float x, float y, LocalizationKey localizationKey, TargetAction targetAction) {
        super(x, y, new EmptyTexture(), localizationKey, targetAction);
    }

    @Override
    protected void handleMouseEvent() {

    }
}
