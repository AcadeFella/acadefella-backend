package com.acadefella.acadefellabackend.domain.student.core.value;

import com.acadefella.acadefellabackend.domain.student.core.value.academic.RollNo;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Section;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Standard;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Subject;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class Schedule {
    @NonNull Subject subject;
    @NonNull Instant date;
    @NonNull Instant time;
    @NonNull Section section;
    @NonNull List<Exam> exams;
}
