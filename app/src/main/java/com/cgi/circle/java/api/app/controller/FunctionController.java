package com.cgi.circle.java.api.app.controller;

import com.cgi.circle.java.api.app.dto.wrappers.PointCircleWrapper;
import com.cgi.circle.java.api.app.service.FunctionService;
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
    public Boolean isInside(@RequestBody PointCircleWrapper pointCircleWrapper){
        return functionService.isInside(pointCircleWrapper.getPoint(), pointCircleWrapper.getCircle());
    }

}
