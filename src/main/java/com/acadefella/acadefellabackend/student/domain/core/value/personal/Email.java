package com.acadefella.acadefellabackend.student.domain.core.value.personal;

import lombok.NonNull;
import lombok.Value;

@Value
public class Email {
  @NonNull String email;

  public static Email create(String email) {
    return new Email(email);
  }
}
