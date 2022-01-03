package com.acadefella.acadefellabackend.domain.student.command;

import com.acadefella.acadefellabackend.domain.student.core.StudentState;
import com.acadefella.acadefellabackend.domain.student.core.value.AcademicDetails;
import com.acadefella.acadefellabackend.domain.student.core.value.PersonalDetails;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Name;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.Password;
import com.acadefella.acadefellabackend.domain.student.core.value.personal.UserName;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class CreateStudent {
    @NonNull Name name;
    @NonNull UserName userName;
    @NonNull Password password;
    @NonNull PersonalDetails personalDetails;
    @NonNull AcademicDetails academicDetails;

    public StudentState toStudentState() {
        return StudentState.builder()
                .name(name)
                .userName(userName)
                .password(password)
                .personalDetails(personalDetails)
                .academicDetails(academicDetails)
                .build();
    }
}
