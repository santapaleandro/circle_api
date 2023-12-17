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
    public Optional<Point> getById(@RequestBody String id){
        return pointService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Point point){
        pointService.create(point);
    }

    @PutMapping
    public Point update(@RequestBody Point point){
        return pointService.update(point);
    }

    @DeleteMapping
    public void delete(@RequestBody String id){
        pointService.delete(id);
    }

}
