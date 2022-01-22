package com.acadefella.acadefellabackend.domain.student.core.value;

import com.acadefella.acadefellabackend.domain.student.core.value.academic.Section;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Subject;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Schedule {
  @NonNull Subject subject;
  @NonNull Instant date;
  @NonNull Instant time;
  @NonNull Section section;
  @NonNull List<Exam> exams;
}
