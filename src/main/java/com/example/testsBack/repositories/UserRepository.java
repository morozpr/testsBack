package com.example.testsBack.repositories;

import com.example.testsBack.entities.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
    boolean existsByEmail(String email);
    List<User> findByEmail(String email);
}