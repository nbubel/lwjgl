package com.bit.lake.lwjgl.api;

import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import javax.smartcardio.Card;
import java.util.List;

/**
 * Created by michael on 02.04.16.
 */
public interface GameClient {
    void attackedBy(List<Card> cards);
    void switchPhase(User user, int timeout);
    void stateChanged(User user);

    void defeated();
    void win();
    void rematchRequest();
}
