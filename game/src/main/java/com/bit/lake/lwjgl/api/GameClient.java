package com.bit.lake.lwjgl.api;

import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import javax.smartcardio.Card;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by michael on 02.04.16.
 */
public interface GameClient {
    void attackedBy(List<Card> cards) throws RemoteException;
    void switchPhase(User user, int timeout) throws RemoteException;
    void stateChanged(User user) throws RemoteException;

    void defeated() throws RemoteException;
    void win() throws RemoteException;
    void rematchRequest() throws RemoteException;
}
