package hometasks;

public class Ball {
    private double x;
    private double y;
    private int radius;
    private double xDelta;
    private double yDelta;
    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = speed * Math.cos( (direction * Math.PI) / 180.0d);
        this.yDelta = speed * Math.sin( (direction * Math.PI) / 180.0d);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getXDelta() {
        return xDelta;
    }

    public void setXDelta(double xDelta) {
        this.xDelta = xDelta;
    }

    public double getYDelta() {
        return yDelta;
    }

    public void setYDelta(double yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        x += xDelta;
        y +=yDelta;
    }

    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + ((Double)x).toString() + ", " +  ((Double) y).toString()
                + "), speed = (" + ((Double) xDelta).toString() + ", " + ((Double) yDelta).toString() + ")]";
    }
}
