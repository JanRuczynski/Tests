package org.example;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
        validMoves = getValidMoves();
    }

    public Coordinates[] getValidMoves() {
        Coordinates[] validMoves = new Coordinates[8];

        validMoves[0] = getCoordinates().getOffset(-1, 2);
        validMoves[1] = getCoordinates().getOffset(1, 2);
        validMoves[2] = getCoordinates().getOffset(2, 1);
        validMoves[3] = getCoordinates().getOffset(2, -1);
        validMoves[4] = getCoordinates().getOffset(1, -2);
        validMoves[5] = getCoordinates().getOffset(-1, -2);
        validMoves[6] = getCoordinates().getOffset(-2, -1);
        validMoves[7] = getCoordinates().getOffset(-2, 1);

        return validMoves;
    }
}
