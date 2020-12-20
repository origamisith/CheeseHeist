package com.lsedillo.Model;

import javax.swing.*;

public class HomingCat extends Cat{
    public HomingCat(GridLocation loc) {
        super(loc);
        setDirection(Compass.SOUTH);
    }

//    @Override
//    public ImageIcon getImageIcon() {
//        return null;
//    }

    @Override
    public void move() {

    }

    public String toString() {
        return "Homing Cat at " + getLoc();
    }
}
