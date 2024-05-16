package edu.mareanexx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LighterConfig {
    @Bean
    public Lighter Lamp() {
        return new Lamp();
    }

    @Bean
    public Lighter Flashlight() {
        return new Flashlight();
    }

    @Bean
    public Lighter Firefly() {
        return new Firefly();
    }
}
