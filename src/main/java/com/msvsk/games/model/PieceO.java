package com.msvsk.games.model;

public class PieceO extends Piece
{
    private char piece;

    public PieceO() {
        piece = 'O';
    }

    @Override
    public char getPieceChar() {
        return piece;
    }
}
