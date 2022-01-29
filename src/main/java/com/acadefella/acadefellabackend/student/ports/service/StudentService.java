package com.acadefella.acadefellabackend.student.ports.service;

import com.acadefella.acadefellabackend.student.domain.command.CreateStudent;
import lombok.NonNull;

public interface StudentService {
  void save(@NonNull CreateStudent createStudent);
}
