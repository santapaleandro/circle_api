package com.cgi.circle.java.api.app.repository;

import com.cgi.circle.java.api.app.model.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PointRepository extends MongoRepository<Point, String> {

}