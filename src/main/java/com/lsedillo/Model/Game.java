package com.lsedillo.Model;

import com.lsedillo.Controller.CheeseHeist;
import com.lsedillo.View.TopBar;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Game {
    public static Maze maze;
    public static Mouse mouse;
    public static Cat[] cats;
    public static Cheese[] cheeses;
    public static boolean keyPressed;
//    private static File mazeFile;
    private static Path mazePath;

    private static long nanosStart;
    private static long nanosElapsed;
//    private static TopBar topBar = CheeseHeist.rootFrame.topBar;

    public static void step() {
        CheeseHeist.rootFrame.topBar.updateStats();
    }
    public static void start() {

    }
    public static void stop() {
    }
    public static void reset() {

    }
    public static void parseFile(Path input) {
        Scanner mazeScanner;
        mazePath = input;
        try {
            maze = new Maze(mazePath);
            Stream<String> myLines = Files.lines(mazePath);
            ArrayList<String> list = (ArrayList<String>)myLines.collect(Collectors.toList());

            mouse = list.stream().filter(line-> line.startsWith("M"))
                    .map(line -> Arrays.stream(line.split(" "))
                            .filter(c -> !c.equals("M"))
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new))
                    .map(a -> new Mouse(new GridLocation(a[0], a[1]))).findFirst().get();
            cheeses = list.stream().filter(line-> line.startsWith("C"))
                    .map(line -> Arrays.stream(line.split(" "))
                            .filter(c -> !c.equals("C"))
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new))
                    .map(a -> new Cheese(new GridLocation(a[0], a[1]))).toArray(Cheese[]::new);
            cats = list.stream().filter(line-> Character.isDigit(line.charAt(0)))
                    .map(line -> Arrays.stream(line.split(" "))
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new))
                    .map(a -> {
                        GridLocation loc = new GridLocation(a[1], a[2]);
                        return switch(a[0]) {
                            case 1 -> new RandomCat(loc);
                            case 2 -> new RightCat(loc);
                            case 3 -> new VerticalCat(loc);
                            case 4 -> new HorizontalCat(loc);
                            case 5 -> new HomingCat(loc);
                            default -> new Cat(loc);
                        };
                    }).toArray(Cat[]::new);
            System.out.println(maze);
            System.out.println(mouse);
            System.out.println(Arrays.toString(cheeses));
            System.out.println(Arrays.toString(cats));
        } catch(FileNotFoundException e) {
            System.err.println("Maze File not found");
        } catch(IOException e) {
            System.err.println("IOException");
        }

        nanosStart = System.nanoTime();
    }

    public static long getNanosElapsed() {
        nanosElapsed = System.nanoTime() - nanosStart;
        return nanosElapsed;
    }

    public static String getTimeElapsed() {
        nanosElapsed = getNanosElapsed();
        long seconds = nanosElapsed / (1_000_000_000) % 60;
        long minutes = nanosElapsed / (1_000_000_000) / 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

}
