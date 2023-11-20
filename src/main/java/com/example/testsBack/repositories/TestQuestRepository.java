package com.example.testsBack.repositories;

import com.example.testsBack.entities.TestQuest;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TestQuestRepository extends CrudRepository<TestQuest, Long>, JpaSpecificationExecutor<TestQuest> {
}