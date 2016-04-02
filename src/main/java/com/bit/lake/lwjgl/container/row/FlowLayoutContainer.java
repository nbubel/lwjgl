package com.bit.lake.lwjgl.container.row;


import com.bit.lake.lwjgl.components.Component;
import com.bit.lake.lwjgl.container.AbstractContainer;
import org.lwjgl.opengl.Display;

public final class FlowLayoutContainer extends AbstractContainer {
    @Override
    public void render() {
        int currentX = 0;
        int currentY = 0;
        for (Component component : components) {
            component.setX(currentX);
            component.setY(currentY);
            component.renderComponent();
            currentX += component.getWidth() + 20;
            if (currentX > Display.getWidth()) {
                currentX = 0;
                currentY += component.getHeight() + 20;
            }
        }
    }
}
