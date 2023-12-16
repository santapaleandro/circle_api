package com.circle.java.service.implementation;

import org.springframework.stereotype.Service;

import com.circle.java.model.Circle;
import com.circle.java.repository.CircleRepository;
import com.circle.java.service.CircleService;


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
    public Circle getById(Long id) {
        return circleRepository.findById(id).get();
    }

    @Override
    public Circle update(Circle circle) {
        return circleRepository.save(circle);
    }

    @Override
    public void delete(Long id) {
        circleRepository.deleteById(id);
    }

    @Override
    public void create(Circle circle) {
        circleRepository.save(circle);
    }
}