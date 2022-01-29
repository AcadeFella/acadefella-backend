package com.acadefella.acadefellabackend.student.domain.core.value;

import com.acadefella.acadefellabackend.student.domain.core.value.academic.Notification;
import com.acadefella.acadefellabackend.student.domain.core.value.academic.Subject;
import com.acadefella.acadefellabackend.student.domain.core.value.personal.Name;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class Exam {
  @NonNull Name name;
  @NonNull Subject subject;
  @NonNull Instant startDate;
  @NonNull Instant endDate;
  @NonNull Instant resultDate;
  @NonNull Notification notification;
}
