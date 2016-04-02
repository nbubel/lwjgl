package com.bit.lake.lwjgl.container;


import com.bit.lake.lwjgl.components.Component;

public interface Container {
    void add(Component component);

    void render();
}
