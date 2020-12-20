package com.lsedillo.Model;

import javax.swing.*;

public class MazeCell {
    private char cellType;
    public static final char BORDER = 'B';
    public static final char HOLE= 'H';
    public static final char PATH = 'P';
    public static final char GREEN = 'G';
    public MazeCell(char c) throws IllegalArgumentException{
        if(c != 'B' && c != 'H' && c != 'P' && c != 'G') throw new IllegalArgumentException(c + "not valid type");
        else cellType = c;

    }

    public char getCellType() {
        return cellType;
    }

    public ImageIcon getImageIcon() {
        String fileName ="";
        switch(cellType) {
            case BORDER -> fileName = "border.png";
            case HOLE -> fileName = "hole.png";
            case PATH-> fileName = "path.png";
            case GREEN-> fileName = "green.png";
        }
        return new ImageIcon("src/main/java/com/lsedillo/Model/" + fileName);
    }

    public String toString() {
        return cellType + "";
    }
}
