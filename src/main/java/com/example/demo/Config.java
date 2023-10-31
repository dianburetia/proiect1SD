package com.example.demo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
public class Config {
    @Configuration
    public class ApplicationConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:3000/AdminPage")
                    .allowedMethods("*")
                    .allowedHeaders("*")
                    .allowCredentials(false).maxAge(3600);
        }
    }
}
