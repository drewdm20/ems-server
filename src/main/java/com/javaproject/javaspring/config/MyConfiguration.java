package com.javaproject.javaspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
/**
 * <p> This is a configuration class that is used to configure CORS for communication between two different addresses </p>
 * @return WebMvcConfigurer to configure CORS origins, methods and headers
 */
public class MyConfiguration {
    
   @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*")
                    .allowedOrigins("*");
            }
        };
    }
}
