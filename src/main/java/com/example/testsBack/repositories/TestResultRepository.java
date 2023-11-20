package com.example.testsBack.repositories;

import com.example.testsBack.entities.TestResult;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TestResultRepository extends CrudRepository<TestResult, Long>, JpaSpecificationExecutor<TestResult> {
}