package com.caco3.messagesource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ActiveProfiles("messageSourceWithStandardName")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageSourceWithStandardNameTests {
  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void shouldPreferMessageSourceWithStandardName() {
    String message = applicationContext.getMessage("does not matter", null, null);
    assertEquals("42", message);
  }
}
