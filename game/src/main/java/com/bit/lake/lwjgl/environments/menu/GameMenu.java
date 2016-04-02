package com.bit.lake.lwjgl.environments.menu;

import com.bit.lake.lwjgl.components.ComponentTextureName;
import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.components.TargetAction;
import com.bit.lake.lwjgl.components.button.Button;
import com.bit.lake.lwjgl.components.hashtag.Hashtag;
import com.bit.lake.lwjgl.configuration.GameConfiguration;
import com.bit.lake.lwjgl.container.row.FlowLayoutContainer;
import com.bit.lake.lwjgl.entities.Entity;
import com.bit.lake.lwjgl.entities.EntityTextureName;
import com.bit.lake.lwjgl.entities.background.BackgroundEntity;
import com.bit.lake.lwjgl.environments.AbstractEnvironment;
import com.bit.lake.lwjgl.environments.Environment;
import com.bit.lake.lwjgl.game.GameController;
import com.bit.lake.lwjgl.game.GameState;
import com.bit.lake.lwjgl.utils.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Environments should always be singletons.
 *
 * @author Patrick Wilmes
 */
public final class GameMenu extends AbstractEnvironment {

    private static GameMenu instance;
    private GameController gameController;
    private Entity background;
    private List<Hashtag> hashtags = new ArrayList<>();

    private GameMenu() {
        GameConfiguration configuration = new GameConfiguration();
        background = new BackgroundEntity(0, 0, EntityTextureName.menuBackgroundTexture);
        float startX = 10;
        float startY = 40;
        for (Hashtag tag : configuration.getHashtags()) {
            tag.setY(startY);
            startY += 50;
        }

        setLayout(new FlowLayoutContainer());
        Button startButton = new Button(10, 10, TargetAction.quit, ComponentTextureName.menuButton);
        startButton.addObserver(this);
        Button exitButton = new Button(10, 10, TargetAction.newGame, ComponentTextureName.menuButton);
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

    @Override
    public void render(Timer timer) {
        background.render();
        super.render(timer);

    }
}
