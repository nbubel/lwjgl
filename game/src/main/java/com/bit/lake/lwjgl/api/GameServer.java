package com.bit.lake.lwjgl.api;

import java.rmi.Remote;

/**
 * Created by michael on 02.04.16.
 */
public interface GameServer extends Remote {
    User connect();

    void playCard(User user, Card card);

    void changeGameState(User user, GamePhase phase);
}
