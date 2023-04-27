package org.example;

public class Pawn extends Piece{
    public boolean hasMoved = false;
    public Pawn(Color color) {
        super(color);
        validMoves = getValidMoves();
    }

    public Coordinates[] getValidMoves() {
        int numOfPossibleMoves = hasMoved ? 3 : 4;
        Coordinates[] validMoves = new Coordinates[numOfPossibleMoves];

        validMoves[0] = getCoordinates().getOffset(0, 1 * getDirModif());
        validMoves[1] = getCoordinates().getOffset(1, 1 * getDirModif());
        validMoves[2] = getCoordinates().getOffset(-1, 1 * getDirModif());

        if(!hasMoved) {
            validMoves[3] = getCoordinates().getOffset(0,2*getDirModif());
        }

        return validMoves;
    }
}
