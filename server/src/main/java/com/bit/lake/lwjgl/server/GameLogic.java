package com.bit.lake.lwjgl.server;

import com.bit.lake.lwjgl.user.GamePhase;
import com.bit.lake.lwjgl.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 02.04.16.
 */
public class GameLogic {
    static final int PhaseLengthInSec = 30;
    private List<User> players = new ArrayList<>();

    private int round;
    private int curPlayer;
    private GamePhase curPhase;

    public void addPlayer(User player) {
        if(round == 0)
            players.add(player);
    }

    public User getCurrentPlayer() {
        return curPlayer >= 0 ? players.get(curPlayer) : null;
    }

    public void nextRound() {
        round++;
        curPlayer = 0;
    }

    public GamePhase nextPhase() {
        curPhase = nextPhase(curPhase);
        getCurrentPlayer().setGamePhase(curPhase);
        return curPhase;
    }

    public User nextPlayer() {
        // make sure that last user is in idle mode
        User user = players.get(curPlayer++);
        user.setGamePhase(GamePhase.Idle);

        if(curPlayer >= players.size())
            nextRound();

        nextPhase();
        return getCurrentPlayer();
    }

    public void reset() {
        players.clear();
        round = 0;
        curPlayer = -1;
        curPhase = GamePhase.Idle;
    }

    public static GamePhase nextPhase(GamePhase phase) {
        GamePhase[] phases = GamePhase.values();
        return phases[(1 + phase.ordinal()) % phases.length];
    }
}
