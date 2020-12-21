package com.lsedillo.Controller;

import com.lsedillo.Model.*;
import com.lsedillo.View.MazePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class MazePanelListener implements ActionListener {

    MazePanel parent;
    public MazePanelListener(MazePanel parent){
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.requestFocusInWindow();
        if(e.getSource().equals(parent.timer)) {
            Game.step();
            targetedRepaint();
        }
        else {
            JButton btn = (JButton)e.getSource();

        }
    }
    public void targetedRepaint() {
        GridLocation mouseLoc = Game.mouse.getLoc();
        int w = Maze.pixelWidth;
//        if(Game.keyPressed) {
//            parent.repaint(mouseLoc.getPixelX() - w, mouseLoc.getPixelY() - w, 3 * w, 3 * w);
//        }
////        /*
//        Arrays.stream(Game.cheeses)
//                .filter(Cheese::isVisible)
//                .map(Cheese::getLoc)
//                .forEach(loc -> {
//                    parent.repaint(loc.getPixelX(), loc.getPixelY(), w,w);
//                });
//        Arrays.stream(Game.cats).map(Cat::getLoc).forEach(loc -> {
//            parent.repaint(loc.getPixelX(), loc.getPixelY(), w,w);
//        });
        parent.repaint();
    }
}
