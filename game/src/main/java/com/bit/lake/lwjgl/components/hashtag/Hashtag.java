package com.bit.lake.lwjgl.components.hashtag;

import com.bit.lake.lwjgl.components.AbstractComponent;
import com.bit.lake.lwjgl.components.TargetAction;

/**
 * @author Patrick Wilmes
 */
public final class Hashtag extends AbstractComponent {
    public Hashtag(float x, float y, final String text, TargetAction targetAction) {
        super(x, y, text, targetAction);
    }

    @Override
    protected void handleMouseEvent() {

    }
}
