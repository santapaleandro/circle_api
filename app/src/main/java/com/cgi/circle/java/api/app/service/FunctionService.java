package com.cgi.circle.java.api.app.service;

import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.model.Point;

public interface FunctionService {
    Boolean isInside(Point point, Circle circle);
    Iterable<Point> findAllPointsInside(Circle circle);
    Iterable<Point> findAllPointsOutside(Circle circle);
}