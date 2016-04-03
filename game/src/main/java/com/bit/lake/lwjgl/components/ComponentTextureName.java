package com.bit.lake.lwjgl.components;

import com.bit.lake.lwjgl.utils.TextureName;

/**
 * @author Patrick Wilmes
 */
public enum ComponentTextureName implements TextureName {
    menuButton("textures/start/play.png"),
    menuClose("textures/start/close.png"),
    menuInfo("textures/start/info.png"),
    menuCardCircle("textures/start/card-cirlce-big.png");

    private String textureName;

    ComponentTextureName(String textureName) {
        this.textureName = textureName;
    }

    @Override
    public String getTextureName() {
        return textureName;
    }
}
