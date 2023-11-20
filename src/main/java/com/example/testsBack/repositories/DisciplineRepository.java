package com.example.testsBack.repositories;

import com.example.testsBack.entities.Discipline;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DisciplineRepository extends CrudRepository<Discipline, Long>, JpaSpecificationExecutor<Discipline> {
}