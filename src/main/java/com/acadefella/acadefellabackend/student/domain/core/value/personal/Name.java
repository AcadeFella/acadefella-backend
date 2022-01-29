package com.acadefella.acadefellabackend.student.domain.core.value.personal;

import lombok.NonNull;
import lombok.Value;

@Value
public class Name {
  @NonNull String name;

  public static Name create(String name) {
    return new Name(name);
  }
}
