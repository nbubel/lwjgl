package com.bit.lake.lwjgl.environments.game;

import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.components.TargetAction;
import com.bit.lake.lwjgl.components.button.Button;
import com.bit.lake.lwjgl.container.row.FlowLayoutContainer;
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
        FlowLayoutContainer container = new FlowLayoutContainer();
        container.add(new Button(10, 10, LocalizationKey.gameNextRound, TargetAction.nextRound));
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
