package com.lsedillo.View;

import com.lsedillo.Controller.BottomBarListener;
import com.lsedillo.Model.Game;

import javax.swing.*;
import java.awt.*;

public class BottomBar extends JPanel {
    JFrame rootFrame;
    BottomBarListener listener;
    public BottomBar(JFrame rootFrame) {
        super();
        this.rootFrame = rootFrame;
        this.listener = new BottomBarListener();
        setPreferredSize(new Dimension(48*25, 110));
        setLayout(new GridLayout(1,3));
        JPanel fpsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel fpsLabel = new JLabel("FPS");

        JSlider fpsSlider = new JSlider(JSlider.HORIZONTAL, Game.FPS_MIN, Game.FPS_MAX, Game.fps);
        fpsSlider.setMajorTickSpacing(4);
        fpsSlider.setMinorTickSpacing(1);
        fpsSlider.setPaintTicks(true);
        fpsSlider.setPaintLabels(true);
        fpsSlider.setSnapToTicks(true);
        fpsSlider.addChangeListener(listener);

        fpsPanel.add(fpsLabel);
        fpsPanel.add(fpsSlider);



        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 1;
        c.gridy = 0;
        JButton up = new JButton("↑");
        up.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        up.addActionListener(listener);
        btnPanel.add(up, c);
        c.gridx = 0;
        c.gridy++;
        JButton left = new JButton("←");
        left.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        left.addActionListener(listener);
        btnPanel.add(left, c);
        c.gridx++;
        JButton down = new JButton("↓");
        down.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        down.addActionListener(listener);
        btnPanel.add(down, c);
        c.gridx++;
        JButton right= new JButton("→");
        right.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        right.addActionListener(listener);
        btnPanel.add(right, c);


        add(new JPanel());
        add(fpsSlider, 1);
        add(btnPanel);
    }
}
