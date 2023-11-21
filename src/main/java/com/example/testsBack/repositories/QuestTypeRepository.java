package com.example.testsBack.repositories;

import com.example.testsBack.entities.QuestType;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface QuestTypeRepository extends CrudRepository<QuestType, Long>, JpaSpecificationExecutor<QuestType> {
    boolean existsByQuestTypeName(String questTypeName);
}