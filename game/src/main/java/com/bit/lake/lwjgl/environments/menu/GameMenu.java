package com.bit.lake.lwjgl.environments.menu;

import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.components.TargetAction;
import com.bit.lake.lwjgl.components.button.Button;
import com.bit.lake.lwjgl.container.row.FlowLayoutContainer;
import com.bit.lake.lwjgl.environments.AbstractEnvironment;
import com.bit.lake.lwjgl.environments.Environment;
import com.bit.lake.lwjgl.game.GameController;
import com.bit.lake.lwjgl.game.GameState;

import java.util.Observable;

/**
 * Environments should always be singletons.
 *
 * @author Patrick Wilmes
 */
public final class GameMenu extends AbstractEnvironment {

    private static GameMenu instance;
    private GameController gameController;

    private GameMenu() {
        setLayout(new FlowLayoutContainer());
        Button startButton = new Button(10, 10, LocalizationKey.menuButtonExit, TargetAction.quit);
        startButton.addObserver(this);
        Button exitButton = new Button(10, 10, LocalizationKey.menuButtonNewGame, TargetAction.newGame);
        exitButton.addObserver(this);
        add(exitButton);
        add(startButton);
    }

    public static Environment newInstance(GameController gameController) {
        if (instance == null) {
            instance = new GameMenu();
            instance.setGameController(gameController);
        }
        return instance;
    }

    private void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Button) {
            Button button = (Button) o;
            TargetAction action = button.getAction();
            switch (action) {
                case quit:
                    gameController.shutdown();
                    break;
                case newGame:
                    gameController.updateState(GameState.level);
                    break;
            }
        }
    }
}
