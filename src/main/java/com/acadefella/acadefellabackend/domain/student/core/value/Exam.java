package com.acadefella.acadefellabackend.domain.student.core.value;

import com.acadefella.acadefellabackend.domain.student.core.value.academic.Notification;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Subject;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Name;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Value;

import java.time.Instant;

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
