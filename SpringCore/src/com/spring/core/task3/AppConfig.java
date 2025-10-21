package com.spring.core.task3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	@Scope("prototype")//or singleton for print destroy-method
    @Bean
    public UserService personService() {
        return new PersonService();
    }
  
    
    
}
