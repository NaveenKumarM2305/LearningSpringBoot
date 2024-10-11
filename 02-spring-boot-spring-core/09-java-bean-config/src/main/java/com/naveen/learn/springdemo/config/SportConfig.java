package com.naveen.learn.springdemo.config;

import com.naveen.learn.springdemo.common.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach mySwimCoach(){
        return new SwimCoach();
    }
}
