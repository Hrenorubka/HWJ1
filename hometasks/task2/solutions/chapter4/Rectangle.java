package hometasks.task2.solutions.chapter4;

import hometasks.task1.solutions.MyPoint;

public class Rectangle extends Shape{

    private MyPoint topLeft;

    public Rectangle(MyPoint topLeft, double width, double height) {
        super(new MyPoint(topLeft.getX() + width / 2, topLeft.getY() + height / 2));
        this.topLeft = new MyPoint(topLeft.getX(), topLeft.getY());
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }

    public MyPoint getTopLeft() {
        return topLeft;
    }
}
