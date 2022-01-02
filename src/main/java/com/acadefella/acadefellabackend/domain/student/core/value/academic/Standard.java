package com.acadefella.acadefellabackend.domain.student.core.value.academic;

import lombok.NonNull;
import lombok.Value;

@Value
public class Standard {
    @NonNull String standard;

    public static Standard create(String standard) {
        return new Standard(standard);
    }
}
