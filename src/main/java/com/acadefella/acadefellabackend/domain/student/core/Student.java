package com.acadefella.acadefellabackend.domain.student.core;

import com.acadefella.acadefellabackend.domain.student.command.CreateStudent;
import lombok.Getter;
import lombok.NonNull;

public class Student {
    @Getter private final StudentState state;

    public Student(StudentState studentState) {
        this.state = studentState;
    }

    public static Student create(@NonNull CreateStudent createStudent) {
        return create(createStudent.toStudentState());
    }

    public static Student create(@NonNull StudentState studentState) {
        return new Student(studentState);
    }
}
