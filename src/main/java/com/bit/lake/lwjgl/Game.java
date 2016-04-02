package com.bit.lake.lwjgl;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * @author Patrick Wilmes
 */
public final class Game {

    public static void main(String[] args) throws LWJGLException {
        Display.setDisplayMode(new DisplayMode(800, 600));
        Display.create();

        while(!Display.isCloseRequested()) {
            Display.update();
        }

        Display.destroy();
    }

}
