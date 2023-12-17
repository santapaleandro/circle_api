package com.cgi.circle.java.api.app.service.impl;

import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.service.FunctionService;
import org.springframework.stereotype.Service;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Override
    public Boolean isInside(Point point, Circle circle) {
        double distance = Math.sqrt(Math.pow(point.getX() - circle.getX(), 2) + Math.pow(point.getY() - circle.getY(), 2));
        return distance < circle.getRadius();
    }

    @Override
    public Iterable<Point> findAllPointsInside(Circle circle) {
        return null;
    }

    @Override
    public Iterable<Point> findAllPointsOutside(Circle circle) {
        return null;
    }
}
