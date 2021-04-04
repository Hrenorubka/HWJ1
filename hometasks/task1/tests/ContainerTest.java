package hometasks.task1.tests;

import hometasks.task1.solutions.Ball;
import org.junit.Assert;
import hometasks.task1.solutions.Container;
import org.junit.Before;
import org.junit.Test;

public class ContainerTest extends Assert {
    Ball testBall;
    @Before
    public void setUpObjContainer() {
        testBall = new Ball(1.0f, 1.0f, 4, 3, 60);
    }
    @Test
    public void testCollides() {
        Container testContainer = new Container(0, 0, 5, 5);
        assertFalse(testContainer.collides(testBall));
        testBall.setRadius(1);
        testBall.setX(2.0f);
        testBall.setY(2.0f);
        assertTrue(testContainer.collides(testBall));
    }

}
