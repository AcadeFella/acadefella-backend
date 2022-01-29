package com.acadefella.acadefellabackend.student.domain.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class HouseNumber {
  @NonNull String houseNumber;

  public static HouseNumber create(String houseNumber) {
    return new HouseNumber(houseNumber);
  }
}
