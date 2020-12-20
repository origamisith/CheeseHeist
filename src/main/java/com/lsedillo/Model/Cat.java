package com.lsedillo.Model;

import javax.swing.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class Cat extends Entity{
    public Cat(GridLocation loc) {
        super(loc);
    }

    public boolean sniffForMouse() {
        boolean isMouse = Game.mouse.getLoc().equals(getLoc());
        if(isMouse) Game.mouse.respawn();
        return isMouse;
    }

    public boolean sniffForCheese() {
        boolean areCheeses;
        Stream<Cheese> cheeseStream = Arrays.stream(Game.cheeses)
                .filter(c -> c.getLoc().equals(getLoc()));
        areCheeses = cheeseStream.count() > 0;
        if(areCheeses) {
            cheeseStream.forEach((c)->c.setVisible(false));
        }
        return areCheeses;

    }

    public String toString() {
        return "Nonfunctional Cat at " + getLoc().toString();
    }

    @Override
    public ImageIcon getImageIcon() {
        String path = "src/main/resources/";
        path += switch(getDirection()) {
            case WEST -> "westcat.png";
            case EAST-> "eastcat.png";
            case NORTH-> "northcat.png";
            case SOUTH ->"southcat.png";
        };
        return new ImageIcon(path);
//        if(getDirection() == Compass.WEST || getDirection() == Compass.EAST) {
//            return new ImageIcon("src/main/java/com/lsedillo/Model/cat.png");
//        } else{
//            return new ImageIcon("src/main/java/com/lsedillo/Model/catvertical.png");
//        }
    }
}
