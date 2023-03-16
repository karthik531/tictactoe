package com.msvsk.games.strategy;

import java.util.List;

import com.msvsk.games.model.Board;
import com.msvsk.games.model.NoPiece;
import com.msvsk.games.model.Player;
import com.msvsk.games.model.Piece;

public class DefaultWinnerStrategy implements WinnerStrategy
{
    @Override
    public int checkWinner(Board board, List<Player> players) {
        
        // check rows
        for(int i = 0; i < board.getDimension(); i++) {
            if(checkRow(board, i)) {
                return getPlayerForPiece(players, board.getPiece(i, 0));
            }
        }

        // check cols
        for(int i = 0; i < board.getDimension(); i++) {
            if(checkCol(board, i)) {
                return getPlayerForPiece(players, board.getPiece(0, i));
            }
        }

        // check diagonals
        for(int i = 0; i < board.getDimension(); i++) {
            if(checkDiagonals(board)) {
                return getPlayerForPiece(players, board.getPiece(i, 0));
            }
        }

        // no winner
        return -1;
    }
    
    public boolean checkRow(Board board, int row) {
        Piece piece = board.getPiece(row, 0);
        for(int i = 1; i < board.getDimension(); i++) {
            if(piece.equals(new NoPiece()) || !piece.equals(board.getPiece(row, i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(Board board, int col) {
        Piece piece = board.getPiece(0, col);
        for(int i = 1; i < board.getDimension(); i++) {
            if(piece.equals(new NoPiece()) || !piece.equals(board.getPiece(i, col))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkDiagonals(Board board) {
        // check symmetric diagonal
        boolean isDiagonalSame = true;
        Piece piece = board.getPiece(0, 0);
        for(int i = 1; i < board.getDimension(); i++) {
            if(piece.equals(new NoPiece()) || !piece.equals(board.getPiece(i, i))) {
                isDiagonalSame = false;
                break;
            }
        }
        if(isDiagonalSame) return true;

        // check asymmetric diagonal
        int n = board.getDimension()-1;
        piece = board.getPiece(0, n);
        for(int i = 1; i < board.getDimension(); i++) {
            if(piece.equals(new NoPiece()) || !piece.equals(board.getPiece(i, n-i))) {
                return false;
            }
        }
        return true;
    }

    public int getPlayerForPiece(List<Player> players, Piece piece) {
        int count = 0;
        for(Player player : players) {
            if(player.getPiece().equals(piece)) {
                return count;
            }
            count++;
        }
        throw new RuntimeException("No player exists for the piece " + piece);
    }
}
