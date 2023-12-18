package com.cgi.circle.java.api.app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NoIDPointDTO {
    @NotNull(message = "X coordinate is required")
    private Double x;

    @NotNull(message = "Y coordinate is required")
    private Double y;
}
