package com.bit.lake.lwjgl.components.button;

import com.bit.lake.lwjgl.components.AbstractComponent;
import com.bit.lake.lwjgl.components.ComponentTextureName;
import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.utils.InternalTextureLoader;
import com.bit.lake.lwjgl.utils.MouseButton;
import org.apache.log4j.Logger;
import org.lwjgl.input.Mouse;

/**
 * @author Patrick Wilmes
 */
public class Button extends AbstractComponent {

    private static final Logger LOGGER = Logger.getLogger(Button.class);

    public Button(float x, float y) {
        super(x, y, InternalTextureLoader.loadTexture(ComponentTextureName.menuButton), LocalizationKey.btnMenuText);
    }

    @Override
    protected void handleMouseEvent() {
        if (Mouse.isButtonDown(MouseButton.LEFT)) {
            if (isMouseClickInRange()) {
                LOGGER.info("Clicked");
                triggerCooldown();
                setChanged();
                notifyObservers();
            }
        }
    }
}
