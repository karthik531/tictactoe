package com.msvsk.games.strategy;

import java.util.List;

import com.msvsk.games.model.Player;

public class DefaultPickfirstPlayerStrategy implements PickFirstPlayerStrategy
{

    @Override
    public int getFirstPlayer(List<Player> players) {
        return 0;
    }
    
}
