package com.bit.lake.lwjgl.user;

import org.newdawn.slick.state.GameState;

import java.util.UUID;

/**
 * @author Patrick Wilmes
 */
public final class User {
    private UUID userId;
    private GameState gameState;

    public User() {
        userId = UUID.randomUUID();
    }

    public UUID getUserId() {
        return userId;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
