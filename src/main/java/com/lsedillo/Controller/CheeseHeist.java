package com.lsedillo.Controller;
import com.lsedillo.Model.*;
import com.lsedillo.View.*;

import java.awt.event.WindowEvent;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheeseHeist {
    public static RootFrame rootFrame;
    static Path mazePath;
    public static void main(String[] args) {
        File mazeFile;
        if(args.length == 0) mazePath = Paths.get("src/main/resources/defaultMaze.txt");
        else mazePath = Paths.get(args[0]);
        Game.parseFile(mazePath);
        rootFrame = new RootFrame();
    }

    public static void reset() {
        rootFrame.dispose();
        Game.parseFile(mazePath);
        rootFrame.removeAll();
        rootFrame.revalidate();
        rootFrame = new RootFrame();
        rootFrame.repaint();
        rootFrame.mazePanel.timer.restart();
    }
}
