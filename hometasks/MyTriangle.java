package hometasks;
import java.math.*;
public class MyTriangle implements GeometricFigure {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(){}

    public MyTriangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        this.v1 = new MyPoint(x1, y1);
        this.v2 = new MyPoint(x2, y2);
        this.v3 = new MyPoint(x3, y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = new MyPoint(v1.getX(), v1.getY());
        this.v2 = new MyPoint(v2.getX(), v2.getY());
        this.v3 = new MyPoint(v3.getX(), v3.getY());
    }

    @Override
    public String toString(){
        return "MyTriangle[v1 = " + v1.toString() + ", v2 = " + v2.toString() + ", v3 = " + v3.toString() + "]";
    }

    @Override
    public double getArea(){
        double halfPerimetr = getPerimetr() / 2.0d;
        return Math.sqrt(halfPerimetr * (halfPerimetr - v1.distance(v2)) * (halfPerimetr - v1.distance(v3)) * (halfPerimetr - v2.distance(v3)));
    }

    @Override
    public double getPerimetr(){
        return v1.distance(v2) + v1.distance(v3) + v2.distance(v3);
    }

    public String getType()
    {
        if (v1.distance(v2) == v1.distance(v3) && v1.distance(v3) == v2.distance(v3)) {
            return "Equilateral";
        }
        if (v1.distance(v2) == v1.distance(v3) || v2.distance(v1) == v2.distance(v3) || v3.distance(v1) == v3.distance(v2)) {
            return  "Isosceles";
        }
        return "Scalene";
    }
}
