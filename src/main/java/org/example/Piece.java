package org.example;

public class Piece {
    static int x = 0;
    static int y = 0;
    public final Color color;
    public Coordinates[] validMoves;

    public Piece(Color color) {
        this.color = color;
    }
    public void setCoordinates(Coordinates coords) {
        x = coords.getX();
        y = coords.getY();
    }
    public void setCoordinates(String chessCoords) {
        Coordinates coords = new Coordinates(chessCoords);
        x = coords.getX();
        y = coords.getY();
    }
    public int getDirModif() {
        if(this.color == Color.WHITE) {
            return -1;
        } else {
            return 1;
        }
    }

    public static int getY() {
        return y;
    }
    public static int getX() {
        return x;
    }
    public Coordinates getCoordinates() {
        return new Coordinates(this.x, this.y);
    }

    public Coordinates[] getValidMoves() {
        return validMoves;
    }
}
