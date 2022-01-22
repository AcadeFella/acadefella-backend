package com.acadefella.acadefellabackend.domain.student.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class LandMark {
  @NonNull String landMark;

  public static LandMark create(String landMark) {
    return new LandMark(landMark);
  }
}
