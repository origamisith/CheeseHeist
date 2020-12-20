package com.lsedillo.Controller;

import com.lsedillo.Model.Game;
import com.lsedillo.View.TopBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopBarListener implements ActionListener {

    TopBar parent;
    public TopBarListener(TopBar parent) {
        super();
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton)e.getSource();
        if(source.equals(parent.start)) {
            Game.start();
        }
        else if(source.equals(parent.stop)) {
            Game.stop();

        }
        else if(source.equals(parent.step)) {
            Game.step();
        }
        else {
            Game.reset();
        }
    }
}
