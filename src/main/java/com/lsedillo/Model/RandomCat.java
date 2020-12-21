package com.lsedillo.Model;

import java.util.Random;

public class RandomCat extends Cat{
    public RandomCat(GridLocation loc) {
        super(loc);
        setDirection(Compass.NORTH);
    }

    @Override
    public void move() {
        MazeCell f = Game.maze.getForwardCell(this);
        MazeCell l = Game.maze.getLeftCell(this);
        MazeCell r = Game.maze.getRightCell(this);

        if(f.getCellType() != MazeCell.PATH) {
            Random rand = new Random();
            int degrees = (rand.nextInt(4) + 1) * 90;
            setDirection(Compass.NORTH.getByDegrees(degrees));
        }

        else if(l.getCellType() == MazeCell.PATH || r.getCellType() == MazeCell.PATH) {
            MazeCell currentFront = f;
            do {
                Random rand = new Random();
                int degrees = (rand.nextInt(4) + 1) * 90;
                setDirection(Compass.NORTH.getByDegrees(degrees));
                currentFront = Game.maze.getForwardCell(this);
            } while(currentFront.getCellType() != MazeCell.PATH);
            super.move();
        }

        else super.move();
    }

    public String toString() {
        return "Random Cat at " + getLoc();
    }
}
