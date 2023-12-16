package com.circle.java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.circle.java.model.Circle;

public interface CircleRepository extends MongoRepository<Circle, Long>{
    
}
