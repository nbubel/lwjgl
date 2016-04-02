package com.bit.lake.lwjgl.components;

/**
 * @author Patrick Wilmes
 */
public abstract class AbstractComponent implements Component {
    private float x, y;
    private Component.ComponentState state;

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }
}
