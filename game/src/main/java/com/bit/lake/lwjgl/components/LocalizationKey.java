package com.bit.lake.lwjgl.components;

/**
 * @author Patrick Wilmes
 */
public enum LocalizationKey {
    btnMenuText("menu.btn.exit");

    private String key;

    LocalizationKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
