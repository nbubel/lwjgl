package com.bit.lake.lwjgl.server;

import com.bit.lake.lwjgl.api.GameClient;
import com.bit.lake.lwjgl.api.GameServer;
import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import javax.smartcardio.Card;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by michael on 02.04.16.
 */
public class CardGameServer extends UnicastRemoteObject implements GameServer {
    private final Map<UUID, GameClient> clients = new HashMap<UUID, GameClient>();
    private final Map<UUID, User> users = new HashMap<UUID, User>();
    private final GameLogic logic;

    protected CardGameServer() throws RemoteException {
        logic = new GameLogic();
    }

    protected CardGameServer(int port) throws RemoteException {
        super(port);
        logic = new GameLogic();
    }

    @Override
    public User connect(GameClient client) {
        User user = new User();
        clients.put(user.getUserId(), client);
        users.put(user.getUserId(), user);
        return user;
    }

    @Override
    public void disconnect(UUID userId) {
        clients.remove(userId);
        users.remove(userId);
    }

    @Override
    public void newGame(UUID userId) {

    }

    @Override
    public User setCard(Card card, UUID userId) {
        return null;
    }

    @Override
    public User attack(List<Integer> cardIds, UUID userId) {
        return null;
    }

    @Override
    public User defend(Map<Card, List<Card>> mapping, UUID userId) {
        return null;
    }

    @Override
    public void finishPhase(UUID userId) {
        User user = users.get(userId);

        if(user == null || !user.equals(logic.getCurrentPlayer())) return;

        GamePhase nextPhase = logic.nextPhase();
        clients.get(userId).switchPhase(user, GameLogic.PhaseLengthInSec);
        if(nextPhase == GamePhase.Idle) {
            User nextUser = logic.nextPlayer();
            clients.get(nextUser.getUserId()).switchPhase(nextUser, GameLogic.PhaseLengthInSec);
        }
    }
}
