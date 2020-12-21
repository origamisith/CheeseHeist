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
            case EAST -> setLoc(loc.transpose(1,0));
            case WEST-> setLoc(loc.transpose(-1,0));
            case NORTH-> setLoc(loc.transpose(0,-1));
            case SOUTH-> setLoc(loc.transpose(0, 1));
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
