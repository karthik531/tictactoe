package com.msvsk.games.strategy;

import java.util.List;

import com.msvsk.games.model.Board;
import com.msvsk.games.model.Player;

public interface WinnerStrategy 
{
    public int checkWinner(Board board, List<Player> players);
}
