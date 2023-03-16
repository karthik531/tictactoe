package com.msvsk.games.gameloop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.msvsk.games.model.Board;
import com.msvsk.games.model.PieceO;
import com.msvsk.games.model.PieceX;
import com.msvsk.games.model.Player;
import com.msvsk.games.strategy.DefaultNextPlayerStrategy;
import com.msvsk.games.strategy.DefaultPickfirstPlayerStrategy;
import com.msvsk.games.strategy.DefaultWinnerStrategy;
import com.msvsk.games.strategy.NextPlayerStrategy;
import com.msvsk.games.strategy.PickFirstPlayerStrategy;
import com.msvsk.games.strategy.WinnerStrategy;

public class Gameplay 
{
    private List<Player> players;
    private Board board;
    private PickFirstPlayerStrategy firstPlayerStrategy;
    private WinnerStrategy winnerStrategy;
    private NextPlayerStrategy nextPlayerStrategy;

    public Gameplay(Board board, List<Player> players, PickFirstPlayerStrategy firstPlayerStrategy, WinnerStrategy winnerStrategy, NextPlayerStrategy nextPlayerStrategy) {
        this.board = board;
        this.players = players;
        this.firstPlayerStrategy = firstPlayerStrategy;
        this.winnerStrategy = winnerStrategy;
        this.nextPlayerStrategy = nextPlayerStrategy;
    }

    public void playGame() throws InterruptedException {

        Scanner scan = new Scanner(System.in);
        int curPlayer = firstPlayerStrategy.getFirstPlayer(players);
        System.out.println("Starting TicTacToe, please wait ...");
        Thread.sleep(3000);
        while(true) {
            // print the board
            board.print();

            // make a move
            System.out.print("\n\nPlayer " + players.get(curPlayer).getId() + "'s turn, pick a position: ");
            int x, y;
            do {
                x = scan.nextInt();
                y = scan.nextInt();
                if(board.pieceExists(x, y)) {
                    System.out.print("Location already used, please enter again: ");
                }
            }
            while(board.pieceExists(x, y));
            players.get(curPlayer).makeMove(board, x, y);

            // check winner
            int winningPlayer = winnerStrategy.checkWinner(board, players);
            if(winningPlayer != -1) {
                board.print();
                System.out.println("\n\n Player " + players.get(winningPlayer).getId() + " WON the game !!");
                board.clear();
                break;
            }

            // if no winner yet, pick next player
            curPlayer = nextPlayerStrategy.pickNextPlayer(players, curPlayer);
        }
        scan.close();
    }

    public static void main(String[] args) throws InterruptedException {

        Board board = new Board(3);
        
        Player player1 = new Player("Joel", new PieceX());
        Player player2 = new Player("Goel", new PieceO());
        List<Player> players = new ArrayList<>();
        players.add(player1); players.add(player2);
        
        PickFirstPlayerStrategy firstPlayerStrategy = new DefaultPickfirstPlayerStrategy();
        WinnerStrategy winnerStrategy = new DefaultWinnerStrategy();
        NextPlayerStrategy nextPlayerStrategy = new DefaultNextPlayerStrategy();

        // create gameplay object
        Gameplay gameplay = new Gameplay(board, players, firstPlayerStrategy, winnerStrategy, nextPlayerStrategy);
        gameplay.playGame();
    }
}
