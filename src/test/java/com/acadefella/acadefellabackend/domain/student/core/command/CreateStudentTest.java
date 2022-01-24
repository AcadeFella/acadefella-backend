package com.acadefella.acadefellabackend.domain.student.core.command;

import static org.assertj.core.api.Assertions.assertThat;

import com.acadefella.acadefellabackend.domain.student.core.StudentState;
import com.acadefella.acadefellabackend.util.TestDataBuilder;
import org.junit.jupiter.api.Test;

class CreateStudentTest {

  @Test
  void shouldCreateStudentStateFromCommand() {
    var createStudent = TestDataBuilder.randomCreateStudentBuilder().build();
    assertThat(CreateStudent.toStudentState(createStudent)).isInstanceOf(StudentState.class);
  }
}
