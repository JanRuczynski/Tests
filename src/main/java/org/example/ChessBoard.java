package org.example;

public class ChessBoard {
    private Piece[][] internalBoard = new Piece[8][8];
    private Piece[] whiteCapturedPieces = new Piece[0];
    private Piece[] blackCapturedPieces = new Piece[0];

    public void add(Piece piece, String Coords) {
        Coordinates coords = new Coordinates(Coords);
        piece.setCoordinates(coords);
        internalBoard[coords.getX()][coords.getY()] = piece;
    }
    public Piece getPieceAtCoords(String chessCoords) {
        Coordinates coords = new Coordinates(chessCoords);
        return internalBoard[coords.getX()][coords.getY()];
    }

    public void move(Piece piece, String coords) {
        Coordinates oldCoords = piece.getCoordinates();
        Coordinates newCoords = new Coordinates(coords);
        if (isMoveFoundInArray(piece.getValidMoves(), newCoords)) {
            internalBoard[oldCoords.getX()][oldCoords.getY()] = null;
            add(piece, coords);
            piece.validMoves = piece.getValidMoves();
        }
    }

    public static boolean isMoveFoundInArray(Coordinates[] moves, Coordinates expectedMove) {
        for (Coordinates move : moves) {
            if (move.getX() == expectedMove.getX() && move.getY() == expectedMove.getY()) return true;
        }
        return false;
    }
}
