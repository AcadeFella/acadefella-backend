package com.acadefella.acadefellabackend.domain.student.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class City {
  @NonNull String city;

  public static City create(String city) {
    return new City(city);
  }
}
