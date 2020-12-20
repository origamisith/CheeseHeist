package com.lsedillo.Controller;

import com.lsedillo.View.MazePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazePanelListener implements ActionListener {

    MazePanel parent;
    public MazePanelListener(MazePanel parent){
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        parent.repaint();
    }
}
