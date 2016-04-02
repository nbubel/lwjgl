package com.bit.lake.lwjgl.container.row;

import com.bit.lake.lwjgl.components.Component;
import com.bit.lake.lwjgl.container.AbstractContainer;
import org.lwjgl.opengl.Display;

import java.util.HashMap;
import java.util.Map;

public class GridLayoutContainer extends AbstractContainer {

    public static class RowDef {
        public int maxColumns;
        public int width;
        public int height;

    }

    public GridLayoutContainer() {
        int width = Display.getWidth();
        addRowDef(0, 10, width / 10, 100);
        addRowDef(1, 4, width / 4, 200);
        addRowDef(2, 4, width / 4, 200);
        addRowDef(3, 10, width / 10, 100);
    }

    private Map<Integer, Map<Integer, Component>> contentMap = new HashMap<>();
    public Map<Integer, RowDef> rowDefMap = new HashMap<>();

    @Override
    public void render() {
        int currentX = 0;
        int currentY = 0;

        for (Integer yLine : rowDefMap.keySet()) {
            RowDef def = rowDefMap.get(yLine);
            Map<Integer, Component> compMap = contentMap.get(yLine);
            for (int x = 0; x < def.maxColumns; x++) {

                if (compMap != null) {

                    Component component = compMap.get(x);
                    if (component != null) {
                        // center
                        float centerX = currentX + (def.width / 2) - (component.getWidth() / 2);
                        float centerY = currentY + (def.height / 2) - (component.getHeight() / 2);

                        component.setX(centerX);
                        component.setY(centerY);
                        component.renderComponent();
                    }
                }

                currentX += def.width;
            }
            currentX = 0;
            currentY += def.height;
        }

    }

    public void addComponent(Integer posX, Integer posY, Component component) {
        components.add(component);
        Map<Integer, Component> xMap = contentMap.get(posY);
        if (xMap == null) {
            xMap = new HashMap<>();
            contentMap.put(posY, xMap);
        }

        xMap.put(posX, component);
    }

    public void addRowDef(int posY, int maxColumns, int width, int height) {
        RowDef newDef = new RowDef();
        newDef.maxColumns = maxColumns;
        newDef.width = width;
        newDef.height = height;
        rowDefMap.put(posY, newDef);
    }
}
