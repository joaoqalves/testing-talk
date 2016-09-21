package com.schibsted.testing;

import com.schibsted.testing.servicetest.domain.model.users.User;

import java.lang.reflect.AnnotatedType;

public class StaticClassWithComplexOperations {

  private static User user;

  public static User getUser() {
    return user;
  }
}
