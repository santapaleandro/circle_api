package com.cgi.circle.java.api.app.controller;

import com.cgi.circle.java.api.app.dto.NoIDPointDTO;
import com.cgi.circle.java.api.app.dto.PointIdCircleIdDTO;
import com.cgi.circle.java.api.app.dto.wrappers.PointCircleWrapper;
import com.cgi.circle.java.api.app.mapper.CircleMapper;
import com.cgi.circle.java.api.app.mapper.PointMapper;
import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.model.Point;
import com.cgi.circle.java.api.app.service.FunctionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/func")
public class FunctionController {
    private final FunctionService functionService;
    private final PointMapper pointMapper;
    private final CircleMapper circleMapper;

    public FunctionController(PointMapper pointMapper, FunctionService functionService, CircleMapper circleMapper) {
        this.functionService = functionService;
        this.pointMapper = pointMapper;
        this.circleMapper = circleMapper;
    }

    @PostMapping("/is_inside")
    @Operation(summary = "Check if a point is inside a circle",
            description = "Returns true if the specified point is inside the given circle")
    @ApiResponse(responseCode = "200", description = "Successfully determined the point's position",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Boolean.class)))
    public Boolean isInside(@Parameter(description = "Wrapper object containing a point and a circle DTOs", required = true)
                                @RequestBody PointCircleWrapper wrapper){
        Point point = pointMapper.noIDPointDTOToPoint(wrapper.getPoint());
        Circle circle = circleMapper.noIDCircleDTOToCircle(wrapper.getCircle());
        return functionService.isInside(point, circle);
    }

    @PostMapping("/is_inside_by_id")
    @Operation(summary = "Check if a point is inside a circle",
            description = "Returns true if the specified point is inside the given circle")
    @ApiResponse(responseCode = "200", description = "Successfully determined the point's position",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class)))
    public Boolean isInside(@Parameter(description = "Wrapper object containing a point and a circle IDs", required = true)
                            @RequestBody PointIdCircleIdDTO bothId){
        return functionService.isInside(bothId.getPointId(), bothId.getCircleId());
    }

    @PostMapping("/get-all-points-inside-circle")
    @Operation(summary = "Get all points inside a circle",
            description = "Retrieves all points that are inside the specified circle")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the points",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Point.class)))
    public Iterable<Point> getAllPointsInsideCircle(@Parameter(description = "ID of the circle", required = true)
                                                        @RequestBody String circleId){
        return functionService.findAllPointsInside(circleId);
    }

    @PostMapping("/get-all-points-outside-circle")
    @Operation(summary = "Get all points outside a circle",
            description = "Retrieves all points that are outside the specified circle")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the points",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Point.class)))
    public Iterable<Point> getAllPointsOutsideCircle(@Parameter(description = "ID of the circle", required = true)
                                                     @RequestBody String circleId){
        return functionService.findAllPointsOutside(circleId);
    }

    @PostMapping("/all-circles-point-in")
    @Operation(summary = "Get all circles containing a point",
            description = "Retrieves all circles that contain the specified point")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved circles",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Circle.class)))
    public Iterable<Circle> getAllCirclesPointIn(@Parameter(description = "Point to check", required = true)
                                                 @RequestBody Point point) {
        return functionService.findAllCirclesPointIn(point);
    }

    @PostMapping("/all-circles-point-out")
    @Operation(summary = "Get all circles not containing a point",
            description = "Retrieves all circles that do not contain the specified point")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved circles",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Circle.class)))
    public Iterable<Circle> getAllCirclesPointOut(@Parameter(description = "Point to check", required = true)
                                                  @RequestBody NoIDPointDTO p) {
        return functionService.findAllCirclesPointOut(new Point(p.getX(), p.getY()));
    }
}
