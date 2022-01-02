package com.acadefella.acadefellabackend.domain.student.core.value.academic;

import lombok.NonNull;
import lombok.Value;

@Value
public class Subject {
    @NonNull String subject;

    public static Subject create(String subject) {
        return new Subject(subject);
    }
}
