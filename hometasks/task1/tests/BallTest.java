package hometasks.task1.tests;

import org.junit.Assert;
import hometasks.task1.solutions.Ball;
import org.junit.Test;

public class BallTest extends Assert {

    Ball testBall;

    @Test
    public void testToString() {
        testBall = new Ball(1.0f, 1.0f, 4, 3, 60);
        assertEquals("Ball[(1.0, 1.0), speed = ("+ ((Double) (3 * Math.cos(Math.PI / 3.0d)) ).toString() + ", "
                    + ((Double) (3 * Math.sin(Math.PI / 3.0d)) ).toString() + ")]", testBall.toString());
    }


}
