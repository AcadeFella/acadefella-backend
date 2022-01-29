package com.acadefella.acadefellabackend.student.domain.core.value;

import com.acadefella.acadefellabackend.student.domain.core.value.personal.FatherName;
import com.acadefella.acadefellabackend.student.domain.core.value.personal.MotherName;
import com.acadefella.acadefellabackend.student.domain.core.value.personal.Name;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class PersonalDetails {
  @NonNull Name name;
  @NonNull Address address;
  @NonNull MotherName motherName;
  @NonNull FatherName fatherName;
}
