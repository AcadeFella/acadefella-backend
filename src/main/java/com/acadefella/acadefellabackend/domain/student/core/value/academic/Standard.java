package com.acadefella.acadefellabackend.domain.student.core.value.academic;

import lombok.NonNull;
import lombok.Value;

@Value
public class Standard {
  @NonNull Integer standard;

  public static Standard create(Integer standard) {
    return new Standard(standard);
  }
}
