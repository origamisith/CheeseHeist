package com.lsedillo.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Arrays;
import java.util.stream.IntStream;

import com.lsedillo.Controller.MazePanelListener;
import com.lsedillo.Model.*;

public class MazePanel extends JPanel{
    String gameState = "playing";
    JFrame rootFrame;
    public Timer timer;
    public  MazePanelListener listener;
    public MazePanel(JFrame rootFrame) {
        this.rootFrame = rootFrame;
        listener = new MazePanelListener(this);
        timer = new Timer(1000/Game.fps, listener);
        setPreferredSize(new Dimension(Maze.pixelWidth * 25, Maze.pixelWidth*15));
        //-------------------------------------//
        // If this code looks similar to Kittera's, I admit that I took inspiration from her code for this bit
        addAction(KeyEvent.VK_UP, Compass.NORTH);
        addAction(KeyEvent.VK_W, Compass.NORTH);
        addAction(KeyEvent.VK_RIGHT, Compass.EAST);
        addAction(KeyEvent.VK_D, Compass.EAST);
        addAction(KeyEvent.VK_DOWN, Compass.SOUTH);
        addAction(KeyEvent.VK_S, Compass.SOUTH);
        addAction(KeyEvent.VK_LEFT, Compass.WEST);
        addAction(KeyEvent.VK_A, Compass.WEST);
        //--------------------------------------//

        requestFocusInWindow();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        if(gameState.equals("lose")) {
            g2d.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
            g2d.drawString("You lost.", getWidth()/2-150, getHeight()/2);
            return;
        }
        if(gameState.equals("win")) {
            g2d.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
            g2d.drawString("YOU WON!!!", getWidth()/2-150, getHeight()/2);
            System.out.println("youuuu");
            return;
        }
        IntStream.range(1, 26)
                .forEach(x -> IntStream.range(1, 16)
                        .forEach(y -> {
                            GridLocation loc = new GridLocation(x,y);
                            Image cellImage = Game.maze.mazeArray[y-1][x-1].getImageIcon().getImage();
                            g2d.drawImage(cellImage, loc.getPixelX(), loc.getPixelY(), null);
                        }));

        Arrays.stream(Game.cheeses).filter(Cheese::isVisible).filter(c -> !c.isEaten()).forEach(cheese -> {
            g2d.drawImage(cheese.getImageIcon().getImage(), cheese.getLoc().getPixelX(), cheese.getLoc().getPixelY(), null);
        });
        Arrays.stream(Game.cats).forEach(cat -> {
            g2d.drawImage(cat.getImageIcon().getImage(), cat.getLoc().getPixelX(), cat.getLoc().getPixelY(), null);
        });
        g2d.drawImage(Game.mouse.getImageIcon().getImage(), Game.mouse.getLoc().getPixelX(), Game.mouse.getLoc().getPixelY(), null);
    }

    private void addAction(int keyStroke, Compass direction) {
        KeyStroke stroke = KeyStroke.getKeyStroke(keyStroke, 0, false);
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(stroke, keyStroke + "");
        AbstractAction a = new KeyAction(keyStroke + "", direction);
        getActionMap().put(keyStroke + "", a);
    }

    private class KeyAction extends AbstractAction {

        private Compass direction;
        public KeyAction(String key, Compass direction) {
            super(key);
            this.direction = direction;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Game.mouse.setDirection(direction);
            Game.mouse.sniffForCheese();
            Game.keyPressed = true;
        }
    }

    public void lose() {
        this.gameState = "lose";
        repaint();
    }
    public void win() {
        this.gameState = "win";
        repaint();
    }
}