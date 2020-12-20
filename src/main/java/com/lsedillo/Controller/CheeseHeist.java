package com.lsedillo.Controller;
import com.lsedillo.Model.*;
import com.lsedillo.View.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheeseHeist {
    public static RootFrame rootFrame;
    public static void main(String[] args) {
        File mazeFile;
        Path mazePath;
        if(args.length == 0) mazePath = Paths.get("src/main/resources/defaultMaze.txt");
        else mazePath = Paths.get(args[0]);
        Game.parseFile(mazePath);
        rootFrame = new RootFrame();
    }
}
