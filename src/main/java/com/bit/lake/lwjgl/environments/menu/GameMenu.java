package com.bit.lake.lwjgl.environments.menu;

import com.bit.lake.lwjgl.components.button.Button;
import com.bit.lake.lwjgl.container.row.FlowLayoutContainer;
import com.bit.lake.lwjgl.environments.AbstractEnvironment;
import com.bit.lake.lwjgl.environments.Environment;

import java.util.Observable;

/**
 * Environments should always be singletons.
 *
 * @author Patrick Wilmes
 */
public final class GameMenu extends AbstractEnvironment {

    private static GameMenu instance;

    private GameMenu() {
        setLayout(new FlowLayoutContainer());
        Button button = new Button(10, 10);
        button.addObserver(this);
        add(button);
    }

    public static Environment newInstance() {
        if (instance == null)
            instance = new GameMenu();
        return instance;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Button) {

        }
    }
}
