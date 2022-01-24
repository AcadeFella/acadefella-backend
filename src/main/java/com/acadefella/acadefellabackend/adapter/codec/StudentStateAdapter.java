package com.acadefella.acadefellabackend.adapter.codec;

import com.acadefella.acadefellabackend.adapter.entity.StudentStateEntity;
import com.acadefella.acadefellabackend.domain.student.core.StudentState;
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
