package com.bit.lake.lwjgl.environments.menu;

import com.bit.lake.lwjgl.components.button.Button;
import com.bit.lake.lwjgl.environments.Environment;

/**
 * Environments should always be singletons.
 *
 * @author Patrick Wilmes
 */
public final class GameMenu implements Environment {

    private static GameMenu instance;
    private Button button;

    private GameMenu() {
        button = new Button(10, 10);
    }

    public static Environment newInstance() {
        if (instance == null)
            instance = new GameMenu();
        return instance;
    }

    @Override
    public void render() {
        button.renderComponent();
    }
}
