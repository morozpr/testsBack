package com.example.testsBack.repositories;

import com.example.testsBack.entities.QuestBase;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface QuestBaseRepository extends CrudRepository<QuestBase, Long>, JpaSpecificationExecutor<QuestBase> {
}