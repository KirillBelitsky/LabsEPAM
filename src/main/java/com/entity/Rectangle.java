package com.entity;

public class Rectangle {

    private String square;
    private String perimeter;

    public Rectangle(String square, String perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(String perimeter) {
        this.perimeter = perimeter;
    }
}
