package com.bit.lake.lwjgl.utils;


import org.newdawn.slick.TrueTypeFont;

import java.awt.*;

public final class InternalFontLoader {
    private InternalFontLoader() {
    }

    public static TrueTypeFont loadFont() {
        TrueTypeFont trueTypeFont;
        Font font1 = new Font("Times New Roman", Font.BOLD, 24);
        trueTypeFont = new TrueTypeFont(font1, false);
        return trueTypeFont;
    }
}
