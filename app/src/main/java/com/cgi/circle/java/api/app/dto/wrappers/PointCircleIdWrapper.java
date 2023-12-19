package com.cgi.circle.java.api.app.dto.wrappers;

import com.cgi.circle.java.api.app.model.Circle;
import com.cgi.circle.java.api.app.model.Point;
import lombok.Data;

@Data
public class PointCircleIdWrapper {
    private Point point;
    private Circle circle;
}
