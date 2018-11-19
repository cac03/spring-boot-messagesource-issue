package com.caco3.messagesource;

import org.junit.Test;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class NotMessageSourceMessageSourceTests {

  @Configuration
  public static class Config {
    @Bean
    public NotMessageSourceMessageSource messageSource() {
      return new NotMessageSourceMessageSource();
    }
  }

  @Test(expected = BeanNotOfRequiredTypeException.class)
  public void applicationContextExpectsActualMessageSourceNamedMessageSource() {
    new AnnotationConfigApplicationContext(Config.class);
  }
}
