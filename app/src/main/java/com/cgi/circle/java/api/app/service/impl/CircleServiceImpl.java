package com.cgi.circle.java.api.app.service.impl;

import com.cgi.circle.java.api.app.exceptions.CircleRadiusTooLowException;
import com.cgi.circle.java.api.app.exceptions.EntityNotFoundException;
import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.repository.CircleRepository;
import com.cgi.circle.java.api.app.service.CircleService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Circle getById(String id) {
        return circleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Circle not found with id: " + id));
    }

    @Override
    public Circle update(Circle circle) throws CircleRadiusTooLowException {
        if (circle.getRadius() < 0.001){
            throw new CircleRadiusTooLowException("Circle radius is lower than 0.001");
        }
        return circleRepository.save(circle);
    }

    @Override
    public void delete(String id) {
        circleRepository.deleteById(id);
    }

    @Override
    public void create(Circle circle) throws CircleRadiusTooLowException {
        if (circle.getRadius() < 0.001){
            throw new CircleRadiusTooLowException("Circle radius is lower than 0.001");
        }
        circleRepository.save(circle);
    }

    @Override
    public void createMultiple(List<Circle> circles) {
        circleRepository.saveAll(circles);
    }

    @Override
    public void deleteAll() {
        circleRepository.deleteAll();
    }
}
