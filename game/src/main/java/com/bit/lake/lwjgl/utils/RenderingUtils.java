package com.bit.lake.lwjgl.utils;

import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.*;

/**
 * @author Patrick Wilmes
 */
public final class RenderingUtils {
    private RenderingUtils() {
    }

    public static void renderTexturedQuad(float x, float y, float width, float height, Texture texture) {
        texture.bind();
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
