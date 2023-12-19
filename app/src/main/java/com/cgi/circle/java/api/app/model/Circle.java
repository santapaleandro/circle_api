package com.cgi.circle.java.api.app.model;

import jakarta.validation.constraints.DecimalMin;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection = "circles")
@Data
public class Circle {
    @Id
    private String id;
    @NonNull
    private Double x;
    @NonNull
    private Double y;
    @NonNull
    @DecimalMin(value = "0.0001", message = "The radius must be greater than 0.0001")
    private Double radius;
}
