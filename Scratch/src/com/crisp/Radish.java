package com.crisp;

/*
 *  Natural order is defined by 'size' (double)
 *  'size' is called the "sort key."
 */

class Radish implements Comparable<Radish>{
    private String color;
    private double size;
    private double tailLength;
    private int guysOnTop;

    //  TODO: generate accessor methods for these
    //  write toString()
    //  write a 4-arg ctor that takes them all in and delegates to setters

    public Radish(String color, double size, double tailLength, int guysOnTop) {
        setColor(color);
        setSize(size);
        setTailLength(tailLength);
        setGuysOnTop(guysOnTop);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public int getGuysOnTop() {
        return guysOnTop;
    }

    public void setGuysOnTop(int guysOnTop) {
        this.guysOnTop = guysOnTop;
    }

    //  'size' (double is our sort key
    @Override  //   interface Comparable
    public int compareTo(Radish other) {
        return Double.compare(this.getSize(), other.getSize());
    }

    public String toString() {
        return String.format("%s: color = %s, size = %s, tailLength = %s, guysOnTop = %s ",
                getClass().getSimpleName(), getColor(), getSize(), getTailLength(), getGuysOnTop());
    }
}