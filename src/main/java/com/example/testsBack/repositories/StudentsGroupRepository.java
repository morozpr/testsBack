package com.example.testsBack.repositories;

import com.example.testsBack.entities.StudentsGroup;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface StudentsGroupRepository extends CrudRepository<StudentsGroup, Long>, JpaSpecificationExecutor<StudentsGroup> {
}