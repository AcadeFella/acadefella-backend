package com.acadefella.acadefellabackend.student.domain.core;

import static org.assertj.core.api.Assertions.assertThat;

import com.acadefella.acadefellabackend.student.domain.command.CreateStudent;
import com.acadefella.acadefellabackend.util.TestDataBuilder;
import org.junit.jupiter.api.Test;

class StudentTest {

  @Test
  void shouldCreateStudentDomainFromCommand() {
    CreateStudent createStudent = TestDataBuilder.randomCreateStudentBuilder().build();
    var studentState = CreateStudent.toStudentState(createStudent);
    assertThat(Student.create(studentState)).isInstanceOf(Student.class);
  }
}
