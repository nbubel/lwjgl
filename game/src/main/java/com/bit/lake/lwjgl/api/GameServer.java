package com.bit.lake.lwjgl.api;

import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import javax.smartcardio.Card;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by michael on 02.04.16.
 */
public interface GameServer extends Remote {
    User connect(GameClient client) throws RemoteException;
    void disconnect(UUID userId) throws RemoteException;
    void newGame(UUID userId) throws RemoteException;

    User setCard(Card card, UUID userId) throws RemoteException;
    User attack(List<Integer> cardIds, UUID userId) throws RemoteException;
    User defend(Map<Card, List<Card>> mapping, UUID userId) throws RemoteException;
    void finishPhase(UUID userId) throws RemoteException;

    void reset() throws RemoteException;
}
