package com.cgi.circle.java.api.app.service;

import com.cgi.circle.java.api.app.model.Circle;

import java.util.Optional;

public interface CircleService {
    Iterable<Circle> getAll();
    Optional<Circle> getById(String id);
    Circle update(Circle circle);
    void delete(String id);
    void create(Circle circle);

}
