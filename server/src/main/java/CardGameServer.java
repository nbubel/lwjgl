import com.bit.lake.lwjgl.api.GameClient;
import com.bit.lake.lwjgl.api.GameServer;
import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import javax.smartcardio.Card;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by michael on 02.04.16.
 */
public class CardGameServer extends UnicastRemoteObject implements GameServer {
    private Map<UUID, GameClient> clients = new HashMap<UUID, GameClient>();

    protected CardGameServer() throws RemoteException {
    }

    protected CardGameServer(int port) throws RemoteException {
        super(port);
    }

    @Override
    public User connect(GameClient client) {
        User user = new User();
        clients.put(user.getUserId(), client);
        return user;
    }

    @Override
    public void disconnect(UUID userId) {
        clients.remove(userId);
    }

    @Override
    public void newGame(UUID userId) {

    }

    @Override
    public void attackWith(Card card, UUID userId) {

    }

    @Override
    public void defendWith(Card card, UUID userId) {

    }

    @Override
    public void finishPhase(GamePhase phase, UUID userId) {

    }
}
