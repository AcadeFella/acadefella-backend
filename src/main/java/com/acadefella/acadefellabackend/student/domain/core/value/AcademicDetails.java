package com.acadefella.acadefellabackend.student.domain.core.value;

import com.acadefella.acadefellabackend.student.domain.core.value.academic.RollNo;
import com.acadefella.acadefellabackend.student.domain.core.value.academic.Section;
import com.acadefella.acadefellabackend.student.domain.core.value.academic.Standard;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class AcademicDetails {
  @NonNull Standard standard;
  @NonNull RollNo rollNo;
  @NonNull Section section;
  @NonNull SchoolName schoolName;
}
