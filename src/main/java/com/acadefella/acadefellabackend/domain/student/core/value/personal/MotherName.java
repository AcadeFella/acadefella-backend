package com.acadefella.acadefellabackend.domain.student.core.value.personal;

import lombok.NonNull;
import lombok.Value;

@Value
public class MotherName {
    @NonNull String motherName;

    public static MotherName create(String motherName) {
        return new MotherName(motherName);
    }
}
