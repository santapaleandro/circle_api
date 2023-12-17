package com.cgi.circle.java.api.app.service.impl;

import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.repository.CircleRepository;
import com.cgi.circle.java.api.app.service.CircleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CircleServiceImpl implements CircleService {

    private final CircleRepository circleRepository;

    public CircleServiceImpl(CircleRepository circleRepository) {
        this.circleRepository = circleRepository;
    }

    @Override
    public Iterable<Circle> getAll() {
        return circleRepository.findAll();
    }

    @Override
    public Optional<Circle> getById(String id) {
        return circleRepository.findById(id);
    }

    @Override
    public Circle update(Circle circle) {
        return circleRepository.save(circle);
    }

    @Override
    public void delete(String id) {
        circleRepository.deleteById(id);
    }

    @Override
    public void create(Circle circle) {
        circleRepository.save(circle);
    }
}
