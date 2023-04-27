package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinates {
    private int x;
    private int y;
    Coordinates(String chessCoords) {
        String regex = "([a-h])([1-8])";
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(chessCoords);
        if(mat.matches()) {
            y = getReversedNumbers(Integer.parseInt(mat.group(2)));
            x = getLetterOrdinal(mat.group(1)) - 1;
        }
    }
    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static String getNumberOrdinal(int input) {
        String output = "";
        if(input <= 26 && input >= 1) {
            output = String.valueOf(Letters.values()[input-1]);
        }
        return output;
    }
    public static int getReversedNumbers(int number) {
        int output = 0;
        if(number >= 1 && number <= 8) {
            output = 8 - number;
        }
        return output;
    }
    public static int getLetterOrdinal(String input) {
        int ordinal = 0;
        if(input.matches("[a-z]")) {
            ordinal = Letters.valueOf(input).ordinal() + 1;
        }
        return ordinal;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinates getOffset(int x, int y) {
        Coordinates outputCoords = new Coordinates(this.getX() + x, this.getY() + y);
        return outputCoords;
    }

}
