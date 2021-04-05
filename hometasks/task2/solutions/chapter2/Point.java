package hometasks.task2.solutions.chapter2;

public final class Point {

    private double x;
    private double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        x = 0.0;
        y = 0.0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    Point translate(double inpX, double inpY) {
        return new Point(x + inpX, y + inpY);
    }

    Point scale(double inpScale) {
        return  new Point(x * inpScale, y * inpScale);
    }

}