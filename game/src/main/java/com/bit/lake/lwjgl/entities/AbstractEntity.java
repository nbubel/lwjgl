package com.bit.lake.lwjgl.entities;

import com.bit.lake.lwjgl.utils.InternalTextureLoader;
import com.bit.lake.lwjgl.utils.RenderingUtils;
import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;
/**
 * @author Patrick Wilmes
 */
public abstract class AbstractEntity implements Entity {
    private float x, y;
    private float width, height;
    private Texture texture;

    public AbstractEntity(final float x, final float y, EntityTextureName textureName) {
        this.x = x;
        this.y = y;
        texture = InternalTextureLoader.loadTexture(textureName);
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public void render() {
        RenderingUtils.renderTexturedQuad(x, y, width, height, texture);
    }
}
