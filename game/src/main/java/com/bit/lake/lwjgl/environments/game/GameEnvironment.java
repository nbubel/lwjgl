package com.bit.lake.lwjgl.environments.game;

import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.components.TargetAction;
import com.bit.lake.lwjgl.components.button.Button;
import com.bit.lake.lwjgl.container.row.GridLayoutContainer;
import com.bit.lake.lwjgl.environments.AbstractEnvironment;
import com.bit.lake.lwjgl.environments.Environment;
import com.bit.lake.lwjgl.game.GameController;

import java.util.Observable;

/**
 * @author Patrick Wilmes
 */
public class GameEnvironment extends AbstractEnvironment {

    private static GameEnvironment instance;
    private GameController controller;

    private GameEnvironment() {
        GridLayoutContainer container = new GridLayoutContainer();

        for (int y = 0; y < container.rowDefMap.size(); y++) {

            for (int x = 0; x < container.rowDefMap.get(y).maxColumns; x++) {
                container.addComponent(x, y, new Button(10, 10, LocalizationKey.gameNextRound, TargetAction.nextRound));
            }
        }
        setLayout(container);
    }

    public static Environment newInstance(GameController controller) {
        if (instance == null) {
            instance = new GameEnvironment();
            instance.setController(controller);
        }
        return instance;
    }

    private void setController(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
