package hometasks;

public class Rectangle implements GeometricFigure {
    private float length = 1.0f;
    private float width = 1.0f;
    public Rectangle() {}

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength(){
        return length;
    }

    public float getWidth() {
        return width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return  "Rectangle[length = " + ((Float)length).toString() + ", width = " + ((Float)width).toString() + "]";
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimetr() {
        return 2 * (width + length);
    }
}
