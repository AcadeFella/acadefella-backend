package com.acadefella.acadefellabackend.student.domain.core.value;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Address {
  @NonNull HouseNumber houseNumber;
  @NonNull Street street;
  @NonNull City city;
  @NonNull State state;
  @NonNull Pin pin;
  @NonNull LandMark landMark;
}
