package com.acadefella.acadefellabackend.student.domain.core.value;

import lombok.NonNull;
import lombok.Value;

@Value
public class State {
  @NonNull String state;

  public static State create(String state) {
    return new State(state);
  }
}
