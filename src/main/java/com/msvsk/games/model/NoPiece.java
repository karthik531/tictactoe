package com.msvsk.games.model;

public class NoPiece extends Piece
{
    private char piece;

    public NoPiece() {
        this.piece = ' ';
    }

    @Override
    char getPieceChar() {
        return piece;
    }
}
