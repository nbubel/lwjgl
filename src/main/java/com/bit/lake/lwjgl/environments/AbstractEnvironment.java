package com.bit.lake.lwjgl.environments;

import com.bit.lake.lwjgl.components.Component;
import com.bit.lake.lwjgl.container.Container;

/**
 * @author Patrick Wilmes
 */
public abstract class AbstractEnvironment implements Environment {
    private Container container;

    @Override
    public void setLayout(Container container) {
        this.container = container;
    }

    @Override
    public void add(Component component) {
        container.add(component);
    }

    @Override
    public void render() {
        container.render();
    }
}
