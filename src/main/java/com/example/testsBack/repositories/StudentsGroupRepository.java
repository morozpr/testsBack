package com.example.testsBack.repositories;

import com.example.testsBack.entities.StudentsGroup;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentsGroupRepository extends CrudRepository<StudentsGroup, Long>, JpaSpecificationExecutor<StudentsGroup> {
    @Transactional
    @Modifying
    @Query("update StudentsGroup s set s.studentsGroupName = ?1 where s.id = ?2")
    void updateStudentsGroupNameById(String studentsGroupName, Long id);
    List<StudentsGroup> findByStudentsGroupName(String studentsGroupName);
}