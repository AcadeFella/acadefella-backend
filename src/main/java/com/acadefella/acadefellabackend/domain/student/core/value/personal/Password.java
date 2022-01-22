package com.acadefella.acadefellabackend.domain.student.core.value.personal;

import lombok.NonNull;
import lombok.Value;

@Value
public class Password {
  @NonNull String password;

  public static Password create(String password) {
    return new Password(password);
  }
}
