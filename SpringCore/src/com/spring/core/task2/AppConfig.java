package com.spring.core.task2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService() {
        return new PersonService();
    }

    @Bean
    public AccountService accountService(PersonService personService) {
        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setPersonService(personService); 
        return accountService;
    }
}
