package com.acadefella.acadefellabackend.domain.student.core.value.personal;

import lombok.NonNull;
import lombok.Value;

@Value
public class UserName {
    @NonNull String userName;

    public static UserName create(String userName) {
        return new UserName(userName);
    }
}
