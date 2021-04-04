package hometasks.task1.solutions;

public class MyPoint {
    private double x = 0.0d;
    private double y = 0.0d;
    public MyPoint(){ }
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double[] getXY(){
        double[] cordinates = new double[2];
        cordinates[0] = x;
        cordinates[1] = y;
        return cordinates;
    }

    public void setXY(double x, double y) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return '(' + ((Double)x).toString() + ", " + ((Double)y).toString() + ')';
    }

    public double distance(double x, double y){
        double squareDistanceX = (this.x - x) * (this.x - x);
        double squareDistanceY = (this.y - y) * (this.y - y);
        return Math.sqrt(squareDistanceX + squareDistanceY);
    }

    public double distance(MyPoint another) {
        return distance(another.getX(), another.getY());
    }

    public double distance() {
        return distance(0.0d, 0.0d);
    }

}
