package com.example.testsBack.repositories;

import com.example.testsBack.entities.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long>, JpaSpecificationExecutor<Role> {
    @Transactional
    @Modifying
    @Query("update Role r set r.roleName = ?1 where r.id = ?2")
    void updateRoleNameById(String roleName, Long id);
    List<Role> findByRoleName(String roleName);
}