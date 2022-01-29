package com.acadefella.acadefellabackend.message;

import static org.assertj.core.api.Assertions.assertThat;

import com.acadefella.acadefellabackend.student.domain.command.CreateStudent;
import com.acadefella.acadefellabackend.util.TestDataBuilder;
import org.junit.jupiter.api.Test;

class StudentMessageTest {

  @Test
  void shouldCreateStudentCommandFromMessage() {
    var studentMessage = TestDataBuilder.randomStudentMessageBuilder().build();
    assertThat(StudentMessage.toCreateStudentCommand(studentMessage))
        .isInstanceOf(CreateStudent.class);
  }
}
