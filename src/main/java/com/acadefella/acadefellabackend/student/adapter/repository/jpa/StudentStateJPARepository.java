package com.acadefella.acadefellabackend.student.adapter.repository.jpa;

import com.acadefella.acadefellabackend.student.adapter.entity.StudentStateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentStateJPARepository extends MongoRepository<StudentStateEntity, String> {}
