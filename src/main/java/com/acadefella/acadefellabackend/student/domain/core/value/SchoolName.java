package com.acadefella.acadefellabackend.student.domain.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class SchoolName {
  @NonNull String schoolName;

  public static SchoolName create(String schoolName) {
    return new SchoolName(schoolName);
  }
}
