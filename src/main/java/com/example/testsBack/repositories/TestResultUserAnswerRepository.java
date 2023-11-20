package com.example.testsBack.repositories;

import com.example.testsBack.entities.TestResultUserAnswer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TestResultUserAnswerRepository extends CrudRepository<TestResultUserAnswer, Long>, JpaSpecificationExecutor<TestResultUserAnswer> {
}