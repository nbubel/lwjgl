package com.bit.lake.lwjgl.environments;


import com.bit.lake.lwjgl.components.Component;
import com.bit.lake.lwjgl.container.Container;
import com.bit.lake.lwjgl.container.row.FlowLayoutContainer;
import com.bit.lake.lwjgl.environments.menu.GameMenu;
import com.bit.lake.lwjgl.utils.GameState;

/**
 * @author Patrick Wilmes
 */
public interface Environment {

    static Environment getInstance(GameState currentState) {
        switch (currentState) {
            case menu:
                Environment environment = GameMenu.newInstance();
                return environment;
        }
        return null;
    }

    void setLayout(final Container container);

    void render();

    void add(Component component);
}
