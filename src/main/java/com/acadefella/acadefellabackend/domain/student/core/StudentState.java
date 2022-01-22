package com.acadefella.acadefellabackend.domain.student.core;

import com.acadefella.acadefellabackend.domain.student.core.value.*;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Name;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Password;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.UserName;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class StudentState {
  @NonNull private Name name;
  @NonNull private UserName userName;
  @NonNull private Password password;
  @NonNull private PersonalDetails personalDetails;
  @NonNull private AcademicDetails academicDetails;
}
