package com.spring.core.task1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserService personService() {
        return new PersonService();
    }
    
    @Bean
    public UserService mangerService() {
        return new MangerService();
    }
    
}
