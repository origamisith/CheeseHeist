package com.lsedillo.Model;

import javax.swing.*;

public abstract class Entity implements Movable{
    private Compass direction;
    private GridLocation loc;
    private GridLocation spawnLoc;

    public Entity(GridLocation loc) {
        this.loc = loc;
        this.spawnLoc = loc;
        this.direction = Compass.WEST;

    }
    public Entity() {
        this(new GridLocation(0,0));
    }

    public abstract ImageIcon getImageIcon();

    public void respawn() {
        loc = spawnLoc;
    }

    @Override
    public void move() {
        switch(direction) {
            case EAST -> setLoc(new GridLocation(getLoc().getX() + 1, getLoc().getY()));
            case WEST-> setLoc(new GridLocation(getLoc().getX() - 1, getLoc().getY()));
            case NORTH-> setLoc(new GridLocation(getLoc().getX(), getLoc().getY() - 1));
            case SOUTH-> setLoc(new GridLocation(getLoc().getX(), getLoc().getY()+1));
        }
    }

    public Compass getDirection() {
        return direction;
    }

    public void setDirection(Compass direction) {
        this.direction = direction;
    }

    public GridLocation getLoc() {
        return loc;
    }

    public void setLoc(GridLocation loc) {
        this.loc = loc;
    }
}
