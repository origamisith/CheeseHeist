package com.lsedillo.View;

import com.lsedillo.Model.Game;
import com.lsedillo.Model.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RootFrame extends JFrame {
    public BottomBar bottomBar;
    public MazePanel mazePanel;
    public TopBar topBar;
    public RootFrame() {
        super();
        setTitle("Cheese Heist");
        bottomBar = new BottomBar(this);
        mazePanel = new MazePanel(this);
        topBar = new TopBar(this);
        JPanel glass = (JPanel)getGlassPane();
        glass.setPreferredSize(new Dimension(Maze.pixelWidth*25+100, Maze.pixelWidth*15+350));
        glass.setVisible(true);
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
        setPreferredSize(new Dimension(width*25+ 100, width*15+350));
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(b);
    }
}
