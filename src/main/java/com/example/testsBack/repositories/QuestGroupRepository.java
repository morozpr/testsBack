package com.example.testsBack.repositories;

import com.example.testsBack.entities.QuestGroup;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface QuestGroupRepository extends CrudRepository<QuestGroup, Long>, JpaSpecificationExecutor<QuestGroup> {
}