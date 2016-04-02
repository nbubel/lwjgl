package com.bit.lake.lwjgl.environments.menu;

import com.bit.lake.lwjgl.environments.Environment;

/**
 * Environments should always be singletons.
 *
 * @author Patrick Wilmes
 */
public final class GameMenu implements Environment {

    private static GameMenu instance;

    private GameMenu() {
    }

    public static Environment newInstance() {
        if (instance == null)
            instance = new GameMenu();
        return instance;
    }

    @Override
    public void render() {

    }
}
