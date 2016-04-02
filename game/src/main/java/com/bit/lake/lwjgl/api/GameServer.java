package com.bit.lake.lwjgl.api;

import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import javax.smartcardio.Card;
import java.rmi.Remote;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by michael on 02.04.16.
 */
public interface GameServer extends Remote {
    User connect(GameClient client);
    void disconnect(UUID userId);
    void newGame(UUID userId);

    User setCard(Card card, UUID userId);
    User attack(List<Integer> cardIds, UUID userId);
    User defend(Map<Card, List<Card>> mapping, UUID userId);
    void finishPhase(UUID userId);

    void reset();
}
