package com.msvsk.games.model;

public class Player 
{
    private String id;
    private Piece piece;

    public Player(String id, Piece piece) {
        this.id = id;
        this.piece = piece;
    }

    public String getId() {
        return id;
    }

    public Piece getPiece() {
        return piece;
    }

    public void makeMove(Board board, int x, int y) {
        board.setPiece(x, y, piece);
    }
}
