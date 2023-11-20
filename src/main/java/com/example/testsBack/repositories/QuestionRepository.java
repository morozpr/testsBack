package com.example.testsBack.repositories;

import com.example.testsBack.entities.Question;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long>, JpaSpecificationExecutor<Question> {
}