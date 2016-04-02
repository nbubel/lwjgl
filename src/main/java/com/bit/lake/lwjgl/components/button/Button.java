package com.bit.lake.lwjgl.components.button;

import com.bit.lake.lwjgl.components.AbstractComponent;
import com.bit.lake.lwjgl.components.ComponentTextureName;
import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.utils.InternalTextureLoader;

/**
 * @author Patrick Wilmes
 */
public class Button extends AbstractComponent {

    public Button(float x, float y) {
        super(x, y, InternalTextureLoader.loadTexture(ComponentTextureName.menuButton), LocalizationKey.btnMenuText);
    }

    @Override
    public float getWidth() {
        return 0;
    }

    @Override
    public float getHeight() {
        return 0;
    }
}
