package com.example.testsBack.repositories;

import com.example.testsBack.entities.UserAnswer;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserAnswerRepository extends CrudRepository<UserAnswer, Long>, JpaSpecificationExecutor<UserAnswer> {
}