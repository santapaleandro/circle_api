package com.cgi.circle.java.api.app.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "points")
public class Point {
    @Id
    private String id;
    @NonNull
    private Double x;
    @NonNull
    private Double y;
}
