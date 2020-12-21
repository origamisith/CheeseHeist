package com.lsedillo.Model;

public class GridLocation {
    private int x;
    private int y;
    private int pixelX;
    private int pixelY;
    private char mazeCellType;
    public GridLocation(int x, int y) {
        this.x = x;
        this.y = y;
        pixelX = calculatePixels(x);
        pixelY = calculatePixels(y);
        mazeCellType = Game.maze.mazeArray[y-1][x-1].getCellType();
    }

    private int calculatePixels(int gridPos) {
        return (gridPos-1)*Maze.pixelWidth;
    }

    public GridLocation transpose(int deltaX, int deltaY) {
        return new GridLocation(x + deltaX, y + deltaY);
    }
    public boolean equals(GridLocation other) {
        return this.x == other.x && this.y == other.y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        pixelX = calculatePixels(x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        pixelY = calculatePixels(x);
    }

    public int getPixelX() {
        return pixelX;
    }

    public int getPixelY() {
        return pixelY;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
