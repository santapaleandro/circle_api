package com.cgi.circle.java.api.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

@Document(collection = "users")
@Data
public class Circle {
    @Id
    private Long id;
    @NonNull
    private Integer x;
    @NonNull
    private Integer y;
    @NonNull
    private Integer radius;
}
