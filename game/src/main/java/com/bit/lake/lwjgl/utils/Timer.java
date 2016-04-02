package com.bit.lake.lwjgl.utils;

import org.lwjgl.Sys;

/**
 * @author Patrick Wilmes
 */
public final class Timer {
    private long lastFrame;

    public Timer() {
        lastFrame = getTime();
    }

    private long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    public int getDelta() {
        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;
        return delta;
    }
}
