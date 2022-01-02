package com.acadefella.acadefellabackend.domain.student.core.value.personal;

import lombok.NonNull;
import lombok.Value;

@Value
public class FatherName {
    @NonNull String fatherName;

    public static FatherName create(String fatherName) {
        return new FatherName(fatherName);
    }
}
