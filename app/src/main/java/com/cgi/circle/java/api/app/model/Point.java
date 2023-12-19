package com.cgi.circle.java.api.app.model;

import com.mongodb.lang.NonNull;
import lombok.Data;

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
