package com.acadefella.acadefellabackend.domain.student.service;

import com.acadefella.acadefellabackend.domain.student.core.Student;
import com.acadefella.acadefellabackend.domain.student.core.command.CreateStudent;
import com.acadefella.acadefellabackend.domain.student.ports.repository.StudentStateRepository;
import com.acadefella.acadefellabackend.domain.student.ports.service.StudentService;
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
