package com.acadefella.acadefellabackend.domain.student.core.value;

import com.acadefella.acadefellabackend.domain.student.core.value.academic.RollNo;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Section;
import com.acadefella.acadefellabackend.domain.student.core.value.academic.Standard;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Builder
@Data
public class AcademicDetails {
    @NonNull Standard standard;
    @NonNull RollNo rollNo;
    @NonNull Section section;
    @NonNull List<Exam> exams;
}
