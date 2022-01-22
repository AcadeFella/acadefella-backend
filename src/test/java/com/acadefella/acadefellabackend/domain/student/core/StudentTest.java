package com.acadefella.acadefellabackend.domain.student.core;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.acadefella.acadefellabackend.domain.student.command.CreateStudent;
import com.acadefella.acadefellabackend.util.TestDataBuilder;
import org.junit.jupiter.api.Test;

class StudentTest {

  @Test
  void shouldCreateStudentFromCommand() {
    CreateStudent createStudent = TestDataBuilder.randomCreateStudentBuilder().build();
    var studentState = createStudent.toStudentState();
    assertThat(Student.create(studentState)).isInstanceOf(Student.class);
  }
}
