package hometasks.task1.solutions;

public class Circle implements GeometricFigure {
    private double radius = 1.0;
    private String color = "red";
    public Circle() { }
    public Circle(double radius) {

        this.radius = radius;
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  "Circle[radius = " + ((Double)radius).toString() + ", color = " + color + "]";
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimetr() {
        return Math.PI * 2 * radius;
    }
}
