package com.bit.lake.lwjgl;

import com.bit.lake.lwjgl.game.GameController;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * @author Patrick Wilmes
 */
public final class Game {

    public static void main(String[] args) throws LWJGLException {
        new GameController().start();
    }

}
