package com.cgi.circle.java.api.app.controller;

import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.service.CircleService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/circles")
public class CircleController {

    private final CircleService circleService;

    public CircleController(CircleService circleService) {
        this.circleService = circleService;
    }

    @GetMapping("/all")
    public Iterable<Circle> getAll() {
        return circleService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Circle> getById(@RequestBody String id) {
        return circleService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Circle circle){
        circleService.create(circle);
    }

    @PutMapping
    public Circle update(@RequestBody Circle circle) {
        return circleService.update(circle);
    }

    @DeleteMapping("{id}")
    public void delete(@RequestBody String id) {
        circleService.delete(id);
    }

}
