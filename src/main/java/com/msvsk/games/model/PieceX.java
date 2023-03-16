package com.msvsk.games.model;

public class PieceX extends Piece
{
    private char piece;

    public PieceX() {
        piece = 'X';
    }

    @Override
    public char getPieceChar() {
        return piece;
    }
}
