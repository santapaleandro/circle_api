package com.cgi.circle.java.api.app.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NoIDCircleDTO {
    @NotNull(message = "X coordinate is required")
    private Double x;

    @NotNull(message = "Y coordinate is required")
    private Double y;

    @DecimalMin(value = "0.0001", message = "Radius must be greater than 0.0001")
    private Double radius;
}
