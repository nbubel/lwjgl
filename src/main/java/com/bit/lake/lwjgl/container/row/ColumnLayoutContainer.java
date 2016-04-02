package com.bit.lake.lwjgl.container.row;


import com.bit.lake.lwjgl.components.Component;
import com.bit.lake.lwjgl.container.AbstractContainer;
import org.lwjgl.opengl.Display;

public final class ColumnLayoutContainer extends AbstractContainer {
    public enum ComponentAlignment {
        left, right, center
    }

    private int numberOfCols = 1;
    private ComponentAlignment componentAlignment = ComponentAlignment.left;


    public ColumnLayoutContainer(int numberOfCols) {
        this.numberOfCols = numberOfCols;
    }

    public ColumnLayoutContainer(int numberOfCols, ComponentAlignment componentAlignment) {
        this(numberOfCols);
        this.componentAlignment = componentAlignment;
    }

    @Override
    public void render() {
        int componentsPerCol = components.size() / numberOfCols;
        int availableSpace = Display.getWidth();
        int colSize = availableSpace / numberOfCols;

        float currentY = 0;
        float colStart = 0;
        for (int i = 0; i < numberOfCols; i++) {
            for (int j = 0; j < componentsPerCol; j++) {
                Component component = components.get(i);
                if (componentAlignment == ComponentAlignment.center) {
                    float newX = colSize / 2 - component.getWidth() / 2;
                    component.setX(colStart + newX);
                } else if (componentAlignment == ComponentAlignment.right) {
                    float newX = colSize - component.getWidth() - 20;
                    component.setX(colStart + newX);
                } else {
                    component.setX(colStart);
                }
                component.setY(currentY);
                component.renderComponent();
                currentY += component.getHeight() + 20;
            }
            colStart += colSize;
            currentY = 0;
        }
    }
}
