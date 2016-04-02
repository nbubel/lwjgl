package com.bit.lake.lwjgl.container;


import com.bit.lake.lwjgl.components.Component;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractContainer implements Container {

    protected List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }
}
