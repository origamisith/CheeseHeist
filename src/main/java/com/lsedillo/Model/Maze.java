package com.lsedillo.Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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
        mazeArray = Files.lines(mazePath)
                .filter(line -> line.length() == 25)
                .map(line-> line.chars().mapToObj(c -> new MazeCell((char) c)).toArray(MazeCell[]::new))
                        .toArray(MazeCell[][]::new);
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
