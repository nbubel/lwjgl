package com.bit.lake.lwjgl.components;

import org.newdawn.slick.opengl.Texture;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Patrick Wilmes
 */
public abstract class AbstractComponent implements Component {
    private float x, y;
    private float width, height;
    private Component.ComponentState state;
    private Texture baseTexture;
    private boolean cooldown;

    public AbstractComponent(final float x, final float y, final Texture texture) {
        setX(x);
        setY(y);
        baseTexture = texture;
        width = baseTexture.getTextureWidth();
        height = baseTexture.getTextureHeight();
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
    public void renderComponent() {
        glBegin(GL_QUADS);
        {
            glTexCoord2d(0, 0);
            glVertex2f(x, y);

            glTexCoord2d(1, 0);
            glVertex2f(x + width, y);

            glTexCoord2d(1, 1);
            glVertex2f(x + width, y + height);

            glTexCoord2d(0, 1);
            glVertex2f(x, y + height);
        }
        glEnd();
    }
}
