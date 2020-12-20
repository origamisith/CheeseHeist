package com.lsedillo.Model;

import javax.swing.*;

public class Cheese extends Entity{
    public boolean visible, eaten;

    public Cheese(GridLocation loc) {
        super(loc);

    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }

    public String toString(){
        return "Cheese at " + getLoc().toString();
    }

    @Override
    public ImageIcon getImageIcon() {
        return new ImageIcon("src/main/resources/cheese.png");
    }
}
