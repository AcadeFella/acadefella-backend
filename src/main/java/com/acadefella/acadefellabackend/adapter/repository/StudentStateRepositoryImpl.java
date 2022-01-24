package com.acadefella.acadefellabackend.adapter.repository;

import com.acadefella.acadefellabackend.adapter.codec.StudentStateAdapter;
import com.acadefella.acadefellabackend.adapter.repository.jpa.StudentStateJPARepository;
import com.acadefella.acadefellabackend.domain.student.core.Student;
import com.acadefella.acadefellabackend.domain.student.ports.repository.StudentStateRepository;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public class StudentStateRepositoryImpl implements StudentStateRepository {

  private final StudentStateJPARepository studentStateJPARepository;
  private final StudentStateAdapter studentStateAdapter;

  public StudentStateRepositoryImpl(
          StudentStateJPARepository studentStateJPARepository, StudentStateAdapter studentStateAdapter) {
    this.studentStateJPARepository = studentStateJPARepository;
    this.studentStateAdapter = studentStateAdapter;
  }

  @Override
  public void save(@NonNull Student student) {
    studentStateJPARepository.save(studentStateAdapter.encode(student.getState()));
  }
}
