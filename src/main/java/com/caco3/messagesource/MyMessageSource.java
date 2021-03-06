package com.caco3.messagesource;

import org.springframework.context.annotation.Profile;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component
@Profile("messageSourceWithNonStandardName")
public class MyMessageSource extends AbstractMessageSource {
  @Override
  protected MessageFormat resolveCode(String s, Locale locale) {
    return new MessageFormat("unused");
  }
}
