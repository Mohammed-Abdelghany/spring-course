    package com.example.teacherstudents.service.imp;

import com.example.teacherstudents.helper.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class BundleMessageService {

    private final MessageSource messageSource;

    @Autowired
    public BundleMessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    public String getMessageAr(String key) {
        return messageSource.getMessage(key, null, new Locale("ar"));
    }

    public String getMessageEn(String key) {
        return messageSource.getMessage(key, null, new Locale("en"));
    }

   public MessageResponse getMessageResponse(String key) {
       return new MessageResponse(
                getMessageAr(key),
                getMessageEn(key)
       );



   }


}
