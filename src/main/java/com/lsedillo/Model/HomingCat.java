package com.lsedillo.Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class HomingCat extends Cat{
    MazeCell oldCell;
    public HomingCat(GridLocation loc) {
        super(loc);
        setDirection(Compass.SOUTH);
    }


//    @Override
//    public void move() {
//        int mouseX = Game.mouse.getLoc().getX();
//        int mouseY = Game.mouse.getLoc().getY();
//
////        int deltaX = getLoc().getX() - mouseX;
////        int deltaY = getLoc().getY() - mouseY;
//
//        Compass direction;
//        MazeCell[] surrounding = Game.maze.getSurroundingCells(this);
//        MazeCell c = Arrays.stream(surrounding).filter(cell -> cell.getCellType() == MazeCell.PATH).sorted().findFirst().get();
//        if(c.equals(oldCell)) return;
//        System.out.println(c);
//
//        int deltaX = c.x+1-getLoc().getX();
//        int deltaY = c.y+1-getLoc().getY();
//        Compass tempDirection = Compass.NORTH;
//        if(deltaX == 1) tempDirection = (Compass.EAST);
//        else if(deltaX == -1) tempDirection = (Compass.WEST);
//        else if(deltaY == -1) tempDirection = (Compass.NORTH);
//        else if(deltaY == 1) tempDirection = Compass.SOUTH;
//
//        setDirection(tempDirection);
//
//        super.move();
//
//        oldCell = c;
//    }

    @Override
    public void move() {
        int mouseX = Game.mouse.getLoc().getX()-1;
        int mouseY = Game.mouse.getLoc().getY()-1;


        MazeCell destination = Game.maze.mazeArray[mouseY][mouseX];
        MazeCell initial = Game.maze.mazeArray[getLoc().getY() - 1][getLoc().getX() - 1];
        initial.traveled = 0;

        MazeCell current = initial;
        current.previous = null;
        ArrayList<MazeCell> open = new ArrayList();
        open.add(current);
        ArrayList<MazeCell> closed = new ArrayList();

        while(!current.equals(destination)) {
            MazeCell finalCurrent = current;
            ArrayList<MazeCell> neighbors = (ArrayList<MazeCell>)Arrays.stream(Game.maze.getSurroundingCells(current))
                    .filter(cell -> cell.getCellType()== MazeCell.PATH || cell.getCellType() == MazeCell.HOLE).collect(Collectors.toList());
            neighbors.forEach(cell -> {
                if(!open.contains(cell)&& !closed.contains(cell)) {
                    open.add(cell);
                    cell.previous = finalCurrent;
                    cell.traveled = finalCurrent.traveled+1;
                }
                else if(open.contains(cell)) {
                    if(cell.traveled > finalCurrent.traveled) {
                        cell.traveled = finalCurrent.traveled;
                        cell.previous = finalCurrent;
                    }
                }
            });

            open.remove(current);
            closed.add(current);

            current = open.stream().sorted().findFirst().get();
        }

        ArrayList<MazeCell> path = new ArrayList();
        int i = 0;
        while(current != null){
            path.add(0, current);
            current = current.previous;
            i++;
            if(i > 50) break;
        }
        if(path.size() <=1) return;
        int x1 = initial.x;
        int y1 = initial.y;
        int x2 = path.get(1).x;
        int y2 = path.get(1).y;
        if(x2-x1 < 0) setDirection(Compass.WEST);
        if(x2-x1 > 0) setDirection(Compass.EAST);
        if(y2-y1 < 0) setDirection(Compass.NORTH);
        if(y2-y1 > 0) setDirection(Compass.SOUTH);
        if(path.get(1).getCellType() != MazeCell.HOLE) super.move();
    }
    public String toString() {
        return "Homing Cat at " + getLoc();
    }
}
