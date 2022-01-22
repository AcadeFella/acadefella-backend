package com.acadefella.acadefellabackend.domain.student.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class Pin {
  @NonNull String pin;

  public static Pin create(String pin) {
    return new Pin(pin);
  }
}
