package com.acadefella.acadefellabackend.message;

import com.acadefella.acadefellabackend.domain.student.core.command.CreateStudent;
import com.acadefella.acadefellabackend.domain.student.core.value.PhoneNumber;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Email;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Name;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Password;
import java.time.Instant;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentMessage {
  @NonNull String name;
  @NonNull String email;
  @NonNull String phoneNumber;
  @NonNull Instant dob;
  @NonNull String password;

  public static CreateStudent toCreateStudentCommand(StudentMessage studentMessage) {
    return CreateStudent.builder()
        .name(Name.create(studentMessage.getName()))
        .email(Email.create(studentMessage.getEmail()))
        .phoneNumber(PhoneNumber.create(studentMessage.getPhoneNumber()))
        .dob(studentMessage.getDob())
        .password(Password.create(studentMessage.getPassword()))
        .build();
  }
}
