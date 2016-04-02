package com.bit.lake.lwjgl.api;

import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import javax.smartcardio.Card;
import java.rmi.Remote;
import java.util.UUID;

/**
 * Created by michael on 02.04.16.
 */
public interface GameServer extends Remote {
    User connect();
    void disconnect(UUID userId);
    void newGame(UUID userId);

    void attackWith(Card card, UUID userId);
    void defendWith(Card card, UUID userId);
    void finishPhase(GamePhase phase, UUID userId);
}
