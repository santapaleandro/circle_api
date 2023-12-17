package com.cgi.circle.java.api.app.model;

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
    private Double radius;
}
