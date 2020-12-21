package com.lsedillo.Model;

public class HorizontalCat extends Cat{
    public HorizontalCat(GridLocation loc) {
        super(loc);
    }
    public String toString() {
        return "Horizontal Cat at " + getLoc();
    }


    public void move() {
       MazeCell m = Game.maze.getForwardCell(this);

       if(m.getCellType() != MazeCell.PATH) {
           setDirection(getDirection().turnDegrees(180));
       }
       else super.move();
    }

}
