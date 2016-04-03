package com.bit.lake.lwjgl.environments.menu;

import com.bit.lake.lwjgl.components.ComponentTextureName;
import com.bit.lake.lwjgl.components.LocalizationKey;
import com.bit.lake.lwjgl.components.TargetAction;
import com.bit.lake.lwjgl.components.button.Button;
import com.bit.lake.lwjgl.container.row.CustomLayoutContainer;
import com.bit.lake.lwjgl.container.row.FlowLayoutContainer;
import com.bit.lake.lwjgl.entities.Entity;
import com.bit.lake.lwjgl.entities.EntityTextureName;
import com.bit.lake.lwjgl.entities.background.BackgroundEntity;
import com.bit.lake.lwjgl.environments.AbstractEnvironment;
import com.bit.lake.lwjgl.environments.Environment;
import com.bit.lake.lwjgl.environments.game.GameEnvironment;
import com.bit.lake.lwjgl.game.GameController;
import com.bit.lake.lwjgl.game.GameState;
import com.bit.lake.lwjgl.utils.LaunchJre;
import com.bit.lake.lwjgl.utils.Timer;

import java.util.Arrays;
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

    private Button exitButton;
    private Button startButton;
    private Button infoButton;
    private Button logoButton;

    private GameMenu() {
        background = new BackgroundEntity(0, 0, EntityTextureName.menuBackgroundTexture);
        setLayout(new CustomLayoutContainer());
        startButton = new Button(150, 10, TargetAction.quit, ComponentTextureName.menuClose);
        startButton.addObserver(this);
        exitButton = new Button(300, 500, TargetAction.newGame, ComponentTextureName.menuButton);
        exitButton.addObserver(this);
        infoButton = new Button(450, 500, TargetAction.newGame, ComponentTextureName.menuInfo);
        logoButton = new Button(250, 80, TargetAction.newGame, ComponentTextureName.menuCardCircle);
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
        String host = null;
        if (o instanceof Button) {
            Button button = (Button) o;
            TargetAction action = button.getAction();
            switch (action) {
                case quit:
                    gameController.shutdown();
                    break;
                case newGame:
                    //LaunchJre.launch(Arrays.asList(""));
                    host = "localhost";
                case joinGame:
                    if (host == null) {
                        // TODO ask for domain
                    }

                    //((GameEnvironment) GameEnvironment.newInstance(gameController)).connectToServer(host);
                    gameController.updateState(GameState.level);
                    break;
            }
        }
    }

    @Override
    public void render(Timer timer) {
        background.render();
        super.render(timer);
        exitButton.renderComponent();
        startButton.renderComponent();
        infoButton.renderComponent();
        logoButton.renderComponent();
    }
}
