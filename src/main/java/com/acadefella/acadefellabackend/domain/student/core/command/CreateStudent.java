package com.acadefella.acadefellabackend.domain.student.core.command;

import com.acadefella.acadefellabackend.domain.student.core.StudentState;
import com.acadefella.acadefellabackend.domain.student.core.value.AcademicDetails;
import com.acadefella.acadefellabackend.domain.student.core.value.PersonalDetails;
import com.acadefella.acadefellabackend.domain.student.core.value.PhoneNumber;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Email;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Name;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Password;
import java.time.Instant;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class CreateStudent {
  @NonNull Name name;
  @NonNull Email email;
  @NonNull PhoneNumber phoneNumber;
  @NonNull Password password;
  @NonNull Instant dob;
  PersonalDetails personalDetails;
  AcademicDetails academicDetails;

  public static StudentState toStudentState(CreateStudent createStudent) {
    return StudentState.builder()
        .name(createStudent.getName())
        .email(createStudent.getEmail())
        .dob(createStudent.getDob())
        .phoneNumber(createStudent.getPhoneNumber())
        .password(createStudent.getPassword())
        .personalDetails(createStudent.getPersonalDetails())
        .academicDetails(createStudent.getAcademicDetails())
        .build();
  }
}
