package com.bit.lake.lwjgl.environments;


import com.bit.lake.lwjgl.components.Component;
import com.bit.lake.lwjgl.container.Container;
import com.bit.lake.lwjgl.container.row.FlowLayoutContainer;
import com.bit.lake.lwjgl.environments.game.GameEnvironment;
import com.bit.lake.lwjgl.environments.menu.GameMenu;
import com.bit.lake.lwjgl.game.GameController;
import com.bit.lake.lwjgl.utils.GameState;
import com.bit.lake.lwjgl.utils.Timer;

import java.util.Observer;

/**
 * @author Patrick Wilmes
 */
public interface Environment extends Observer {

    static Environment getInstance(GameState currentState, GameController gameController) {
        switch (currentState) {
            case menu:
                return GameMenu.newInstance(gameController);
            case level:
                return GameEnvironment.newInstance(gameController);
        }
        return null;
    }

    void setLayout(final Container container);

    void render(final Timer timer);

    void add(Component component);
}
