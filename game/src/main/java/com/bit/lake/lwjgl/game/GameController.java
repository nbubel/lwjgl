package com.bit.lake.lwjgl.game;

import com.bit.lake.lwjgl.configuration.GameConfiguration;
import com.bit.lake.lwjgl.environments.Environment;
import com.bit.lake.lwjgl.utils.Timer;
import org.apache.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.ImageIOImageData;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Patrick Wilmes
 */
public final class GameController {

    private static final Logger LOGGER = Logger.getLogger(GameController.class);

    private Timer timer;
    private GameState currentState = GameState.menu;
    private GameConfiguration gameConfiguration = new GameConfiguration();

    public GameController() {
        Display.setTitle("LWJGL Card Game with Twitter");
        try {
            Display.setIcon(loadIcon());
            Display.setDisplayMode(gameConfiguration.getDisplayMode());
            Display.create();
        } catch (LWJGLException e) {
            LOGGER.error("Cannot create opengl display!");
        }
    }

    public void start() {
        initializeGame();

        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
            handleStates();

            Display.update();
            Display.sync(gameConfiguration.getFpsLimit());
        }
        shutdown();
    }

    private void initializeGame() {
        LOGGER.info("");
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        timer = new Timer();
    }

    private void handleStates() {
        Environment environment = Environment.getInstance(currentState, this);
        assert environment != null;
        environment.render(timer);
    }

    private ByteBuffer[] loadIcon() {
        try {
            return new ByteBuffer[]{new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("resources/game.png")), false, false, null)};
        } catch (IOException e) {
            LOGGER.warn("Cannot load application icon versus.ico!", e);
        }
        return null;
    }

    public void updateState(final GameState gameState) {
        currentState = gameState;
    }

    public void shutdown() {
        Display.destroy();
        System.exit(0);
    }
}
