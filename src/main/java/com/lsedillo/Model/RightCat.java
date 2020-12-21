package com.lsedillo.Model;

public class RightCat extends Cat{
    public RightCat(GridLocation loc) {
        super(loc);
        setDirection(Compass.EAST);
    }

    @Override
    public void move() {
        MazeCell f = Game.maze.getForwardCell(this);
        MazeCell l = Game.maze.getLeftCell(this);
        MazeCell r = Game.maze.getRightCell(this);

        if(f.getCellType() != MazeCell.PATH) {
            MazeCell currentFront = f;
            do {
                setDirection(getDirection().turnDegrees(90));
                currentFront = Game.maze.getForwardCell(this);
            } while(currentFront.getCellType()!= MazeCell.PATH);
        }

        else if(r.getCellType() == MazeCell.PATH) {
            setDirection(getDirection().turnDegrees(90));
        }
        super.move();
    }

    public String toString() {
        return "Right Cat at " + getLoc();
    }
}
