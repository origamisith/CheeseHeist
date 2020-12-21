package com.lsedillo.Model;

public enum Compass {
    NORTH(0), EAST(90), SOUTH(180), WEST(270);
    int degrees;
    Compass(int degrees) {
        this.degrees = degrees;
    }

    Compass turnDegrees(int d) {
        int newD = (degrees + d)%360;
        return getByDegrees(newD);
    }
    Compass getByDegrees(int d) {
        return switch(d) {
            case 90, -270-> EAST;
            case 180, -180 -> SOUTH;
            case 270, -90 -> WEST;
            default -> NORTH;
        };
    }

    public static void main(String[] args) {
        System.out.println("West plus 180 degrees is" + WEST.turnDegrees(180));
        System.out.println("The direction corresponding to 90 degrees is " + SOUTH.getByDegrees(90));
    }
}
