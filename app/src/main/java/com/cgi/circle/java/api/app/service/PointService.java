package com.cgi.circle.java.api.app.service;

import com.cgi.circle.java.api.app.model.Point;

import java.util.Optional;

public interface PointService {
    Iterable<Point> getAll();
    Optional<Point> getById(String id);
    void create(Point point);
    Point update(Point point);
    void delete(String id);

}
