package tests;

import hometasks.Circle;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CircleTest extends Assert {

    private final double DELTA = 1e-15;
    private  String testColor;
    private double testRadius;
    private Circle objTest;
    @Before
    public void setUpObjCircle()
    {
        testColor = new String("white");
        testRadius = 3.0d;
    }

    @Test
    public void testToString()
    {
        Circle objTest = new Circle(testRadius, testColor);
        assertEquals("Circle[radius = " + ((Double)testRadius).toString() + ", color = " + testColor + ']', objTest.toString());
    }
    @Test
    public void testGetArea()
    {
        Circle objTest = new Circle(testRadius, testColor);
        assertEquals( Math.PI * testRadius * testRadius, objTest.getArea(), DELTA);
    }
    @Test
    public void testGetPerimetr()
    {
        Circle objTest = new Circle(testRadius, testColor);
        assertEquals(Math.PI * 2 * testRadius, objTest.getPerimetr(), DELTA);
    }

}
