package com.example.teacherstudents.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;



//Legacy code for message source configuration
//Now we don't need this class because we are using spring boot autoconfiguration for a message source

@Component
public class BundleMessage
{
    @Value("${spring.messages.basename}")
    private String baseValue;

    @Bean
    public ResourceBundleMessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(baseValue);
        String UTF_8 = "UTF-8";
        messageSource.setDefaultEncoding(UTF_8);
        return messageSource;

    }
}
