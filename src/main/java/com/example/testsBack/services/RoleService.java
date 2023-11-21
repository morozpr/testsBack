package com.example.testsBack.services;

import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.repositories.RoleRepository;
import org.springframework.stereotype.Service;
import com.example.testsBack.entities.Role;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role addObject(Role role) throws BadRequest {
        if (roleRepository.existsByRoleName(role.getRoleName()) == true) {
            throw new BadRequest("Bad request");
        }

        return roleRepository.save(role);
    }

    public Iterable<Role> getAllObjects(){
        return roleRepository.findAll();
    }

    public Role getOneObject(Long id) throws BadRequest {
        if (roleRepository.findById(id).get() == null) {
            throw new BadRequest("Object not found");
        }
        return roleRepository.findById(id).get();
    }
    public Role editObject(Role role, Long id) throws BadRequest {
        if (roleRepository.findById(id) == null) {
            throw new BadRequest("Object not found");
        }
        roleRepository.updateRoleNameById(role.getRoleName(), id);
        return roleRepository.findById(id).get();
    }

    public void deleteObject(Long id) throws BadRequest {
        if (roleRepository.findById(id).get() == null) {
            throw new BadRequest("Object not found");
        }
        roleRepository.deleteById(id);
    }


}
