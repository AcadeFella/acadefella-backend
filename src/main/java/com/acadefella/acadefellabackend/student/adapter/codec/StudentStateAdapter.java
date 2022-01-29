package com.acadefella.acadefellabackend.student.adapter.codec;

import com.acadefella.acadefellabackend.student.adapter.entity.StudentStateEntity;
import com.acadefella.acadefellabackend.student.domain.core.StudentState;
import org.springframework.stereotype.Component;

@Component
public class StudentStateAdapter {
  public StudentStateEntity encode(StudentState studentState) {
    return StudentStateEntity.builder()
        .name(studentState.getName().getName())
        .email(studentState.getEmail().getEmail())
        .phoneNumber(studentState.getPhoneNumber().getPhoneNumber())
        .dob(studentState.getDob())
        .password(studentState.getPassword().getPassword())
        .build();
  }
}
