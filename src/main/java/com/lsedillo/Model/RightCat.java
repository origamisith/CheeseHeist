package com.lsedillo.Model;

public class RightCat extends Cat{
    public RightCat(GridLocation loc) {
        super(loc);
        setDirection(Compass.EAST);
    }
    public String toString() {
        return "Right Cat at " + getLoc();
    }
}
