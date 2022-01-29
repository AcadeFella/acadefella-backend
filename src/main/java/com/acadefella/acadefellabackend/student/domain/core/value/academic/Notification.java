package com.acadefella.acadefellabackend.student.domain.core.value.academic;

import lombok.NonNull;
import lombok.Value;

@Value
public class Notification {
  @NonNull String notification;

  public static Notification create(String notification) {
    return new Notification(notification);
  }
}
