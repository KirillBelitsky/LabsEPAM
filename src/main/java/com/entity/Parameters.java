package com.entity;

public class Parameters {

    private int id;
    private String length;
    private String width;

    public Parameters(String length, String width) {
        this.length = length;
        this.width = width;
    }

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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((length == null) ? 0 : length.hashCode());
        result = prime * result + ((width == null) ? 0 : width.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass()!=this.getClass()) return false;

        Parameters guest = (Parameters) obj;

        return  (length == guest.length || (length != null && length.equals(guest.getLength())))
                && (width == guest.width
                || (width != null && width .equals(guest.getWidth())));
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "id=" + id +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                '}';
    }
}
