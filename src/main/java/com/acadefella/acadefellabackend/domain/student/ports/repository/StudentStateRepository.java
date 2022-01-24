package com.acadefella.acadefellabackend.domain.student.ports.repository;

import com.acadefella.acadefellabackend.domain.student.core.Student;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStateRepository {
  void save(@NonNull Student student);
}
