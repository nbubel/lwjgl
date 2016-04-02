package com.bit.lake.lwjgl.api;

import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import javax.smartcardio.Card;

/**
 * Created by michael on 02.04.16.
 */
public interface GameClient {
    void attackedWith(Card card);
    void updateHealth(int delta);
    void switchPhase(GamePhase newPhase, int timeout);

    void defeated();
    void win();
    void rematchRequest();
}
