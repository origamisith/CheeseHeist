package com.lsedillo.Model;

public class VerticalCat extends Cat{
    public VerticalCat(GridLocation loc) {
        super(loc);
        setDirection(Compass.SOUTH);
    }

    @Override
    public void move() {
        MazeCell m = Game.maze.getForwardCell(this);
        if(m.getCellType() != MazeCell.PATH) {
            setDirection(getDirection().turnDegrees(180));
        }
        else super.move();
    }

    public String toString() {
        return "Vertical Cat at " + getLoc();
    }
}
