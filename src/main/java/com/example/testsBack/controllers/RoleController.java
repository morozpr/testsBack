package com.example.testsBack.controllers;

import com.example.testsBack.dtos.RoleDto;
import com.example.testsBack.entities.Role;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.mappers.RoleMapper;
import com.example.testsBack.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMapper roleMapper;

    @PostMapping("/new")
    public ResponseEntity addObject(@RequestBody RoleDto role) {
        try {
            return ResponseEntity.ok(roleMapper.toDto(roleService.addObject(roleMapper.toEntity(role))));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(roleService.getAllObjects().stream().map(roleMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(roleMapper.toDto(roleService.getOneObject(id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editObject(@PathVariable Long id, @RequestBody RoleDto role) {
        try {
            return ResponseEntity.ok(roleMapper.toDto(roleService.editObject(roleMapper.toEntity(role), id)));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            roleService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
