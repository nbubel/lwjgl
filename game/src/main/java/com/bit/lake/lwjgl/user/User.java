package com.bit.lake.lwjgl.user;

import java.util.UUID;

/**
 * @author Patrick Wilmes
 */
public final class User {
    private UUID userId;
    private GamePhase gamePhase;

    public User() {
        userId = UUID.randomUUID();
    }

    public UUID getUserId() {
        return userId;
    }

    public GamePhase getGamePhase() {
        return gamePhase;
    }

    public void setGamePhase(GamePhase gamePhase) {
        this.gamePhase = gamePhase;
    }
}
