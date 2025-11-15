package com.example.teacherstudents.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

//Now we don't need this class because we are using spring boot autoconfiguration for a message source


@Configuration
public class MessageSourceConfig {

//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename("messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//    @Bean
//    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
//        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//        bean.setValidationMessageSource(messageSource);
//        return bean;
//    }
}

//Legacy code for message source configuration

//@Component
//public class BundleMessage
//{
//    @Value("${spring.messages.basename}")
//    private String baseValue;
//
//    @Bean
//    public ResourceBundleMessageSource messageSource(){
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasename(baseValue);
//        String UTF_8 = "UTF-8";
//        messageSource.setDefaultEncoding(UTF_8);
//        return messageSource;
//
//    }
//}
