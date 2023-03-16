package com.msvsk.games.model;

public abstract class Piece 
{
    abstract char getPieceChar();

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Piece) {
            Piece otherPiece = (Piece) obj;
            return (this.getPieceChar() == otherPiece.getPieceChar());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return String.valueOf(this.getPieceChar()).hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(getPieceChar());
    }
}
