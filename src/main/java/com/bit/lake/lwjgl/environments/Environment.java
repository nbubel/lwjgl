package com.bit.lake.lwjgl.environments;


import com.bit.lake.lwjgl.environments.menu.GameMenu;
import com.bit.lake.lwjgl.utils.GameState;

/**
 * @author Patrick Wilmes
 */
public interface Environment {

    static Environment getInstance(GameState currentState) {
        switch (currentState) {
            case menu:
                return GameMenu.newInstance();
        }
        return null;
    }

    void render();
}
