package com.cgi.circle.java.api.app.service;

import com.cgi.circle.java.api.app.model.Circle;

import java.util.List;

public interface CircleService {
    Iterable<Circle> getAll();
    Circle getById(String id);
    Circle update(Circle circle);
    void delete(String id);
    void create(Circle circle);
    void createMultiple(List<Circle> circles);
    void deleteAll();

}
