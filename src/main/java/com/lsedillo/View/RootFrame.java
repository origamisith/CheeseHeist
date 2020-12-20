package com.lsedillo.View;

import com.lsedillo.Model.Game;
import com.lsedillo.Model.Maze;

import javax.swing.*;
import java.awt.*;

public class RootFrame extends JFrame {
    BottomBar bottomBar;
    MazePanel mazePanel;
    public TopBar topBar;
    public RootFrame() {
        super();
        setTitle("Cheese Heist");
        bottomBar = new BottomBar(this);
        mazePanel = new MazePanel(this);
        topBar = new TopBar(this);
        add(bottomBar, BorderLayout.SOUTH);
        add(mazePanel);
        add(topBar, BorderLayout.NORTH);
        setLocationByPlatform(true);
        pack();
        setVisible(true);
    }

    @Override
    public void setVisible(boolean b) {
        setLocationRelativeTo(null);
        int width = Maze.pixelWidth;
        setPreferredSize(new Dimension(width*25+ 100, width*15+150));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(b);
    }
}
