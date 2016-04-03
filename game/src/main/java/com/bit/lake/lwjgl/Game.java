package com.bit.lake.lwjgl;

import com.bit.lake.lwjgl.game.GameController;
import com.bit.lake.lwjgl.swing.HostInputDialog;
import org.lwjgl.LWJGLException;

/**
 * @author Patrick Wilmes
 */
public final class Game {

    public static void main(String[] args) throws LWJGLException {
        new GameController().start();
    }

}
