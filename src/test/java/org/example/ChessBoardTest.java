package org.example;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ChessBoardTest {

    @Test
    public void canAddPawn() {
        ChessBoard board = new ChessBoard();
        Pawn pawn = new Pawn(Color.WHITE);
        board.add(pawn,"a2");
        Pawn foundPawn = (Pawn) board.getPieceAtCoords("a2");
        assertEquals(pawn, foundPawn);
    }
    @Test
    public void canAddKnight() {
        ChessBoard board = new ChessBoard();
        Knight knight = new Knight(Color.WHITE);
        board.add(knight, "c7");
        Knight foundKnight = (Knight) board.getPieceAtCoords("c7");
        assertEquals(knight, foundKnight);
    }

    @Test
    public void canMoveC1KnightToD3() {
        ChessBoard board = new ChessBoard();
        Knight knight = new Knight(Color.WHITE);
        board.add(knight, "c1");
        assertEquals(knight, board.getPieceAtCoords("c1"), "Knight should initially be at c1");

        board.move(knight, "d3");

        assertNull(board.getPieceAtCoords("c1"), "After move, knight should no longer be at c1");
        assertEquals(knight, board.getPieceAtCoords("d3"), "Knight should now be at d3");
    }

    @Test()
    public void canNotMoveC1KnightToInvalidSquare() {
        ChessBoard board = new ChessBoard();
        Knight knight = new Knight(Color.WHITE);
        board.add(knight, "c1");
        assertEquals(knight, board.getPieceAtCoords("c1"), "Knight should initially be at c1");

        board.move(knight, "d4");

        assertNull(board.getPieceAtCoords("d4"), "After move, Knight should not be at d4");
        assertEquals(knight, board.getPieceAtCoords("c1"), "Knight should still be at c1");
    }
}
