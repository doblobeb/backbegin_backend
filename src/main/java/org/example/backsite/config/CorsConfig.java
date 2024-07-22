package org.example.backsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allows all endpoints
                .allowedOrigins("*")  // Allows all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow specified methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);
    }
}