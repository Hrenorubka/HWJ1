package tests;

import hometasks.MyTriangle;
import hometasks.MyPoint;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MyTriangleTest extends Assert {
    private final double DELTA = 1e-15;
    ArrayList<ArrayList<MyPoint>> testMatrixOfApex; // 0 - Isosceles, 1 - Scalene, 2 - Equilateral
    private ArrayList<MyPoint> setApex(double[] x, double[] y)
    {
        ArrayList<MyPoint> out = new ArrayList<MyPoint>(3);
        MyPoint tmp = new MyPoint(x[0], y[0]);
        out.add(0, tmp);
        tmp = new MyPoint(x[1], y[1]);
        out.add(tmp);
        tmp = new MyPoint(x[2], y[2]);
        out.add(tmp);
        return out;
    }
    MyTriangle testObj;
    @Before
    public void setUpObjMyTriangle()
    {
        testMatrixOfApex = new ArrayList<ArrayList<MyPoint>>();
        ArrayList<MyPoint> tmpArray = new ArrayList<MyPoint>(3);
        double[] x = new double[3];
        double[] y = new double[3];
        x[0] = 4; x[1] = -4; x[2] = 0;
        y[0] = 0; y[1] = 0; y[2] = 3;
        testMatrixOfApex.add(setApex(x, y));
        x[0] = 3; x[1] = -3; x[2] = 0;
        y[0] = 1; y[1] = 0; y[2] = 3;
        testMatrixOfApex.add(setApex(x, y));
        x[0] = 3; x[1] = -3; x[2] = 0;
        y[0] = 0; y[1] = 0; y[2] = Math.sqrt(Math.abs(x[0] - x[1]) * Math.abs(x[0] - x[1]) * 0.75d);
        testMatrixOfApex.add(setApex(x, y));
    }
    @Test
    public void testGetPerimetr()
    {
        testObj = new MyTriangle(testMatrixOfApex.get(0).get(0),testMatrixOfApex.get(0).get(1), testMatrixOfApex.get(0).get(2));
        assertEquals(18.0d, testObj.getPerimetr(), DELTA);
    }
    @Test
    public void testGetType()
    {
        ArrayList<String> TypeTriangle = new ArrayList<String>(3);
        TypeTriangle.add("Isosceles");
        TypeTriangle.add("Scalene");
        TypeTriangle.add("Equilateral");
        for (int i = 0; i < 3; i++)
        {
            testObj = new MyTriangle(testMatrixOfApex.get(i).get(0), testMatrixOfApex.get(i).get(1), testMatrixOfApex.get(i).get(2));
            assertEquals(TypeTriangle.get(i), testObj.getType());
        }
    }
    @Test
    public void testGetArea()
    {
        testObj = new MyTriangle(testMatrixOfApex.get(0).get(0),testMatrixOfApex.get(0).get(1), testMatrixOfApex.get(0).get(2));
        assertEquals(12.0d, testObj.getArea(), DELTA);
    }
    @After
    public void tearDownObjMyTriangle()
    {
        testMatrixOfApex.clear();
    }
}
