package com.bit.lake.lwjgl.entities;

/**
 * @author Patrick Wilmes
 */
public interface Entity {
    void setX(float x);
    void setY(float y);
    float getX();
    float getY();
    float getWidth();
    float getHeight();
    void render();
}
