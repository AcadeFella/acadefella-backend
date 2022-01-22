package com.acadefella.acadefellabackend.domain.student.core.value.academic;

import lombok.NonNull;
import lombok.Value;

@Value
public class Section {
  @NonNull String section;

  public static Section create(String section) {
    return new Section(section);
  }
}
