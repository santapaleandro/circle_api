package com.circle.java.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.circle.java.model.Circle;
import com.circle.java.service.CircleService;


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
    public Circle getById(Long id) {
        return circleService.getById(id);
    }

    @PutMapping
    public Circle update(Circle circle) {
        return circleService.update(circle);
    }

    @DeleteMapping("{id}")
    public void delete(Long id) {
        circleService.delete(id);
    }
    


}
