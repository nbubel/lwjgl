package com.bit.lake.lwjgl.user;

import com.bit.lake.lwjgl.api.GameClient;
import com.bit.lake.lwjgl.api.GameServer;

import javax.smartcardio.Card;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * Created by michael on 02.04.16.
 */
public final class UserClient extends UnicastRemoteObject implements GameClient {

    protected UserClient() throws RemoteException {
    }

    protected UserClient(int port) throws RemoteException {
        super(port);
    }

    @Override
    public void attackedBy(List<Card> cards) {

    }

    @Override
    public void switchPhase(User user, int timeout) {

    }

    @Override
    public void stateChanged(User user) {

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
