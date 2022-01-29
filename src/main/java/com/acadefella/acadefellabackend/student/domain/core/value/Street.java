package com.acadefella.acadefellabackend.student.domain.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class Street {
  @NonNull String street;

  public static Street create(String street) {
    return new Street(street);
  }
}
