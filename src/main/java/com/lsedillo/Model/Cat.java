package com.lsedillo.Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cat extends Entity{
    public Cat(GridLocation loc) {
        super(loc);
    }

    public boolean sniffForMouse() {
        boolean isMouse = Game.mouse.getLoc().equals(getLoc());
        if(isMouse) {
            Game.mouse.respawn();
            Game.cats[4].respawn();
        }
        return isMouse;
    }

    public boolean sniffForCheese() {
        boolean areCheeses;
        Stream<Cheese> cheeseStream = Arrays.stream(Game.cheeses)
                .filter(c -> c.getLoc().equals(getLoc()));
        ArrayList<Cheese> list= (ArrayList<Cheese>)(cheeseStream.collect(Collectors.toList()));
        areCheeses = list.size() > 0;
        if(areCheeses) {
            list.forEach((c)->c.setVisible(false));
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
