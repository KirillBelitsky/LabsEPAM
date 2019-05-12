package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

public class Rectangle {

    @JsonIgnore
    private int id;
    private String square;
    private String perimeter;
    private Parameters parameters;

    public Rectangle(String square, String perimeter) {
        this.square = square;
        this.perimeter = perimeter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((square == null) ? 0 : square.hashCode());
        result = prime * result + ((perimeter == null) ? 0 : perimeter.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass()!=this.getClass()) return false;

        Rectangle guest = (Rectangle) obj;

        return  (perimeter == guest.perimeter || (perimeter != null && perimeter.equals(guest.getPerimeter())))
                && (square == guest.square
                || (square != null && square.equals(guest.getSquare())));
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "square='" + square + '\'' +
                ", perimeter='" + perimeter + '\'' +
                '}';
    }
}
