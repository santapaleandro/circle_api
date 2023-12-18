package com.cgi.circle.java.api.app.dto.wrappers;

import com.cgi.circle.java.api.app.dto.NoIDCircleDTO;
import com.cgi.circle.java.api.app.dto.NoIDPointDTO;
import lombok.Data;

@Data
public class PointCircleWrapper {
    private NoIDPointDTO point;
    private NoIDCircleDTO circle;
}
