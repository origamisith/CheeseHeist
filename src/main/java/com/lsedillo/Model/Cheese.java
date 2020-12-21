package com.lsedillo.Model;

import javax.swing.*;

public class Cheese extends Entity{
    public boolean visible, eaten;

    public static ImageIcon imageIcon = new ImageIcon("src/main/resources/cheese.png");
    public Cheese(GridLocation loc) {
        super(loc);
        visible = true;
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
        return "Cheese at " + getLoc().toString() + " is " + visible + " visible ";
    }

    @Override
    public ImageIcon getImageIcon() {
        return imageIcon;
    }
}
