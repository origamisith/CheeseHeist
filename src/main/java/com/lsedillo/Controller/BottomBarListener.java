package com.lsedillo.Controller;

import com.lsedillo.Model.Compass;
import com.lsedillo.Model.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomBarListener implements ActionListener, ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        int fps = source.getValue();
        if(fps==0) {
            Game.stop();
        }
        else {
            Game.setFps(fps);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        switch(button.getText()) {
            case "←" -> Game.mouse.setDirection(Compass.WEST);
            case "→" -> Game.mouse.setDirection(Compass.EAST);
            case "↑" -> Game.mouse.setDirection(Compass.NORTH);
            case "↓" -> Game.mouse.setDirection(Compass.SOUTH);
        }
        Game.keyPressed = true;
    }
}
