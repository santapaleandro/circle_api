package com.cgi.circle.java.api.app.service;

import com.cgi.circle.java.api.app.dto.NoIDCircleDTO;
import com.cgi.circle.java.api.app.dto.NoIDPointDTO;
import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.model.Point;

public interface FunctionService {
    Boolean isInside(Point point, Circle circle);
    Boolean isInside(NoIDPointDTO point, NoIDCircleDTO circle);
    Boolean isInside(String pointId, String circleId);
    Iterable<Point> findAllPointsInside(String circleId);
    Iterable<Point> findAllPointsOutside(String circleId);
    Iterable<Circle> findAllCirclesPointIn(Point point);
    Iterable<Circle> findAllCirclesPointOut(Point point);
}
