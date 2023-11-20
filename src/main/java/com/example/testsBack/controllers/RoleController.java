package com.example.testsBack.controllers;

import com.example.testsBack.entities.Role;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/new")
    public ResponseEntity addObject(@RequestBody Role role) {
        try {
            return ResponseEntity.ok(roleService.addObject(role));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() {
        return ResponseEntity.ok(roleService.getAllObjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(roleService.getOneObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity editObject(@PathVariable Long id, @RequestBody Role role) {
        try {
            return ResponseEntity.ok(roleService.editObject(role, id));
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
