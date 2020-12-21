package com.lsedillo.Model;

import javax.swing.*;

public class MazeCell implements Comparable{
    private final char cellType;
    public static final char BORDER = 'B';
    public static final char HOLE= 'H';
    public static final char PATH = 'P';
    public static final char GREEN = 'G';
    public static final ImageIcon wallIcon = new ImageIcon("src/main/resources/wall.png");
    public static final ImageIcon holeIcon = new ImageIcon("src/main/resources/hole.png");
    public static final ImageIcon pathIcon = new ImageIcon("src/main/resources/path.png");
    public static final ImageIcon greenIcon = new ImageIcon("src/main/resources/green.png");
    public int x, y;


    public MazeCell previous;
    public int traveled;
    private int heuristic;
    private int f;

    public MazeCell(char c) throws IllegalArgumentException{
        if(c != 'B' && c != 'H' && c != 'P' && c != 'G') throw new IllegalArgumentException(c + "not valid type");
        else cellType = c;
    }

    public MazeCell(char c, int x, int y) {
        this(c);
        this.x = x;
        this.y =y;
    }

    public char getCellType() {
        return cellType;
    }

    public ImageIcon getImageIcon() {
        String fileName ="";
        return switch(cellType) {
            case BORDER -> wallIcon;
            case HOLE -> holeIcon;
            case PATH-> pathIcon;
            case GREEN-> greenIcon;
            default -> null;
        };
    }

    public int heuristic() {
        int mouseX = Game.mouse.getLoc().getX();
        int mouseY = Game.mouse.getLoc().getY();
        int cellX = x+1;
        int cellY = y+1;

        int deltaX = Math.abs(cellX - mouseX);
        int deltaY = Math.abs(cellY- mouseY);

        heuristic = deltaX + deltaY;
        if(getCellType() == HOLE) heuristic += 20;
        return heuristic;
    }


    public int f() {
        f = traveled + heuristic();
        return f;
    }

    public int compareTo(Object other) {
        return this.f()-((MazeCell)other).f();
    }

    public String toString() {
        return cellType + " (" + x + ", " + y + ")";
//        return cellType + "";
    }
}
