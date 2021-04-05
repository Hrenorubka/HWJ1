package hometasks.task2.solutions.chapter4;

import hometasks.task1.solutions.MyPoint;


public class Line extends Shape {

    private MyPoint from;


    public Line(MyPoint from, MyPoint to) {
        super(new MyPoint( (to.getX() + from.getX()) / 2, (to.getY() + from.getY()) / 2));
        this.from = new MyPoint(from.getX(), from.getY());
    }


    @Override
    public Line clone() throws CloneNotSupportedException {
        return (Line) super.clone();
    }

    public MyPoint getFrom() {
        return from;
    }
}
