package com.lsedillo.Model;

public class HorizontalCat extends Cat{
    public HorizontalCat(GridLocation loc) {
        super(loc);
    }
    public String toString() {
        return "Horizontal Cat at " + getLoc();
    }

    @Override
    public Compass getDirection() {
        return Compass.WEST;
    }
}
