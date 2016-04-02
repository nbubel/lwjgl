package com.bit.lake.lwjgl.components;

import com.bit.lake.lwjgl.utils.TextureName;

/**
 * @author Patrick Wilmes
 */
public enum ComponentTextureName implements TextureName {
    menuButton("textures/menu_button.png");
    private String textureName;

    ComponentTextureName(String textureName) {
        this.textureName = textureName;
    }

    @Override
    public String getTextureName() {
        return textureName;
    }
}
