package com.cgi.circle.java.api.app.mapper;

import com.cgi.circle.java.api.app.dto.NoIDCircleDTO;
import com.cgi.circle.java.api.app.model.Circle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CircleMapper {

    default Circle noIDCircleDTOToCircle(NoIDCircleDTO noIDCircle) {
        if ( noIDCircle == null) {
            return null;
        }
        return new Circle(
                noIDCircle.getX(),
                noIDCircle.getY(),
                noIDCircle.getRadius()
        );
    }
}
