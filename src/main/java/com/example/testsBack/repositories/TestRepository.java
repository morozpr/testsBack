package com.example.testsBack.repositories;

import com.example.testsBack.entities.Test;
import com.example.testsBack.entities.TestQuest;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TestRepository extends CrudRepository<Test, Long>, JpaSpecificationExecutor<Test> {
    @Transactional
    @Modifying
    @Query("update Test t set t.testQuests = ?1 where t.id = ?2")
    int updateTestQuestsById(TestQuest testQuests, Long id);
    @Transactional
    @Modifying
    @Query("update Test t set t.id = ?1 where t.testQuests = ?2")
    int updateIdByTestQuests(Long id, TestQuest testQuests);
    @Transactional
    @Modifying
    @Query("update Test t set t.name = ?1 where t.id = ?2")
    int updateNameById(String name, Long id);
    @Transactional
    @Modifying
    @Query("update Test t set t.id = ?1 where t.name = ?2")
    int updateIdByName(Long id, String name);
    boolean existsByName(String name);
}