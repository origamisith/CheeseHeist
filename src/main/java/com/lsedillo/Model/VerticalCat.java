package com.lsedillo.Model;

public class VerticalCat extends Cat{
    public VerticalCat(GridLocation loc) {
        super(loc);
        setDirection(Compass.SOUTH);
    }
    public String toString() {
        return "Vertical Cat at " + getLoc();
    }
}
