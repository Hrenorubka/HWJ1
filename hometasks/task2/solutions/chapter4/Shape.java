package hometasks.task2.solutions.chapter4;

import hometasks.task1.solutions.MyPoint;

public abstract class Shape implements Cloneable {

    protected MyPoint center;

    public Shape(MyPoint center) {
        this.center = center;
    }


    public MyPoint getCenter() {
        return center;
    }


    @Override
    public Shape clone() throws CloneNotSupportedException {
        return (Shape) super.clone();
    }
}
