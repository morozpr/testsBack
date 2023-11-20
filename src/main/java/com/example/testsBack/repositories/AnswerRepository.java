package com.example.testsBack.repositories;

import com.example.testsBack.entities.Answer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>, JpaSpecificationExecutor<Answer> {
}