package com.lsedillo.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.stream.IntStream;

import com.lsedillo.Controller.MazePanelListener;
import com.lsedillo.Model.Game;
import com.lsedillo.Model.GridLocation;
import com.lsedillo.Model.Maze;
import com.lsedillo.Model.MazeCell;

public class MazePanel extends JPanel{
    JFrame rootFrame;
    public Timer timer;
    ActionListener listener;
    public MazePanel(JFrame rootFrame) {
        this.rootFrame = rootFrame;
        listener = new MazePanelListener(this);
        timer = new Timer(1000, listener);
        setPreferredSize(new Dimension(Maze.pixelWidth * 25, Maze.pixelWidth*15));
    }


    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        IntStream.range(1, 26)
                .forEach(x -> IntStream.range(1, 16)
                        .forEach(y -> {
                            GridLocation loc = new GridLocation(x,y);
                            String path = "src/main/resources/";
                            path += switch(Game.maze.mazeArray[y-1][x-1].getCellType()) {
                                case MazeCell.BORDER -> "wall.png";
                                case MazeCell.GREEN -> "green.png";
                                case MazeCell.HOLE-> "hole.png";
                                case MazeCell.PATH -> "path.png";
                                default -> Color.WHITE;
                            };
                            ImageIcon cellIcon = new ImageIcon(path);
                            g2d.drawImage(cellIcon.getImage(), loc.getPixelX(), loc.getPixelY(), null);
                        }));

        Arrays.stream(Game.cheeses).forEach(cheese -> {


            g2d.drawImage(cheese.getImageIcon().getImage(), cheese.getLoc().getPixelX(), cheese.getLoc().getPixelY(), null);
            System.out.println(cheese.getLoc().getPixelX());
        });
        Arrays.stream(Game.cats).forEach(cat -> {

            g2d.drawImage(cat.getImageIcon().getImage(), cat.getLoc().getPixelX(), cat.getLoc().getPixelY(), null);
            System.out.println(cat.getLoc().getPixelX());
        });
//        g2d.drawImage(Game.cheeses[2].getImageIcon().getImage(), 48*10, 48*10, null);
        g2d.drawImage(Game.mouse.getImageIcon().getImage(), Game.mouse.getLoc().getPixelX(), Game.mouse.getLoc().getPixelY(), null);




    }
}