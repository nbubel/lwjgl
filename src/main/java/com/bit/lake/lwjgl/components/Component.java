package com.bit.lake.lwjgl.components;

/**
 * @author Patrick Wilmes
 */
public interface Component {
    enum ComponentState {
        ACTIVE, DISABLED
    }

    void renderComponent();

    void setX(float x);

    void setY(float y);

    float getWidth();

    float getHeight();
}
