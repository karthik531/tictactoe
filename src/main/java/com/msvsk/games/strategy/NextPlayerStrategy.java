package com.msvsk.games.strategy;

import java.util.List;

import com.msvsk.games.model.Player;

public interface NextPlayerStrategy 
{
    public int pickNextPlayer(List<Player> players, int curPlayer);
}
