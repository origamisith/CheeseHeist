package com.lsedillo.Model;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mouse extends Entity{

    private int cheesesEaten, livesLeft;

    private static ImageIcon imageIcon= new ImageIcon("src/main/resources/banditv3.png");

    public Mouse(GridLocation loc) {
        super(loc);
        cheesesEaten = 0;
        livesLeft = 3;
    }

    @Override
    public void move() {
        MazeCell f = Game.maze.getForwardCell(this);
        if(f.getCellType() == MazeCell.PATH || f.getCellType() == MazeCell.HOLE)super.move();
    }
//    public void checkForCats() {
//        if(Arrays.stream(Game.cats).map(Cat::getLoc).anyMatch(loc -> loc.equals(getLoc()))) {
//            respawn();
//        }
//    }

    public boolean sniffForCheese() {
        boolean areCheeses;
        Stream<Cheese> cheeseStream = Arrays.stream(Game.cheeses)
                .filter(c -> c.getLoc().equals(getLoc()) && !c.isEaten() && c.isVisible());
        ArrayList<Cheese> list = (ArrayList<Cheese>)cheeseStream.collect(Collectors.toList());
        areCheeses = list.size() > 0;
        if(areCheeses) {
            list.forEach((c)->{
                c.setEaten(true);
                cheesesEaten++;
            });
        }
        if(cheesesEaten >= 3) Game.win();
        return areCheeses;

    }

//    public void move() {
//
//    }

    @Override
    public void respawn() {
        super.respawn();
        livesLeft--;
        if(livesLeft <= 0) Game.lose();
    }

    @Override
    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public String toString() {
        return "Mouse at " + getLoc().toString();
    }

    public int getCheesesEaten() {
        return cheesesEaten;
    }

    public int getLivesLeft() {
        return livesLeft;
    }
}
