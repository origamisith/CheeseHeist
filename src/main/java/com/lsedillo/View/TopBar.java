package com.lsedillo.View;

//import com.lsedillo.Controller.GameStats;
import com.lsedillo.Controller.TopBarListener;
import com.lsedillo.Model.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class TopBar extends JPanel {
    public RootFrame rootFrame;
    public JLabel timeElapsed;
    public JLabel livesLeft;
    public JLabel cheeseEaten;
    public JButton start, stop, step, reset;
    ActionListener listener;


    public TopBar(RootFrame rootFrame) {
        super();
        this.listener = new TopBarListener(this);
        this.rootFrame = rootFrame;
        setLayout(new GridLayout(1,3));
        timeElapsed = new JLabel("Time " + Game.getTimeElapsed());
        timeElapsed.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        timePanel.add(timeElapsed);

        start = new JButton("Start");
        stop= new JButton("Stop");
        step= new JButton("Step");
        reset= new JButton("Reset");

        cheeseEaten = new JLabel(Game.mouse.getCheesesEaten() + "");
        cheeseEaten.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        livesLeft = new JLabel(Game.mouse.getLivesLeft() + "");
        livesLeft.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        infoPanel.add(new JLabel(Game.mouse.getImageIcon()));
        infoPanel.add(livesLeft);
        //Not my proudest line of code
        infoPanel.add((new JPanel()).add(new JLabel("                    ")));
        infoPanel.add(new JLabel(Game.cheeses[0].getImageIcon()));
        infoPanel.add(cheeseEaten);

        start.addActionListener(listener);
        stop.addActionListener(listener);
        step.addActionListener(listener);
        reset.addActionListener(listener);
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(start);
        btnPanel.add(stop);
        btnPanel.add(step);
        btnPanel.add(reset);

//        JPanel cheese = new JLabel(Game.cheeses[0].getImageIcon());

        add(timePanel);
        add(btnPanel);
        add(infoPanel);
    }

    public void updateStats() {
        cheeseEaten.setText(Game.mouse.getCheesesEaten() + "");
        livesLeft.setText(Game.mouse.getLivesLeft() + "");
        timeElapsed.setText("Time " + Game.getTimeElapsed());
    }
}
