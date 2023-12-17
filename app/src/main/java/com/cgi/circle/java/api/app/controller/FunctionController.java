package com.cgi.circle.java.api.app.controller;

import com.cgi.circle.java.api.app.dto.wrappers.PointCircleWrapper;
import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.service.FunctionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/func")
public class FunctionController {
    private final FunctionService functionService;

    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    @GetMapping("/is_inside")
    @Operation(summary = "Check if a point is inside a circle",
            description = "Returns true if the specified point is inside the given circle")
    @ApiResponse(responseCode = "200", description = "Successfully determined the point's position",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class)))
    public Boolean isInside(@Parameter(description = "Wrapper object containing a point and a circle", required = true)
                                @RequestBody PointCircleWrapper pointCircleWrapper){
        return functionService.isInside(pointCircleWrapper.getPoint(), pointCircleWrapper.getCircle());
    }

    @GetMapping("/get_all_points_inside_circle")
    @Operation(summary = "Get all points inside a circle",
            description = "Retrieves all points that are inside the specified circle")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the points",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Point.class)))
    public Iterable<Point> getAllPointsInsideCircle(@Parameter(description = "ID of the circle", required = true)
                                                        @RequestBody String circleId){
        return functionService.findAllPointsInside(circleId);
    }

    @GetMapping("/get_all_points_outside_circle")
    @Operation(summary = "Get all points outside a circle",
            description = "Retrieves all points that are outside the specified circle")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the points",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Point.class)))
    public Iterable<Point> getAllPointsOutsideCircle(@Parameter(description = "ID of the circle", required = true)
                                                         @RequestBody String circleId){
        return functionService.findAllPointsOutside(circleId);
    }
}
