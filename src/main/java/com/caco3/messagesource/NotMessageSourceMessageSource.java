package com.caco3.messagesource;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("messageSource")
@Profile("notMessageSourceMessageSource")
public class NotMessageSourceMessageSource {
}
