package com.acadefella.acadefellabackend.domain.student.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class Street {
  @NonNull String street;

  public static Street create(String street) {
    return new Street(street);
  }
}
