package com.acadefella.acadefellabackend.domain.student.ports.service;

import com.acadefella.acadefellabackend.domain.student.core.command.CreateStudent;
import lombok.NonNull;

public interface StudentService {
  void save(@NonNull CreateStudent createStudent);
}
