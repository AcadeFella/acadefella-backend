package com.acadefella.acadefellabackend.student.ports.repository;

import com.acadefella.acadefellabackend.student.domain.core.Student;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentStateRepository {
  void save(@NonNull Student student);
}
