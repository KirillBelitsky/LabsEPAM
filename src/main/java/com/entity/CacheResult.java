package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "cache_result")
public class CacheResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "length")
    private String length;

    @Column(name = "width")
    private String width;

    @Column(name = "square")
    private String square;

    @Column(name = "perimeter")
    private String perimeter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
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
    public String toString() {
        return "CacheResult{" +
                "id=" + id +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", square='" + square + '\'' +
                ", perimeter='" + perimeter + '\'' +
                '}';
    }
}
