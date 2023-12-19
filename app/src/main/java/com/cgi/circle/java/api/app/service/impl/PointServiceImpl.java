package com.cgi.circle.java.api.app.service.impl;

import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.repository.PointRepository;
import com.cgi.circle.java.api.app.service.PointService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;

    public PointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Override
    public Iterable<Point> getAll() {
        return pointRepository.findAll();
    }

    @Override
    public Optional<Point> getById(String id) {
        return pointRepository.findById(id);
    }

    @Override
    public void create(Point point) {
         pointRepository.save(point);
    }

    @Override
    public void createMultiple(List<Point> pointList) {
        pointRepository.saveAll(pointList);
    }

    @Override
    public Point update(Point point) {
        return pointRepository.save(point);
    }

    @Override
    public void delete(String id) {
        pointRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        pointRepository.deleteAll();
    }
}
