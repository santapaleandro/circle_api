package com.cgi.circle.java.api.app.config;

import com.cgi.circle.java.api.app.mapper.CircleMapper;
import com.cgi.circle.java.api.app.mapper.PointMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public PointMapper pointMapper() {
        return new PointMapper() {};
    }
    @Bean
    public CircleMapper circleMapper(){
        return new CircleMapper() {};
    }
}


