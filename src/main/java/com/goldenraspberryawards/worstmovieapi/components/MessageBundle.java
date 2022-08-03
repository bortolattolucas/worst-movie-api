package com.goldenraspberryawards.worstmovieapi.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageBundle {

    private static MessageSource messageSource;

    @Autowired
    public MessageBundle(MessageSource messageSource) {
        MessageBundle.messageSource = messageSource;
    }

    public static String getMessage(String key, Object... args) {
        try {
            return messageSource.getMessage(key, args, Locale.forLanguageTag("UTF-8"));
        } catch (Exception e) {
            return "Message not found with key: " + key;
        }
    }
}
