package com.acadefella.acadefellabackend.adapter.repository.jpa;

import com.acadefella.acadefellabackend.adapter.entity.StudentStateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentStateJPARepository extends MongoRepository<StudentStateEntity, String> {}
