package com.cgi.circle.java.api.app.controller;

import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.service.CircleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/circles")
public class CircleController {

    private final CircleService circleService;

    public CircleController(CircleService circleService) {
        this.circleService = circleService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all circles", description = "Retrieve a list of all circles")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of circles",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Circle.class)))
    public Iterable<Circle> getAll() {
        return circleService.getAll();
    }

    @GetMapping
    @Operation(summary = "Get a circle by ID", description = "Retrieve a single circle by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the circle",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Circle.class)))
    @ApiResponse(responseCode = "404", description = "Circle not found")
    public Circle getById(@RequestParam String id) {
        return circleService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new circle", description = "Create a new circle and add it to the database")
    @ApiResponse(responseCode = "201", description = "Circle created successfully")
    public void create(@RequestBody Circle circle){
        circleService.create(circle);
    }

    @PostMapping("all")
    @Operation(summary = "Create new circles", description = "Create new circles and add them to the database")
    @ApiResponse(responseCode = "201", description = "Circles created successfully")
    public void createMultiple(@RequestBody List<Circle> circles){
        circleService.createMultiple(circles);
    }

    @PutMapping
    @Operation(summary = "Update a circle", description = "Update an existing circle's details")
    @ApiResponse(responseCode = "200", description = "Circle updated successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Circle.class)))
    public Circle update(@Parameter(description = "Updated circle object", required = true)
                             @RequestBody Circle circle) {
        return circleService.update(circle);
    }

    @DeleteMapping
    @Operation(summary = "Delete a circle", description = "Delete a circle from the database")
    @ApiResponse(responseCode = "200", description = "Circle deleted successfully")
    public void delete(@Parameter(description = "ID of the circle to delete", required = true)
                       @RequestBody String id) {
        circleService.delete(id);
    }

    @DeleteMapping("/all")
    @Operation(summary = "Delete ALL circles", description = "Delete ALL circles from the database")
    @ApiResponse(responseCode = "200", description = "ALL circles deleted successfully")
    public void deleteAll() {
        circleService.deleteAll();
    }

}

