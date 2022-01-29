package com.acadefella.acadefellabackend.student.domain.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class PhoneNumber {
  @NonNull String phoneNumber;

  public static PhoneNumber create(String phoneNumber) {
    return new PhoneNumber(phoneNumber);
  }
}
