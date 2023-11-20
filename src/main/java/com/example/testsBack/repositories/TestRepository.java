package com.example.testsBack.repositories;

import com.example.testsBack.entities.Test;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long>, JpaSpecificationExecutor<Test> {
}