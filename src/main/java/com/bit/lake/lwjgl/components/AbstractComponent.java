package com.bit.lake.lwjgl.components;

import com.bit.lake.lwjgl.configuration.GameConfiguration;
import com.bit.lake.lwjgl.utils.InternalFontLoader;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;

import java.util.ResourceBundle;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Patrick Wilmes
 */
public abstract class AbstractComponent implements Component {
    private float x, y;
    private float width, height;
    private Component.ComponentState state;
    private Texture baseTexture;
    private TrueTypeFont trueTypeFont;
    private boolean cooldown;
    private String componentText;

    public AbstractComponent(final float x, final float y, final Texture texture, final LocalizationKey localizationKey) {
        GameConfiguration gameConfiguration = new GameConfiguration();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("game", gameConfiguration.getConfiguredLocale());
        setX(x);
        setY(y);
        baseTexture = texture;
        width = baseTexture.getTextureWidth();
        height = baseTexture.getTextureHeight();
        trueTypeFont = InternalFontLoader.loadFont();
        componentText = resourceBundle.getString(localizationKey.getKey());
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
        baseTexture.bind();
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
        int textWidth = trueTypeFont.getWidth(componentText);
        int textHeight = trueTypeFont.getHeight();
        trueTypeFont.drawString(x + (width / 2) - textWidth, y + (height / 2) - textHeight, componentText);
    }
}
