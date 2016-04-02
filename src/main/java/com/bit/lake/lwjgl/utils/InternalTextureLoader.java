package com.bit.lake.lwjgl.utils;

import com.bit.lake.lwjgl.texture.EmptyTexture;
import org.apache.log4j.Logger;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InternalTextureLoader {
    private InternalTextureLoader() {
    }

    public static Texture loadTexture(TextureName textureName) {
        try {
            InputStream inputStream = new FileInputStream("resources/" + textureName.getTextureName());
            return TextureLoader.getTexture("PNG", inputStream);
        } catch (IOException e) {
            Logger.getLogger(InternalTextureLoader.class).error("Cannot load texture " + textureName.getTextureName() + "!", e);
        }
        return new EmptyTexture();
    }
}
