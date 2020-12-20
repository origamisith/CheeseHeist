package com.lsedillo.Model;

public class RandomCat extends Cat{
    public RandomCat(GridLocation loc) {
        super(loc);
        setDirection(Compass.NORTH);
    }
    public String toString() {
        return "Random Cat at " + getLoc();
    }
}
