package tests;

import org.junit.Assert;
import hometasks.MyPolynomial;
import org.junit.Test;

import java.util.ArrayList;

public class MyPolynomialTest extends Assert {
    private final double DELTA = 1.0E-15D;
    MyPolynomial testPolynomial;
    @Test
    public void testToString() {

        testPolynomial = new MyPolynomial(2.0d, 0.0d, -1.0d);
        assertEquals("-1.0x^2+2.0x^0", testPolynomial.toString());
    }
    @Test
    public void testEvaluate() {
        testPolynomial = new MyPolynomial(1.0d, 1.0d, 1.0d);
        assertEquals(1.75d, testPolynomial.evaluate(-1.5d), DELTA);
    }
    @Test
    public void testEquals() {
        MyPolynomial testPolynomial1 = new MyPolynomial(1.0d, 1.0d, 1.0d);
        MyPolynomial testPolynomial2 = new MyPolynomial(1.0d, 1.0d, 1.0d);
        MyPolynomial testPolynomial3 = new MyPolynomial(1.0d, 1.0d, -1.0d);
        assertTrue(testPolynomial1.equals(testPolynomial2));
        assertFalse(testPolynomial1.equals(testPolynomial3));
    }
    @Test
    public void testAdd() {
        MyPolynomial testPolynomial1 = new MyPolynomial(1.0d, 1.0d, 1.0d);
        MyPolynomial testPolynomial2 = new MyPolynomial(1.0d, 1.0d, 1.0d, 1.0d);
        MyPolynomial testPolynomail3 = new MyPolynomial(2.0d, 2.0d, 2.0d, 1.0d);
        assertTrue((testPolynomial1.add(testPolynomial2)).equals(testPolynomail3));
    }

    @Test
    public void testMultiply() {
        MyPolynomial testPolynomial1 = new MyPolynomial(1.0d, 1.0d, 1.0d);
        MyPolynomial testPolynomial2 = new MyPolynomial(1.0d, 1.0d);
        MyPolynomial testPolynomail3 = new MyPolynomial(1.0d, 2.0d, 2.0d, 1.0d);
        assertTrue((testPolynomial1.multiply(testPolynomial2)).equals(testPolynomail3));
        MyPolynomial testPolynomial4 = new MyPolynomial(1.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, -1.0d);
        assertEquals(12, (testPolynomial1.multiply(testPolynomial4)).getDegree());
    }
}
