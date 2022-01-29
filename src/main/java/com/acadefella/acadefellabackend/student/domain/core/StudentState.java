package com.acadefella.acadefellabackend.student.domain.core;

import com.acadefella.acadefellabackend.student.domain.core.value.AcademicDetails;
import com.acadefella.acadefellabackend.student.domain.core.value.PersonalDetails;
import com.acadefella.acadefellabackend.student.domain.core.value.PhoneNumber;
import com.acadefella.acadefellabackend.student.domain.core.value.personal.Email;
import com.acadefella.acadefellabackend.student.domain.core.value.personal.Name;
import com.acadefella.acadefellabackend.student.domain.core.value.personal.Password;
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
  private PersonalDetails personalDetails;
  private AcademicDetails academicDetails;
}
