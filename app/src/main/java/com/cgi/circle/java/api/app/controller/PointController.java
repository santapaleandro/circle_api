package com.cgi.circle.java.api.app.controller;

import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.service.PointService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/points")
public class PointController {

    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/all")
    public Iterable<Point> getAll(){
        return pointService.getAll();
    }

    @GetMapping
    public Optional<Point> getById(String id){
        return pointService.getById(id);
    }

    @PostMapping
    public void create(Point point){
        pointService.create(point);
    }

    @PutMapping
    public Point update(Point point){
        return pointService.update(point);
    }

    @DeleteMapping
    public void delete(String id){
        pointService.delete(id);
    }

}
