package hometasks.task1.tests;

import hometasks.task1.solutions.MyComplex;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class MyComplexTest extends Assert {
    private final double DELTA = 1e-15;
    private ArrayList<Double> testReal;
    private ArrayList<Double> testImag;
    private MyComplex objMyComplex;
    @Before
    public void setUpObjMyComplex() {
        testReal = new ArrayList<Double>();
        testImag = new ArrayList<Double>();
        testReal.add(1.0d);
        testReal.add(0.0d);
        testImag.add(1.0d);
        testImag.add(-1.0d);
    }

    @Test
    public void TestToString() {
        MyComplex objMyComplex = new MyComplex(testReal.get(0), testImag.get(0));
        assertEquals("(1.0+1.0i)", objMyComplex.toString());
        objMyComplex.setValue(testReal.get(1), testImag.get(1));
        assertEquals("(0.0-1.0i)", objMyComplex.toString());
    }
    @Test
    public void TestEquals() {
        MyComplex objMyComplex = new MyComplex(testReal.get(0), testImag.get(0));
        assertTrue(objMyComplex.equals(1.0d, 1.0d));
        MyComplex anotherObj = new MyComplex(1.0d, 1.0d);
        assertTrue(objMyComplex.equals(anotherObj));
    }
    @Test
    public void TestMagnitude(){
        MyComplex objMyComplex = new MyComplex(testReal.get(0), testImag.get(0));
        assertEquals(Math.sqrt(2), objMyComplex.magnitude(), DELTA);
    }

    @Test
    public void TestArgument() {
        MyComplex objMyComplex = new MyComplex(testReal.get(0), testImag.get(0));
        assertEquals((Math.PI / 4), objMyComplex.argument(), DELTA);
        objMyComplex.setValue(testReal.get(1), testImag.get(1));
        assertEquals((- Math.PI / 2), objMyComplex.argument(), DELTA);
        objMyComplex.setValue(-1.0d, -1.0d);
        assertEquals((-3.0d * Math.PI / 4.0d), objMyComplex.argument(), DELTA);
        objMyComplex.setValue(-1.0d, 1.0d);
        assertEquals((3.0d * Math.PI / 4.0d), objMyComplex.argument(), DELTA);
        objMyComplex.setValue(-1.0d, 0.0d);
        assertEquals(Math.PI, objMyComplex.argument(), DELTA);
    }
    @After
    public void tearDownObjMyComplex() {
        testReal.clear();
        testImag.clear();
    }
}
