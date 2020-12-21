package com.lsedillo.Model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Maze {
    private Path mazePath;
    public MazeCell[][] mazeArray;
    public static final int pixelWidth = 48;
    private int height, width;
    public Maze(Path path) throws IOException {
        this.mazePath = path;
//        mazeScanner.useDelimiter("");
        constructMaze();
    }

    private void constructMaze() throws IOException {
        height = 0;
        width = 0;
        AtomicInteger x = new AtomicInteger();
        AtomicInteger y = new AtomicInteger();
        mazeArray = Files.lines(mazePath)
                .filter(line -> line.length() == 25)
                .map(line-> line.chars().mapToObj(c -> new MazeCell((char) c, x.getAndIncrement()%25, y.getAndIncrement()/25)).toArray(MazeCell[]::new))
                        .toArray(MazeCell[][]::new);
    }

    public MazeCell getForwardCell(Entity e) {
        GridLocation loc = e.getLoc();
        int x = loc.getX()-1;
        int y = loc.getY()-1;

        return switch(e.getDirection()) {
            case EAST -> mazeArray[y][x+1];
            case WEST-> mazeArray[y][x-1];
            case NORTH-> mazeArray[y-1][x];
            case SOUTH-> mazeArray[y+1][x];
        };
    }
    public MazeCell getLeftCell(Entity e) {
        GridLocation loc = e.getLoc();
        int x = loc.getX()-1;
        int y = loc.getY()-1;
        return switch(e.getDirection()) {
            case EAST -> mazeArray[y-1][x];
            case WEST-> mazeArray[y+1][x];
            case NORTH-> mazeArray[y][x-1];
            case SOUTH-> mazeArray[y][x+1];
        };
    }
    public MazeCell getRightCell(Entity e) {
        GridLocation loc = e.getLoc();
        int x = loc.getX()-1;
        int y = loc.getY()-1;
        return switch(e.getDirection()) {
            case EAST -> mazeArray[y+1][x];
            case WEST-> mazeArray[y-1][x];
            case NORTH-> mazeArray[y][x+1];
            case SOUTH-> mazeArray[y][x-1];
        };
    }

    public MazeCell getBackwardCell(Entity e) {
        GridLocation loc = e.getLoc();
        int x = loc.getX()-1;
        int y = loc.getY()-1;
        return switch(e.getDirection()) {
            case EAST -> mazeArray[y][x-1];
            case WEST-> mazeArray[y][x+1];
            case NORTH-> mazeArray[y+1][x];
            case SOUTH-> mazeArray[y-1][x];
        };
    }

    public MazeCell[] getSurroundingCells(Entity e) {
        return new MazeCell[] {getForwardCell(e), getRightCell(e), getBackwardCell(e), getLeftCell(e)};
    }

    public MazeCell[] getSurroundingCells(MazeCell m) {
        return new MazeCell[] {mazeArray[m.y][m.x +1], mazeArray[m.y][m.x-1], mazeArray[m.y+1][m.x], mazeArray[m.y-1][m.x]};
    }
    public String toString() {
        return "Maze Grid representation \n"
                + Arrays.deepToString(mazeArray)
                .replace("], [", "\n")
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
    }
}
