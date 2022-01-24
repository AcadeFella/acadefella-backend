package com.acadefella.acadefellabackend.domain.student.core;

import com.acadefella.acadefellabackend.domain.student.core.value.*;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Email;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Name;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Password;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class StudentState {
  @NonNull private Name name;
  @NonNull private Email email;
  @NonNull private PhoneNumber phoneNumber;
  @NonNull private Instant dob;
  @NonNull private Password password;
  @NonNull private PersonalDetails personalDetails;
  @NonNull private AcademicDetails academicDetails;
}
