package com.acadefella.acadefellabackend.student.domain.core.value.academic;

import lombok.NonNull;
import lombok.Value;

@Value
public class RollNo {
  @NonNull String rollNo;

  public static RollNo create(String rollNo) {
    return new RollNo(rollNo);
  }
}
