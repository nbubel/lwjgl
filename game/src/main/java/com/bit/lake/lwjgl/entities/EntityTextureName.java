package com.bit.lake.lwjgl.entities;

import com.bit.lake.lwjgl.utils.TextureName;

/**
 * @author Patrick Wilmes
 */
public enum EntityTextureName implements TextureName {
    menuBackgroundTexture("textures/start/bg.png"),
    gameBackground("textures/grid/bg.png");

    private String textureKey;

    EntityTextureName(String textureKey) {
        this.textureKey = textureKey;
    }

    @Override
    public String getTextureName() {
        return textureKey;
    }
}
