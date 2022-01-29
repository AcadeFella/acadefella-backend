package com.acadefella.acadefellabackend.student.domain.core.value.academic;

import lombok.NonNull;
import lombok.Value;

@Value
public class Subject {
  @NonNull String subject;

  public static Subject create(String subject) {
    return new Subject(subject);
  }
}
