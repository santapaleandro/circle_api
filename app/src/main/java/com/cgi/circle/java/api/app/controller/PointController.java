package com.cgi.circle.java.api.app.controller;

import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.service.PointService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/points")
public class PointController {

    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all points", description = "Retrieve a list of all points")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of points",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Point.class)))
    public Iterable<Point> getAll(){
        return pointService.getAll();
    }

    @GetMapping
    @Operation(summary = "Get a point by ID", description = "Retrieve a single point by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the point",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Point.class)))
    @ApiResponse(responseCode = "404", description = "Point not found")
    public Optional<Point> getById(@Parameter(description = "ID of the point to retrieve", required = true)
                                       @RequestBody String id){
        return pointService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new point", description = "Create a new point and add it to the database")
    @ApiResponse(responseCode = "201", description = "Point created successfully")
    public void create(@Parameter(description = "Point object to be created", required = true)
                           @RequestBody Point point){
        pointService.create(point);
    }

    @PostMapping("all")
    @Operation(summary = "Create new points", description = "Create new points and add them to the database")
    @ApiResponse(responseCode = "201", description = "Points created successfully")
    public void createMultiple(@RequestBody List<Point> points){
        pointService.createMultiple(points);
    }

    @PutMapping
    @Operation(summary = "Update a point", description = "Update an existing point's details")
    @ApiResponse(responseCode = "200", description = "Point updated successfully",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Point.class)))
    @ApiResponse(responseCode = "404", description = "Point not found")
    public Point update(@Parameter(description = "Updated point object", required = true)
                            @RequestBody Point point){
        return pointService.update(point);
    }

    @DeleteMapping
    @Operation(summary = "Delete a point", description = "Delete a point from the database")
    @ApiResponse(responseCode = "200", description = "Point deleted successfully")
    @ApiResponse(responseCode = "404", description = "Point not found")
    public void delete(@Parameter(description = "ID of the point to delete", required = true)
                           @RequestBody String id){
        pointService.delete(id);
    }

    @DeleteMapping("/all")
    @Operation(summary = "Delete ALL points", description = "Delete ALL points from the database")
    @ApiResponse(responseCode = "200", description = "ALL points deleted successfully")
    public void deleteAll() {
        pointService.deleteAll();
    }

}
