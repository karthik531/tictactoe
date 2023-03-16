package com.msvsk.games.strategy;

import java.util.List;

import com.msvsk.games.model.Player;

public class DefaultNextPlayerStrategy implements NextPlayerStrategy
{
    @Override
    public int pickNextPlayer(List<Player> players, int curPlayer) {
        return (curPlayer + 1) % (players.size());
    }
}
