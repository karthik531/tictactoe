package com.msvsk.games.model;

import java.util.Arrays;

public class Board 
{
    private int dimension;

    private Piece[][] pieces;

    public Board(int dimension) {
        this.dimension = dimension;
        pieces = new Piece[dimension][dimension];
        for(int i = 0; i < dimension; i++) {
            Arrays.fill(pieces[i], new NoPiece());
        }
    }

    public void setPiece(int x, int y, Piece piece) {
        if(pieceExists(x, y)) {
            System.out.println("Piece already exists in this location, cannot place another");
            return;
        }
        pieces[x][y] = piece;
    }

    public boolean pieceExists(int x, int y) {
        return (!pieces[x][y].equals(new NoPiece()));
    }

    public Piece getPiece(int x, int y) {
        return pieces[x][y];
    }

    public int getDimension() {
        return dimension;
    }

    public void clear() {
        for(int i = 0; i < dimension; i++) {
            Arrays.fill(pieces[i], new NoPiece());
        }
    }

    public void print() {
        for(int i = 0; i < getDimension(); i++) {
            for(int j = 0; j < getDimension(); j++) {
                if(!pieceExists(i, j)) {
                    System.out.print("    ");
                }
                else {
                    System.out.print("  " + pieces[i][j].getPieceChar() + " ");
                }
                if(j < getDimension()-1) {
                    System.out.print("|");
                }
            }
            if(i < getDimension()-1)
                System.out.println("\n---------------");
        }
    }
}
