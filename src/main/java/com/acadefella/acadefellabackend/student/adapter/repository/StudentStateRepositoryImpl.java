package com.acadefella.acadefellabackend.student.adapter.repository;

import com.acadefella.acadefellabackend.student.adapter.codec.StudentStateAdapter;
import com.acadefella.acadefellabackend.student.adapter.repository.jpa.StudentStateJPARepository;
import com.acadefella.acadefellabackend.student.domain.core.Student;
import com.acadefella.acadefellabackend.student.ports.repository.StudentStateRepository;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class StudentStateRepositoryImpl implements StudentStateRepository {

  private final StudentStateJPARepository studentStateJPARepository;
  private final StudentStateAdapter studentStateAdapter;

  public StudentStateRepositoryImpl(
      StudentStateJPARepository studentStateJPARepository,
      StudentStateAdapter studentStateAdapter) {
    this.studentStateJPARepository = studentStateJPARepository;
    this.studentStateAdapter = studentStateAdapter;
  }

  @Override
  public void save(@NonNull Student student) {
    studentStateJPARepository.save(studentStateAdapter.encode(student.getState()));
  }
}
