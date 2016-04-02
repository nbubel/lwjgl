package com.bit.lake.lwjgl.user;

import com.bit.lake.lwjgl.api.GameClient;

import javax.smartcardio.Card;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by michael on 02.04.16.
 */
public class UserClient extends UnicastRemoteObject implements GameClient {
    protected UserClient() throws RemoteException {
    }

    protected UserClient(int port) throws RemoteException {
        super(port);
    }

    @Override
    public void attackedWith(Card card) {

    }

    @Override
    public void updateHealth(int delta) {

    }

    @Override
    public void switchPhase(GamePhase newPhase, int timeout) {

    }

    @Override
    public void defeated() {

    }

    @Override
    public void win() {

    }

    @Override
    public void rematchRequest() {

    }
}
