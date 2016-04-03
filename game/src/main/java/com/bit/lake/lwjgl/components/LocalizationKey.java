package com.bit.lake.lwjgl.components;

/**
 * @author Patrick Wilmes
 */
public enum LocalizationKey {
    menuButtonExit("menu.btn.exit"),
    menuButtonNewGame("menu.btn.newGame"),
    gameNextRound("game.next.round"), none("empty"),
    twitterCardGame("game.twitter.card");

    private String key;

    LocalizationKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
