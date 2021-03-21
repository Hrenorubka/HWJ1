package hometasks;

public class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public Container(int x, int y, int width, int height) {
        x1 = x;
        y1 = y;
        x2 = x + width;
        y2 = y + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return (x2 - x1);
    }

    public int getHeight() {
        return (y2 - y1);
    }
    public boolean collides(Ball ball) {
        return ((ball.getX() - ball.getRadius() >= x1) && (ball.getX() + ball.getRadius() <= x2))
                || ((ball.getY() - ball.getRadius() >= y1) && (ball.getY() + ball.getRadius() <= y2));
    }

    @Override
    public String toString() {
        return "Container[(" + ((Integer)x1).toString() + ", " + ((Integer)y1).toString()
                + ", (" + ((Integer)x2).toString() + ", " + ((Integer)y2).toString() + ")]";
    }
}
