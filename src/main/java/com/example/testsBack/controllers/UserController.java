package com.example.testsBack.controllers;

import com.example.testsBack.entities.User;
import com.example.testsBack.exceptions.BadRequest;
import com.example.testsBack.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity putObject(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.addObject(user));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getAllObjects() { return ResponseEntity.ok(userService.getAllObjects()); }

    @GetMapping("/{id}")
    public ResponseEntity getOneObject(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getObject(id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity putObject(@PathVariable Long id, @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.editObject(user, id));
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteObject(@PathVariable Long id) {
        try {
            userService.deleteObject(id);
            return ResponseEntity.ok("Object deleted");
        } catch (BadRequest e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
