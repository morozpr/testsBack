package com.example.testsBack.repositories;

import com.example.testsBack.entities.University;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Long>, JpaSpecificationExecutor<University> {
    boolean existsByUniversityName(String universityName);
}