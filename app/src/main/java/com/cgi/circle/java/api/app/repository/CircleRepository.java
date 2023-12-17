package com.cgi.circle.java.api.app.repository;

import com.cgi.circle.java.api.app.model.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CircleRepository extends MongoRepository<Circle, String>{

}