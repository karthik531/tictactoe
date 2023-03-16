package com.msvsk.games.strategy;

import java.util.List;

import com.msvsk.games.model.Player;

public interface PickFirstPlayerStrategy 
{
    public int getFirstPlayer(List<Player> players);
}
