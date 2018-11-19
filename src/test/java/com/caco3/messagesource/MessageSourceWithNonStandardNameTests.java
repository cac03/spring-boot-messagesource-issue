package com.caco3.messagesource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("messageSourceWithNonStandardName")
public class MessageSourceWithNonStandardNameTests {

  @Autowired
  private ApplicationContext applicationContext;


  /**
   * Without the fix {@link org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration}
   * does not expose {@link org.springframework.context.MessageSource} bean
   * since {@link MyMessageSource} is defined, but the {@link ApplicationContext}
   * expects a {@link org.springframework.context.MessageSource} to be defined only with
   * {@link org.springframework.context.support.AbstractApplicationContext#MESSAGE_SOURCE_BEAN_NAME}
   * name that is not the case.
   *
   * Part of Conditions evaluation report:
   * MessageSourceAutoConfiguration:
   *       Did not match:
   *          - @ConditionalOnMissingBean (types: org.springframework.context.MessageSource; SearchStrategy: current)
   *          found beans of type 'org.springframework.context.MessageSource' myMessageSource (OnBeanCondition)
   *       Matched:
   *          - ResourceBundle found bundle URL [file:/home/caco3/Dev/IdeaProjects/messagesource/target/classes/messages.properties]
   *          (MessageSourceAutoConfiguration.ResourceBundleCondition)
   */
  @Test
  @Ignore("fails without the fix")
  public void messageShouldBeResolved() {
    String message = applicationContext.getMessage("foo", new Object[0], Locale.US);
    assertEquals("barbaz", message);
  }
}
