package com.lsedillo.Model;

import javax.swing.*;
import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

public class Mouse extends Entity{

    private int cheesesEaten, livesLeft;

    private static ImageIcon imageIcon= new ImageIcon("src/main/resources/banditv3.png");

    public Mouse(GridLocation loc) {
        super(loc);
        cheesesEaten = 0;
        livesLeft = 3;
    }

    public boolean sniffForCheese() {
        boolean areCheeses;
        Stream<Cheese> cheeseStream = Arrays.stream(Game.cheeses)
                .filter(c -> c.getLoc().equals(getLoc()));
        areCheeses = cheeseStream.count() > 0;
        if(areCheeses) {
            cheeseStream.forEach((c)->{
                c.setEaten(true);
                cheesesEaten++;
            });
        }
        return areCheeses;

    }

    @Override
    public void respawn() {
        super.respawn();
        livesLeft--;
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
