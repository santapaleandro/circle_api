package com.cgi.circle.java.api.app;

import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.service.FunctionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AppApplicationTests {

    @Autowired
    private FunctionService functionService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testIsInside_WhenPointIsInside() {
        Point testPoint = new Point(1.0, 1.0);
        Circle testCircle = new Circle(2.0, 2.0, 5.0);
        boolean result = functionService.isInside(testPoint, testCircle);
        assertTrue(result, "Point should be inside the circle");
    }

    @Test
    public void testIsInside_WhenPointIsOnEdge() {
        Point testPoint = new Point(7.0, 2.0);
        Circle testCircle = new Circle(2.0, 2.0, 5.0);
        boolean result = functionService.isInside(testPoint, testCircle);
        assertFalse(result, "Point on the edge should be considered outside the circle");
    }

    @Test
    public void testFindAllPointsInside() {
        Point testPoint = new Point(1.0, 1.0);
        Circle testCircle = new Circle(2.0, 2.0, 5.0);
        boolean result = functionService.isInside(testPoint, testCircle);
        assertTrue(result, "Point should be inside the circle");
    }

    @Test
    public void testFindAllPointsOutside() {
        Point testPoint = new Point(10.0, 10.0);
        Circle testCircle = new Circle(2.0, 2.0, 5.0);
        boolean result = functionService.isInside(testPoint, testCircle);
        assertFalse(result, "Point should be outside the circle");
    }

}
