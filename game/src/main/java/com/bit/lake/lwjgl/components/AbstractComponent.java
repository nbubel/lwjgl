package com.bit.lake.lwjgl.components;

import com.bit.lake.lwjgl.configuration.GameConfiguration;
import com.bit.lake.lwjgl.utils.InternalFontLoader;
import com.bit.lake.lwjgl.utils.RenderingUtils;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;

import java.util.Observable;
import java.util.ResourceBundle;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Patrick Wilmes
 */
public abstract class AbstractComponent extends Observable implements Component {
    private float x, y;
    private float width, height;
    private Component.ComponentState state;
    private Texture baseTexture;
    private TrueTypeFont trueTypeFont;
    private boolean cooldown;
    private String componentText;
    private TargetAction targetAction;

    public AbstractComponent(final float x, final float y, final String text, final TargetAction targetAction) {
        GameConfiguration gameConfiguration = new GameConfiguration();
        setX(x);
        setY(y);
        width = baseTexture.getTextureWidth();
        height = baseTexture.getTextureHeight();
        trueTypeFont = InternalFontLoader.loadFont();
        componentText = text;
        this.targetAction = targetAction;
    }

    public AbstractComponent(final float x, final float y, final Texture texture, final LocalizationKey localizationKey, final TargetAction targetAction) {
        GameConfiguration gameConfiguration = new GameConfiguration();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("game", gameConfiguration.getConfiguredLocale());
        setX(x);
        setY(y);
        baseTexture = texture;
        width = baseTexture.getTextureWidth();
        height = baseTexture.getTextureHeight();
        trueTypeFont = InternalFontLoader.loadFont();
        componentText = resourceBundle.getString(localizationKey.getKey());
        this.targetAction = targetAction;
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
    public void renderComponent() {
        if (!cooldown)
            handleMouseEvent();

        RenderingUtils.renderTexturedQuad(x, y, width, height, baseTexture);
        int textWidth = trueTypeFont.getWidth(componentText);
        int textHeight = trueTypeFont.getHeight();
        trueTypeFont.drawString(x + (width / 2) - textWidth, y + (height / 2) - textHeight, componentText);
    }

    protected abstract void handleMouseEvent();

    protected boolean isMouseClickInRange() {
        float mouseX = Mouse.getX();
        float mouseY = Display.getHeight() - Mouse.getY();
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    protected void triggerCooldown() {
        cooldown = true;
        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cooldown = false;
        }).run();
    }

    @Override
    public TargetAction getAction() {
        return targetAction;
    }
}
