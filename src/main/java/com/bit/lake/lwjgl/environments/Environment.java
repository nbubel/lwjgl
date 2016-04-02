package com.bit.lake.lwjgl.environments;


import com.bit.lake.lwjgl.components.Component;
import com.bit.lake.lwjgl.container.Container;
import com.bit.lake.lwjgl.container.row.FlowLayoutContainer;
import com.bit.lake.lwjgl.environments.menu.GameMenu;
import com.bit.lake.lwjgl.utils.GameState;
import com.bit.lake.lwjgl.utils.Timer;

import java.util.Observer;

/**
 * @author Patrick Wilmes
 */
public interface Environment extends Observer {

    static Environment getInstance(GameState currentState) {
        switch (currentState) {
            case menu:
                Environment environment = GameMenu.newInstance();
                return environment;
        }
        return null;
    }

    void setLayout(final Container container);

    void render(final Timer timer);

    void add(Component component);
}
