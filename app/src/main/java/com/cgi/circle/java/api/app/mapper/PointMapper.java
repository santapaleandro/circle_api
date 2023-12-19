package com.cgi.circle.java.api.app.mapper;

import com.cgi.circle.java.api.app.dto.NoIDPointDTO;
import com.cgi.circle.java.api.app.model.Point;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PointMapper {

    default Point noIDPointDTOToPoint(NoIDPointDTO noIDPoint) {
        if ( noIDPoint == null) {
            return null;
        }
        return new Point(
                noIDPoint.getX(),
                noIDPoint.getY()
        );
    }
}
