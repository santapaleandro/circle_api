package com.cgi.circle.java.api.app;

import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.service.CircleService;
import com.cgi.circle.java.api.app.service.FunctionService;
import com.cgi.circle.java.api.app.service.PointService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MultipleServiceTest {
    @LocalServerPort
    private Integer port;
    @Container
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    @BeforeAll
    static void connect(){
        mongoDBContainer.start();
    }
    @AfterAll
    static void disconnect(){
        mongoDBContainer.stop();
    }
    @Autowired
    private PointService pointService;
    @Autowired
    private CircleService circleService;
    @Autowired
    private FunctionService functionService;
    @BeforeEach
    void setUp(){
        RestAssured.baseURI = "http://localhost:" + port;
        pointService.deleteAll();
        circleService.deleteAll();

        Point testPoint1 = new Point(1.0,1.0);
        Point testPoint2 = new Point(5.0,3.0);
        Point testPoint3 = new Point(-4.0,-2.0);
        Point testPoint4 = new Point(10.0,-1.0);
        Circle testCircle1 = new Circle(1.0,1.0,4.0);
        Circle testCircle2 = new Circle(-1.0,-5.0,6.0);

        List<Point> points = new ArrayList<>();
        points.add(testPoint1);
        points.add(testPoint2);
        points.add(testPoint3);
        points.add(testPoint4);
        List<Circle> circles = new ArrayList<>();
        circles.add(testCircle1);
        circles.add(testCircle2);

        pointService.createMultiple(points);
        circleService.createMultiple(circles);
    }

    @Test
    public void testIsInside() {
        // Set up your test data and mocks
        // Call the method and assert results
    }

    @Test
    public void testFindAllPointsInside() {
        // Set up your test data and mocks
        // Call the method and assert results
    }

    @Test
    public void testFindAllPointsOutside() {
        // Set up your test data and mocks
        // Call the method and assert results
    }

    @Test
    public void testFindAllCirclesPointIn() {
        // Set up your test data and mocks
        // Call the method and assert results
    }

    @Test
    public void testFindAllCirclesPointOut() {
        // Set up your test data and mocks
        // Call the method and assert results
    }



}
