package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTest {
    @Test
    public void pawnCanMoveOneForward() {
        Pawn pawn = new Pawn(Color.WHITE);
        pawn.hasMoved = true;
        pawn.setCoordinates("a2");
        Coordinates[] validMoves = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a3");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }

    @Test
    public void pawnCanMoveTwoForwardOnFirstMove() {
        Pawn pawn = new Pawn(Color.WHITE);
        pawn.setCoordinates("a2");
        Coordinates[] validMoves = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a4");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }
    @Test
    public void canNotMoveTwoAfterFirstMove() {
        Pawn pawn = new Pawn(Color.WHITE);
        pawn.hasMoved = true;
        pawn.setCoordinates("a2");
        Coordinates[] validMoves = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a4");
        assertFalse(isMoveFoundInArray(validMoves, expectedDestination));
    }
    @Test
    public void canMoveOneDiagonallyRight() {
        Pawn pawn = new Pawn(Color.WHITE);
        pawn.setCoordinates("a2");
        Coordinates[] validMoves = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("b3");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }
    @Test
    public void canMoveOneDiagonallyLeft() {
        Pawn pawn = new Pawn(Color.WHITE);
        pawn.setCoordinates("a2");
        Coordinates[] validMoves = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("b3");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }
    @Test
    public void blackPawnCanMoveOneForward() {
        Pawn pawn = new Pawn(Color.BLACK);
        pawn.hasMoved = true;
        pawn.setCoordinates("a7");
        Coordinates[] validMoves = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a6");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }
    @Test
    public void blackPawnCanMoveTwoForward() {
        Pawn pawn = new Pawn(Color.BLACK);
        pawn.setCoordinates("a7");
        Coordinates[] validMoves = pawn.getValidMoves();
        Coordinates expectedDestination = new Coordinates("a5");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }

    @Test
    public void knightCanMoveNorthEast() {
        Knight knight = new Knight(Color.WHITE);
        knight.setCoordinates("c1");
        Coordinates[] validMoves = knight.getValidMoves();
        Coordinates expectedDestination = new Coordinates("d3");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }

    @Test
    public void knightCanMoveNorthWest() {
        Knight knight = new Knight(Color.WHITE);
        knight.setCoordinates("c1");
        Coordinates[] validMoves = knight.getValidMoves();
        Coordinates expectedDestination = new Coordinates("b3");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }

    @Test
    public void knightCanMoveEastNorth() {
        Knight knight = new Knight(Color.WHITE);
        knight.setCoordinates("c1");
        Coordinates[] validMoves = knight.getValidMoves();
        Coordinates expectedDestination = new Coordinates("e2");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }

    @Test
    public void knightCanMoveEastSouth() {
        Knight knight = new Knight(Color.WHITE);
        knight.setCoordinates("c3");
        Coordinates[] validMoves = knight.getValidMoves();
        Coordinates expectedDestination = new Coordinates("e2");
        assertTrue(isMoveFoundInArray(validMoves, expectedDestination));
    }

    public static boolean isMoveFoundInArray(Coordinates[] moves, Coordinates expectedMove) {
        for(int x=0; x< moves.length; x++) {
            if(moves[x].getX() == expectedMove.getX() && moves[x].getY() == expectedMove.getY()) return true;
        }
        return false;
    }
}
