package com.acadefella.acadefellabackend.student.service;

import com.acadefella.acadefellabackend.student.domain.command.CreateStudent;
import com.acadefella.acadefellabackend.student.domain.core.Student;
import com.acadefella.acadefellabackend.student.ports.repository.StudentStateRepository;
import com.acadefella.acadefellabackend.student.ports.service.StudentService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

@Service
public class StudentStateServiceImpl implements StudentService {

  private final StudentStateRepository studentStateRepository;

  public StudentStateServiceImpl(StudentStateRepository studentStateRepository) {
    this.studentStateRepository = studentStateRepository;
  }

  @Override
  public void save(@NonNull CreateStudent createStudent) {
    try {
      studentStateRepository.save(Student.create(createStudent));
    } catch (Exception e) {
      throw new RuntimeException("Unable to save student data: {}", e);
    }
  }
}
