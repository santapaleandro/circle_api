package com.cgi.circle.java.api.app.service.impl;

import com.cgi.circle.java.api.app.dto.NoIDCircleDTO;
import com.cgi.circle.java.api.app.dto.NoIDPointDTO;
import com.cgi.circle.java.api.app.exceptions.EntityNotFoundException;
import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.repository.CircleRepository;
import com.cgi.circle.java.api.app.repository.PointRepository;
import com.cgi.circle.java.api.app.service.FunctionService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FunctionServiceImpl implements FunctionService {

    private final PointRepository pointRepository;
    private final CircleRepository circleRepository;

    public FunctionServiceImpl(PointRepository pointRepository, CircleRepository circleRepository) {
        this.pointRepository = pointRepository;
        this.circleRepository = circleRepository;
    }

    @Override
    public Boolean isInside(Point point, Circle circle) {
        double distance = Math.sqrt(Math.pow(point.getX() - circle.getX(), 2) + Math.pow(point.getY() - circle.getY(), 2));
        return distance < circle.getRadius();
    }

    @Override
    public Boolean isInside(NoIDPointDTO point, NoIDCircleDTO circle) {

        return null;
    }

    @Override
    public Boolean isInside(String pointId, String circleId) {
        Optional<Circle> circle = circleRepository.findById(circleId);
        Optional<Point> point = pointRepository.findById(pointId);
        if (point.isEmpty()) {
            throw new EntityNotFoundException("Point not found with ID: " + pointId);
        }

        if (circle.isEmpty()) {
            throw new EntityNotFoundException("Circle not found with ID: " + circleId);
        }

        return isInside(point.get(), circle.get());
    }

    @Override
    public Iterable<Point> findAllPointsInside(String circleId) {
        Iterable<Point> selected = pointRepository.findAll();
        Optional<Circle> circle = circleRepository.findById(circleId);
        if (circle.isPresent()) {
            Circle circle1 = circle.get();
            return StreamSupport.stream(selected.spliterator(), false)
                    .filter(point -> isInside(point, circle1))
                    .toList();
        }
        return null;
    }

    @Override
    public Iterable<Point> findAllPointsOutside(String circleId) {
        Set<Point> inside = StreamSupport.stream(findAllPointsInside(circleId).spliterator(), false)
                .collect(Collectors.toSet());
        return pointRepository.findAll().stream()
                .filter(point -> !inside.contains(point))
                .toList();
    }

    @Override
    public Iterable<Circle> findAllCirclesPointIn(Point point) {
        return circleRepository.findAll().stream()
                .filter(c -> isInside(point, c))
                .toList();
    }

    @Override
    public Iterable<Circle> findAllCirclesPointOut(Point point) {
        return circleRepository.findAll().stream()
                .filter(c -> !isInside(point, c))
                .toList();
    }
}
