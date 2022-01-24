package com.acadefella.acadefellabackend.api;

import com.acadefella.acadefellabackend.domain.student.ports.service.StudentService;
import com.acadefella.acadefellabackend.message.StudentMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class StudentController {
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @PostMapping("/student/register")
  public ResponseEntity<String> storeFeedData(@RequestBody StudentMessage studentMessage) {
    log.info("Registering a student");
    studentService.save(StudentMessage.toCreateStudentCommand(studentMessage));
    return ResponseEntity.accepted().body("Student Registered Successfully!");
  }
}
