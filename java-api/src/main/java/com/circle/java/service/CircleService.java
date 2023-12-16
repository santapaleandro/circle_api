package com.circle.java.service;

import com.circle.java.model.Circle;

public interface CircleService {

    Iterable<Circle> getAll();
    Circle getById(Long id);
    Circle update(Circle circle);
    void delete(Long id);
    void create(Circle circle);
    
}